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
enum Suits {
    HEARTS(1),
    DIAMONDS(2),
    CLUBS(3),
    SPADES(4);

    final private int value;

    Suits(int value) {
        this.value = value;
    }

    public String rusName() {
        switch (this.name()) {
            case "HEARTS":
                return "ЧЕРВИ";
            case "DIAMONDS":
                return "БУБИ";
            case "CLUBS":
                return "ТРЕФЫ";
            case "SPADES":
                return "ПИКИ";
        }
        return this.name();
    }
};
