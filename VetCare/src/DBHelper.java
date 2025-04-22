import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * DBHelper handles connection to the SQLite database
 * and creates the 'pets' table if it doesn't exist.
 */
public class DBHelper {
    // SQLite database file name
    private static final String DB_URL = "jdbc:sqlite:vetcare.db";

    /**
     * Connects to the SQLite database
     * @return Connection object or null if connection fails
     */
    public static Connection connect() {
        Connection conn = null;
        try {
            // Establish connection to SQLite
            conn = DriverManager.getConnection(DB_URL);
        } catch (SQLException e) {
            System.out.println("Connection to database failed!");
            e.printStackTrace();  // Show full error for debugging
        }
        return conn;
    }

    /**
     * Creates the pets table if it doesn't exist
     */
    public static void setupDatabase() {
        // SQL statement to create the pets table
        String petTable = "CREATE TABLE IF NOT EXISTS pets ("
                        + "id INTEGER PRIMARY KEY AUTOINCREMENT, "
                        + "name TEXT NOT NULL, "
                        + "species TEXT NOT NULL, "
                        + "age INTEGER NOT NULL"
                        + ");";

        try (Connection conn = connect(); Statement stmt = conn.createStatement()) {
            if (conn != null) {
                stmt.execute(petTable);
                System.out.println("Database and table are ready.");
            } else {
                System.out.println("Failed to establish connection to run table creation.");
            }
        } catch (SQLException e) {
            System.out.println("Database setup failed!");
            e.printStackTrace();  // Show line where error occurred
        }
    }
}
