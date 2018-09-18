package com.foundations.convertor.view;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.awt.BorderLayout;
import uk.co.caprica.vlcj.binding.LibVlc;
import uk.co.caprica.vlcj.component.EmbeddedMediaPlayerComponent;
import uk.co.caprica.vlcj.discovery.NativeDiscovery;
import uk.co.caprica.vlcj.player.MediaPlayer;
import uk.co.caprica.vlcj.player.MediaPlayerEventAdapter;

public class MultimediaPlayer {
    private JFrame frame;
    private EmbeddedMediaPlayerComponent mediaPlayerComponent;

    /**
     * Starts to play multimedia with VLCJ
     * @param mmPath string of the multimedia path
     */
    public void start(String mmPath){
        new NativeDiscovery().discover();
        boolean found = new NativeDiscovery().discover();
        System.out.println(found);
        System.out.println(LibVlc.INSTANCE.libvlc_get_version());
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                VLCPlayer(encodePath(mmPath));
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

    private void VLCPlayer(String path) {
        frame = new JFrame("Convertor - Multimedia Player");
        frame.setBounds(100, 100, 600, 400);
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        //Release resources when frame closes
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.out.println(e);
                mediaPlayerComponent.release();
                frame.dispose();
            }
        });

        JPanel contentPane = new JPanel();
        contentPane.setLayout(new BorderLayout());

        mediaPlayerComponent = new EmbeddedMediaPlayerComponent();
        contentPane.add(mediaPlayerComponent, BorderLayout.CENTER);

        JPanel controlsPane = new JPanel();

        JButton rewindButton = new JButton("<<");
        controlsPane.add(rewindButton);
        JButton pauseButton = new JButton("Play/Pause");
        controlsPane.add(pauseButton);
        JButton skipButton = new JButton(">>");
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
                                mediaPlayerComponent.getMediaPlayer().getMediaMeta().getUrl()
                        ));
                    }
                });
            }

            @Override
            public void finished(MediaPlayer mediaPlayer) {
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        closeWindow();
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