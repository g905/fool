package ru.g905.fool;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author g905
 */
class Player {

    final private String name;

    private final ArrayList<Card> cards;

    private boolean skip = false;

    private boolean out = false;

    Player(String nm) {
        this.name = nm;
        cards = new ArrayList<>();
    }

    public void takeCards(Stack s, int q) {
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

    public void setSkip(boolean val) {
        skip = val;
    }

    public boolean getSkip() {
        return skip;
    }

    public void setOut(boolean val) {
        out = val;
    }

    public boolean getOut() {
        return out;
    }

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

    public String getName() {
        return name;
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
                //System.out.print("  ");
                //c.printCard();
            });
        }
    }

    public ArrayList<Card> getCards() {
        return cards;
    }

    public void sortCards(Suits trump) {
        Collections.sort(cards);
    }

    public Card attack() {
        sortCards(Suits.getTrump());
        Card cardToAttack = cards.get(0);
        cards.remove(0);
        System.out.println("Игрок " + name + " ходит картой " + cardToAttack.getCard());
        return cardToAttack;
    }

    public Card defence(Card cardToDefeat) {
        sortCards(Suits.getTrump());
        Card greaterCard = null;
        for (Card card : cards) {
            if (card.greaterThan(cardToDefeat)) {
                greaterCard = card;
                cards.remove(card);
                break;
            }
        }
        if (greaterCard == null) {
            cards.add(cardToDefeat);
            skip = true;
        }

        String log = greaterCard != null ? "Игрок " + name + " отбивается картой " + greaterCard.getCard() : "Игрок " + name + " берет карту " + cardToDefeat.getCard();
        sortCards(Suits.getTrump());
        System.out.println(log);

        return greaterCard;
    }

    public boolean canBeat(Card card, Card cardToDefeat) {
        return card.greaterThan(cardToDefeat);
    }

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
}
