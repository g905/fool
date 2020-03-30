/*
 * The MIT License
 *
 * Copyright 2020 g905.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
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
