// This class will contain all necesarry queries to modify the contents of the SiNE database.
// These have been put in there own class to guarantee that when a certain kind of db modification is needed, eg.
// deletion of an object, it always happen in the same way. When the program and db is expanded, this is the only 
// place in the program where the db queries need to be updated; all the calls remain the same.

package sine;


import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import java.sql.DriverManager;
import java.sql.ResultSet;


public class dbQueries {
    
    public dbQueries() {
        super();
    }
    
    public void createObject(SineObject theObj, dbConnection theConnection) throws Exception {
        
        //This creates the DB entry for an object (requires an object and a structure
        Connection con;
        Statement stmnt;
        String query;
        
        String url,user,pass;
        
        url = "jdbc:mysql://" + theConnection.host + "/sine_object";
        user = theConnection.login;
        pass = theConnection.pw;
        
        //attempt data connection
        Class.forName("com.mysql.jdbc.Driver").newInstance();
        con = (Connection)DriverManager.getConnection(url, user, pass);
        
        //make new object      
        query = "INSERT INTO `sine_object`.`object`" + 
        "(`name`,`domain`,`type`,`description`,`ID`,`cruisingSpeed`,`maxSpeed`,`minSpeed`,`maxAltitude`,`minAltitude`,`maxRange`,`minRange`) " + 
        "VALUES(" + 
        " \" " + theObj.name + " \",\"" + theObj.domain + "\",\"" + theObj.type + "\",\"" + theObj.ID + "\",\"" + theObj.description + "\"," +
        theObj.cruisingSpeed + "," + theObj.maxSpeed + "," +theObj.minSpeed + "," + theObj.maxAltitude + "," + theObj.minAltitude + "," +
            theObj.maxRange + "," +theObj.minRange + ");";
        
        stmnt = (Statement)con.createStatement();      
        stmnt.executeUpdate(query);
        
        //make corresponding structure entry
        query = "INSERT INTO `sine_object`.`structure`\n" + 
        "(`Object_idObject`,`length`,`width`,`height`,`draught`,`diameter`,`weight`,`displacement`) " + 
        "VALUES(" + 
        "LAST_INSERT_ID()," + theObj.structure.length + "," + theObj.structure.width + "," + theObj.structure.height + "," + 
        theObj.structure.draught + "," + theObj.structure.diameter + "," + theObj.structure.weight + "," + theObj.structure.displacement + ");";
        
        stmnt.executeUpdate(query);

    }
    
    public void updateObject(int objectID, dbConnection theConnection) throws Exception{
    }
    public void removeObject(int objectID, dbConnection theConnection) throws Exception{
        //here the queries go to remove an object and it's links to other tables based on it's ID
        
        //This creates the DB entry for an object (requires an object and a structure
        //returns the id of the created object or -1 if failed
        Connection con;
        Statement stmnt;
        String query;
        
        String url,user,pass;
        
        url = "jdbc:mysql://" + theConnection.host + "/sine_object";
        user = theConnection.login;
        pass = theConnection.pw;
        
        //attempt data connection
        Class.forName("com.mysql.jdbc.Driver").newInstance();
        con = (Connection)DriverManager.getConnection(url, user, pass);
        
        //Remove structure
        query = "DELETE FROM `sine_object`.`structure` WHERE `Object_idObject`='" + objectID + "';";
        
        stmnt = (Statement)con.createStatement();      
        stmnt.executeUpdate(query);
        
        //Then remove object
        query = "DELETE FROM `sine_object`.`object` WHERE `idObject`='" + objectID + "';";  
        stmnt.executeUpdate(query);
        
    }
    
    public SineObject selectObject(int objectID, dbConnection theConnection) throws Exception{
        SineObject retObj = new SineObject();
        
        //This creates the DB entry for an object (requires an object and a structure
        Connection con;
        Statement stmnt;
        String query;
        ResultSet rs;
        
        String url,user,pass;
        
        url = "jdbc:mysql://" + theConnection.host + "/sine_object";
        user = theConnection.login;
        pass = theConnection.pw;
        
        //attempt data connection
        Class.forName("com.mysql.jdbc.Driver").newInstance();
        con = (Connection)DriverManager.getConnection(url, user, pass);
        
        //make new object      
        query = "SELECT * FROM `sine_object`.`object` WHERE idObject = '" + objectID + "';";
        
        stmnt = (Statement)con.createStatement();      
        rs = stmnt.executeQuery(query); //should return just one entry
        
        //fill the object from the database values
        while (rs.next()) {
            retObj.idObject = rs.getInt(1);
            retObj.name = rs.getString(2);
            retObj.domain = Enum.Domain.valueOf(rs.getString(3));
            retObj.type = Enum.Type.valueOf(rs.getString(4));
            
            retObj.description = rs.getString(5);
            retObj.ID = rs.getString(6);
            retObj.cruisingSpeed = rs.getFloat(7);
            retObj.maxSpeed = rs.getFloat(8);
            retObj.minSpeed = rs.getFloat(9);
            retObj.maxAltitude = rs.getFloat(10);
            retObj.minAltitude = rs.getFloat(11);
            retObj.maxRange = rs.getFloat(12);
            retObj.minRange = rs.getFloat(13);
    
            break; //unconditional break. Only one entry should be return, if multiple are here we just use the first (also you need to take a look at your DB!
        }
        //fetch structure info
        query = "SELECT * FROM `sine_object`.`structure` WHERE Object_idObject = '" + objectID + "';";
        
        stmnt = (Statement)con.createStatement();      
        rs = stmnt.executeQuery(query); //should return just one entry
        
        //fill the object from the database values
        while (rs.next()) {
            retObj.structure.length = rs.getFloat(2);
            retObj.structure.width = rs.getFloat(3);
            retObj.structure.height = rs.getFloat(4);
            retObj.structure.draught = rs.getFloat(5);
            retObj.structure.diameter = rs.getFloat(6);
            retObj.structure.weight = rs.getFloat(7);
            retObj.structure.displacement = rs.getFloat(8);
         
            break;   
        }
        
        return retObj;
    }
    
}
