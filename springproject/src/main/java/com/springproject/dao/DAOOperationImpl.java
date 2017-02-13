package com.springproject.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Timestamp;
import java.util.List;

import org.springframework.stereotype.Service;

import com.springproject.beans.form.CalculatorObject;

@Service
public class DAOOperationImpl implements IDAOOperation{

	@Override
	public void insertOperation(String po, String so, String op) {
		try{
			checkDriverMySQL();
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/springproject","root", "");
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
		try{
			checkDriverMySQL();
			
			
			
			
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return null;
	}
	
	private void checkDriverMySQL() throws ClassNotFoundException{
		Class.forName("com.mysql.jdbc.Driver");
	}

}
