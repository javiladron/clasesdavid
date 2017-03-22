package com.springproject.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.springproject.beans.bbdd.LogBean;

/**
 * Vamos a hacer cuatro implementaciones posibles de esta clase de ejemplo dao
 * 3� JPA-hibernate con configuracion desde codigo
 * 4� JPA-hibernate desde servidor de aplicaciones (tomcat)
 * @author david
 *
 */




@Repository
public class DAOOperationJPAImpl implements IDAOOperationJPA{
	
	@PersistenceContext//(unitName="springproject")
	private EntityManager em;

	@Override
	@Transactional
	public void insertOperation(LogBean obj) throws PersistenceException{
		em.persist(obj);
		em.flush();
	}

	@Override
	@Transactional
	public List<LogBean> getListadoLog(String op) throws PersistenceException{
		//JPQL (sentencias SQL sobre clases de persistencia (Entity). NUNCA sobre tablas de bbdd)
		String select="select lg from LogBean lg order by lg.fecha desc";
		if(StringUtils.isNotBlank(op)){
			select="select lg from LogBean lg where lg.operacion = :opeparam order by lg.fecha desc";
		}
		Query query = em.createQuery(select);
		if(StringUtils.isNotBlank(op)){
			query.setParameter("opeparam", op);
		}
		return query.getResultList();
	}

}
