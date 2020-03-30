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
enum Weights {
    two(2),
    three(3),
    four(4),
    five(5),
    six(6),
    seven(7),
    eight(8),
    nine(9),
    ten(10),
    JACK(11),
    QUEEN(12),
    KING(13),
    ACE(14);

    final private int value;

    Weights(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }

    public String rusName() {
        switch (this.name()) {
            case "two":
                return "двойка";
            case "three":
                return "тройка";
            case "four":
                return "четверка";
            case "five":
                return "пятерка";
            case "six":
                return "шестерка";
            case "seven":
                return "семерка";
            case "eight":
                return "восьмерка";
            case "nine":
                return "девятка";
            case "ten":
                return "десятка";
            case "JACK":
                return "валет";
            case "QUEEN":
                return "дама";
            case "KING":
                return "король";
            case "ACE":
                return "туз";
        }
        return this.name();
    }
}
