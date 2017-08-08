package org.javabrains.koushik.dto;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
@Entity
public class TwoWheeler extends Vehicle {
	
	private String direksiyonTopuzu;

	public String getDireksiyonTopuzu() {
		return direksiyonTopuzu;
	}

	public void setDireksiyonTopuzu(String direksiyonTopuzu) {
		this.direksiyonTopuzu = direksiyonTopuzu;
	}

}
