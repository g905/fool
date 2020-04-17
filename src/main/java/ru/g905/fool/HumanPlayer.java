/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.g905.fool;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import static ru.g905.fool.GameLogic.CARDS_QUANTITY;

/**
 *
 * @author zharnikov
 */
public class HumanPlayer implements IPlayer {

    final private String name;

    private final ArrayList<Card> cards;

    private boolean skip = false;

    private boolean out = false;

    private final Scanner in;

    HumanPlayer() {
        in = new Scanner(System.in);
        System.out.println("Как вас зовут?");
        String a;
        a = in.nextLine();
        this.name = a;
        System.out.println("Игрок " + a + " входит в игру.");
        cards = new ArrayList<>();
    }

    @Override
    public void takeCards(Stack s, int q) {
        if (out) {
            return;
        }
        if (s.getLength() <= 0) {
            System.out.println("Колода пуста. Игрок " + name + " не берет карты.");
            return;
        }
        if (cards.size() >= GameLogic.CARDS_QUANTITY) {
            System.out.println("Игрок " + name + " не берет карты.");
            return;
        }
        int count = 0;
        while (cards.size() < q) {
            try {
                cards.add(s.takeCard());
            } catch (Exception ex) {
                break;
            }
            ++count;
        }
        System.out.println("Игрок " + name + " берет " + count + " карт (ы).");
    }

    @Override
    public void setSkip(boolean val) {
        skip = val;
    }

    @Override
    public boolean getSkip() {
        return skip;
    }

    @Override
    public void setOut(boolean val) {
        out = val;
    }

    @Override
    public boolean getOut() {
        return out;
    }

    @Override
    public void takeCard(Stack s) throws Exception {
        //System.out.println("Игрок " + name + " берет карту");
        try {
            cards.add(s.takeCard());
        } catch (Exception ex) {

        }
    }

    public void printName() {
        System.out.println(this.name);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getQuant() {
        return cards.size();
    }

    @Override
    public void printCards() {
        System.out.print("У игрока " + name);
        if (cards.size() <= 0) {
            System.out.println(" нет карт.");
        } else {
            System.out.println(" " + cards.size() + " карт(a): ");
            this.cards.forEach((c) -> {
                //System.out.print("\t");
                //c.printCard();
            });
        }
    }

    @Override
    public ArrayList<Card> getCards() {
        return cards;
    }

    @Override
    public void sortCards(Suits trump) {
        Collections.sort(cards);
    }

    @Override
    public Card attack() {
        sortCards(Suits.getTrump());
        System.out.println("Ваш ход! ");
        System.out.println("Козырь - " + Suits.getTrump().rusName());
        System.out.println("У вас такие карты: ");
        int count = 1;
        for (Card c : cards) {
            System.out.print(count + ". ");
            c.printCard();
            ++count;
        }
        Boolean ask = true;
        int a = -1;
        while (ask) {
            System.out.println("Какой картой ходить? ");
            a = in.nextInt();
            if (--a <= cards.size() && a >= 0) {
                ask = false;
            }
        }
        if (a > -1) {
            Card cardToAttack = cards.get(a);
            cards.remove(cardToAttack);
            System.out.println("Вы ходите картой " + cardToAttack.getCard());
            return cardToAttack;
        }
        return null;
    }

    public boolean canBeat(Card card, Card cardToDefeat) {
        return card.greaterThan(cardToDefeat);
    }

    @Override
    public Card getLowestTrump(Suits trump) {
        Card lowest = null;
        for (int i = 0; i < cards.size(); ++i) {
            if (cards.get(i).isTrump(trump)) {
                lowest = cards.get(i);
                if (cards.get(i).compareTo(lowest) < 0) {
                    lowest = cards.get(i);
                }
            }
        }
        return lowest;
    }

    @Override
    public boolean checkSkip() {
        if (skip) {
            System.out.println("Вы взяли карты и пропускаете ход.");
            setSkip(false);
            return true;
        }
        return out;
    }

    public void toss(Stack table, IPlayer opponent) {
        if (out) {
            return;
        }
        System.out.println("Подкидывает игрок " + name);
        int limit = opponent.getQuant() - 1;
        if (limit > CARDS_QUANTITY - 1) {
            limit = CARDS_QUANTITY - 1;
        }
        System.out.println("Можем подкинуть не более " + limit + " карт.");
        ArrayList<Card> cardsToToss = new ArrayList<>();
        int count = 0;

        for (Card tc : table.getCards()) {
            if (count >= limit) {
                break;
            }

            for (Card c : cards) {
                if (c.getWeight() == tc.getWeight()) {
                    cardsToToss.add(c);
                }
            }
            cards.removeAll(cardsToToss);
            ++count;
        }
        if (!cardsToToss.isEmpty()) {
            for (Card c : cardsToToss) {
                System.out.println("\t" + c.getCard());

                try {
                    TimeUnit.MILLISECONDS.sleep(1000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Player.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            cards.removeAll(cardsToToss);
            table.putCards(cardsToToss);
        }
    }

    @Override
    public ArrayList<Card> tDefence(Stack table) {
        sortCards(Suits.getTrump());

        System.out.println("Игрок " + name + " пытается отбиться:");

        ArrayList<Card> cardsToReturn = new ArrayList<>();
        boolean success = true;

        out:
        for (Card tc : table.getCards()) {
            if (tc.getBeaten()) {
                System.out.println("Карта " + tc.getCard() + " уже побита, пропускаем.");
                continue;
            }
            for (Card c : cards) {
                if (c.greaterThan(tc)) {
                    System.out.println("\tПобили карту " + tc.getCard() + " картой " + c.getCard());
                    cards.remove(c);
                    cardsToReturn.add(c);
                    tc.setBeaten(true);
                    c.setBeaten(true);
                    break;
                }
            }
        }

        int count = 0;

        for (Card c : table.getCards()) {
            if (!c.getBeaten()) {
                ++count;
            }
        }

        if (count > 0) {
            System.out.println("Не побили " + count + " карт. Берем:");
            for (Card c : table.getCards()) {
                System.out.println("\t" + c.getCard());
            }
            cards.addAll(cardsToReturn);
            cardsToReturn.clear();
            cards.addAll(table.getCards());
            table.getCards().clear();
            skip = true;
            for (Card c : cards) {
                c.setBeaten(false);
            }
        } else {
            System.out.println("Игрок " + name + " отбился.");
            cards.removeAll(cardsToReturn);
        }
        return cardsToReturn;
    }

}
