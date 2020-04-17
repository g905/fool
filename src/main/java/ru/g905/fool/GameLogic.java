package ru.g905.fool;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author g905
 */
public class GameLogic implements IGameLogic {

    private Stack stack;

    private Suits trump;

    private ArrayList<IPlayer> players;

    private Stack beaten;

    private Stack table;

    private IPlayer fool;

    public static final int CARDS_QUANTITY = 6;

    @Override
    public void init() {

        players = new ArrayList<>();
        stack = new Stack(false);
        beaten = new Stack(true);
        stack.shuffle();

        table = new Stack(true);

        Player vasya = new Player("Вася");

        HumanPlayer petya = new HumanPlayer();
        Player masha = new Player("Маша");
        Player anatoliy = new Player("Анатолий");
        players.add(vasya);
        players.add(petya);
        players.add(masha);
        players.add(anatoliy);
    }

    @Override
    public void start() throws Exception {

        takeOff();
        whoIsFirst();

        loop();

    }

    /**
     *
     * @return
     */
    public boolean exit() {
        Scanner in = new Scanner(System.in);
        System.out.println("Продлжить? Д/Н");
        String a;
        a = in.nextLine();
        return ("Н".equals(a) || "н".equals(a) || "n".equals(a) || "N".equals(a));
    }

    /**
     * Раздача карт
     *
     * @throws Exception
     */
    public void takeOff() throws Exception {

        Card trumpCard = stack.takeCard();

        trump = trumpCard.getSuit();

        Suits.setTrump(trump);
        stack.setTrump(Suits.getTrump());

        int taken = 0;
        int i = 0;
        while (i < CARDS_QUANTITY) {
            for (IPlayer p : players) {
                p.takeCard(stack);

                ++taken;
            }
            ++i;
        }

        stack.putCardToFirst(trumpCard);

        System.out.println("Козырь: " + Suits.getTrump().rusName());
        System.out.println("Роздано " + taken + " карт");
        System.out.println("В колоде " + stack.getLength() + " карт");
    }

    private void whoIsFirst() {
        IPlayer first = players.get(0);
        for (IPlayer p : players) {
            Card lowesTrump = p.getLowestTrump(trump);
            if (lowesTrump != null) {
                if (first.getLowestTrump(trump) == null || lowesTrump.compareTo(first.getLowestTrump(trump)) < 0) {
                    first = p;
                }
            }
        }
        players.remove(first);
        players.add(0, first);
    }

    /**
     *
     * @param p
     * @return
     */
    private IPlayer getOpponent(IPlayer p) {
        int idx = players.indexOf(p);
        while (true) {
            if (idx == players.size() - 1) {
                idx = 0;
            } else {
                idx += 1;
            }
            if (!players.get(idx).getOut()) {
                break;
            }

        }
        return players.get(idx);
    }

    private void takeCards() {
        for (IPlayer p : players) {
            p.takeCards(stack, CARDS_QUANTITY);
        }
    }

    /**
     *
     * @param p
     * @param opponent
     */
    private void battle(IPlayer p, IPlayer opponent) {
        System.out.println("Ходит " + p.getName());
        System.out.println("Отбивается " + opponent.getName());

        p.printCards();
        opponent.printCards();

        int i = 0;
        while (i < opponent.getQuant()) {
            if (i == 0) {
                Card c = p.attack();
                table.putCard(c);
            }
            p.toss(table, opponent);

            if (table.getLength() > 0) {
                System.out.println("На отбой такие карты:");
                for (Card c : table.getCards()) {
                    c.printCard();
                }
            }

            ArrayList<Card> winnerCards = opponent.tDefence(table);
            if (winnerCards.size() > 0) {
                table.putCards(winnerCards);
            }

            if (table.getLength() > 0) {
                System.out.println("На отбой такие карты:");
                for (Card c : table.getCards()) {
                    c.printCard();
                }
            }

            for (IPlayer pp : players) {
                if (pp.equals(p) || pp.equals(opponent) || p.getOut()) {
                    //System.out.println("Игрок " + pp.getName() + " уже подкидывал, пропускаем.");
                    continue;
                }

                pp.toss(table, opponent);

                if (table.getLength() > 0) {
                    System.out.println("На отбой такие карты:");
                    for (Card c : table.getCards()) {
                        c.printCard();
                    }
                }

                ArrayList<Card> winnerCardsPP = opponent.tDefence(table);
                if (winnerCards.size() > 0) {
                    table.putCards(winnerCardsPP);
                }
                if (table.getLength() > 0) {
                    System.out.println("На отбой такие карты:");
                    for (Card c : table.getCards()) {
                        c.printCard();
                    }
                }
            }

            beaten.putCards(table.getCards());
            table.getCards().clear();

            if (table.getLength() == 0) {
                break;
            }

            ++i;
        }

        for (IPlayer ppp : players) {
            for (Card c : ppp.getCards()) {
                c.setBeaten(false);
            }
            ppp.sortCards(Suits.getTrump());
        }

    }

    public void loop() throws Exception {
        boolean isRunning = true;

        whoIsFirst();

        System.out.println("В игре: ");
        for (IPlayer p : players) {
            p.printName();
        }

        int i = 0;
        while (isRunning) {

            while (i <= players.size()) {
                if (i == players.size()) {
                    i = 0;
                }
                IPlayer p = players.get(i);

                if (p.checkSkip()) {
                    ++i;
                    continue;
                }

                IPlayer opponent = getOpponent(p);

                battle(p, opponent);

                takeCards();

                System.out.println("Бито: " + beaten.getLength() + " карт");
                System.out.println("В колоде: " + stack.getLength() + " карт");

                if (p.getCards().size() <= 0 && stack.getLength() <= 0) {
                    System.out.println("Игрок " + p.getName() + " выходит из игры");
                    p.setOut(true);
                }

                if (opponent.getCards().size() <= 0 && stack.getLength() <= 0) {
                    System.out.println("Игрок " + opponent.getName() + " выходит из игры");
                    opponent.setOut(true);
                }

                int countPlayers = 0;

                System.out.println("В игре: ");
                for (IPlayer pp : players) {
                    System.out.print(pp.getOut() ? "" : pp.getName() + "\n");
                    if (!pp.getOut()) {
                        ++countPlayers;
                    }
                }

                if (countPlayers == 1) {
                    for (IPlayer pp : players) {
                        if (!pp.getOut()) {
                            fool = pp;
                        }
                    }
                    System.out.println("В дураках остался " + fool.getName());
                    isRunning = false;
                    break;
                }

                ++i;
                if (exit()) {
                    isRunning = false;
                    break;
                }
            }
        }
        System.out.println(fool != null ? "Пожелаем игроку " + fool.getName() + " удачи в следующей игре." : "Выход");
    }
}
