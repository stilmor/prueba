import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
public class MiPrimerSql {
    public static void main(String[] args) {
        Ejercicio1datos start=new Ejercicio1datos();
// Objetos conexion y Sentencia
        Connection conn = null;
        Statement stmt = null;
        try {
// Paso 1: cargar el driver JDBC.No es necesario incluirlo
            Class.forName("com.mysql.jdbc.Driver").newInstance();
// Paso2: conectarse a la BBDD utilizando la clase Connection
            String userName = "root";
            String password = "1234";
// URL de la base de datos (equipo, puerto, base de datos)
            String url = "jdbc:mysql:" + "//127.0.0.1/sqlddbb";
// 10.0.2.15-Ip de mysql
// String url="jdbc:mysql://localhost/sqlbbdd?autoReconnect=true&useSSL=false";
            conn = (Connection) DriverManager.getConnection(url, userName, password);
            if (conn != null) {
                JOptionPane.showMessageDialog(null, "Conexion a base de datos " + url
                        + " ... Ok", "Informacion", JOptionPane.INFORMATION_MESSAGE);
            }
// Paso 3: crear sentencias SQL, utilizando objetos de tipo Statement
            stmt = (Statement) conn.createStatement();
// Paso 4: Ejecutar las sentencias
            String sqlStr = "select * from prueba";
// String sqlStr = "select * from prueba where pru_numero= '1'";
// Mostrar el resultado de la consulta por consola
            System.out.println("Tu consulta es: " + sqlStr);
            ResultSet rset = stmt.executeQuery(sqlStr);
// Paso 5: procesar el conjunto de registros utilizando ResultSet
            while (rset.next()) {
                System.out.println(rset.getString("pru_numero") + ", " +
                        rset.getString("pru_texto"));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally
        {try
            {
// Cerramos el resto de recursos
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
}