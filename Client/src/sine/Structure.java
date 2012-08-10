package sine;

public class Structure {
    SineObject parent; //the parent object
    Float length; // length in m
    Float width; // in m
    Float height; // in m
    Float draught; // in m
    Float diameter; // in m
    Float weight; // in kg
    Float displacement; // in kg

    public Structure(){
    }
    public Structure(SineObject obj){
        this.parent = obj;
    }
    public void setParent(SineObject obj){
        this.parent = obj;
    }
}
