// Dessa Shapiro
/**
 * This file creates a player and is formated to get a despirction string 
 * as well as an image path
 * it also gives different functions to alter the volume of the player
 */
package unit04;

import java.io.File;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

/** */
public class Channel{
    private final String playerPath;
    private final String imagePath;
    private final String description;
    private MediaPlayer mediaPlayer;


    /**
     * 
     * @param player
     * @param imagePath
     * @param description
     */
    public Channel(String description, String imagePath, String playerPath) {
        this.playerPath = playerPath;
        this.imagePath = imagePath;
        this.description = description;
    }

    /**
     * 
     * @return
     */
    public String getPlayerPath() {
        return this.playerPath; }

    /**
     * 
     * @return
     */
    public String getDescription() {
        return this.description; }

        /**
     * 
     * @return
     */
    public String getImagePath() {
        return this.imagePath; }


    public void stop() {
        if (mediaPlayer != null) {
            mediaPlayer.stop();
        }
    }

    public void play() {
        stop();
        Media media = new Media(new File(getPlayerPath()).toURI().toString());
        mediaPlayer = new MediaPlayer(media);
        mediaPlayer.setVolume(0.5); // Set a default volume
        mediaPlayer.play();
    }

    /**
     * 
     * @param volume
     */
    public void setVolume(double volume) {
        this.mediaPlayer.setVolume(volume);
    }

    public double getVolume() {
        return this.mediaPlayer.getVolume();
    }

    
    public void increaseVolume() {
        if(this.mediaPlayer.getVolume() < 1.0)
            this.mediaPlayer.setVolume(this.mediaPlayer.getVolume()+0.1);
    }

    public void decreaseVolume() {
        if(this.mediaPlayer.getVolume() > 0.0)
            this.mediaPlayer.setVolume(this.mediaPlayer.getVolume()-0.1);
    }
    
}
