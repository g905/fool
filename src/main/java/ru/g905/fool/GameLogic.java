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

    private ArrayList<Player> players;

    private Stack beaten;

    private Player fool;

    public static final int CARDS_QUANTITY = 6;

    private int firstPlayerIdx;

    @Override
    public void init() {
        players = new ArrayList<>();
        stack = new Stack(false);
        beaten = new Stack(true);
        stack.shuffle();

        Player vasya = new Player("Вася");
        Player petya = new Player("Петя");
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

    public boolean exit() {
        Scanner in = new Scanner(System.in);
        System.out.println("Прервать? Д/Н");
        String a;
        a = in.nextLine();
        return ("Д".equals(a) || "д".equals(a) || "y".equals(a) || "Y".equals(a));
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
            for (Player p : players) {
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

    private Player whoIsFirst() {
        Player first = players.get(0);
        for (Player p : players) {
            Card lowesTrump = p.getLowestTrump(trump);
            if (lowesTrump != null) {
                if (first.getLowestTrump(trump) == null || lowesTrump.compareTo(first.getLowestTrump(trump)) < 0) {
                    first = p;
                }
            }
        }
        return first;
    }

    /**
     *
     * @todo: Если игрок вышел из игры, то не выбирать его в оппоненты
     * @param idx
     * @return
     */
    private Player getOpponent(Player p) {
        int idx = players.indexOf(p);
        if (idx == players.size() - 1) {
            return players.get(0);
        } else {
            return players.get(idx + 1);
        }
    }

    public void loop() throws Exception {
        boolean isRunning = true;

        Player first = whoIsFirst();

        players.remove(first);
        players.add(0, first);

        System.out.println("В игре: ");
        for (Player p : players) {
            p.printName();
        }

        int i = 0;
        while (isRunning) {

            while (i <= players.size()) {
                if (i == players.size()) {
                    i = 0;
                }
                System.out.println("i = " + i);
                Player p = players.get(i);
                if (p.getSkip()) {
                    System.out.println("Игрок " + p.getName() + " взял карты, пропускаем.");
                    p.setSkip(false);
                    ++i;
                    continue;
                }
                if (p.getOut()) {
                    System.out.println("Игрок " + p.getName() + " вышел, пропускаем.");
                    ++i;
                    continue;
                }
                System.out.println("Ходит " + p.getName());

                Player opponent = getOpponent(p);
                System.out.println("Отбивается " + opponent.getName());

                p.printCards();
                opponent.printCards();

                Card attackC = p.attack();
                Card winnerCard = opponent.defence(attackC);

                if (winnerCard != null) {
                    System.out.println("Бито. ");
                    beaten.putCard(winnerCard);
                    beaten.putCard(attackC);
                }

                p.takeCards(stack, CARDS_QUANTITY);
                opponent.takeCards(stack, CARDS_QUANTITY);

                System.out.println("Бито: " + beaten.getLength() + " карт");
                System.out.println("В колоде: " + stack.getLength() + " карт");

                if (p.getCards().size() <= 0) {
                    System.out.println("Игрок " + p.getName() + " выходит из игры");
                    p.setOut(true);
                }

                if (opponent.getCards().size() <= 0) {
                    System.out.println("Игрок " + opponent.getName() + " выходит из игры");
                    opponent.setOut(true);
                }

                int countPlayers = 0;

                System.out.println("В игре: ");
                for (Player pp : players) {
                    System.out.print(pp.getOut() ? "" : pp.getName() + "\n");
                    if (!pp.getOut()) {
                        ++countPlayers;
                    }
                }

                if (countPlayers == 1) {
                    for (Player pp : players) {
                        if (!pp.getOut()) {
                            fool = pp;
                        }
                    }
                    System.out.println("В дураках остался " + fool.getName());
                    isRunning = false;
                    break;
                }

                ++i;
                //System.out.println("i = " + i);
                if (exit()) {
                    isRunning = false;
                    break;
                }
            }
        }
        System.out.println(fool != null ? "Пожелаем игроку " + fool.getName() + " удачи в следующей игре." : "Выход");
    }
}
