package org.example.blackjack;

import java.util.ArrayList;

public class Deck {
    // BlackJack Deck Class
    private ArrayList<Card> deck; // Array of cards

    public Deck(){
        deck = new ArrayList<Card>();
        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 13; j++){
                deck.add(new Card(Card.Faces[j]));
            }
        }
    }
    // reset the deck
    public void reset(){
        deck = new ArrayList<Card>();
        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 13; j++){
                deck.add(new Card(Card.Faces[j]));
            }
        }
    }
    // deal a card
    public Card deal(){
        return deck.remove((int)(Math.random() * deck.size()));
    }
}
