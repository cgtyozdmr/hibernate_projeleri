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
	user.setUserName("Kiþi "+i);
	session.save(user);//CREATE iþlemi yapýldý
	}
	
	 user=(UserDetails)session.get(UserDetails.class,6);//id no=6 olan kiþi user nesnemiz artýk
	 
	 System.out.println("6 numaralý kiþinin ismi "+user.getUserName());//id no=6 olan kiþi(useri) yi READ yaptýk.
	 session.delete(user);//id no=6 olan kiþi(useri) DELETE yaptýk.
	 
	 user=(UserDetails)session.get(UserDetails.class,5);//id=6 silindiði için yeni userýmýz id=5 olsun
	 user.setUserName("polat_alemdar");//id=5 in ismini UPDATE ettik
	 session.update(user);
	 
	
	session.getTransaction().commit();
	session.close();
	
	
	
	
	}}

