package sine;

public class Enum {
    public Enum() {
        super();
    }


    public enum Domain {
        UNKNOWN,
        SURFACE, 
        SUBSURFACE, 
        SEA, 
        LAND, 
        AIR, 
        SPACE        
    }
    
    public enum Type {
        UNKNOWN,
        VEHICLE,
        BUILDING,
        GEOLOGICAL_FEATURE,
        
    }
    
    public enum SpeedUnits {
        MS, //DEFAULT (SI)
        KMH, // kilometers/hour
        MPH, // miles/hour
        KTS, //knots (nautical mile/hour)
        MACH, // Mach number (at sea level)
        
    }
    
    public enum LengthUnits {
        M, //DEFAULT (SI)
        FEET,
        YARD,
        KM,
        NM, // Nautical Mile
        MILES,
        
    }
    
    public enum MassUnits {
        KG, //DEFAULT (SI)
        TONNES,
        LB,
    }
}