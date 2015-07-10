/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datamodel.cards;

import java.util.Random;

/**
 *
 * @author JotaSe
 */
public class Deck {

    private int NEXT_CARD = 0;
    private Card[] cards = new Card[52];

    public Deck() {
        createDeck();
    }

    private void createDeck() {
        int i = 0;
        for (Card.type type : Card.type.values()) {
            for (Card.value card : Card.value.values()) {
                cards[i] = new Card(card, type);
                i++;
            }
        }
    }

    public void mix() {

        Random rnd = new Random();
        for (int i = cards.length - 1; i > 0; i--) {
            int index = rnd.nextInt(i + 1);
            // Simple swap
            Card a = cards[index];
            cards[index] = cards[i];
            cards[i] = a;
        }

    }

    public Card getNextCard() {
        if (NEXT_CARD < cards.length) {
            NEXT_CARD++;
        }
        return cards[NEXT_CARD];
    }

    public Card getpreviousCard() {
        if (NEXT_CARD > 0) {
            NEXT_CARD--;
        }
        return cards[NEXT_CARD];
    }

}
