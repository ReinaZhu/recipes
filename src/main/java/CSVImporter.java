import com.opencsv.CSVReader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CSVImporter {

    public static void main(String[] args) {

        // JDBC connection information
        String url = "jdbc:postgresql://localhost:5432/postgres";
        String user = "yin";
        String password = "123456";

        // CSV file information
        String csvFile =  "./src/data/db-recipes.csv";
        String delimiter = ",";

        try {
            // Load the PostgreSQL JDBC driver
            Class.forName("org.postgresql.Driver");

            // Create a database connection
            Connection connection = DriverManager.getConnection(url, user, password);

            // Create a table in the database
            String createTableSQL = "CREATE TABLE recipe (id INTEGER, name TEXT, source TEXT, preptime INTEGER, waittime INTEGER, cooktime INTEGER,servings INTEGER ,comments TEXT, calories INTEGER,fat INTEGER,satfat INTEGER,carbs INTEGER,fiber INTEGER,sugar INTEGER, protein INTEGER,instructions TEXT ,ingredients TEXT,tags TEXT)";
            PreparedStatement createTableStmt = connection.prepareStatement(createTableSQL);
            createTableStmt.executeUpdate();

            // Read the contents of the CSV file and insert the data into the database
            CSVReader reader = new CSVReader(new FileReader(csvFile));
            String[] nextLine;
            while ((nextLine = reader.readNext()) != null) {
                int id = Integer.parseInt(nextLine[0]);
                String name = nextLine[1];
                String source = nextLine[2];
                int preptime = Integer.parseInt(nextLine[3]);
                int waittime =  Integer.parseInt(nextLine[4]);
                int cooktime  =  Integer.parseInt(nextLine[5]);
                int servings =  Integer.parseInt(nextLine[6]);
                String comments = nextLine[7];
                int calories =  Integer.parseInt(nextLine[8]);
                int fat =  Integer.parseInt(nextLine[9]);
                int satfat =  Integer.parseInt(nextLine[10]);
                int carbs  =  Integer.parseInt(nextLine[11]);
                int fiber =  Integer.parseInt(nextLine[12]);
                int sugar =  Integer.parseInt(nextLine[13]);
                int protein  =  Integer.parseInt(nextLine[14]);
                String instructions = nextLine[15];
                String ingredients = nextLine[16];
                String tags = nextLine[17];
//Insert
                String insertSQL = "INSERT INTO recipe (id, name, source, preptime, waittime, cooktime, " +
                        "servings, comments, calories, fat, satfat, carbs, fiber, sugar, protein,instructions , ingredients, tags) " +
                        "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? ,?, ? ,?)";
                PreparedStatement insertStmt = connection.prepareStatement(insertSQL);
                insertStmt.setInt(1, id);
                insertStmt.setString(2, name);
                insertStmt.setString(3, source);
                insertStmt.setInt(4, preptime);
                insertStmt.setInt(5, waittime);
                insertStmt.setInt(6, cooktime);
                insertStmt.setInt(7, servings);
                insertStmt.setString(8, comments);
                insertStmt.setInt(9, calories);
                insertStmt.setInt(10, fat);
                insertStmt.setInt(11, satfat);
                insertStmt.setInt(12, carbs);
                insertStmt.setInt(13, fiber);
                insertStmt.setInt(14, sugar);
                insertStmt.setInt(15, protein);
                insertStmt.setString(16, instructions);
                insertStmt.setString(17, ingredients);
                insertStmt.setString(18, tags);

                insertStmt.executeUpdate();
            }

            // Close the database connection and CSV reader
            reader.close();
            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
