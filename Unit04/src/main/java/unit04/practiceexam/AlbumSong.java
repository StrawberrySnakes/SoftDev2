package unit04.practiceexam;

public class AlbumSong extends Song {
    private String albumTitle;

    public AlbumSong(String title, String author, int runtime, Genre genre, String ablumTitle) {
        super(title, author, runtime, genre);
        this.albumTitle = ablumTitle;
    }

    public String getAlbumSTitle() {return this.albumTitle;}

    @Override
    public String toString() {
        return super.title+" by "+super.author+" from "+this.albumTitle+": "+getRuntimeString()+" Genre: "+super.genre.getName();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof AlbumSong) {
            AlbumSong other = (AlbumSong)obj;
            return super.equals(obj) && this.albumTitle.equals(other.albumTitle);
        } else {return false;}  

    
}
}
