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

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author g905
 */
class Stack {

    ArrayList<Card> cards = new ArrayList<>();

    Stack() {
        for (Suits s : Suits.values()) {
            for (Weights w : Weights.values()) {
                Card card = new Card(s, w);
                cards.add(card);
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
