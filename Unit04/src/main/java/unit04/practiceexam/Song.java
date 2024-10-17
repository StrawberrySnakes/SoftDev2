package unit04.practiceexam;

public class Song {
    public static final Object albumTitle = null;
    protected String title;
    protected String author;
    protected int runtime;
    protected Genre genre;

    public Song(String title, String author, int runtime, Genre genre) {
        this.title = title;
        this.author = author;
        this.runtime = runtime;
        this.genre = genre;
    }

    public String getTitle() {return this.title;}
    public String getAuthor() {return this.author;}
    public int getRuntime() {return this.runtime;}
    public Genre getGenre() {return this.genre;}

    public String getRuntimeString() {return "Runtime: "+this.runtime+" seconds";}

    @Override
    public String toString() {
        return this.title+" by "+this.author+": "+getRuntimeString()+" Genre: "+this.genre.getName();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Song) {
            Song other = (Song)obj;
            return this.title.equals(other.title) && this.author.equals(other.author) && this.runtime == other.runtime;
        } else {return false;}

    }



    


    
}
