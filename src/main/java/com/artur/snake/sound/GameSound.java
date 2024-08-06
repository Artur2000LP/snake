package com.artur.snake.sound;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.net.URL;

public class GameSound {
    private final URL urlSound;
    private Clip clip;
    private boolean isLoop = false;

    public GameSound(String resourceName) {
        urlSound = GameSound.class.getResource("/" + resourceName);
        loadSound(urlSound);
    }

    public void setLoop(boolean isLoop) {
        this.isLoop = isLoop;
    }

    public void play() {
        if (clip != null) {
            new Thread(() -> {
                try {
                    if (clip.isOpen())
                        clip.close();
                    AudioInputStream stream = AudioSystem.getAudioInputStream(urlSound);
                    clip.open(stream);
                    clip.start();
                    if (isLoop) {
                        clip.loop(1000);
                    }
                } catch (Exception e) {
                    System.out.printf("Erorr on play %s, with message %s", urlSound, e.getMessage());
                }
            }).start();
        }
    }

    private void loadSound(URL urlSound) {
        try {
            clip = AudioSystem.getClip();
        } catch (Exception e) {
            System.out.printf("Erorr on loadSound %s, with message %s", urlSound, e.getMessage());
        }
    }
}
