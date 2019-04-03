package org.springframework.samples.petclinic.bill;


import java.sql.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Digits;

import org.springframework.samples.petclinic.owner.Owner;
import org.springframework.samples.petclinic.visit.Visit;

@Entity
@Table(name = "bill")
public class Bill {
	
	@Id
	@GeneratedValue
	@Column(name = "Id")
	private long  Id;
	
	@Column(name = "fechaPago")
	@Temporal(TemporalType.DATE)
	private Date fechaPago;
	
	@Column(name = "cuantia")
	@Digits(integer = 10, fraction = 2)
	private float cuantia;
	
	@ManyToOne
	@JoinColumn(name = "id", nullable = true)
	private Owner own;
	

	@OneToOne( mappedBy = "id", cascade = CascadeType.ALL)
	private Visit visit;
	
	
	

	public long getId() {
		return Id;
	}

	public void setId(long id) {
		Id = id;
	}

	public Date getFechaPago() {
		return fechaPago;
	}

	public void setFechaPago(Date fechaPago) {
		this.fechaPago = fechaPago;
	}

	public float getCuantia() {
		return cuantia;
	}

	public void setCuantia(float cuantia) {
		this.cuantia = cuantia;
	}
	
	
	

}
