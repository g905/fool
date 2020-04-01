package ru.g905.fool;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author g905
 */
class Stack {

    ArrayList<Card> cards = new ArrayList<>();

    Stack(boolean empty) {
        if (!empty) {
            for (Suits s : Suits.values()) {
                for (Weights w : Weights.values()) {
                    Card card = new Card(s, w);
                    cards.add(card);
                }
            }
        }
    }

    public int getLength() {
        return cards.size();
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    public Card takeCard() throws Exception {
        if (cards.size() <= 0) {
            throw new Exception("Колода пуста");
        }
        Card cardToReturn = cards.get(cards.size() - 1);
        cards.remove(cards.size() - 1);
        return cardToReturn;
    }

    public void putCard(Card card) {
        cards.add(card);
    }

    public void putCards(ArrayList<Card> cards) {
        this.cards.addAll(cards);
    }

    public void putCardToFirst(Card card) {
        cards.add(0, card);
    }

    public void printStack() throws Exception {
        if (cards.size() <= 0) {
            throw new Exception("Колода пуста");
        }
        cards.forEach((c) -> {
            c.printCard();
        });
    }

    public void setTrump(Suits trump) throws Exception {
        if (cards.size() <= 0) {
            throw new Exception("Колода пуста");
        }
        cards.forEach((c) -> {
            c.setValue(trump);
        });
    }

}
