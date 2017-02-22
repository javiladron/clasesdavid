package com.springproject.dao;

import java.util.List;

import com.springproject.beans.form.CalculatorObject;

public interface IDAOOperationJPA {
	
	public void insertOperation(CalculatorObject obj);
	
	public List<CalculatorObject> getListadoLog();

}
