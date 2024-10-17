// Dessa Shapiro
package unit04;
import java.io.File;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;


public class TV extends Application{
    private Channel[] channels;
    private int currentChannel = -1;
    private Label channelInfoLabel;
    
    @Override
    public void start(Stage primaryStage) {
        channels = createChannels();

        BorderPane root = new BorderPane();
        root.setPadding(new Insets(10));

        // configure the image
        ImageView imageView = new ImageView();
        imageView.setFitWidth(500); 
        imageView.setFitHeight(300); 
        BorderPane.setAlignment(imageView, Pos.TOP_CENTER); 
        root.setCenter(imageView);

        // configure the top label
        channelInfoLabel = new Label("Current Channel: None");
        channelInfoLabel.setStyle("-fx-font-weight: bold; -fx-background-color: black; -fx-text-fill: white;");
        channelInfoLabel.setPadding(new Insets(10)); 
        root.setTop(channelInfoLabel);
        channelInfoLabel.setMaxWidth(Double.MAX_VALUE);

        //configure the right-side controls
        VBox controls = createControls();
        root.setRight(controls);

        primaryStage.setScene(new Scene(root, 820, 350));
        primaryStage.setTitle("TV Set");
        primaryStage.show();
    }

/**
 * 
 * @return
 */
    private VBox createControls() {
        VBox controls = new VBox(10);

        //configure the channel grid
        GridPane channelGrid = createChannelGrid();
        controls.getChildren().add(channelGrid);

        //configure the volume buttons
        HBox volumeButtons = createVolumeButtons();
        controls.getChildren().add(volumeButtons);

        return controls;
    }

    /**Method to create the channel grid layout
     * 
     * @return
     */
    private GridPane createChannelGrid() {
    GridPane gridPane = new GridPane();
    gridPane.setHgap(0);
    gridPane.setVgap(0);

    for (int i = 0; i < 10; i++) {
       
        Button channelButton = new Button(String.valueOf(i));
        channelButton.setMinSize(100, 50);
        channelButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                changeChannel(Integer.parseInt(channelButton.getText()));
            }
        });

        int row = i / 3;
        int col = i % 3;
        gridPane.add(channelButton, col, row);
    }

    return gridPane;
}



    /**
     * 
     * @return
     */
    private HBox createVolumeButtons() {
        HBox volumeButtons = new HBox(10);
    
        Button increaseVolumeButton = new Button("+");
        Button decreaseVolumeButton = new Button("-");
        Label volumeLabel = new Label("Volume: 50");  // Initial label text, assuming starting volume is 50
    
        increaseVolumeButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                increaseVolume();
                updateVolumeLabel(volumeLabel);
            }
        });
    
        decreaseVolumeButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                decreaseVolume();
                updateVolumeLabel(volumeLabel);
            }
        });
    
        volumeButtons.getChildren().addAll(increaseVolumeButton, decreaseVolumeButton, volumeLabel);
    
        return volumeButtons;
    }

    /**
     * 
     * @return
     */
    private Channel[] createChannels() {
        Channel[] channels = new Channel[10];
        channels[0] = new Channel("Channel 0", "path/to/image0.jpg", "path/to/audio0.mp3");
        channels[1] = new Channel("Channel 1", "src/main/java/unit04/TVSet/images/west.jpeg", "src/main/java/unit04/TVSet/images/one.mp3");
        channels[2] = new Channel("Channel 2", "src/main/java/unit04/TVSet/images/sport.jpg", "src/main/java/unit04/TVSet/images/two.mp3");
        channels[3] = new Channel("Channel 3", "src/main/java/unit04/TVSet/images/PandF.jpeg", "src/main/java/unit04/TVSet/images/three.mp3");
        channels[4] = new Channel("Channel 4", "src/main/java/unit04/TVSet/images/hunger.jpg", "src/main/java/unit04/TVSet/images/three.mp3");
        channels[5] = new Channel("Channel 5", "src/main/java/unit04/TVSet/images/avatar.jpg", "src/main/java/unit04/TVSet/images/three.mp3");
        channels[6] = new Channel("Channel 6", "src/main/java/unit04/TVSet/images/nature.jpeg", "src/main/java/unit04/TVSet/images/three.mp3");
        channels[7] = new Channel("Channel 7", "src/main/java/unit04/TVSet/images/adventure.png", "src/main/java/unit04/TVSet/images/three.mp3");
        channels[8] = new Channel("Channel 8", "src/main/java/unit04/TVSet/images/puff.jpeg", "src/main/java/unit04/TVSet/images/three.mp3");
        channels[9] = new Channel("Channel 9", "src/main/java/unit04/TVSet/images/kerm.jpeg", "src/main/java/unit04/TVSet/images/three.mp3");

        return channels;
    }

    private void playCurrentChannel() {
        Channel channel = getCurrentChannel();
        if (channel != null) {
            channel.play();
            updateImageView(channel);
            updateChannelInfoLabel(channel);
        }
    }

    private void increaseVolume() {
        Channel channel = getCurrentChannel();
        if (channel != null) {
            channel.increaseVolume();
        }
    }

    private void decreaseVolume() {
        Channel channel = getCurrentChannel();
        if (channel != null) {
            channel.decreaseVolume();
        }
    }

    /**
     * 
     * @param newChannel
     */
    private void changeChannel(int newChannel) {
        stopCurrentChannel();  
        currentChannel = newChannel;
        playCurrentChannel();
        updateImageView(getCurrentChannel());
        updateChannelInfoLabel(getCurrentChannel());
    }
    
    private void stopCurrentChannel() {
        Channel channel = getCurrentChannel();
        if (channel != null) {
            channel.stop();
        }
    }


    private void updateVolumeLabel(Label volumeLabel) {
        Channel channel = getCurrentChannel();
        if (channel != null) {
            double currentVolume = channel.getVolume();
            volumeLabel.setText("Volume: " + currentVolume);
        }
    }

    /**
     * 
     * @param channel
     */
    private void updateImageView(Channel channel) {
        if (channel != null) {
            ImageView imageView = (ImageView) ((BorderPane) channelInfoLabel.getParent()).getCenter();
            Image image = new Image(new File(channel.getImagePath()).toURI().toString());
            imageView.setImage(image);
        }
    }
    
    
    /**
     * 
     * @param channel
     */
    private void updateChannelInfoLabel(Channel channel) {
        if (channel != null) {
            channelInfoLabel.setText("Current Channel: " + channel.getDescription());
        } else {
            channelInfoLabel.setText("Current Channel: None");
        }
    }

    /**
     * 
     * @return
     */
    private Channel getCurrentChannel() {
        return currentChannel >= 0 && currentChannel < channels.length ? channels[currentChannel] : null;
    }

    /**
     * 
     * @param text
     * @param fontName
     * @param fontSize
     * @param insets
     * @param textFill
     * @param position
     * @param backgroungColor
     * @return
     */
    private static Label makeLabel(String text, String fontName, int fontSize, int insets, Color textFill, Pos position, Color backgroungColor) {
        Label label = new Label(text);
        label.setFont(new Font(fontName, fontSize));
        label.setPadding(new Insets(insets));
        label.setTextFill(textFill);
        label.setAlignment(position);
        label.setBackground(new Background(new BackgroundFill(backgroungColor, CornerRadii.EMPTY, Insets.EMPTY)));
        label.setBorder(new Border(new BorderStroke(Color.CYAN, BorderStrokeStyle.DASHED, new CornerRadii(10), BorderStroke.THICK)));
        return label;
    }

    /**
     * 
     * @param args
     */
    public static void main(String[] args) {
        launch(args);
    }

}
    
