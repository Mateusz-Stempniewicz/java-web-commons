/**
 * 
 */
package com.java.web.commons.jpa.entity.base;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * @author mateusz.stempniewicz
 * @param ID
 *          - pozwala na ustawienie jako id encji dowolnego typu, który
 *          implementuje/rozszerza interfejs {@link Serializable}
 */
@MappedSuperclass
public abstract class AbstractBaseEntity<ID extends Serializable> implements Serializable {
	
	private static final long serialVersionUID = 459845562436465591L;
	
	private ID id;
	
	public AbstractBaseEntity() {
		super();
	}
	
	public AbstractBaseEntity(ID id) {
		this();
		this.id = id;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	public ID getId() {
		return id;
	}
	
	public void setId(ID id) {
		this.id = id;
	}
}
