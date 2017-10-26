package controller;
    import java.sql.Connection;
    import java.sql.DriverManager;
    import java.sql.SQLException;
public class ConnectionFactory {
    public Connection getConnection(){
        try {
            return DriverManager.getConnection("jdbc:postgresql://localhost:5432/SGM","postgres","24261208t");
        } catch (SQLException excecao) {
            throw new RuntimeException(excecao);
        }
    }
}
