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

    private static Suits trump;

    public static Suits getTrump() {
        return trump;
    }

    public static void setTrump(Suits trump) {
        Suits.trump = trump;
    }

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
