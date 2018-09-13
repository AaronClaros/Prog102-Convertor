/*
 * Copyright (c) 2018 Jala Foundation.
 * 2643 Av Melchor Perez de Olguin, Colquiri Sud, Cochabamba, Bolivia.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of
 * Jala Foundation, ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Jala Foundation.
 */

package com.foundations.convertor.view;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.embed.swing.JFXPanel;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Slider;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.paint.Color;
import javafx.util.Duration;
import javax.swing.SwingUtilities;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import java.io.File;


/**
 *  Multimedia player using JavaFx
 *
 * @author Adrian Rojas - AWT-[01].
 * @version 0.1
 */
public class MoviePlayer {

    private JFrame playerFrame;
    private JFXPanel jfxPanel;
    private MediaPlayer player;
    private Timeline slideIn;
    private Timeline slideOut;
    private VBox vbox;
    private Slider slider;

    public MoviePlayer() {
        super();
    }
    /**
     * Starts to play the video specified
     *
     * @param videoPath is the path for the video to play
     * @throws Exception
     */
    public void start(String videoPath) {

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                framePlayer(encodePath(videoPath));
            }
        });
    }

    /**
     * Encodes path to UTF-8
     * @param path brute path
     * @return usable path
     */
    private String encodePath(String path){
        path = "file:"+File.separator+path;
        path = path.replace("\\","/");
        path = path.replace(" ","%20");
        return path;
    }
    /**
     * This method runs on the EDT thread: It loads the content from the Swing context
     */
    private void framePlayer(String path) {
        playerFrame = new JFrame("Convertor - Movie Player");
        jfxPanel = new JFXPanel();
        playerFrame.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        playerFrame.setSize(400,400);
        playerFrame.add(jfxPanel);
        playerFrame.setVisible(true);
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                initFX(jfxPanel,path);
            }
        });
    }

    /**
     * This method is invoked on the JavaFX thread
     * @param fxPanel is the FX panel to be inserted in the JFrame
     */
    private void initFX(JFXPanel fxPanel, String path) {
        //Create objects for video player
        Group root = new Group();
        Media media = new Media(path);
        player = new MediaPlayer(media);
        MediaView view = new MediaView(player);
        Scene scene = new Scene(root, 400, 400, Color.BLACK);
        //Create objects for slider
        slideIn = new Timeline();
        slideOut = new Timeline();
        root.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                slideOut.play();
            }
        });
        root.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                slideIn.play();
            }
        });

        vbox = new VBox();
        slider = new Slider();
        root.getChildren().add(view);
        vbox.getChildren().add(slider);
        root.getChildren().add(vbox);
        player.play();
        fxPanel.setScene(scene);
        //Frame and slider changes size depending on the video size
        changeToMedia();
        //Listener for the slider position
        player.currentTimeProperty().addListener(new ChangeListener<Duration>() {
            @Override
            public void changed(ObservableValue<? extends Duration> observableValue, Duration duration, Duration current) {
                slider.setValue(current.toSeconds());
            }
        });
        //Listener for the slider click action
        slider.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                player.seek(Duration.seconds(slider.getValue()));
            }
        });

    }

    /**
     * Frame Size and JavaFX slider changes size according to the video size
     */
    public void changeToMedia (){
        player.setOnReady(new Runnable() {
            @Override
            public void run() {
                int w = player.getMedia().getWidth();
                int h = player.getMedia().getHeight();

                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        playerFrame.setSize(w,h);
                        System.out.println("Multimedia size "+w+","+h);
                    }
                });

                vbox.setMinSize(w, 100);
                vbox.setTranslateY(h - 100);

                slider.setMin(0.0);
                slider.setValue(0.0);
                slider.setMax(player.getTotalDuration().toSeconds());

                slideOut.getKeyFrames().addAll(
                        new KeyFrame(new Duration(0),
                                new KeyValue(vbox.translateYProperty(), h-100),
                                new KeyValue(vbox.opacityProperty(), 0.9)
                        ),
                        new KeyFrame(new Duration(300),
                                new KeyValue(vbox.translateYProperty(), h),
                                new KeyValue(vbox.opacityProperty(), 0.0)
                        )
                );
                slideIn.getKeyFrames().addAll(
                        new KeyFrame(new Duration(0),
                                new KeyValue(vbox.translateYProperty(), h),
                                new KeyValue(vbox.opacityProperty(), 0.0)
                        ),
                        new KeyFrame(new Duration(300),
                                new KeyValue(vbox.translateYProperty(), h-100),
                                new KeyValue(vbox.opacityProperty(), 0.9)
                        )
                );
            }
        });
    }
}
