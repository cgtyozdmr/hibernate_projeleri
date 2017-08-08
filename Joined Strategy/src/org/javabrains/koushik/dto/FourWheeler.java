package org.javabrains.koushik.dto;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
public class FourWheeler extends Vehicle {
	private String direksiyon;

	public String getDireksiyon() {
		return direksiyon;
	}

	public void setDireksiyon(String direksiyon) {
		this.direksiyon = direksiyon;
	}

}
