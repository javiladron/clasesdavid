package com.springproject.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springproject.beans.form.CalculatorObject;

/**
 * Vamos a hacer cuatro implementaciones posibles de esta clase de ejemplo dao
 * 1º Acceso a datos mediante jdbc con configuracion desde codigo
 * 2º Acceso a datos mediante jdbc con configuracion desde servidor de aplicaciones (tomcat)
 * 4º JPA-hibernate desde servidor de aplicaciones (tomcat)
 * @author david
 *
 */


@Service
public class DAOOperationImpl implements IDAOOperation{
	
	@Autowired
	private DataSource dataSource;
	
	Connection connection;

	@Override
	public void insertOperation(String po, String so, String op) {
		try{
			checkDriverMySQL();
			
			if(connection!=null){
				PreparedStatement pstmt=connection.prepareStatement("insert into operationlog values(NULL,?,?,?,?)");
				connection.setAutoCommit(false);
				pstmt.setInt(1, Integer.parseInt(po));
				pstmt.setInt(2, Integer.parseInt(so));
				pstmt.setString(3, op);
				pstmt.setTimestamp(4, new Timestamp(System.currentTimeMillis()));
				int n=pstmt.executeUpdate();//usamos este metodo para las operaciones insert, update y delete
				if(n<1){
					throw new Exception();
				}
				connection.commit();
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
		
		
	}

	@Override
	public List<CalculatorObject> getListadoLog() {
		List<CalculatorObject> lista=null;
		try{
			checkDriverMySQL();
			
			if(connection!=null){
				PreparedStatement pstmt=connection.prepareStatement("select * from operationlog order by fecha desc");
				ResultSet rs=pstmt.executeQuery();//para select usamos este metodo
				lista=new ArrayList<CalculatorObject>();
				while(rs.next()){
					//seteamos bean on los parametros del resultset
					CalculatorObject co=new CalculatorObject();
					co.setPrimerop(rs.getString(2));//co.setPrimerop(rs.getString("primerop"));
					co.setSegundoop(rs.getString(3));
					co.setOperacion(getOperationByCode(rs.getString(4)));
					//agregamos a lista
					lista.add(co);
				}
				return lista;
			}
			
			
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return null;
	}
	
	private String getOperationByCode(String code){
		String res=null;
		switch(code){
			case "1":
				res="suma";
				break;
			case "2":
				res="resta";
				break;
			case "3":
				res="multiplicacion";
				break;
			case "4":
				res="division";
				break;
			default:
				break;
		}
		return res;
	}
	
	private void checkDriverMySQL() throws ClassNotFoundException,SQLException{
		//Conexion con bbdd metodo 1
		/*Class.forName("com.mysql.jdbc.Driver");
		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/springproject","root", "");*/
		//Conexion con bbdd metodo 2
		if(connection==null){
			connection=dataSource.getConnection();
		}
		
	}

}
