package com.example.huffman;

//this class defines the UI & graphics

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

public class UI extends Application {
    long start = System.nanoTime();
    @Override
    public void start(Stage stage) throws IOException {
        Rectangle rect = new Rectangle(1000, 667);
        Image background = new Image(new FileInputStream("src/main/resources/images/back.png"));
        rect.setFill(new ImagePattern(background));

        //initialize the input text field
        TextArea input = new TextArea();
        input.setPromptText("Enter your text");
        input.setLayoutX(40);
        input.setLayoutY(40);
        input.setMaxSize(700, 250);
        input.setMinSize(700, 250);
        input.setStyle("""
            -fx-background-color: transparent;
            -fx-text-fill: #000000;
            -fx-font-size: 24px;
            -fx-font-weight: bold;
                """);

        //initialize run button and it's effects
        Button run = new Button("Run");
        run.setLayoutX(820);
        run.setLayoutY(75);
        run.setMaxSize(130, 50);
        run.setMinSize(130, 50);
        run.setStyle("""
            -fx-background-color: unset;
            -fx-background-radius: 25px;
            -fx-text-fill: #00a303;
            -fx-font-size: 17px;
            -fx-font-weight: bold;
            -fx-border-color: #00a303;
            -fx-border-width: 3px;
            -fx-border-radius: 25px;
                """);
        run.setCursor(Cursor.HAND);
        run.setOnMouseEntered(mouseEvent-> {
            run.setStyle("""
                -fx-background-color: #00a303;
                -fx-background-radius: 20px;
                -fx-text-fill: #ffffff;
                -fx-font-size: 20px;
                -fx-font-weight: bold;
                -fx-border-color: #ffffff;
                -fx-border-width: 4px;
                -fx-border-radius: 20px;
            """);
        });
        run.setOnMouseExited(mouseEvent-> {
            run.setStyle("""
                -fx-background-color: unset;
                -fx-background-radius: 25px;
                -fx-text-fill: #00a303;
                -fx-font-size: 17px;
                -fx-font-weight: bold;
                -fx-border-color: #00a303;
                -fx-border-width: 3px;
                -fx-border-radius: 25px;
            """);
        });

        //initialize example button and it's effects
        Button examples = new Button("Examples");
        examples.setLayoutX(820);
        examples.setLayoutY(150);
        examples.setMaxSize(130, 50);
        examples.setMinSize(130, 50);
        examples.setStyle("""
            -fx-background-color: unset;
            -fx-background-radius: 25px;
            -fx-text-fill: #f18e00;
            -fx-font-size: 17px;
            -fx-font-weight: bold;
            -fx-border-color: #f18e00;
            -fx-border-width: 3px;
            -fx-border-radius: 25px;
                """);
        examples.setCursor(Cursor.HAND);
        examples.setOnMouseEntered(mouseEvent-> {
            examples.setStyle("""
                -fx-background-color: #f18e00;
                -fx-background-radius: 20px;
                -fx-text-fill: #ffffff;
                -fx-font-size: 20px;
                -fx-font-weight: bold;
                -fx-border-color: #ffffff;
                -fx-border-width: 4px;
                -fx-border-radius: 20px;
            """);
        });
        examples.setOnMouseExited(mouseEvent-> {
            examples.setStyle("""
                -fx-background-color: unset;
                -fx-background-radius: 25px;
                -fx-text-fill: #f18e00;
                -fx-font-size: 17px;
                -fx-font-weight: bold;
                -fx-border-color: #f18e00;
                -fx-border-width: 3px;
                -fx-border-radius: 25px;
            """);
        });

        //initialize tree button and it's effects
        Button tree = new Button("Tree");
        tree.setLayoutX(820);
        tree.setLayoutY(225);
        tree.setMaxSize(130, 50);
        tree.setMinSize(130, 50);
        tree.setStyle("""
            -fx-background-color: unset;
            -fx-background-radius: 25px;
            -fx-text-fill: #ff006c;
            -fx-font-size: 17px;
            -fx-font-weight: bold;
            -fx-border-color: #ff006c;
            -fx-border-width: 3px;
            -fx-border-radius: 25px;
                """);
        tree.setCursor(Cursor.HAND);
        tree.setOnMouseEntered(mouseEvent-> {
            tree.setStyle("""
                -fx-background-color: #ff006c;
                -fx-background-radius: 20px;
                -fx-text-fill: #ffffff;
                -fx-font-size: 20px;
                -fx-font-weight: bold;
                -fx-border-color: #ffffff;
                -fx-border-width: 4px;
                -fx-border-radius: 20px;
            """);
        });
        tree.setOnMouseExited(mouseEvent-> {
            tree.setStyle("""
                -fx-background-color: unset;
                -fx-background-radius: 25px;
                -fx-text-fill: #ff006c;
                -fx-font-size: 17px;
                -fx-font-weight: bold;
                -fx-border-color: #ff006c;
                -fx-border-width: 3px;
                -fx-border-radius: 25px;
            """);
        });

        //initialize end button and it's effects
        Button exit = new Button("Exit");
        exit.setLayoutX(820);
        exit.setLayoutY(550);
        exit.setMaxSize(130, 50);
        exit.setMinSize(130, 50);
        exit.setStyle("""
            -fx-background-color: unset;
            -fx-background-radius: 25px;
            -fx-text-fill: #FF0000;
            -fx-font-size: 17px;
            -fx-font-weight: bold;
            -fx-border-color: #FF0000;
            -fx-border-width: 3px;
            -fx-border-radius: 25px;
                """);
        exit.setCursor(Cursor.HAND);
        exit.setOnMouseEntered(mouseEvent-> {
            exit.setStyle("""
                -fx-background-color: #FF0000;
                -fx-background-radius: 20px;
                -fx-text-fill: #ffffff;
                -fx-font-size: 20px;
                -fx-font-weight: bold;
                -fx-border-color: #ffffff;
                -fx-border-width: 4px;
                -fx-border-radius: 20px;
            """);
        });
        exit.setOnMouseExited(mouseEvent-> {
            exit.setStyle("""
                -fx-background-color: unset;
                -fx-background-radius: 25px;
                -fx-text-fill: #FF0000;
                -fx-font-size: 17px;
                -fx-font-weight: bold;
                -fx-border-color: #FF0000;
                -fx-border-width: 3px;
                -fx-border-radius: 25px;
            """);
        });

        //initialize the results text field
        TextArea result = new TextArea();
        result.setEditable(false);
        result.setLayoutX(40);
        result.setLayoutY(370);
        result.setMaxSize(700, 250);
        result.setMinSize(700, 250);
        result.setStyle("""
            -fx-background-color: transparent;
            -fx-text-fill: #000000;
            -fx-font-size: 24px;
            -fx-font-weight: bold;
                """);

        //closes program when exit clicked
        exit.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                long end = System.nanoTime();
                System.exit(0);
            }
        });

        //starts encoding the string when run clicked
        run.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                huffman.execute(input.getText());
                result.setText(huffman.result);
                huffman.reset();
            }
        });

        //read examples from file and encode them
        examples.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                huffman.examples();
                example(result);
                ex_input(input);
            }
        });

        Group root = new Group(rect, input, run, examples, tree, exit, result);

        Scene scene = new Scene(root);
        stage.setTitle("Huffman");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }

    //putting example text file in input text field
    public void example(TextArea result){
        result.setText(huffman.all_results);
    }

    //putting example text results in result text field
    public void ex_input(TextArea input){
        String temp = "";
        ArrayList<String> text = file.reader();
        for (int i = 0; i < text.size(); i++) {
            temp = temp.concat(text.get(i) + "\n");
        }
        input.setText(temp);
    }
}