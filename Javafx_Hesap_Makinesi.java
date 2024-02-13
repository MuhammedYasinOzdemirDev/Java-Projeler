package com.example.odev;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
//171421005
//Muhammed Yasin Özdemir
public class Odev extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Button btn1=new Button("Count Up");
        Button btn2=new Button("Count Down");
        Button btn3=new Button("Reset");
        Button btn4=new Button("Topla");
        Button btn5=new Button("Çıkart");
        Button btn6=new Button("Çarp");
        Button btn7=new Button("Bol");

        TextField textField=new TextField("5");
        TextField s1=new TextField();
        TextField s2=new TextField();
        TextField sonuc=new TextField();
        Label label=new Label();
        label.setTextFill(Color.RED);
        label.setFont(Font.font("Times New Roman",18));
        sonuc.setDisable(true);
        textField.setBackground(Background.fill(Color.CYAN));
        textField.setDisable(true);
        GridPane pane=new GridPane();
        pane.addRow(0,textField,btn1,btn2,btn3);
        btn2.setTranslateX(-45);
        Pane panee=new Pane(btn4,btn5,btn6,btn7);
        pane.addRow(1,s1,s2);
        pane.addRow(2,panee,sonuc);
        pane.addRow(3,label);
        sonuc.setTranslateX(80);
        sonuc.setBackground(Background.fill(Color.CYAN));
        btn4.setTranslateX(0);
        btn5.setTranslateX(60);
        btn6.setTranslateX(120);
        btn7.setTranslateX(180);
        pane.setPadding(new Insets(12));
        pane.setHgap(8);
        pane.setVgap(12);

        btn1.setOnAction(actionEvent -> {
            textField.setText(String.valueOf(Integer.parseInt(textField.getText())+1));
        });
        btn2.setOnAction(actionEvent -> {
            textField.setText(String.valueOf(Integer.parseInt(textField.getText())-1));
        });
        btn3.setOnAction(actionEvent -> {
            textField.setText(String.valueOf(5));
        });
        btn4.setOnAction(actionEvent -> {
            label.setText("");
            try{
                sonuc.setText(String.valueOf(Integer.parseInt(s1.getText())+Integer.parseInt(s2.getText())));
            }
            catch (Exception e){
                label.setText("Sayı giriniz");
            }
        });
        btn5.setOnAction(actionEvent -> {
            label.setText("");
            try{
                sonuc.setText(String.valueOf(Integer.parseInt(s1.getText())-Integer.parseInt(s2.getText())));
            }
            catch (Exception e){
                label.setText("Sayı giriniz");
            }
        });
        btn6.setOnAction(actionEvent -> {
            label.setText("");
            try{
                sonuc.setText(String.valueOf(Integer.parseInt(s1.getText())*Integer.parseInt(s2.getText())));
            }
            catch (Exception e){
                label.setText("Sayı giriniz");
            }
        });
        btn7.setOnAction(actionEvent -> {
            label.setText("");
            try{
                sonuc.setText(String.valueOf(Double.parseDouble(s1.getText())/Integer.parseInt(s2.getText())));
            }
            catch (Exception e){
                label.setText("Sayı giriniz");
            }
        });



        pane.setBackground(Background.fill(Color.BLACK));
        Scene scene=new Scene(pane);
        stage.setScene(scene);
        stage.setTitle("Odev");
        stage.setResizable(false);
        stage.show();

    }
    public static void main(String[] args){
        launch();
    }
}
