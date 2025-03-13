package SQL;

import Gui.models.Person;
import storage.Storage;

import java.sql.*;

public class InitStorage {
    public static void initPerson(){
        try {
        			String url = "jdbc:sqlserver://DESKTOP-KQNO6AD\\SQLEXPRESS;databaseName=stockDB;user=sa;password=CARDONDB;";
        			Connection minConnection = DriverManager.getConnection(url);

        			String query = "SELECT * FROM person";
        			Statement stmt = minConnection.createStatement();

        			ResultSet res = stmt.executeQuery(query);

        			while (res.next()) {
        				Person person = new Person(res.getInt(1),res.getString(2));
                        Storage.addPerson(person);
        			}

        			if (stmt != null)
        				stmt.close();
        			if (minConnection != null)
        				minConnection.close();

        		}
        		catch (SQLException e){
        			System.out.println(e.getMessage());
        			System.out.println(e.getErrorCode());
        			if (e.getErrorCode() == 547) System.out.println("FEJL: Klub har foreign key til hold");

        		}
                catch (Exception e) {
        			System.out.println("fejl:  " + e.getMessage());
        		}
    }

}
