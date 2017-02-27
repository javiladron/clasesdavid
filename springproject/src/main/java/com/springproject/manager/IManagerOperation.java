package com.springproject.manager;

import java.util.List;

import com.springproject.beans.bbdd.LogBean;
import com.springproject.beans.form.CalculatorObject;

public interface IManagerOperation {
	
	public String calcular(String po,String so, String op);
	
	//metodo que utilizabamos para extraer listado de logs con jdbc (bean formulario CalculatorObject)
	public List<CalculatorObject> dameListadoLogs();
	
	//metodo que utilizamos para extraer los logs con JPA-Hibernate
	public List<LogBean> dameListadoLogsJPA();

}
