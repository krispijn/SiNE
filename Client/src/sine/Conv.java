package sine;

public class Conv {
    //This is class that does our conversions based on Enums
    public Conv() {
        super();
    }
    
    public static float toSI (float theVal, Enum.LengthUnits theType){
        float retVal = 0f;
        
        switch(theType){
        
        case KM:     
            retVal = theVal * 1000f;
            break;
        case M:
            retVal = theVal;
            break;
        case MILES:
            retVal = theVal * 1609.34f;
            break;                
        case NM:
            retVal = theVal * 1852f;
            break;
        case FEET:     
            retVal = theVal * 0.3048f;
            break;
        case YARD:
            retVal = theVal * 0.9144f;
        }
                
        return retVal;
    }
    
    public static float toSI (float theVal, Enum.MassUnits theType){
        float retVal = 0f;
        
        switch(theType){    

        case KG:
            retVal = theVal;
            break;
        case LB:
            retVal = theVal * 0.453592f;
            break;
        case TONNES:
            retVal = theVal * 1000;
            break;
        }
        return retVal ;  
    }
    
    public static float toSI (float theVal, Enum.SpeedUnits theType){
            float retVal = 0f;
            
            switch(theType){    

            case KMH:
                retVal = theVal * 0.277778f;
                break;
            case KTS:
                retVal = theVal * 0.514444f;
                break;
            case MACH:
                retVal = theVal * 343.2f; // At sea level in dry air at 20 degrees C
                break;
            case MPH:
                retVal = theVal * 0.44704f;
                break;
            case MS:
                retVal = theVal;
                break;
            }
            return retVal ;  
        }
    
    public static float fromSI (float theVal, Enum.LengthUnits theType){
        float retVal = 0f;
        
        switch(theType){
        
        case KM:     
            retVal = theVal * 0.001f;
            break;
        case M:
            retVal = theVal;
            break;
        case MILES:
            retVal = theVal * 0.000621371f;
            break;                
        case NM:
            retVal = theVal * 0.000539957f;
            break;
        case FEET:     
            retVal = theVal * 3.28084f;
            break;
        case YARD:
            retVal = theVal * 1.09361f;
        }
                
        return retVal;
    }
    
    public static float fromSI (float theVal, Enum.MassUnits theType){
        float retVal = 0f;
        
        switch(theType){    

        case KG:
            retVal = theVal;
            break;
        case LB:
            retVal = theVal * 2.20462f;
            break;
        case TONNES:
            retVal = theVal * 0.001f;
            break;
        }
        return retVal ;  
    }
    
    public static float fromSI (float theVal, Enum.SpeedUnits theType){
            float retVal = 0f;
            
            switch(theType){    

            case KMH:
                retVal = theVal * 3.6f;
                break;
            case KTS:
                retVal = theVal * 1.94384f;
                break;
            case MACH:
                retVal = theVal * 0.0029137529f; // At sea level in dry air at 20 degrees C
                break;
            case MPH:
                retVal = theVal * 2.23694f;
                break;
            case MS:
                retVal = theVal;
                break;
            }
            return retVal ;  
        }
    
    public static float convert (float theVal, Enum.LengthUnits theType1, Enum.LengthUnits theType2){
        return Conv.fromSI(Conv.toSI(theVal, theType1), theType2);
        
    }
    public static float convert (float theVal, Enum.MassUnits theType1, Enum.MassUnits theType2){
        return Conv.fromSI(Conv.toSI(theVal, theType1), theType2);
        
    }
    
    public static float convert (float theVal, Enum.SpeedUnits theType1, Enum.SpeedUnits theType2){
        return Conv.fromSI(Conv.toSI(theVal, theType1), theType2);      
    }

}
