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

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springproject.beans.form.CalculatorObject;
import com.springproject.utils.GeneralUtils;

/**
 * Vamos a hacer cuatro implementaciones posibles de esta clase de ejemplo dao
 * 1º Acceso a datos mediante jdbc con configuracion desde codigo
 * 2º Acceso a datos mediante jdbc con configuracion desde servidor de aplicaciones (tomcat)
 * @author david
 *
 */


@Service
public class DAOOperationImpl implements IDAOOperation{
	
	@Autowired
	private DataSource dataSource;
	
	//@Autowired
	//private GeneralUtils utils;
	
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
				pstmt.setInt(3, Integer.parseInt(op));
				pstmt.setTimestamp(4, new Timestamp(System.currentTimeMillis()));
				int n=pstmt.executeUpdate();//usamos este metodo para las operaciones insert, update y delete
				if(n<1){
					throw new Exception();
				}
				connection.commit();
			}
		}catch(Exception ex){
			try{
				connection.rollback();//menejo manual de transacciones (un coñazo)
			}catch(SQLException sqlexcept){
				sqlexcept.printStackTrace();
			}
			
			
		}
		
		
	}

	@Override
	public List<CalculatorObject> getListadoLog(String op) {
		List<CalculatorObject> lista=null;
		try{
			checkDriverMySQL();
			
			if(connection!=null){
				//String query="select * from operationlog order by fecha desc";
				String query="select ol.id,ol.primerop,ol.segundop,d.nombreop,d.color from operationlog ol, descoperation d  where ol.idoperacion=d.id order by ol.fecha desc";
				if(StringUtils.isNotBlank(op)){
					//query="select * from operationlog where operacion = ? order by fecha desc";
					 query="select ol.id,ol.primerop,ol.segundop,d.nombreop,d.color from operationlog ol, descoperation d  where ol.idoperacion=d.id and ol.idoperacion = ? order by ol.fecha desc";
				}
				PreparedStatement pstmt=connection.prepareStatement(query);//SQL
				if(StringUtils.isNotBlank(op)){
					pstmt.setString(1, op);//elegimos setString porque la columna operacion en bbdd es un varchar2. El primer algumento indica la posicion del interrogante que queremos dar valor
				}
				ResultSet rs=pstmt.executeQuery();//para select usamos este metodo
				lista=new ArrayList<CalculatorObject>();
				while(rs.next()){
					//seteamos bean on los parametros del resultset
					CalculatorObject co=new CalculatorObject();
					co.setPrimerop(rs.getString(2));//co.setPrimerop(rs.getString("primerop"));
					co.setSegundoop(rs.getString(3));
					//co.setOperacion(utils.getOperationByCode(rs.getString(4)));
					co.setOperacion(rs.getString(4));
					co.setColor(rs.getString(5));
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
