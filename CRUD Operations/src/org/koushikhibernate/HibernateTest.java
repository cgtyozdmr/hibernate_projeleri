package org.koushikhibernate;

//import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
//import org.javabrains.koushik.dto.Address;
//import org.javabrains.koushik.dto.FourWheeler;
//import org.javabrains.koushik.dto.TwoWheeler;
import org.javabrains.koushik.dto.UserDetails;
//import org.javabrains.koushik.dto.Vehicle;

public class HibernateTest {

	public static void main(String[] args) 
	{
	UserDetails user;
	SessionFactory sf=new Configuration().configure().buildSessionFactory();
	Session session=sf.openSession();
	session.beginTransaction();
	
	
	for(int i=0;i<10;i++) 
	{
 user=new UserDetails();
	user.setUserName("Ki�i "+i);
	session.save(user);//CREATE i�lemi yap�ld�
	}
	
	 user=(UserDetails)session.get(UserDetails.class,6);//id no=6 olan ki�i user nesnemiz art�k
	 
	 System.out.println("6 numaral� ki�inin ismi "+user.getUserName());//id no=6 olan ki�i(useri) yi READ yapt�k.
	 session.delete(user);//id no=6 olan ki�i(useri) DELETE yapt�k.
	 
	 user=(UserDetails)session.get(UserDetails.class,5);//id=6 silindi�i i�in yeni user�m�z id=5 olsun
	 user.setUserName("polat_alemdar");//id=5 in ismini UPDATE ettik
	 session.update(user);
	 
	
	session.getTransaction().commit();
	session.close();
	
	
	
	
	}}

