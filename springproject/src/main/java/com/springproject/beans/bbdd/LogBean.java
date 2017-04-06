package com.springproject.beans.bbdd;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


/**
 * Esta entity tiene una relacion 1:N con las entity DescOperationBean
 * @author david
 *
 */
@Entity
@Table(name="operationlog")
public class LogBean implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	//@Column(name="primerop")
	private Integer primerop;
	@Column(name="segundop")
	private Integer segundoop;
	@Column(name="idoperacion")
	private Integer operacion;
	private Timestamp fecha;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idoperacion",nullable=false,insertable = false, updatable = false)
	private DescOperationBean descOperation;


	public Integer getId() {
		return id;
	}






	public Integer getPrimerop() {
		return primerop;
	}






	public Integer getSegundoop() {
		return segundoop;
	}






	public Integer getOperacion() {
		return operacion;
	}






	public Timestamp getFecha() {
		return fecha;
	}






	public void setId(Integer id) {
		this.id = id;
	}






	public void setPrimerop(Integer primerop) {
		this.primerop = primerop;
	}






	public void setSegundoop(Integer segundoop) {
		this.segundoop = segundoop;
	}






	public void setOperacion(Integer operacion) {
		this.operacion = operacion;
	}






	public void setFecha(Timestamp fecha) {
		this.fecha = fecha;
	}

	





	public DescOperationBean getDescOperation() {
		return descOperation;
	}






	public void setDescOperation(DescOperationBean descOperation) {
		this.descOperation = descOperation;
	}






	@Override
	public String toString() {
		return id+" "+primerop+" "+segundoop+" "+operacion+" "+fecha;
	}
	

}
