package ru.g905.fool;

/**
 *
 * @author g905
 */
class Card implements Comparable {

    private final Suits suit;
    private final Weights weight;
    private int value;

    Card(Suits suit, Weights weight) {
        this.suit = suit;
        this.weight = weight;
        value = weight.getValue();
    }

    public void printCard() {
        System.out.println(this.weight.rusName() + " " + this.suit.rusName());
    }

    public int getValue() {
        return value;
    }

    public void setValue(Suits trump) {
        value = suit == trump ? value + 13 : value;
    }

    public Suits getSuit() {
        return suit;
    }

    public boolean isTrump(Suits trump) {
        return suit == trump;
    }

    @Override
    public int compareTo(Object o) {
        Card c = (Card) o;
        int comapreWeight = c.getValue();
        return getValue() - comapreWeight;
    }
}
