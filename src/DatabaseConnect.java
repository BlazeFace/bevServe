/**
 * Created by Nate Bensing on 7/20/2017.
 */
import java.sql.*;

public class DatabaseConnect {
    static Connection c = null;
    public static void main(String args[]) {
        //  DatabasePrint.print();
        //  writeDB("Revolt", "U");
        //    DatabasePrint.print();

    }
    public static void writeDB(int id, int val, String table, String col){
        Statement stmt = null;
        if(dbConnect()){
            try {
                PreparedStatement statement = c.prepareStatement("select * from users where uniqueid  = ?");
                statement.setInt(1, id);
                ResultSet rs = statement.executeQuery();
                // n = 101; Use this to set product
                stmt = c.createStatement();
                statement = c.prepareStatement("UPDATE " + table + " set " + col +" = " + val + " where uniqueid = ?");
                statement.setInt(1, id);
                statement.executeUpdate();
                c.commit();
                rs.close();
                statement.close();
                c.close();
                System.out.print("Succ");
            }
            catch ( Exception e ) {
                System.err.println( e.getClass().getName()+": " + e.getMessage() );
                System.exit(0);
            }
        }
    }
    public static void writeDB(int id, String val, String table, String col){
        Statement stmt = null;
        if(dbConnect()){
            try {
                PreparedStatement statement = c.prepareStatement("select * from users where uniqueid  = ?");
                statement.setInt(1, id);
                ResultSet rs = statement.executeQuery();
                // n = 101; Use this to set product
                stmt = c.createStatement();
                statement = c.prepareStatement("UPDATE " + table + " set " + col + " = " + val + " where uniqueid = ?");
                statement.setInt(1, id);
                statement.executeUpdate();
                c.commit();
                rs.close();
                statement.close();
                c.close();
                System.out.print("Succ");
            }
            catch ( Exception e ) {
                System.err.println( e.getClass().getName()+": " + e.getMessage() );
                System.exit(0);
            }
        }
    }
    public static boolean dbConnect() {
        Statement stmt = null;
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager
                    .getConnection("jdbc:postgresql://localhost:5432/BevFDev", "postgres", "Bensingn1");
            c.setAutoCommit(false);
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
            return false;
        }
    }
}
