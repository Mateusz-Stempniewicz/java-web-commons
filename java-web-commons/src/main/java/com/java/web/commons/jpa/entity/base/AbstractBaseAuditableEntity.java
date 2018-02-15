/**
 * 
 */
package com.java.web.commons.jpa.entity.base;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;

/**
 * Encje rozszerzające tą klasę dostają dodatkowe kolumny z informacjami kto i
 * kiedy utworzył obiekt<br />
 * Rozszerza podstawową encję {@link AbstractBaseEntity}.
 * 
 * @author mateusz.stempniewicz
 */
@MappedSuperclass
public abstract class AbstractBaseAuditableEntity<T, ID extends Serializable>
    extends AbstractBaseEntity<ID> {
	
	private static final long serialVersionUID = -1836336873591921952L;
	
	private T createdBy;
	private Date createdDate;
	
	public AbstractBaseAuditableEntity() {
		super();
	}
	
	public AbstractBaseAuditableEntity(ID id,
	    T createdBy,
	    Date createdDate) {
		super(id);
		this.createdBy = createdBy;
		this.createdDate = createdDate;
	}
	
	@CreatedBy
	@ManyToOne
	@JoinColumn(name = "created_user_id", updatable = false)
	public T getCreatedBy() {
		return createdBy;
	}
	
	public void setCreatedBy(T createdBy) {
		this.createdBy = createdBy;
	}
	
	@CreatedDate
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_date", nullable = false, updatable = false)
	public Date getCreatedDate() {
		return createdDate;
	}
	
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	
}
