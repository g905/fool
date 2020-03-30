package ru.g905.fool;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author g905
 */
class Player {

    final private String name;

    private ArrayList<Card> cards = new ArrayList<>();

    Player(String nm) {
        this.name = nm;
    }

    public void takeCards(Stack s, int q) {
        System.out.println("Игрок " + name + " берет " + q + " карт (ы).");
        while (cards.size() < q) {
            try {
                cards.add(s.takeCard());
            } catch (Exception ex) {

            }
        }
    }

    public void takeCard(Stack s) throws Exception {
        //System.out.println("Игрок " + name + " берет карту");
        cards.add(s.takeCard());
    }

    public void printName() {
        System.out.print(this.name);
    }

    public int getQuant() {
        return cards.size();
    }

    public void printCards() {
        System.out.print("У игрока " + name);
        if (cards.size() <= 0) {
            System.out.println(" нет карт.");
        } else {
            System.out.println(" " + cards.size() + " карт(a): ");
            this.cards.forEach((c) -> {
                System.out.print("  ");
                c.printCard();
            });
        }
    }

    public void sortCards(Suits trump) {
        Collections.sort(cards);
    }
}
