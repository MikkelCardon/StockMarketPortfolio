package SQL;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class InitStocks {
    public static void main(String[] args) {
        initStock();
    }

    public static void initStock(){
        try {
            Scanner scanner = new Scanner(new File("src/main/java/SQL/STOCKS"));

            while(scanner.hasNextLine()){
                String[] data = scanner.nextLine().split(",");

                addStockToDB(data);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private static String url = "jdbc:sqlserver://DESKTOP-KQNO6AD\\SQLEXPRESS;databaseName=StockDB;user=sa;password=CARDONDB;";
    private static Connection minConnection;


    public static void addStockToDB(String[] data){
        try {
            minConnection = DriverManager.getConnection(url);

            String sql = "INSERT INTO Stocks (ticker, stock_name, exchange) VALUES (?, ?, ?)";
            PreparedStatement prestmt = minConnection.prepareStatement(sql);
            prestmt.clearParameters();
            prestmt.setString(1, data[0]);
            prestmt.setString(2, data[1]);
            prestmt.setString(3, data[2]);

            prestmt.executeUpdate();
            System.out.println(GREEN+"Added stock: " + data[1] + RESET);

        } catch (SQLException e) {
            if (e.getMessage().contains("PK_DB")){
                System.out.println(RED + "Duplicated ticker -"+data[0]+"-"+data[1] + "- not inkluded" + RESET);
            }else{
                throw new RuntimeException(e);
            }
        }
    }

    public static final String RESET = "\u001B[0m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";

}
