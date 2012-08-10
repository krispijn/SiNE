package sine;

public class SineObject {
    
    Integer idObject; // unique identifier from database
    String name;
    Enum.Domain domain; // domain of the object
    Enum.Type type;  // object typification
    Float cruisingSpeed; // in m/s (convert for display purposes
    Float maxSpeed; // in m/s
    Float minSpeed; // in m/s
    Float maxAltitude; // in m
    Float minAltitude; // in m
    Float maxRange; // in m
    Float minRange; // in m
    
    String ID;
    String description;
    
    Structure structure; // structure data
    
    public SineObject() {
        super();
        this.structure = new Structure(this); // init the manadatory structure info
    }
    

}

