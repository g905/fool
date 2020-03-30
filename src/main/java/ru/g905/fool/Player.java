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
