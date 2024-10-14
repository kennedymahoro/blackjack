package org.example.blackjack;

public class Card{
    // BlackJack Card Class
    public static String[] Faces = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"}; // Array of faces
    private static int Height = 130; // height of image of the card
    private String face; // face of the card

    public Card(String face){
        this.face = face;
    }
    // get face
    public String getFace(){
        return face;
    }
    // value of the card
    public int getValue(){
        if(face.equals("A")){
            return 11;
        }
        else if(face.equals("J") || face.equals("Q") || face.equals("K")){
            return 10;
        }
        else{
            return Integer.parseInt(face);
        }
    }

}