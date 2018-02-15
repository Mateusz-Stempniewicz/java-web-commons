/**
 * 
 */
package com.java.web.commons.dto;

import java.io.Serializable;

/**
 * Podstawowy obiekt DTO zawierający tylko id obiketu.
 * 
 * @param ID
 *          - typ id, jaki ma mieć dany obiekt, musi rozszerzać
 *          {@link Serializable}
 * 
 * @author mateusz.stempniewicz
 */
public class IdentityDto<ID extends Serializable> implements Serializable {
	
	private static final long serialVersionUID = -7225817011835752349L;
	
	private ID id;
	
	public IdentityDto() {
		super();
	}
	
	public ID getId() {
		return id;
	}
	
	public void setId(ID id) {
		this.id = id;
	}
}
