package unit04.practiceexam;

public enum Genre {
    POP("pop"),
    RAP("Rap"),
    HIPHOP("Hip-Hop"),
    ROCKANDROOL("Rock and Roll"),
    JAZZ("Jazz");

    private String name;

    private Genre(String name) {
        this.name = name;
    }

    public String getName() {return this.name;}


}
