package com.springproject.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.springproject.beans.bbdd.LogBean;

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
	@Transactional
	public void insertOperation(LogBean obj) throws PersistenceException{
		em.persist(obj);
		em.flush();
	}

	@Override
	@Transactional
	public List<LogBean> getListadoLog() throws PersistenceException{
		String select="select lg from LogBean lg order by lg.fecha desc";//JPQL (sentencias SQL sobre clases de persistencia (Entity). NUNCA sobre tablas de bbdd)
		Query query = em.createQuery(select);
//		String select2="select lg from LogBean lg where lg.operacion = :opeparam order by lg.fecha desc";//JPQL con clausula where
//		Query query2 = em.createQuery(select2);
//		query2.setParameter("opeparam", "3");
		return query.getResultList();
	}

}
