package com.springproject.manager;

import java.util.List;

import com.springproject.beans.bbdd.LogBean;
import com.springproject.beans.form.CalculatorObject;

public interface IManagerOperationJPA {
	
	public String calcular(String po,String so, String op);
	
	//metodo que utilizamos para extraer los logs con JPA-Hibernate
	public List<LogBean> dameListadoLogsJPA(String op);

}
