/**
 * @author Lucas
 */
import java.sql.*;

public class Modelo {
	// Atributos de la clase
	private String surl = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
	private Connection conexion;
	private Statement stmt;
	private ResultSet rset;

	// Constructor que crea la conexión
	public Modelo() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conexion = DriverManager.getConnection(surl, "system", "Nokia5320@");
			System.out.println(" - Conexión con ORACLE establecida -");
			conexion.close();
		} catch (Exception e) {
			System.out.println(" – Error de Conexión con ORACLE-"+ e.getMessage());
			e.printStackTrace();
		}
	}
	public void Consulta(String query,int columna){
		try{
		Statement stmt = conexion.createStatement();
		ResultSet rset = stmt.executeQuery(query);
		while(rset.next())
		System.out.println(rset.getString(columna));
		rset.close();
		stmt.close();
		} catch(SQLException s){
		s.printStackTrace();
		}
		}
	
	public String Insertarsocio(String Nombre, String Apellido, int numSocio, String DNI, int Telefono){
		String error=""; 
		try {
			stmt= conexion.createStatement();
			int result = stmt.executeUpdate("INSERT INTO SOCIOS VALUES(" + numSocio + "," + Nombre + "," + Apellido + "," + DNI + "," + Telefono +")" );   //  INSERT INTO TABLA VALUES ()
		System.out.println("---->"+result);
		} catch (SQLException e) {
			// TODO: handle exception
			error = e.getMessage();
			System.out.println("--->"+error);
		}return error;
		
		
	}
	
	
}