package controller;
    import java.sql.Connection;
    import java.sql.DriverManager;
    import java.sql.SQLException;
public class ConnectionFactory {
    public Connection getConnection(){
        try {
            return DriverManager.getConnection("jdbc:postgresql://localhost:5432/sgm","postgres","2426");
        } catch (SQLException excecao) {
            throw new RuntimeException(excecao);
        }
    }
}
