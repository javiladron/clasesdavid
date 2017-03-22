package com.springproject.dao;

import java.util.List;

import com.springproject.beans.bbdd.LogBean;

public interface IDAOOperationJPA {
	
	public void insertOperation(LogBean obj);
	
	public List<LogBean> getListadoLog(String op);

}
