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
