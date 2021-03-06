package ru.g905.fool;

import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import static ru.g905.fool.GameLogic.CARDS_QUANTITY;

/**
 *
 * @author g905
 */
class Player implements IPlayer {

    final private String name;

    private final ArrayList<Card> cards;

    private boolean skip = false;

    private boolean out = false;

    Player(String nm) {
        this.name = nm;
        System.out.println("Игрок " + nm + " входит в игру.");
        cards = new ArrayList<>();
    }

    @Override
    public void takeCards(Stack s, int q) {
        if (s.getLength() <= 0) {
            return;
        }
        if (cards.size() >= GameLogic.CARDS_QUANTITY) {
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

    @Override
    public void setSkip(boolean val) {
        skip = val;
    }

    @Override
    public boolean getSkip() {
        return skip;
    }

    @Override
    public void setOut(boolean val) {
        out = val;
    }

    @Override
    public boolean getOut() {
        return out;
    }

    public void takeCard(Stack s) throws Exception {
        try {
            cards.add(s.takeCard());
        } catch (Exception ex) {

        }
    }

    public void printName() {
        System.out.println(this.name);
    }

    public void setName(String name) {
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
                //System.out.print("\t");
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
        try {
            TimeUnit.MILLISECONDS.sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Player.class.getName()).log(Level.SEVERE, null, ex);
        }
        sortCards(Suits.getTrump());
        Card cardToAttack = cards.get(0);
        cards.remove(cardToAttack);
        System.out.println("Игрок " + name + " ходит картой " + cardToAttack.getCard());
        return cardToAttack;
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

    public boolean checkSkip() {
        if (skip) {
            System.out.println("Игрок " + name + " взял карты, пропускаем.");
            setSkip(false);
            return true;
        }
        if (out) {
            System.out.println("Игрок " + name + " вышел, пропускаем.");
            return true;
        }

        return false;
    }

    public ArrayList<Card> tDefence(Stack table) {
        sortCards(Suits.getTrump());

        System.out.println("Игрок " + name + " пытается отбиться:");

        ArrayList<Card> cardsToReturn = new ArrayList<>();

        out:
        for (Card tc : table.getCards()) {
            if (tc.getBeaten()) {
                continue;
            }
            for (Card c : cards) {
                if (c.greaterThan(tc)) {
                    System.out.println("\tПобили карту " + tc.getCard() + " картой " + c.getCard());
                    cards.remove(c);
                    cardsToReturn.add(c);
                    tc.setBeaten(true);
                    c.setBeaten(true);
                    break;
                }
                try {
                    TimeUnit.MILLISECONDS.sleep(100);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Player.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

        int count = 0;

        for (Card c : table.getCards()) {
            if (!c.getBeaten()) {
                ++count;
            }
        }

        if (count > 0) {
            System.out.println("Не побили " + count + " карт. Берем:");
            for (Card c : table.getCards()) {
                System.out.println("\t" + c.getCard());
            }
            cards.addAll(cardsToReturn);
            cardsToReturn.clear();
            cards.addAll(table.getCards());
            table.getCards().clear();
            skip = true;
            for (Card c : cards) {
                c.setBeaten(false);
            }
        } else {
            cards.removeAll(cardsToReturn);
        }
        return cardsToReturn;
    }

    @Override
    public void toss(Stack table, IPlayer opponent) {
        if (out) {
            return;
        }
        System.out.println("Подкидывает игрок " + name);
        int limit = opponent.getQuant() - 1;
        if (limit > CARDS_QUANTITY - 1) {
            limit = CARDS_QUANTITY - 1;
        }
        System.out.println("Можем подкинуть не более " + limit + " карт.");
        ArrayList<Card> cardsToToss = new ArrayList<>();
        int count = 0;

        for (Card tc : table.getCards()) {
            if (count >= limit) {
                break;
            }

            for (Card c : cards) {
                if (c.getWeight() == tc.getWeight()) {
                    cardsToToss.add(c);
                }
            }
            cards.removeAll(cardsToToss);
            ++count;
        }
        if (!cardsToToss.isEmpty()) {
            for (Card c : cardsToToss) {
                System.out.println("\t" + c.getCard());

                try {
                    TimeUnit.MILLISECONDS.sleep(1000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Player.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            cards.removeAll(cardsToToss);
            table.putCards(cardsToToss);
        }
    }
}
