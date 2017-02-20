package com.springproject.manager;

import java.util.List;

import com.springproject.beans.form.CalculatorObject;

public interface IManagerOperation {
	
	public String calcular(String po,String so, String op);
	
	public List<CalculatorObject> dameListadoLogs();

}
