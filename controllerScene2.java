

package com.example.stickherogame;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import java.io.IOException;
import javafx.animation.*;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
import java.util.ResourceBundle;


public class controllerScene2 implements Initializable {
    @FXML
    private Button click;
    @FXML
    private Button pause;
    private Timeline t;
    private Line l;
    private Rectangle first;
    ImageView iv;
    private Rectangle second;

    @FXML
    private AnchorPane pausePane;
    Platform randomPlatform1;

    public void pause(){
        pausePane.setVisible(true);
    }

    public void resume(){
        pausePane.setVisible(false);

    }


    Platform p1 = new Platform(30, 50);
    Platform p2 = new Platform(40, 50);
    Platform p3 = new Platform(45, 50);
    Platform p4 = new Platform(50, 50);
    Platform p5 = new Platform(80, 50);
    Platform p6 = new Platform(60, 50);
    Platform p7 = new Platform(90, 50);
    Platform p8 = new Platform(70, 50);
    Platform p9 = new Platform(100, 50);
    Platform p10 = new Platform(110, 50);
    Platform p11 = new Platform(120, 50);
    Platform p12 = new Platform(127, 50);
    Platform p13 = new Platform(140, 50);
    Platform p14 = new Platform(150, 50);
    Platform p15 = new Platform(15, 50);

    ArrayList<Platform> arr = new ArrayList<>();

    @FXML
    private AnchorPane mainPain;
    public void setRandomPlatforms() {
        Random random = new Random();

        int randomIndex1 = random.nextInt(arr.size());
        randomPlatform1 = arr.get(randomIndex1);

        Rectangle r1 = new Rectangle();
        r1.setHeight(randomPlatform1.getPlatform_Height());
        r1.setWidth(randomPlatform1.getPlatform_Width());
        r1.setLayoutX(54);
        r1.setLayoutY(280);
        first=r1;

        mainPain.getChildren().add(r1);

        Image image = new Image(getClass().getResource("ninja.png").toExternalForm());
        iv = new ImageView(image);
        iv.setLayoutX(((first.getLayoutX()+first.getWidth())/2)+12);
        iv.setLayoutY(396-140);
        iv.setFitWidth(31);
        iv.setFitHeight(30);
        mainPain.getChildren().add(iv);


        int randomIndex2;
        do {
            randomIndex2 = random.nextInt(arr.size());
        } while (randomIndex2 == randomIndex1);

        Platform randomPlatform2 = arr.get(randomIndex2);

        Rectangle r2 = new Rectangle();
        r2.setHeight(randomPlatform2.getPlatform_Height());
        r2.setWidth(randomPlatform2.getPlatform_Width());

        int gap = random.nextInt(150) + 50;
        r2.setLayoutX(54 + r1.getWidth() + gap);
        r2.setLayoutY(280);
        second=r2;

        mainPain.getChildren().add(r2);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.println("cfghj");
        arr.add(p1);
        arr.add(p2);
        arr.add(p3);
        arr.add(p4);
        arr.add(p5);
        arr.add(p6);
        arr.add(p7);
        arr.add(p8);
        arr.add(p9);
        arr.add(p10);
        arr.add(p11);
        arr.add(p12);
        arr.add(p13);
        arr.add(p14);
        arr.add(p15);
        setRandomPlatforms();
        t=new Timeline(new KeyFrame(Duration.seconds(0.3),e -> incr()));
        t.setCycleCount(Timeline.INDEFINITE);


        Image image = new Image(getClass().getResource("ninja.png").toExternalForm());
        ImageView imageView = new ImageView(image);

    }
    public void startStick(MouseEvent event){
        l=new Line();
        System.out.println("start");
        l.setLayoutX(first.getLayoutX()+first.getWidth()+100);
        l.setLayoutY(280);
        l.setStartX(-100);
        l.setStartY(0);
        l.setEndX(-100);
        l.setEndY(0);
        l.setStrokeWidth(3);
        mainPain.getChildren().add(l);
        t.play();

    }
    public void incr(){
        System.out.println("incr");
        l.setEndY(l.getEndY()-10);
    }
    public void endStick(MouseEvent event){
        System.out.println("end");
        t.stop();

        Line line = l;
        double length = randomPlatform1.getPlatform_Width() / 2;

        double midPointY = (line.getStartY()+line.getEndY()) / 2;
        RotateTransition rotateTransition = new RotateTransition(Duration.millis(500), line);
        rotateTransition.setByAngle(90);

        TranslateTransition translateTransition = new TranslateTransition(Duration.millis(500), line);
        translateTransition.setByY(midPointY - line.getEndY());
        translateTransition.setByX(-((line.getStartY()+line.getEndY())/2));


        ParallelTransition parallelTransition = new ParallelTransition(rotateTransition, translateTransition);
        parallelTransition.play();

        double len = first.getLayoutX()+first.getWidth();
        double sl = Math.abs(l.getStartY()+l.getEndY());

        if(sl+len >= second.getLayoutX() && sl+len<=(second.getLayoutX()+ second.getWidth())){
            double diff = first.getLayoutX()+first.getWidth();
            double target=(first.getWidth()+sl) - length;
            System.out.println("true");
            TranslateTransition translate = new TranslateTransition();
            translate.setNode(iv);
            translate.setDuration(Duration.millis(3000));
            translate.setByX(target);
            translate.play();
        } else {
            System.out.println("false");
            TranslateTransition translate = new TranslateTransition();
            translate.setNode(iv);
            translate.setDuration(Duration.millis(3000));
            translate.setByX(-line.getEndY() + line.getStartY() + length);
            SequentialTransition sequentialTransition = new SequentialTransition(translate);
            TranslateTransition fallDownTransition = new TranslateTransition();
            fallDownTransition.setNode(iv);
            fallDownTransition.setToY(mainPain.getHeight());
            fallDownTransition.setDuration(Duration.millis(500));
            sequentialTransition.getChildren().add(fallDownTransition);
            sequentialTransition.play();
            fallDownTransition.setOnFinished(Event ->{
                switchToScene3();
            });
        }

    }
    private void switchToScene3() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/stickherogame/scene3.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);

            Stage stage = (Stage) mainPain.getScene().getWindow();
            if (stage != null && stage.isShowing()) {
                stage.setScene(scene);
                stage.show();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

