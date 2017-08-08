package org.javabrains.koushik.dto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SecondaryTable;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.postgresql.jdbc2.ArrayAssistantRegistry;

@Entity
@Table(name="tablom")
//@SecondaryTable(name="tablo_iki")
public class UserDetails 
{
	@Id
	 @Column(name="ýd_no")
	                                 //@GeneratedValue(strategy=GenerationType.AUTO) //user.setUserId(2);'a gerek kalmýcak
	private int UserId;
	                                //@Transient --> bu  annotation userName i tablodan trans eder.
	private String userName;
	
	@OneToMany
	private Collection <Vehicle> vehicle=new ArrayList<Vehicle>();
	
	
	                          
	public int getUserId() {
		return UserId;
	}
	public void setUserId(int userId) {
		UserId = userId;
	}
	@Column(name="USER_NAME")
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Collection<Vehicle> getVehicle() {
		return vehicle;
	}
	public void setVehicle(Collection<Vehicle> vehicle) {
		this.vehicle = vehicle;
	}
	
	
	
	
	

}
