package com.example.odev;

import javafx.animation.AnimationTimer;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.effect.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;;
import java.util.ArrayList;
import java.util.Random;

//Muhammed Yasin Özdemir
//171421005
public class Muhammed_Yasin_Ozdemir_171421005_Odev extends Application  {
    private static int topx=200;
    private static int topy=200;
    private static int top_hiz=20;
    private static int yaricap=20;
    private static double ybuyutmeoran=1.1;
    private static Color stroke=Color.YELLOW;
    private static Color color=Color.RED;
    private static Color arkaplan=Color.BLACK;
    private static Circle circle;
    private static Scene scene;
    private static int borderkalinlik=5;
    private static Pane panel;

    private static int boya_s=0;
    private static ArrayList<Circle> boyalar=new ArrayList<>();
    private static TranslateTransition animasyon;
    @Override
    public void start(Stage stage) throws Exception {

        panel=new Pane();   //Panel oluşturur
        scene=new Scene(panel,640,480, arkaplan);   //Panel ekrana dahil edilir
        circle=new Circle(topx,topy,yaricap, color);    //Top oluşturulur
        circle.setStroke(stroke);       //Border oluşturulur.
        circle.setStrokeWidth(borderkalinlik);  //Borderin kalınlığı belirlenir
        Text text=new Text("Muhammed Yasin Özdemir");   //Text oluşturulur
        text.setFont(Font.font("Times New Roman", FontWeight.BOLD,24));//Fontu ayarlanır
        Text text1=new Text();
        text1.setFont(Font.font("Times New Roman",FontWeight.BLACK,14));
        text1.setFill(color);
        text1.setTranslateX(485);
        text1.setTranslateY(20);
        text.setFill(color);    //Text renk verilir
        text.setTranslateX(350);    //Konumu belirlenir
        text.setTranslateY(470);
        Lighting lighting = new Lighting();//Efect uygularız
        lighting.setSurfaceScale(5);
        text.setEffect(lighting);
        panel.getChildren().add(circle);
        panel.getChildren().add(text);
        panel.getChildren().add(text1);
        new AnimationTimer() {  //Animasyon başlanır
            @Override
            public void handle(long l) {//50 ms bir doner
                klavye();
                Mouse();
                circle.setCenterX(topx);
                circle.setCenterY(topy);
                circle.setRadius(yaricap);
                circle.setFill(color);
                circle.setStroke(stroke);
                scene.setFill(arkaplan);
                text.setFill(color);
                text1.setText("Hız : "+top_hiz+"  Boya sayısı : "+boya_s);
                text1.setFill(color);
            }

        }.start();

        stage.setTitle("Uygulama");

        panel.setFocusTraversable(true);

        stage.setResizable(false);

        stage.setScene(scene);
        stage.show();
    }
    public static void main(String[] args){
        launch();
    }
    public static void klavye(){
        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                if(keyEvent.getCode()==KeyCode.UP ||keyEvent.getCode()== KeyCode.W){  //Top yukarı gider
                    if(topy-top_hiz>circle.getRadius())
                        topy-=top_hiz;
                    else if (topy>0)
                        topy= (int) circle.getRadius();
                }

                if(keyEvent.getCode()==KeyCode.DOWN || keyEvent.getCode()==KeyCode.S){  //Top aşağı gider
                    if(topy+top_hiz<470-circle.getRadius())
                        topy+=top_hiz;
                    else if (topy<480) {
                        topy= (int) (480- circle.getRadius());
                    }
                }
                if (keyEvent.getCode()==KeyCode.LEFT || keyEvent.getCode()==KeyCode.A)   //Top Sola gider
                {
                    if(topx-top_hiz>circle.getRadius())
                        topx-=top_hiz;
                    else if(topx>0)
                        topx= (int) circle.getRadius();
                }

                if(keyEvent.getCode()==KeyCode.RIGHT || keyEvent.getCode()==KeyCode.D) {    //Top Sağa gider
                    if(topx+top_hiz<640-circle.getRadius())
                        topx+=top_hiz;
                    else if (topx<640) {
                        topx= (int) (640-circle.getRadius());
                    }
                }
                if(keyEvent.getCode()==KeyCode.K){  //Top Hızlanır
                    if(top_hiz<100)
                        top_hiz+=3;
                }
                if(keyEvent.getCode()==KeyCode.M){  //Top Yavaslar
                    if(top_hiz>2)
                        top_hiz-=3;
                }

                if(keyEvent.getCode()==KeyCode.ADD)   //Top büyür
                {
                    if(yaricap<100)     //Max buyume oranı
                        yaricap*=ybuyutmeoran;
                }
                if(keyEvent.getCode()==KeyCode.SUBTRACT) //Top küçülür
                {

                    if(yaricap>10)
                        yaricap/=ybuyutmeoran;
                }

                if(keyEvent.getCode()==KeyCode.Z){  //Top renk değişir. Z tuşu
                    Random rnd=new Random();
                    color=Color.rgb(rnd.nextInt(255),rnd.nextInt(255),rnd.nextInt(255));
                }
                if(keyEvent.getCode()==KeyCode.X){ //Border renk değişir X tuşu
                    Random rnd=new Random();
                    stroke=Color.rgb(rnd.nextInt(255),rnd.nextInt(255),rnd.nextInt(255));
                }
                if(keyEvent.getCode()==KeyCode.C){  //Arka plan renk değişir
                    Random rnd=new Random();
                    arkaplan=Color.rgb(rnd.nextInt(255),rnd.nextInt(255),rnd.nextInt(255));
                }
                if(keyEvent.getCode()==KeyCode.ENTER){  //Yatayda Animasyon Başlatır.Enter tuşu
                    animasyon=new TranslateTransition();
                    topx=yaricap+borderkalinlik-5;
                    topy=240;
                    animasyon.setCycleCount(6);//6 tur atar
                    animasyon.setDuration(Duration.millis(1200-top_hiz*10));    //Hız ayarlanır
                    animasyon.setByX(625-yaricap-borderkalinlik);
                    animasyon.setAutoReverse(true);
                    animasyon.setNode(circle);
                    animasyon.play();
                    animasyon=null;

                }
                if(keyEvent.getCode()==KeyCode.BACK_SPACE)  //Dikeyde Animasyon Başlatır.Bacspace tuşşu yani yazılanı silen tuş
                {
                    animasyon=new TranslateTransition();
                    topy=yaricap+borderkalinlik-5;
                    topx=320;
                    animasyon.setCycleCount(6);
                    animasyon.setDuration(Duration.millis(1200-top_hiz*10));
                    animasyon.setByY(465-yaricap-borderkalinlik);
                    animasyon.setAutoReverse(true);
                    animasyon.setNode(circle);
                    animasyon.play();
                    animasyon=null;
                }
                if(keyEvent.getCode()==KeyCode.SHIFT)//Çapraz animasyon yapar
                {
                    animasyon=new TranslateTransition();
                    topy=yaricap;
                    topx=yaricap;
                    animasyon.setCycleCount(6);
                    animasyon.setDuration(Duration.millis(1200-top_hiz*10));
                    animasyon.setByX(625-yaricap-borderkalinlik);
                    animasyon.setByY(465-yaricap-borderkalinlik);
                    animasyon.setAutoReverse(true);
                    animasyon.setNode(circle);
                    animasyon.play();
                    animasyon=null;
                }

                if(keyEvent.getCode()==KeyCode.SPACE )  //Boya bırakır space tuşu
                {
                    Circle boya=new Circle(topx,topy,circle.getRadius()*0.5,color);
                    boyalar.add(boya);
                    boya_s++;
                    panel.getChildren().add(boya);
                }
                if(keyEvent.getCode()==KeyCode.DELETE)  //Tüm boyaları siler del tuşu
                {
                    for(Circle boya:boyalar){
                       panel.getChildren().remove(boya);
                    }
                    boyalar.clear();
                    boya_s=0;

                }
                if(keyEvent.getCode()==KeyCode.Q){  //Üstündeki boyayı siler. Q tuşu
                    for(Circle boya:boyalar){
                       if(boya.getCenterX()<circle.getCenterX()+circle.getRadius() && boya.getCenterX()>circle.getCenterX()-circle.getRadius() && boya.getCenterY()<circle.getCenterY()+circle.getRadius() && boya.getCenterY()>circle.getCenterY()-circle.getRadius()) {
                           panel.getChildren().remove(boya);
                           if(boya_s!=0)
                                boya_s--;
                       }
                    }
                }

            }
        });
    }
    public static void Mouse(){
        circle.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {  //Topa tıklandığında boyar
                Random rnd=new Random();
                color=Color.rgb(rnd.nextInt(255),rnd.nextInt(255),rnd.nextInt(255));
            }
        });
        panel.setOnMouseClicked(new EventHandler<MouseEvent>() {    //Arkapalan tıklandığında tema değişir
            @Override
            public void handle(MouseEvent event) {
                Random rnd=new Random();
                arkaplan=Color.rgb(rnd.nextInt(255),rnd.nextInt(255),rnd.nextInt(255));
                stroke=Color.rgb(rnd.nextInt(255),rnd.nextInt(255),rnd.nextInt(255));
            }
        });
    }


}
