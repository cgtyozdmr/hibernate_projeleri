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
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQuery;
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
@NamedQuery(name="UserDetail_idsiverilenigetir",query="from UserDetails where userId=?")//ismini biz veririz hql de from dan sonra entity ismi
@NamedNativeQuery(name="UserDetails_ismiverilenigetir",query="select * from tablom where userName=:kisi_ismi",resultClass=UserDetails.class)
//Native sql sorgusu oldugu icin fromdan sonra tablo ismi kullanýlýr ve son parametreside sonuc clasýdýr.
public class UserDetails 
{
	@Id     @GeneratedValue(strategy=GenerationType.AUTO)                         
	private int UserId;
	                               
	private String userName;

	
	                          
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
	
	
	
	
	

}
