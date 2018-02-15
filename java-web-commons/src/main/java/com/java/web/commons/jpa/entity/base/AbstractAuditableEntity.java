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

import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

/**
 * Encje rozszerzające tą klasę dostają dodatkowe kolumny z informacjami kto i
 * kiedy utworzył obiekt<br />
 * oraz kto i kiedy go ostatnio modyfikował.<br />
 * Rozszerza podstawową encję {@link AbstractBaseEntity}.
 * 
 * @author mateusz.stempniewicz
 */
@MappedSuperclass
public abstract class AbstractAuditableEntity<T, ID extends Serializable>
    extends AbstractBaseAuditableEntity<T, ID> {
	
	private static final long serialVersionUID = -560300121711370820L;
	
	private T lastModifiedBy;
	private Date lastModifiedDate;
	
	public AbstractAuditableEntity() {
		super();
	}
	
	public AbstractAuditableEntity(ID id,
	    T createdBy,
	    Date createdDate,
	    T lastModifiedBy,
	    Date lastModifiedDate) {
		super(id, createdBy, createdDate);
		this.lastModifiedBy = lastModifiedBy;
		this.lastModifiedDate = lastModifiedDate;
	}
	
	@LastModifiedBy
	@ManyToOne
	@JoinColumn(name = "last_modified_user_id")
	public T getLastModifiedBy() {
		return lastModifiedBy;
	}
	
	public void setLastModifiedBy(T lastModifiedBy) {
		this.lastModifiedBy = lastModifiedBy;
	}
	
	@LastModifiedDate
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "last_modified_date", nullable = false)
	public Date getLastModifiedDate() {
		return lastModifiedDate;
	}
	
	public void setLastModifiedDate(Date lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}
}
