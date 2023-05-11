package com.example.demo2;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TaxiRating extends Application {

    private int rating = 0;

    @Override
    public void start(Stage primaryStage) {
        // Create UI elements
        Label titleLabel = new Label("Rate your taxi service");
        Label ratingLabel = new Label("Rating: ");
        Label resultLabel = new Label();

        RadioButton radioButton1 = new RadioButton("1");
        RadioButton radioButton2 = new RadioButton("2");
        RadioButton radioButton3 = new RadioButton("3");
        RadioButton radioButton4 = new RadioButton("4");
        RadioButton radioButton5 = new RadioButton("5");

        ToggleGroup toggleGroup = new ToggleGroup();
        radioButton1.setToggleGroup(toggleGroup);
        radioButton2.setToggleGroup(toggleGroup);
        radioButton3.setToggleGroup(toggleGroup);
        radioButton4.setToggleGroup(toggleGroup);
        radioButton5.setToggleGroup(toggleGroup);

        Button submitButton = new Button("Submit");

        // Configure UI elements
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(10));
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setAlignment(Pos.CENTER);
        gridPane.add(titleLabel, 0, 0, 2, 1);
        gridPane.add(radioButton1, 0, 1);
        gridPane.add(radioButton2, 0, 2);
        gridPane.add(radioButton3, 0, 3);
        gridPane.add(radioButton4, 0, 4);
        gridPane.add(radioButton5, 0, 5);
        gridPane.add(ratingLabel, 1, 5);
        gridPane.add(submitButton, 0, 6, 2, 1);
        gridPane.add(resultLabel, 0, 7, 2, 1);

        VBox vbox = new VBox();
        vbox.getChildren().add(gridPane);
        vbox.setAlignment(Pos.CENTER);

        // Define button action
        submitButton.setOnAction(e -> {
            RadioButton selectedRadioButton = (RadioButton) toggleGroup.getSelectedToggle();
            if (selectedRadioButton != null) {
                rating = Integer.parseInt(selectedRadioButton.getText());
                resultLabel.setText("Thank you for your feedback!");
            } else {
                resultLabel.setText("Please select a rating");
            }
        });

        // Create and show scene
        Scene scene = new Scene(vbox, 300, 300);
        primaryStage.setTitle("Taxi Rating");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}