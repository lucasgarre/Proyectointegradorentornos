/**
 * 
 * @author Lucas
 *
 */
import java.sql.*;
public class Modelo {
	// Atributos de la clase
	private String surl = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
	private Connection conexion;
	private Statement stmt;
	private ResultSet rset;
	private String bd, login, pwd, url;

	// Constructor que crea la conexión
	public Modelo() {
		try {
			login = "lucas";
			pwd = "Blackberry8520@@";
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String mi_url = "jdbc:oracle:thin:@localhost:1521:XE";
			conexion = DriverManager.getConnection(mi_url, "SYSTEM", "Nokia5320@");
			System.out.println("-- Conexión establecida --");
		} catch (ClassNotFoundException e) {
			System.out.println("No tengo el driver cargado");
		} catch (SQLException e) {
			System.out.println("Falla la conexión");
			System.out.println(e.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
//Creamos el código para obtener las consultas en la tabla socios
	public String[][] ObtenerSocios(String query){
		
		 String[][] socios  = new String[10][10];

		
		try{
			
		 
		 stmt = conexion.createStatement();
		 rset = stmt.executeQuery(query);
	
		 int cont=0;
		 
		 while(rset.next()){// Recorrido de registros de la query
			 
			 
			 //for (int i=0; i<socios[0].length;i++){
				 
				 socios[cont][0] = rset.getString("Nº_SOCIOS");
				 socios[cont][1] = rset.getString("NOMBRE");
				 socios[cont][2] = rset.getString("APELLIDO");
				 socios[cont][3] = rset.getString("DNI");
				 socios[cont][4] = String.valueOf(rset.getInt("TELEFONO"));
			 //}
			 
			 
			 cont++;
			 
			 /*
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
			*/




		}
		 
		 
		 
		}
		catch(SQLException s){
			s.printStackTrace();
		}
		finally{
			try{
				rset.close();
				stmt.close();
				
			}
			catch(SQLException e){
				System.out.println(e.getMessage());
			}

		}
		
		return socios;
		
		}
	//Terminamos el código para las consultas de la tabla socios.
	//Empezamos la creación de código para los inserts de la tabla socio
	
	public String Insertarsocio(String Nombre, String Apellido, int numSocio, String DNI, int Telefono){
		String error=""; 
		try {
			stmt= conexion.createStatement();
			int result = stmt.executeUpdate("INSERT INTO appfinal.SOCIOS VALUES ("  +numSocio+  ",'" + Nombre + "','" + Apellido + "','" + DNI + "'," + Telefono +")" );   //  INSERT INTO TABLA VALUES ()
		System.out.println("---->"+result);
		} catch (SQLException e) {
			// TODO: handle exception
			error = e.getMessage();
			System.out.println("--->"+error);
		}return error;
		
		
	}
	//Fin creación código inserts
	//Comienzo borrado de socio
	public String BorrarSocio(String cod_socio){
		String error=""; 
		try {
			stmt= conexion.createStatement();
			
			  int codsocio  = Integer.parseInt(cod_socio);
			  
			int result = stmt.executeUpdate("DELETE from appfinal.SOCIOS where Nº_Socios =  "  + cod_socio );   //  INSERT INTO TABLA VALUES ()
		System.out.println("---->"+result);
		} catch (SQLException e) {
			// TODO: handle exception
			error = e.getMessage();
			System.out.println("--->"+error);
		}return error;
		
		
	}
	//Fin borrado de socios
	
	}
	