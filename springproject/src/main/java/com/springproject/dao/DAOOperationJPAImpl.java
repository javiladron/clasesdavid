package com.springproject.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.springproject.beans.form.CalculatorObject;

/**
 * Vamos a hacer cuatro implementaciones posibles de esta clase de ejemplo dao
 * 3º JPA-hibernate con configuracion desde codigo
 * 4º JPA-hibernate desde servidor de aplicaciones (tomcat)
 * @author david
 *
 */




@Repository
public class DAOOperationJPAImpl implements IDAOOperationJPA{
	
	@PersistenceContext//(unitName="springproject")
	private EntityManager em;

	@Override
	public void insertOperation(CalculatorObject obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<CalculatorObject> getListadoLog() {
		// TODO Auto-generated method stub
		return null;
	}

}
