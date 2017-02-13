package com.springproject.dao;

import java.util.List;

import com.springproject.beans.form.CalculatorObject;

public interface IDAOOperation {
	
	public void insertOperation(String po, String so, String op);
	
	public List<CalculatorObject> getListadoLog();

}
