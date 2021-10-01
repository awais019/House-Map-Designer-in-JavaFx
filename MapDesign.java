/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package house.map;

import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.text.Font;
import javafx.application.Application;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.input.ContextMenuEvent;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.Background;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;
import javax.imageio.ImageIO;

/**
 *
 * @author Awais
 */
public class MapDesign extends Application{

    @Override
    public void start(Stage primaryStage) throws Exception {
        FileChooser file = new FileChooser();
        Menu menu = new Menu("File");
        MenuItem m1 = new MenuItem("Save");
        menu.getItems().add(m1);
        MenuBar mb =  new MenuBar();
        mb.getMenus().add(menu);
        mb.translateXProperty().set(0);
        mb.translateYProperty().set(0);
        Rectangle rect1 = new Rectangle(1200, 40);
        rect1.setFill(Color.TRANSPARENT);
        rect1.setStroke(Color.BLACK);
        Text txt = new Text("House Map Designer");
        txt.setFont(Font.font("Sans-Serif", FontWeight.BLACK, 20));
        Rectangle rect2 = new Rectangle(0, 71, 150, 628);
        rect2.setFill(Color.TRANSPARENT);
        rect2.setStroke(Color.BLACK);
        Button btn1 = new Button("Plot");
        btn1.setFont(Font.font("Sans-Serif", FontWeight.MEDIUM, 20));
        btn1.setStyle("-fx-border-color: black");
        btn1.setBackground(Background.EMPTY);
        btn1.translateXProperty().set(20);
        btn1.translateYProperty().set(120);
        btn1.setPrefWidth(100);
        Button btn2 = new Button("Rooms");
        btn2.setFont(Font.font("Sans-Serif", FontWeight.MEDIUM, 20));
        btn2.setStyle("-fx-border-color: black");
        btn2.setBackground(Background.EMPTY);
        btn2.translateXProperty().set(20);
        btn2.translateYProperty().set(220);
        btn2.setPrefWidth(100);
        btn2.setDisable(true);
        Button btn3 = new Button("Doors");
        btn3.setFont(Font.font("Sans-Serif", FontWeight.MEDIUM, 20));
        btn3.setStyle("-fx-border-color: black");
        btn3.setBackground(Background.EMPTY);
        btn3.translateXProperty().set(20);
        btn3.translateYProperty().set(320);
        btn3.setPrefWidth(100);
        btn3.setDisable(true);
        Button btn4 = new Button("Windows");
        btn4.setFont(Font.font("Sans-Serif", FontWeight.MEDIUM, 10));
        btn4.setStyle("-fx-border-color: black");
        btn4.setBackground(Background.EMPTY);
        btn4.translateXProperty().set(20);
        btn4.translateYProperty().set(420);
        btn4.setPrefWidth(100);
        btn4.setPrefHeight(40);
        btn4.setDisable(true);
        Button btn5 = new Button("Gate");
        btn5.setFont(Font.font("Sans-Serif", FontWeight.MEDIUM, 20));
        btn5.setStyle("-fx-border-color: black");
        btn5.setBackground(Background.EMPTY);
        btn5.translateXProperty().set(20);
        btn5.translateYProperty().set(520);
        btn5.setPrefWidth(100);
        btn5.setDisable(true);
        Button btn6 = new Button("Stairs");
        btn6.setFont(Font.font("Sans-Serif", FontWeight.MEDIUM, 20));
        btn6.setStyle("-fx-border-color: black");
        btn6.setBackground(Background.EMPTY);
        btn6.translateXProperty().set(20);
        btn6.translateYProperty().set(620);
        btn6.setPrefWidth(100);
        btn6.setDisable(true);
        StackPane stack = new StackPane();
        stack.translateXProperty().set(0);
        stack.translateYProperty().set(30);
        stack.getChildren().addAll(rect1, txt);
        Rectangle r = new Rectangle();
        Group root = new Group();
        Group group = new Group();
        root.translateXProperty().set(200);
        root.translateYProperty().set(100);
        group.getChildren().addAll(root, mb, stack, rect2, btn1, btn2, btn3, btn4, btn5, btn6);
         btn1.setOnAction(new EventHandler(){
            @Override
            public void handle(Event event) {
                Stage stage = new Stage();
                GridPane pane = new GridPane();
                Label lb1 = new Label("Enter length of plot: ");
                TextField txf1 = new TextField();
                Label lb2 = new Label("Enter width of plot: ");
                TextField txf2 = new TextField();
                Button btn = new Button("Draw");
                pane.setHgap(5);
                pane.setVgap(10);
                pane.add(lb1, 0, 0);
                pane.add(txf1, 1, 0);
                pane.add(lb2, 0, 1);
                pane.add(txf2, 1, 1);
                pane.add(btn, 1, 5);
                Text txt1 = new Text();
                Text txt = new Text();
                  btn.setOnAction((ActionEvent event1) -> {                       
                      try{
                        double h = Double.parseDouble(txf1.getText());
                        double w = Double.parseDouble(txf2.getText());
                        if(h < 100){
                            r.setHeight(h*10);
                        }
                        else if(h >= 100 && h < 300){
                            r.setHeight(h*3);
                        }
                        else if(h >= 300 && h < 1000){
                            r.setHeight(h);
                        }else {
                             r.setHeight(h/10 + 400);
                        }
                        if(w < 100){
                            r.setWidth(w*10);
                        }
                        else if(w >= 100 && w < 300){
                            r.setWidth(w*3);
                        }
                        else if(w >= 300 && w < 1000){
                            r.setWidth(w);
                        }else {
                             r.setWidth(w/10 + 400);
                        }
                      stage.close();
                      r.setX(0);
                      r.setY(0);
                      r.setFill(Color.TRANSPARENT);
                      r.setStroke(Color.BLACK);
                      r.setStrokeWidth(4);
                      txt.setText(txf2.getText() + "ft");
                      txt.setX(r.getWidth()/2);
                      txt.setY(r.getHeight() + 20);
                      txt.setFont(Font.font("Sans-Serif", FontWeight.BLACK, 20));
                      txt1.setText(txf1.getText() + "ft");
                      txt1.setX(r.getWidth() + 20);
                      txt1.setY(r.getHeight()/2);
                      txt1.setFont(Font.font("Sans-Serif", FontWeight.BLACK, 20));
                      try{
                      root.getChildren().addAll(r, txt, txt1);
                      }catch(IllegalArgumentException e1){}
                      }catch(NumberFormatException e){
                          Alert a = new Alert(Alert.AlertType.NONE);
                          a.setAlertType(Alert.AlertType.WARNING);
                          a.setContentText("Use numbers only");
                          a.show();
                      }
                      if(r.getWidth() > 0 && r.getHeight() > 0){
                       btn2.setDisable(false);
                       btn1.setDisable(true);
                        }
                });
                 
                Scene seen = new Scene(pane, 300, 200);
                stage.setScene(seen);
                stage.initModality(Modality.APPLICATION_MODAL);
                stage.showAndWait();
            }
        });
         btn2.setOnAction((ActionEvent event) -> {
             btn3.setDisable(false);
             Rectangle room = new Rectangle(100, 100);
             room.setX(520);
             room.setY(300);
             room.setFill(Color.TRANSPARENT);
             room.setStroke(Color.BLACK);
             room.setStrokeWidth(2);
             root.getChildren().add(room);
             Text txt2 = new Text();
             root.getChildren().add(txt2);
             room.setOnContextMenuRequested((Event event1) -> {
                Stage stage = new Stage();
                GridPane pane_3 = new GridPane();
                Label lb1 = new Label("Enter length of room: ");
                TextField txf1 = new TextField();
                Label lb2 = new Label("Enter width of room: ");
                TextField txf2 = new TextField();
                Label lb3 = new Label("Enter title of room: ");
                TextField txf3 = new TextField();
                Button btn = new Button("Draw");
                pane_3.setHgap(5);
                pane_3.setVgap(10);
                pane_3.add(lb1, 0, 0);
                pane_3.add(txf1, 1, 0);
                pane_3.add(lb2, 0, 1);
                pane_3.add(txf2, 1, 1);
                pane_3.add(btn, 1, 5);
                pane_3.add(lb3, 0, 2);
                pane_3.add(txf3, 1, 2);
                btn.setOnAction((ActionEvent event2) -> {
                      try{
                        double h = Double.parseDouble(txf1.getText());
                        double w = Double.parseDouble(txf2.getText());
                        if(h < 100){
                            System.out.println(r.getHeight());
                            if(h*10 <= r.getHeight()){
                                room.setHeight(h*10);
                            }else{
                                Alert a = new Alert(Alert.AlertType.NONE);
                                a.setAlertType(Alert.AlertType.WARNING);
                                a.setContentText("Room height cannot be bigger than plot width");
                                a.show();
                            }
                        }else if(h >= 100 && h < 300){
                            if(h*3 <= r.getHeight()){
                            room.setHeight(h*3);
                            }else{
                                 Alert a = new Alert(Alert.AlertType.NONE);
                                a.setAlertType(Alert.AlertType.WARNING);
                                a.setContentText("Room height cannot be bigger than plot width");
                                a.show();
                            }
                        }else if(h >= 300 && h < 1000){
                            if(h <= r.getHeight()){
                                
                            room.setHeight(h);
                            }else{
                                 Alert a = new Alert(Alert.AlertType.NONE);
                                a.setAlertType(Alert.AlertType.WARNING);
                                a.setContentText("Room height cannot be bigger than plot width");
                                a.show();
                            }
                        }else{
                            if((h/10 + 400) <= r.getHeight()){
                                
                            room.setHeight(h/10 + 400);
                            }else{
                                Alert a = new Alert(Alert.AlertType.NONE);
                                a.setAlertType(Alert.AlertType.WARNING);
                                a.setContentText("Room height cannot be bigger than plot width");
                                a.show();
                            }
                        }
                        if(w < 100){
                            if(w*10 <= r.getWidth()){
                                room.setWidth(w*10);
                            }else{
                                Alert a = new Alert(Alert.AlertType.NONE);
                                a.setAlertType(Alert.AlertType.WARNING);
                                a.setContentText("Room width cannot be bigger than plot width");
                                a.show();
                            }
                        }else if(w >= 100 && w < 300){
                            if(w*3 <= r.getWidth()){
                            room.setWidth(w*3);
                            }else{
                                 Alert a = new Alert(Alert.AlertType.NONE);
                                a.setAlertType(Alert.AlertType.WARNING);
                                a.setContentText("Room width cannot be bigger than plot width");
                                a.show();
                            }
                        }else if(w >= 300 && w < 1000){
                            if(h <= r.getWidth()){
                            room.setWidth(w);
                            }else{
                                 Alert a = new Alert(Alert.AlertType.NONE);
                                a.setAlertType(Alert.AlertType.WARNING);
                                a.setContentText("Room width cannot be bigger than plot width");
                                a.show();
                            }
                        }else{
                            if((w/10 + 400) <= r.getWidth()){
                            room.setWidth(h/10 + 400);
                            }else{
                                 Alert a = new Alert(Alert.AlertType.NONE);
                                a.setAlertType(Alert.AlertType.WARNING);
                                a.setContentText("Room width cannot be bigger than plot width");
                                a.show();
                            }
                        }
                        
                      String str = txf3.getText() + "\n" + txf2.getText() + " by " + txf1.getText();
                      txt2.setFont(Font.font("Sans-Serif", FontWeight.LIGHT, 12));
                      txt2.setText(str);
                      txt2.setX(room.getX() + 5);
                      txt2.setY(room.getY() + 5);
                      stage.close();
                      }catch(NumberFormatException e){
                          Alert a = new Alert(Alert.AlertType.NONE);
                          a.setAlertType(Alert.AlertType.WARNING);
                          a.setContentText("Use numbers only");
                          a.show();
                      }
                });
                Scene seen = new Scene(pane_3, 300, 200);
                stage.setScene(seen);
                stage.initModality(Modality.APPLICATION_MODAL);
                stage.showAndWait();
                });
                room.setOnMouseDragged((MouseEvent event3) -> {
                    room.setX(event3.getX());
                    room.setY(event3.getY());
                    txt2.setX(event3.getX() + 10);
                    txt2.setY(event3.getY() + 20);
                });
                txt2.setOnMouseDragged((MouseEvent event3) -> {
                    room.setX(event3.getX());
                    room.setY(event3.getY());
                    txt2.setX(event3.getX() + 10);
                    txt2.setY(event3.getY() + 20);
                });
                room.setOnMouseDragged((MouseEvent event3) -> {
                    room.setX(event3.getX());
                    room.setY(event3.getY());
                    txt2.setX(event3.getX() + 10);
                    txt2.setY(event3.getY() + 20);
                });
                
             });
     
         btn3.setOnAction((ActionEvent e) -> {
            Arc arc = new Arc();  
            arc.setCenterX(400);  
            arc.setCenterY(400);  
            arc.setRadiusX(50);  
            arc.setRadiusY(50);  
            arc.setStartAngle(0);  
            arc.setLength(90);  
            arc.setType(ArcType.ROUND);  
            arc.setFill(Color.TRANSPARENT);  
            arc.setStroke(Color.GREEN);
            arc.setStrokeWidth(3);
            root.getChildren().add(arc);
            Text txt2 = new Text();
            root.getChildren().add(txt2);
            final ContextMenu contextMenu = new ContextMenu();
            final MenuItem item1 = new MenuItem("Set Size");
            final MenuItem item2 = new MenuItem("Rotate");
            contextMenu.getItems().addAll(item1, item2);
            arc.setOnContextMenuRequested((ContextMenuEvent event) -> {
                contextMenu.show(arc, arc.getCenterX() + 200, arc.getCenterY() + 100);
                item1.setOnAction((event1) -> {
                Stage stage = new Stage();
                GridPane pane_2 = new GridPane();
                Label lb1 = new Label("Enter width of door: ");
                TextField txf1 = new TextField();
                Button btn = new Button("Draw");
                pane_2.setHgap(5);
                pane_2.setVgap(10);
                pane_2.add(lb1, 0, 0);
                pane_2.add(txf1, 1, 0);
                pane_2.add(btn, 1, 5);
                btn.setOnAction((ActionEvent event2) -> {
                      try{
                      arc.setRadiusX(Double.parseDouble(txf1.getText())*10);
                      arc.setRadiusY(Double.parseDouble(txf1.getText())*10);
                      String str = txf1.getText() + " ft";
                      txt2.setText(str);
                      txt2.setX(arc.getCenterX() + 10);
                      txt2.setY(arc.getCenterY() - 10);
                      txt2.setFont(Font.font(Double.parseDouble(txf1.getText())*3));
                      stage.close();
                      }catch(NumberFormatException e1){
                          Alert a = new Alert(Alert.AlertType.NONE);
                          a.setAlertType(Alert.AlertType.WARNING); 
                          a.setContentText("Use numbers only");
                          a.show();
                      }
                });
                Scene seen = new Scene(pane_2, 300, 200);
                stage.setScene(seen);
                stage.initModality(Modality.APPLICATION_MODAL);
                stage.showAndWait();
                });
                item2.setOnAction((event1) -> {
                    arc.setRotate(arc.getRotate() + 90);
                });
               
            });
         
                txt2.setOnMouseDragged((e2) -> {
                arc.setCenterX(e2.getX());
                arc.setCenterY(e2.getY());
                txt2.setX(e2.getX() + 10);
                txt2.setY(e2.getY() - 10);
                contextMenu.setX(arc.getCenterX() + 100);
                contextMenu.setY(arc.getCenterY());
            });     
              btn4.setDisable(false);
        });
        btn4.setOnAction((ActionEvent event) ->{
            Rectangle window = new Rectangle();
            window.setX(400);
            window.setY(400);
            window.setHeight(4);
            window.setWidth(40);
            window.setFill(Color.RED);
            root.getChildren().add(window);
            Text tx = new Text();
            root.getChildren().add(tx);
            btn5.setDisable(false);
            final ContextMenu contextMenu = new ContextMenu();
            final MenuItem item1 = new MenuItem("Set Size");
            final MenuItem item2 = new MenuItem("Rotate");
            contextMenu.getItems().addAll(item1, item2);
            window.setOnContextMenuRequested((event2)->{
                contextMenu.show(window, window.getX() + 200, window.getY() + 100);
                item1.setOnAction((event1) -> {
                Stage stage = new Stage();
                GridPane pane_0 = new GridPane();
                Label lb1 = new Label("Enter width of window: ");
                TextField txf1 = new TextField();
                Button btn = new Button("Draw");
                pane_0.setHgap(5);
                pane_0.setVgap(10);
                pane_0.add(lb1, 0, 0);
                pane_0.add(txf1, 1, 0);
                pane_0.add(btn, 1, 5);
                btn.setOnAction((event3)->{
                    tx.setText(txf1.getText() + " ft");
                    try{
                        if(window.getWidth() > window.getHeight()){
                        window.setWidth(Double.parseDouble(txf1.getText())*10);
                        tx.setX(window.getX() + window.getWidth()/2 - 10);
                        tx.setY(window.getY() - 5);
                        tx.setFont(Font.font(Double.parseDouble(txf1.getText())*3));
                        }else{
                             tx.setX(window.getX() - 20);
                             tx.setY(window.getY() + window.getHeight()/2 - 10);
                             window.setHeight(Double.parseDouble(txf1.getText())*10);
                        }
                    }catch(NumberFormatException e){
                        Alert a = new Alert(Alert.AlertType.NONE);
                          a.setAlertType(Alert.AlertType.WARNING); 
                          a.setContentText("Use numbers only");
                          a.show();
                    }
                    stage.close();
                });
                Scene seen = new Scene(pane_0, 300, 200);
                stage.setScene(seen);
                stage.initModality(Modality.APPLICATION_MODAL);
                stage.showAndWait();               
                });
                item2.setOnAction((event5) -> {
                    double h = window.getWidth();
                    double w = window.getHeight();
                    window.setHeight(h);
                    window.setWidth(w);
                    if(window.getWidth() > window.getHeight()){
                        tx.setX(window.getX() + window.getWidth()/2 - 10);
                        tx.setY(window.getY() - 5);
                        }else{
                             tx.setX(window.getX() - 20);
                             tx.setY(window.getY() + window.getHeight()/2 - 10);
                        }
                });
                
            });
            window.setOnMouseDragged((event1)->{
             window.setX(event1.getX());
             window.setY(event1.getY());
             if(window.getWidth() > window.getHeight()){
                        tx.setX(window.getX() + window.getWidth()/2 - 10); 
                        tx.setY(window.getY() - 5);
                        }else{
                             tx.setX(window.getX() - 20);
                             tx.setY(window.getY() + window.getHeight()/2 - 10);
                        }
            });
            tx.setOnMouseDragged((event1)->{
             window.setX(event1.getX());
             window.setY(event1.getY());
             if(window.getWidth() > window.getHeight()){
                        tx.setX(window.getX() + window.getWidth()/2 - 10);
                        tx.setY(window.getY() - 5);
                        }else{
                             tx.setX(window.getX() - 20);
                             tx.setY(window.getY() + window.getHeight()/2 - 10);
                        }
            });
        });
        btn5.setOnAction((ActionEvent  event)->{
            Rectangle rec = new Rectangle();
            rec.setWidth(50);
            rec.setHeight(20);
            rec.setX(200);
            rec.setY(200);
            rec.setFill(new ImagePattern(new Image("gate.png")));
            Text tx = new Text();
            root.getChildren().addAll(rec, tx);
            btn6.setDisable(false);
             final ContextMenu contextMenu = new ContextMenu();
            final MenuItem item1 = new MenuItem("Set Size");
            final MenuItem item2 = new MenuItem("Rotate");
            contextMenu.getItems().addAll(item1, item2);
            rec.setOnContextMenuRequested((event2)->{
                contextMenu.show(rec, rec.getX() + 200, rec.getY() + 120);
                item1.setOnAction((evetn3)->{
                Stage stage = new Stage();
                GridPane pane0 = new GridPane();
                Label lb1 = new Label("Enter width of gate: ");
                TextField txf1 = new TextField();
                Button btn = new Button("Draw");
                pane0.setHgap(5);
                pane0.setVgap(10);
                pane0.add(lb1, 0, 0);
                pane0.add(txf1, 1, 0);
                pane0.add(btn, 1, 5);
                btn.setOnAction((e1)->{
                    tx.setText(txf1.getText() + " ft");
                    try{
                         if(rec.getWidth() > rec.getHeight() ){
                          rec.setWidth(Double.parseDouble(txf1.getText())*10);
                }else{
                     rec.setHeight(Double.parseDouble(txf1.getText())*10);
                }
                      String str = txf1.getText() + " ft" + " Gate";
                      tx.setText(str);
                      tx.setX(rec.getX());
                      tx.setY(rec.getY());
                      tx.setFont(Font.font(Double.parseDouble(txf1.getText())*3));
                    }catch(NumberFormatException e){
                        Alert a = new Alert(Alert.AlertType.NONE);
                          a.setAlertType(Alert.AlertType.WARNING); 
                          a.setContentText("Use numbers only");
                          a.show();
                    }
                    stage.close();
                });
                Scene seen = new Scene(pane0, 300, 200);
                stage.setScene(seen);
                stage.initModality(Modality.APPLICATION_MODAL);
                stage.showAndWait(); 
                });
               item2.setOnAction((event4)->{
                if(rec.getWidth() > rec.getHeight() ){
                    double wi = rec.getWidth();
                    rec.setWidth(rec.getHeight());
                    rec.setHeight(wi);
                }else{
                    double hi = rec.getHeight();
                    rec.setHeight(rec.getWidth());
                    rec.setWidth(hi);
                }
            });
            });
            rec.setOnMouseDragged((event5)->{
                rec.setX(event5.getX());
                rec.setY(event5.getY());
                tx.setX(event5.getX());
                tx.setY(event5.getY());
                
            });
        });
           
        btn6.setOnAction((event2)->{
             Image img = new Image("stairs.jpg");
             ImageView imgv = new ImageView(img); 
             imgv.setX(0);
             imgv.setY(0);
             root.getChildren().add(imgv);
             Text tx1 = new Text();
             root.getChildren().add(tx1);
            final ContextMenu contextMenu1 = new ContextMenu();
            final MenuItem item4 = new MenuItem("Set Size");
            final MenuItem item5 = new MenuItem("Change Style");
            final MenuItem item6 = new MenuItem("Rotate");
            contextMenu1.getItems().addAll(item4, item5, item6);
             imgv.setOnContextMenuRequested((event1)->{
                contextMenu1.show(imgv, imgv.getX() + 200, imgv.getY() + 100);
                item4.setOnAction((ActionEvent event3)->{
                Stage stage = new Stage();
                GridPane pane2 = new GridPane();
                Label lb1 = new Label("Enter width of stairs: ");
                TextField txf1 = new TextField();
                Button btn = new Button("Draw");
                pane2.setHgap(5);
                pane2.setVgap(10);
                pane2.add(lb1, 0, 0);
                pane2.add(txf1, 1, 0);
                pane2.add(btn, 1, 5);
                btn.setOnAction((e1)->{
                    tx1.setText(txf1.getText() + " ft");
                    try{
                        imgv.setFitWidth(Double.parseDouble(txf1.getText())*10);
                        imgv.setFitWidth(Double.parseDouble(txf1.getText())*10);
                      String str = txf1.getText() + " ft";
                      tx1.setText(str);
                      tx1.setX(imgv.getX() + 20);
                      tx1.setY(imgv.getY() + 50);
                      tx1.setFont(Font.font(Double.parseDouble(txf1.getText())*6));
                      
                    }catch(NumberFormatException e){
                        Alert a = new Alert(Alert.AlertType.NONE);
                          a.setAlertType(Alert.AlertType.WARNING); 
                          a.setContentText("Use numbers only");
                          a.show();
                    }
                    stage.close();
                });
                Scene seen = new Scene(pane2, 300, 200);
                stage.setScene(seen);
                stage.initModality(Modality.APPLICATION_MODAL);
                stage.showAndWait();
                });
                item5.setOnAction((event3)->{
                    Image img1 = new Image("stairs1.jpg");;
                    if(imgv.getImage() != img){
                        imgv.setImage(img);
                    }else{
                      imgv.setImage(img1);
                    }
                   
                });
                item6.setOnAction((event4)->{
                    imgv.setRotate(imgv.getRotate() + 90);
                });
             });
             imgv.setOnMouseDragged((event4)->{
                 imgv.setX(event4.getX());
                 imgv.setY(event4.getY());
                 tx1.setX(event4.getX() + 20);
                 tx1.setY(event4.getY() + 50);
             });
        });
        file.setInitialDirectory(new File("C:\\"));
          file.getExtensionFilters().addAll(new ExtensionFilter("jpeg", "*.jpeg"),
                  new ExtensionFilter("pdf", "*.pdf"), 
                  new ExtensionFilter("png", "*.png"),
                  new ExtensionFilter("jpg", "*.jpg"),
                  new ExtensionFilter("gif", "*.gif"));
          file.setTitle("Save File");
          file.setInitialFileName("myHouseDesign");
        m1.setOnAction((event6)->{
           File file1 = file.showSaveDialog(new Stage());
           if(file1 != null){
               WritableImage writableImage = new WritableImage((int) r.getWidth() + 100, (int) r.getHeight() + 100);
              
            root.snapshot(null, writableImage);
             RenderedImage renderedImage = SwingFXUtils.fromFXImage(writableImage, null);
                try {
                    ImageIO.write(renderedImage, "png", file1);
                } catch (IOException ex) {
                    Logger.getLogger(MapDesign.class.getName()).log(Level.SEVERE, null, ex);
                }
           }
        });
        ScrollPane sp = new ScrollPane();
        sp.setContent(group);
        Scene scene =  new Scene(sp, 1200, 700);
        rect1.widthProperty().bind(scene.widthProperty());
        rect2.heightProperty().bind(scene.heightProperty());
        primaryStage.setScene(scene);
        primaryStage.setTitle("House Map Designer");
        primaryStage.show();
    }
    void show(String[] args){
        launch(args);
    }
   
}
