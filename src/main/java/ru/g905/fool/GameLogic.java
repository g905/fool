package ru.g905.fool;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;
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

    private final int CARDS_QUANTITY = 6;

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
                if (lowesTrump.compareTo(first.getLowestTrump(trump)) < 0) {
                    first = p;
                }
            }
        }
        return first;
    }

    /**
     *
     * @param idx
     * @return
     */
    private Player getOpponent(Player p) {
        int idx = players.indexOf(p);
        if (idx >= players.size() - 1) {
            idx = -1;
        }
        return players.get(idx + 1);
    }

    private Player getPlayer(int idx) {
        if (idx >= players.size()) {
            idx = 0;
        }
        Player p = players.get(idx);
        if (p.getCards().size() <= 0) {
            System.out.println("Игрок " + p.getName() + " выходит из игры.");
            Player pl = p;
            p = players.get(++idx);
            players.remove(pl);
        }
        if (p.getSkip()) {
            System.out.println("Игрок " + p.getName() + " пропускает ход");
            p.setSkip(false);
            p = players.get(++idx);
        }
        return p;
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

        while (isRunning) {
            int i = 0;
            while (i < players.size()) {
                if (i == players.size()) {
                    i = 0;
                }
                Player p = getPlayer(i);
                System.out.println("Ходит " + p.getName());

                Player opponent = getOpponent(p);
                System.out.println("Отбивается " + opponent.getName());

                Card attackC = p.attack();

                Card winnerCard = opponent.defence(attackC);

                if (winnerCard != null) {
                    System.out.println("Бито. ");
                    beaten.putCard(winnerCard);
                    beaten.putCard(attackC);

                }

                ++i;
                System.out.println("i = " + i);
                if (exit()) {
                    isRunning = false;
                    break;
                }
            }
            /*Player attackP = players.get(firstPlayerIdx);
            Player defenceP = players.get(firstPlayerIdx + 1);

            Card attackC = attackP.attack();
            System.out.print("Игрок ");
            attackP.printName();
            System.out.print(" ходит картой ");
            attackC.printCard();

            Card winnerCard = defenceP.defence(attackC);
            if (winnerCard == null) {
                System.out.print("Игрок ");
                defenceP.printName();
                System.out.println(" взял карту");
                attackC.printCard();
            } else {
                System.out.print("Игрок ");
                defenceP.printName();
                System.out.print(" отбивает ");
                System.out.print(" картой ");
                winnerCard.printCard();
            }

            attackP.printCards();
            defenceP.printCards();
            attackP.takeCards(stack, CARDS_QUANTITY);
            defenceP.takeCards(stack, CARDS_QUANTITY);
            System.out.println("Бито. Подкидывать мы пока не умеем.");

            beaten.putCard(winnerCard);
            beaten.putCard(attackC);

            attackP.printCards();
            defenceP.printCards();
            System.out.println("Козырь: " + Suits.getTrump().rusName());
            System.out.println("В колоде: " + stack.getLength() + " карт");
            System.out.println("Бито:  " + beaten.getLength() + " карт");
            isRunning = false;*/

        }
    }
}
