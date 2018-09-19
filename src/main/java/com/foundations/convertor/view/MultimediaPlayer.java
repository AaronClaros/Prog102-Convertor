package com.foundations.convertor.view;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.awt.BorderLayout;
import java.util.logging.Logger;

import com.foundations.convertor.utils.LoggerManager;
import com.foundations.convertor.utils.Messages;
import com.foundations.convertor.utils.StyleUtils;
import uk.co.caprica.vlcj.component.EmbeddedMediaPlayerComponent;
import uk.co.caprica.vlcj.discovery.NativeDiscovery;
import uk.co.caprica.vlcj.player.MediaPlayer;
import uk.co.caprica.vlcj.player.MediaPlayerEventAdapter;

public class MultimediaPlayer {
    private JFrame frame;
    private EmbeddedMediaPlayerComponent mediaPlayerComponent;
    private static final int LIMIT = 3; //Instance quantity restriction
    private static int count = 0;
    /**
     *Restricts the MultimediaPlayer instances to 3
    */
    public static synchronized MultimediaPlayer getInstance()
    {
        if(count<LIMIT){
            MultimediaPlayer multimediaPlayer = new MultimediaPlayer();
            count++;
            return multimediaPlayer;
        }
        LoggerManager.getLogger().Log("Only 3 Multimedia players allowed", "INFO");
        Messages.getInstance().informationMessage("Only 3 Players can work at the same time","Atention!");
        return null;
    }
    /**
     * Starts to play multimedia with VLCJ
     * @param mmPath string of the multimedia path
     */
    public void start(String mmPath){
        new NativeDiscovery().discover();
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Player(encodePath(mmPath));
            }
        });
    }
    /**
     * Encodes path to UTF-8
     * @param path brute path
     * @return usable path
     */
    private String encodePath(String path){
        path = "file://"+ File.separator+path;
        path = path.replace("\\","/");
        path = path.replace(" ","%20");
        return path;
    }

    private void Player(String path) {
        frame = new JFrame("Convertor - Multimedia Player");
        ImageIcon openIcon = StyleUtils.getInstance().createImageIcon("Grasshopper_32.png");
        frame.setIconImage(openIcon.getImage());
        frame.setBounds(100, 100, 600, 400);
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        //Release resources when frame closes
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                count --;
                mediaPlayerComponent.release();
                frame.dispose();
            }
        });

        JPanel contentPane = new JPanel();
        contentPane.setLayout(new BorderLayout());

        mediaPlayerComponent = new EmbeddedMediaPlayerComponent();
        contentPane.add(mediaPlayerComponent, BorderLayout.CENTER);

        JPanel controlsPane = new JPanel();
        //Creating playback icons
        ImageIcon playpause = StyleUtils.getInstance().createImageIcon("playpause.png");
        ImageIcon backward = StyleUtils.getInstance().createImageIcon("backward.png");
        ImageIcon forward = StyleUtils.getInstance().createImageIcon("forward.png");
        JButton rewindButton = new JButton();
        rewindButton.setIcon(backward);
        controlsPane.add(rewindButton);
        JButton pauseButton = new JButton();
        pauseButton.setIcon(playpause);
        controlsPane.add(pauseButton);
        JButton skipButton = new JButton();
        skipButton.setIcon(forward);
        controlsPane.add(skipButton);
        contentPane.add(controlsPane, BorderLayout.SOUTH);

        pauseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mediaPlayerComponent.getMediaPlayer().pause();
            }
        });

        rewindButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mediaPlayerComponent.getMediaPlayer().skip(-10000);
            }
        });

        skipButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mediaPlayerComponent.getMediaPlayer().skip(10000);
            }
        });

        mediaPlayerComponent.getMediaPlayer().addMediaPlayerEventListener(new MediaPlayerEventAdapter() {
            @Override
            public void playing(MediaPlayer mediaPlayer) {
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        frame.setTitle(String.format(
                                "Convertor - %s",
                                mediaPlayerComponent.getMediaPlayer().getMediaMeta().getTitle()
                        ));
                    }
                });
            }

            @Override
            public void finished(MediaPlayer mediaPlayer) {
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        mediaPlayerComponent.getMediaPlayer().stop();
                        mediaPlayerComponent.getMediaPlayer().start();
                        mediaPlayerComponent.getMediaPlayer().pause();

                    }
                });
            }

            @Override
            public void error(MediaPlayer mediaPlayer) {
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        JOptionPane.showMessageDialog(
                                frame,
                                "Failed to play media",
                                "Error",
                                JOptionPane.ERROR_MESSAGE
                        );
                        closeWindow();
                    }
                });
            }
        });

        frame.setContentPane(contentPane);
        frame.setVisible(true);

        mediaPlayerComponent.getMediaPlayer().playMedia(path);

    }

    private void closeWindow() {
        frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
    }


}
