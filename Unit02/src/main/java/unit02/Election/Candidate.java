// Dessa Shapiro
package unit02.Election;

// class to create a candidate
public class Candidate {
    // privatizing 
    private String name;
    private Affiliation affiliation;
    private Positions position;

    public Candidate(String name, Affiliation affiliation, Positions position) {
        this.name = name;
        this.affiliation = affiliation;
        this.position = position;}

    public Candidate() {
        this("NoName", Affiliation.INDEPENDENT, Positions.ASSEMBLY_MEMBER);
    }
    // acssesors
    public String getName() { return this.name;}

    public Affiliation getAffiliation() {return this.affiliation;}

    public Positions getPositions() {return this.position;}

    // To get a string repersentation
    @Override
    public String toString() {
        return "Candidate: {Name: "+ this.name + ", Affiliation: " + this.affiliation + ", Position: "  + this.position +"}";
    }

    // Determines when 2 candidates are equal
    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Candidate){
            Candidate other = (Candidate)obj;
            return this.name.equals(other.name) && this.position.equals(other.position);
        } else {
            return false;
        }

    }
    
    
    
}
    
    

