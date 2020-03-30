/*
 *
 */
package ru.g905.fool;

import java.util.ArrayList;

/**
 *
 * @author g905
 */
public class GameLogic implements IGameLogic {

    private Stack stack;

    private Suits trump;

    private ArrayList<Player> players;

    private final int CARDS_QUANTITY = 6;

    private int firstPlayerIdx;

    @Override
    public void init() {
        players = new ArrayList<>();
        stack = new Stack();
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

        //Player p = players.get(0);
        //p.takeCards(stack, CARDS_QUANTITY);
        //p.printCards();

        /*Scanner in = new Scanner(System.in);

        while (a) {

            System.out.println("\nВведите число от 1 до " + stack.getLength() + " (0 - Выход):\n");

            int num;

            try {
                num = in.nextInt();
            } catch (Exception e) {
                System.out.println("\nВы ввели не число, а какую-то хрень, пидор. Идите нахуй.\n");
                break;
            }

            if (num == 0) {
                break;
            }

            Card card = stack.getCard(num);
            if (card != null) {
                card.printCard();
            }

            System.out.println("\nРазмер колоды: " + stack.getLength() + "\n");
            stack.printStack();

        }*/
    }

    /**
     * Раздача карт
     *
     * @throws Exception
     */
    public void takeOff() throws Exception {

        Card trumpCard = stack.takeCard();

        trump = trumpCard.getSuit();

        stack.setTrump(trump);

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

        System.out.println("Козырь: " + trump.rusName());
        System.out.println("Роздано " + taken + " карт");
        System.out.println("В колоде " + stack.getLength() + " карт");
    }

    public void whoIsFirst() {
        firstPlayerIdx = 0;
        // TODO: getting first player (lowest trump)
    }

    public void loop() {
        // TODO: implement game process
    }
}
