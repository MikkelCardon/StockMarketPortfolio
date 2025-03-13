package SQL;

import Gui.models.Person;
import Gui.models.Portfolio;
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

        		}
                catch (Exception e) {
        			System.out.println("fejl:  " + e.getMessage());
        		}
    }

	public static void initPortfolio(){
		try {
			String url = "jdbc:sqlserver://DESKTOP-KQNO6AD\\SQLEXPRESS;databaseName=stockDB;user=sa;password=CARDONDB;";
			Connection minConnection = DriverManager.getConnection(url);

			String query = "SELECT * FROM portfolio";
			Statement stmt = minConnection.createStatement();

			ResultSet res = stmt.executeQuery(query);

			while (res.next()) {
				Portfolio portfolio = new Portfolio(res.getInt(1), res.getString(3));

				int person_id = res.getInt(2);
				for (Person person : Storage.getPersonArrayList()) {
					if (person.getPerson_id() == person_id){
						person.addPortfolio(portfolio);
					}
				}
			}

			if (stmt != null)
				stmt.close();
			if (minConnection != null)
				minConnection.close();

		}
		catch (SQLException e){
			System.out.println(e.getMessage());
			System.out.println(e.getErrorCode());

		}
		catch (Exception e) {
			System.out.println("fejl:  " + e.getMessage());
		}
	}

}
