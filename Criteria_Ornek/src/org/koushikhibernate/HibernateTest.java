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
	UserDetails kisi=new UserDetails();//6 ki�i kaydettik
	kisi.setUserName("kisi "+i);
	session.save(kisi);
	}
	
	//T�m kay�tlar� getirir
	Criteria criteria=session.createCriteria(UserDetails.class);
	List<UserDetails> uyeListesi = criteria.list();
	for(UserDetails uye : uyeListesi){
		System.out.println("ID="+uye.getUserId()+", Ad�="+uye.getUserName());
	}
	
	
    //Id'si 4 olan �ye
	criteria = session.createCriteria(UserDetails.class).add(Restrictions.eq("UserId", 4));
	UserDetails uye = (UserDetails) criteria.uniqueResult();//tek deger old.icin uniqueResult() metodunu dondurduk.
	System.out.println("Ad�=" + uye.getUserName());
	
	
	//Ad� 4 ile ge�en ki�iler	
			criteria = session.createCriteria(UserDetails.class).add(Restrictions.like("userName", "%4%"));
			List<UserDetails> ucgecenler = criteria.list();
			for(UserDetails uy : ucgecenler){
				System.out.println("Sonu�:"+uy.getUserName());
			}
			
			
	
	
	
	session.getTransaction().commit();
	session.close();
	
	
	
	}}

