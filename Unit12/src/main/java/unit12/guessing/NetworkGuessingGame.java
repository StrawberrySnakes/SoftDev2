package unit12.guessing;

import java.io.*;
import java.net.*;

public class NetworkGuessingGame {
    public static void main(String[] args) throws UnknownHostException, IOException {
        
        Socket server = new Socket("129.21.41.180", 12345); 
        // make a guessing game
        // GuessingGame game = new GuessingGameImpl();
        GuessingGame game = new GuessingGameProxy(server); // creating the thing getting injected 


        // use a game player to play it
        GamePlayer player = new GamePlayer(game); // this is where we are actually injecting the thing
        player.playTheGame();
    }

}
