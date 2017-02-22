package com.springproject.beans.bbdd;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class LogBean implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	//@Column(name="primerop")
	private Integer primerop;
	private Integer segundoop;
	private String operacion;
	private Timestamp fecha;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getPrimerop() {
		return primerop;
	}
	public void setPrimerop(Integer primerop) {
		this.primerop = primerop;
	}
	public Integer getSegundoop() {
		return segundoop;
	}
	public void setSegundoop(Integer segundoop) {
		this.segundoop = segundoop;
	}
	public String getOperacion() {
		return operacion;
	}
	public void setOperacion(String operacion) {
		this.operacion = operacion;
	}
	public Timestamp getFecha() {
		return fecha;
	}
	public void setFecha(Timestamp fecha) {
		this.fecha = fecha;
	}
	
	
	@Override
	public String toString() {
		return id+" "+primerop+" "+segundoop+" "+operacion+" "+fecha;
	}
	

}
