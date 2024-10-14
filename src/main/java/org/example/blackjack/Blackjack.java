package org.example.blackjack;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.scene.layout.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;


public class Blackjack extends Application {
    // update the images of the cards
    public void updateImg(ArrayList<Card> playerHand, ListView<ImageView> playerHandImg, Image card2, Image card3, Image card4, Image card5, Image card6, Image card7, Image card8, Image card9, Image card10, Image cardJ, Image cardQ, Image cardK, Image cardA) {
        for (int i = 0; i < playerHand.size(); i++) {
            if (playerHand.get(i).getFace().equals("A")) {
                playerHandImg.getItems().add(new ImageView(cardA));
            } else if (playerHand.get(i).getFace().equals("2")) {
                playerHandImg.getItems().add(new ImageView(card2));
            } else if (playerHand.get(i).getFace().equals("3")) {
                playerHandImg.getItems().add(new ImageView(card3));
            } else if (playerHand.get(i).getFace().equals("4")) {
                playerHandImg.getItems().add(new ImageView(card4));
            } else if (playerHand.get(i).getFace().equals("5")) {
                playerHandImg.getItems().add(new ImageView(card5));
            } else if (playerHand.get(i).getFace().equals("6")) {
                playerHandImg.getItems().add(new ImageView(card6));
            } else if (playerHand.get(i).getFace().equals("7")) {
                playerHandImg.getItems().add(new ImageView(card7));
            } else if (playerHand.get(i).getFace().equals("8")) {
                playerHandImg.getItems().add(new ImageView(card8));
            } else if (playerHand.get(i).getFace().equals("9")) {
                playerHandImg.getItems().add(new ImageView(card9));
            } else if (playerHand.get(i).getFace().equals("10")) {
                playerHandImg.getItems().add(new ImageView(card10));
            } else if (playerHand.get(i).getFace().equals("J")) {
                playerHandImg.getItems().add(new ImageView(cardJ));
            } else if (playerHand.get(i).getFace().equals("Q")) {
                playerHandImg.getItems().add(new ImageView(cardQ));
            } else if (playerHand.get(i).getFace().equals("K")) {
                playerHandImg.getItems().add(new ImageView(cardK));
            }
        }
    }

