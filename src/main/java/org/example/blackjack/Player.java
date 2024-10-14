package org.example.blackjack;

import java.util.ArrayList;

public class Player {
    // BlackJack Player Class
    // holds a maximum of 12 cards
    private ArrayList<Card> hand; // Array of cards
    public static Deck deck; // deck of cards

    public Player(Deck deck){
        hand = new ArrayList<Card>();
        this.deck = deck;
    }
    // get hand
    public ArrayList<Card> getHand(){
        return hand;
    }
    // get value of hand
    public int getValue(){
        int value = 0;
        int aces = 0;
        for(Card card : hand){
            value += card.getValue();
            if(card.getFace().equals("A")){
                aces++;
            }
        }
        while(value > 21 && aces > 0){
            value -= 10;
            aces--;
        }
        return value;
    }
    // clear hand
    public void clearHand(){
        hand.clear();
    }
    // stand boolean
    public boolean stand(int otherPlayerValue){
        if(getValue() > otherPlayerValue){
            return true;
        }
        else{
            if(getValue() > 19){
                return true;
            }
            // if the player value is 16 or higher, stand 50% of the time
            if(getValue() >= 16){
                // half of the time
                return Math.random() < 0.5;
            }
            else{
                return false;
            }
        }
    }
    // hit void
    public void hit(){
        hand.add(deck.deal());
    }
    // isBust boolean
    public boolean isBust(){
        return getValue() > 21;
    }

}
