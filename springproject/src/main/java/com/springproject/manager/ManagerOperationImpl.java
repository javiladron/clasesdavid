package com.springproject.manager;


import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springproject.beans.bbdd.LogBean;
import com.springproject.beans.form.CalculatorObject;
import com.springproject.dao.IDAOOperation;
import com.springproject.dao.IDAOOperationJPA;
import com.springproject.utils.GeneralUtils;


/**
 * El service es  el que habilita el poder ser inyectada 
 * esta clase en cualquiera de las otras
 * @author david
 *
 */
@Service
public class ManagerOperationImpl implements IManagerOperation{

	@Autowired
	IDAOOperation dao;
	
	@Autowired
	GeneralUtils utils;
	
	
	@Override
	public String calcular(String po, String so, String op) {
		String res=null;
		int poN=Integer.parseInt(po);;
		int soN=Integer.valueOf(so).intValue();;
		int opN=new Integer(op).intValue();
		switch (opN) {
			case 1:
				res=String.valueOf(poN+soN);
				break;
			case 2:
				res=String.valueOf(poN-soN);
				break;
			case 3:
				res=String.valueOf(poN*soN);
				break;
			case 4:
				try{
					double d=poN/soN;
					res=String.valueOf(d);
				}catch(ArithmeticException ae){
					res=null;
				}
				break;
			default:
				break;
		}
		System.out.println("insert log by jdbc");
		dao.insertOperation(po,so,op);//insert por jdbc
		return res;
	}


	@Override
	public List<CalculatorObject> dameListadoLogs(String op) {
		return dao.getListadoLog(op);
	}
	

}
