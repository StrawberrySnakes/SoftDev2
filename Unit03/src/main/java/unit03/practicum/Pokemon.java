package unit03.practicum;
// Dessa Shapiro

// initalizing 
public class Pokemon {
    private String name;
    private final Types type;
    private int level;

    public Pokemon(String name, Types type) {
        this.name = name;
        this.type = type;
        this.level= 1;
    }

    
    public Pokemon(String name, Types type, int level) {
        this.name = name;
        this.type = type;
        // if level is over 100 is will be set back to 100
        this.level= level;
    }

    // defult 
    public Pokemon() {
        this("NoName", Types.WATER);
    }

    // getters and setters
    public String getName() {return this.name;}
    public Types getType() {return this.type;}
    public int getLevel() {return this.level;}
    public void setName(String name) {this.name = name;}

    public void levelUp() {
        if (this.level< 100) {
        this.level += 1; }
    }


    // string representation 
    @Override
    public String toString() {
        return "{name = "+getName()+", type = "+getType()+", level = "+ getLevel();
    }

    // two are equal if their type and level is equal
    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Pokemon){
            Pokemon other = (Pokemon) obj;
            return this.type.equals(other.type) && this.level == other.level;
        } else { return false;}
         
    }

}