    @Override
    public void start(Stage stage) throws IOException {
        stage.setTitle("blackjack");

        // GUI

        // Dealer's Gui
        Label dealerLabel = new Label("Dealer Hand");
        Label dealerValue = new Label("Value: ");

        ListView<ImageView> dealerHandImg = new ListView<ImageView>();

        dealerHandImg.setOrientation(Orientation.HORIZONTAL);
        dealerHandImg.setStyle("-fx-background-color: ForestGreen; -fx-text-fill: ForestGreen;");
        dealerHandImg.setStyle("-fx-control-inner-background: ForestGreen; -fx-border-color: transparent;");

        HBox dealerLabelBox = new HBox(dealerLabel, dealerValue);

        dealerLabelBox.setAlignment(javafx.geometry.Pos.CENTER);
        dealerLabelBox.setSpacing(30);

        VBox dealerBox = new VBox(dealerLabelBox, dealerHandImg);
        dealerBox.setStyle("-fx-background-color: ForestGreen; -fx-text-fill: ForestGreen;");

        dealerLabel.setStyle("-fx-text-fill: white; -fx-font-weight: bold;");
        dealerValue.setStyle("-fx-text-fill: white; -fx-font-weight: bold;");

        // Player's Gui
        Label playerLabel = new Label("Player Hand");
        Label playerValue = new Label("Value: ");

        ListView<ImageView> playerHandImg = new ListView<ImageView>(); // changed

        playerHandImg.setOrientation(Orientation.HORIZONTAL);
        playerHandImg.setStyle("-fx-background-color: ForestGreen; -fx-text-fill: ForestGreen;");
        playerHandImg.setStyle("-fx-control-inner-background: ForestGreen;");


        playerLabel.setStyle("-fx-text-fill: white; -fx-font-weight: bold;");
        playerValue.setStyle("-fx-text-fill: white; -fx-font-weight: bold;");

        HBox playerLabelBox = new HBox(playerLabel, playerValue);

        playerLabelBox.setAlignment(javafx.geometry.Pos.CENTER);
        playerLabelBox.setSpacing(30);

        VBox playerBox = new VBox(playerLabelBox, playerHandImg); // changed

        playerBox.setStyle("-fx-background-color: ForestGreen; -fx-text-fill: ForestGreen;");


        // Buttons
        Button Start = new Button("Start");
        Button Hit = new Button("Hit");
        Button Stand = new Button("Stand");
        HBox buttonBox = new HBox(Start, Hit, Stand);
        buttonBox.setStyle("-fx-background-color: ForestGreen; -fx-text-fill: ForestGreen;");
        buttonBox.setAlignment(javafx.geometry.Pos.CENTER);

        Start.setStyle("-fx-text-fill: black; -fx-font-weight: bold; -fx-background-color: white");
        Hit.setStyle("-fx-text-fill: black; -fx-font-weight: bold; -fx-background-color: white");
        Stand.setStyle("-fx-text-fill: black; -fx-font-weight: bold; -fx-background-color: white");

        // label for score
        Label playerScore = new Label("Player Score: ");
        Label dealerScore = new Label("Dealer Score: ");
        VBox scoreBox = new VBox(playerScore, dealerScore);
        scoreBox.setStyle("-fx-background-color: ForestGreen; -fx-text-fill: ForestGreen;");

        playerScore.setStyle("-fx-text-fill: white; -fx-font-weight: bold;");
        dealerScore.setStyle("-fx-text-fill: white; -fx-font-weight: bold;");


        // score
        Label score = new Label("!Score!");
        score.setStyle("-fx-text-fill: white; -fx-font-weight: bold;");

        VBox scoreBox2 = new VBox(score);
        scoreBox2.setStyle("-fx-background-color: ForestGreen; -fx-text-fill: ForestGreen;");
        scoreBox2.setSpacing(50);

        // scores add up
        HBox scoreBox3 = new HBox(scoreBox, scoreBox2);
        scoreBox3.setSpacing(50);

        // add all the boxes to the scene
        VBox root = new VBox(dealerBox, playerBox, buttonBox, scoreBox3);
        root.setStyle("-fx-background-color: ForestGreen;");

        // images
        Image card2 = new Image(new FileInputStream("src/cards/2.png"));
        Image card3 = new Image(new FileInputStream("src/cards/3.png"));
        Image card4 = new Image(new FileInputStream("src/cards/4.png"));
        Image card5 = new Image(new FileInputStream("src/cards/5.png"));
        Image card6 = new Image(new FileInputStream("src/cards/6.png"));
        Image card7 = new Image(new FileInputStream("src/cards/7.png"));
        Image card8 = new Image(new FileInputStream("src/cards/8.png"));
        Image card9 = new Image(new FileInputStream("src/cards/9.png"));
        Image card10 = new Image(new FileInputStream("src/cards/10.png"));
        Image cardJ = new Image(new FileInputStream("src/cards/J.png"));
        Image cardQ = new Image(new FileInputStream("src/cards/Q.png"));
        Image cardK = new Image(new FileInputStream("src/cards/K.png"));
        Image cardA = new Image(new FileInputStream("src/cards/A.png"));

        // functionality

        // create a player and dealer
        Player player = new Player(new Deck());
        Player dealer = new Player(Player.deck);
        // create a deck
        Deck deck = new Deck();
        // create a player and dealer hands
        ArrayList<Card> playerHand = player.getHand();
        ArrayList<Card> dealerHand = dealer.getHand();

        AtomicInteger playerScoreInt = new AtomicInteger();
        AtomicInteger dealerScoreInt = new AtomicInteger();

        // disable the hit and stand buttons
        Hit.setDisable(true);
        Stand.setDisable(true);

        // Start button action
        Start.setOnAction(e -> {

            // clear the hands
            playerHandImg.getItems().clear();
            dealerHandImg.getItems().clear();

            // enable the hit and stand buttons
            Hit.setDisable(false);
            Stand.setDisable(false);
            // disable the start button
            Start.setDisable(true);

            player.hit();
            player.hit();
            // update player's hand

            playerValue.setText("Value: " + player.getValue());

            // get the list of cards of the player
            dealer.hit();
            dealer.hit();

            dealerValue.setText("Value: " + dealer.getValue());

            // set the images of the cards
            updateImg(playerHand, playerHandImg, card2, card3, card4, card5, card6, card7, card8, card9, card10, cardJ, cardQ, cardK, cardA);
            // dealer hand
            updateImg(dealerHand, dealerHandImg, card2, card3, card4, card5, card6, card7, card8, card9, card10, cardJ, cardQ, cardK, cardA);

            // if the winner is determined in the first round
            if(player.getValue() == 21 && dealer.getValue() == 21){
                // draw
                score.setText("Draw!");
                // clear the hands
                player.clearHand();
                dealer.clearHand();
                // listview clear
                // enable the start button
                Start.setDisable(false);
                // disable the hit and stand buttons
                Hit.setDisable(true);
                Stand.setDisable(true);
            }
            else if(dealer.getValue() == 21){
                // dealer wins
                dealerScoreInt.getAndIncrement();
                dealerScore.setText("Dealer Score: " + dealerScoreInt);
                score.setText("Dealer Wins!");
                // clear the hands
                player.clearHand();
                dealer.clearHand();
                // enable the start button
                Start.setDisable(false);
                // disable the hit and stand buttons
                Hit.setDisable(true);
                Stand.setDisable(true);
            }
            else if(player.getValue() == 21){
                // player wins
                playerScoreInt.getAndIncrement();
                playerScore.setText("Player Score: " + playerScoreInt);
                score.setText("Player Wins!");
                // clear the hands
                player.clearHand();
                dealer.clearHand();
                // enable the start button
                Start.setDisable(false);
                // disable the hit and stand buttons
                Hit.setDisable(true);
                Stand.setDisable(true);
            }




            // hit button action
            Hit.setOnAction(e2 -> {
                // hit the player
                // update the GUI
                player.hit();
                playerValue.setText("Value: " + player.getValue());
                // clear the player hand
                playerHandImg.getItems().clear();
                // set the images of the cards
                updateImg(playerHand, playerHandImg, card2, card3, card4, card5, card6, card7, card8, card9, card10, cardJ, cardQ, cardK, cardA);
                if(player.isBust()){
                    // player busts
                    // dealer wins
                    // update the GUI
                    // clear the hands
                    // deal 2 cards to the player and dealer

                   // dealer wins
                    dealerScoreInt.getAndIncrement();
                    dealerScore.setText("Dealer Score: " + dealerScoreInt);
                    score.setText("dealer Wins! + Player Busts");
                    // clear the hands
                    player.clearHand();
                    dealer.clearHand();
                    // enable the start button
                    Start.setDisable(false);
                    // disable the hit and stand buttons
                    Hit.setDisable(true);
                    Stand.setDisable(true);

                }
            });
            // stand button action
            Stand.setOnAction(e3 -> {
                // stand the player

                // dealer hits
                while(!dealer.stand(player.getValue())){
                   dealer.hit();
                   dealerValue.setText("Value: " + dealer.getValue());
                    // clear the player hand
                   dealerHandImg.getItems().clear();
                    // set the images of the cards
                    updateImg(dealerHand, dealerHandImg, card2, card3, card4, card5, card6, card7, card8, card9, card10, cardJ, cardQ, cardK, cardA);
                    if(dealer.isBust()){
                        // dealer busts

                        // player wins
                        playerScoreInt.getAndIncrement();
                        playerScore.setText("Player Score: " + playerScoreInt);
                        score.setText("Player Wins! + Dealer Busts!");
                        // clear the hands
                        player.clearHand();
                        dealer.clearHand();
                        // enable the start button
                        Start.setDisable(false);
                        // disable the hit and stand buttons
                        Hit.setDisable(true);
                        Stand.setDisable(true);
                        break;
                    }
                }
                if(player.getValue() == dealer.getValue()){
                    score.setText("Draw!");
                    // clear hands
                    player.clearHand();
                    dealer.clearHand();
                    // enable the start button
                    Start.setDisable(false);
                    // disable the hit and stand buttons
                    Hit.setDisable(true);
                    Stand.setDisable(true);
                }
                else if(player.getValue()<dealer.getValue()){
                    dealerScoreInt.getAndIncrement();
                    dealerScore.setText("Dealer Score: " + dealerScoreInt);
                    score.setText("Dealer Wins!");
                    // clear the hands
                    player.clearHand();
                    dealer.clearHand();
                    // enable the start button
                    Start.setDisable(false);
                    // disable the hit and stand buttons
                    Hit.setDisable(true);
                    Stand.setDisable(true);
                }
                else if(player.getValue()>dealer.getValue()){
                    playerScoreInt.getAndIncrement();
                    playerScore.setText("Player Score: " + playerScoreInt);
                    score.setText("Player Wins!");
                    // clear the hands
                    player.clearHand();
                    dealer.clearHand();
                    // enable the start button
                    Start.setDisable(false);
                    // disable the hit and stand buttons
                    Hit.setDisable(true);
                    Stand.setDisable(true);
                }

                    updateImg(dealerHand, dealerHandImg, card2, card3, card4, card5, card6, card7, card8, card9, card10, cardJ, cardQ, cardK, cardA);
            });
            // end of gui
        });


        // scene
        Scene scene = new Scene(root, 800, 800);
      //  scene.getStylesheets().add(getClass().getResource("lisStyles.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}