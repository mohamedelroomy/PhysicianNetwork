package Utilities;
import  java.sql.Connection;
import  java.sql.Statement;
import  java.sql.ResultSet;
import  java.sql.DriverManager;
import  java.sql.SQLException;

public class DataBase {
    private static Connection conn;

    public static void connectToSecurityDataBase () throws ClassNotFoundException, SQLException {
        String dbURL ="jdbc:sqlserver://18.197.85.177:5433;encrypt=false;user=sa;password=Pass@word;databaseName=Ahbs.PhysicianNetwork.Services.Security;";
        String UserName ="sa";
        String pass ="Pass@word";
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        conn = DriverManager.getConnection(dbURL);
    }

    public static String getForgetPasswordToken (String Email)   {
        try {
            connectToSecurityDataBase();
            String query = "SELECT TOP (10) [ForgetPassword_token] FROM [Ahbs.PhysicianNetwork.Services.Security].[dbo].[Users] where [Email] ='"+Email+"' And [ForgetPassword_token] is not null";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            String token = null;
            while (rs.next()) {
                token=rs.getString("ForgetPassword_token");
            }
            conn.close();
            return token;
        }
        catch (SQLException e){
            System.out.println(e.getMessage());
        }
        catch (ClassNotFoundException e){
            System.out.println(e.getMessage());
        }
        return null;
    }
}
