package unit04;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import unit04.practiceexam.AlbumSong;
import unit04.practiceexam.Genre;
import unit04.practiceexam.SingleSong;
import unit04.practiceexam.Song;

public class SongTest {
    
    @Test
    public void testToString() {
        // setup
        Song song = new Song("hi", "bye", 5, Genre.HIPHOP);
        String expected = "hi by bye: Runtime: 5 seconds Genre: Hip-Hop";

        String actual = song.toString();

        assertEquals(actual, expected);
    }


    @Test
    public void testEquals() {
        // setup
        Song song1 = new Song("hi", "bye", 5, Genre.HIPHOP);
        Song song2 = new Song("hi", "bye", 5, Genre.HIPHOP);
        Song song3 = new Song("hi", "cry", 5, Genre.HIPHOP);


        assertTrue(song1.equals(song2));
        assertFalse(song2.equals(song3));

    }

    @Test
    public void testSingleToString() {
        // setup
        Song song = new SingleSong("hi", "bye", 5, Genre.HIPHOP);
        String expected = "hi by bye: Runtime: 5 seconds Genre: Hip-Hop (Single)";

        String actual = song.toString();

        assertEquals(actual, expected);
    }

    @Test
    public void testSingleEquals() {
        // setup
        Song song1 = new AlbumSong("hi", "bye", 5, Genre.HIPHOP, "eee");
        Song song2 = new AlbumSong("hi", "bye", 5, Genre.HIPHOP, "eee");
        Song song3 = new AlbumSong("hi", "bye", 5, Genre.HIPHOP, "efe");


        assertTrue(song1.equals(song2));
        assertFalse(song2.equals(song3));

    }
}
