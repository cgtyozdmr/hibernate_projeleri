package org.koushikhibernate;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.*;

//import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.Restrictions;
//import org.javabrains.koushik.dto.Address;
//import org.javabrains.koushik.dto.FourWheeler;
//import org.javabrains.koushik.dto.TwoWheeler;
import org.javabrains.koushik.dto.UserDetails;

import com.vividsolutions.jts.index.strtree.STRtree;
//import org.javabrains.koushik.dto.Vehicle;



public class HibernateTest {

	public static void main(String[] args) 
	{
	
	SessionFactory sf=new Configuration().configure().buildSessionFactory();
	Session session=sf.openSession();
	session.beginTransaction();
	
	for(int i=0;i<6;i++) 
	{
	UserDetails kisi=new UserDetails();//6 kiþi kaydettik
	kisi.setUserName("kisi "+i);
	session.save(kisi);
	}
	Criteria criteria=session.createCriteria(UserDetails.class);
	
	
	criteria.add(Restrictions.eq("userName","kisi 5"));//kriter ekledik eq eþittir demek
	
	List<UserDetails> users2=(List<UserDetails>) criteria.list();//kriter ekledimiz için sorgudan donen degeri baska listede tuttuk.
	session.getTransaction().commit();
	session.close();
	
	for(UserDetails i: users2)
	{
		System.out.println(i.getUserName());
	}
	}}

