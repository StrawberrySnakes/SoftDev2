package unit04.practiceexam;

public class SingleSong extends Song {

    public SingleSong(String title, String author, int runtime, Genre genre) {
        super(title, author, runtime, genre);
        
    }
    
    @Override
    public String toString() {
        return super.toString()+" (Single)";
    }
}
