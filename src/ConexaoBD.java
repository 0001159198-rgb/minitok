import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConexaoBD {

    private static final String URL = "jdbc:mysql://localhost:3306/minitok?useSSL=false&serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    public static Connection getConnection() {

        try {
            // Carregar driver do MySQL
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Abrir conexão
            return DriverManager.getConnection(URL, USER, PASSWORD);

        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Driver MySQL não encontrado!", e);

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao conectar ao banco de dados!", e);
        }
    }

    // Fechar todos os recursos
    public static void fechar(Connection conn, PreparedStatement stmt, ResultSet rs) {

        try {
            if (rs != null) rs.close();
        } catch (SQLException e) {
            System.out.println("Falha ao fechar ResultSet: " + e.getMessage());
        }

        try {
            if (stmt != null) stmt.close();
        } catch (SQLException e) {
            System.out.println("Falha ao fechar PreparedStatement: " + e.getMessage());
        }

        try {
            if (conn != null) conn.close();
        } catch (SQLException e) {
            System.out.println("Falha ao fechar Connection: " + e.getMessage());
        }
    }
}

