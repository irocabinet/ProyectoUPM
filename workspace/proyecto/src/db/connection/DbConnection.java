package db.connection;

import java.sql.*;

/**
 * Clase que permite conectar con la base de datos
 * 
 **/

public class DbConnection {
	//Parametros de conexion
	static String db = "ems_db";
	static String login = "mysql";
	static String password = "proyecto";
	static String url = "jdbc:mysql://192.168.99.12/"+db;
	 
	Connection connection = null;

	//Constructor de DbConnection
	public DbConnection() {
		try{
			//Obtenemos el driver para mysql
			Class.forName("com.mysql.jdbc.Driver");
			//Obtenemos la conexión
			connection = DriverManager.getConnection(url, login, password);
	 
			if (connection!=null){
				System.out.println("Conexión a base de datos " + db + " OK\n");
			}
	}
	catch(SQLException e){
		System.out.println(e);
	}catch(ClassNotFoundException e){
		System.out.println(e);
	}catch(Exception e){
		System.out.println(e);
	}
}

	//Permite retornar la conexión
	public Connection getConnection(){
		return connection;
	}
	 
	public void desconectar(){
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
