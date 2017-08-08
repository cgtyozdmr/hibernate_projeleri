package org.koushikhibernate;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.*;

//import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
//import org.javabrains.koushik.dto.Address;
//import org.javabrains.koushik.dto.FourWheeler;
//import org.javabrains.koushik.dto.TwoWheeler;
import org.javabrains.koushik.dto.UserDetails;

import com.vividsolutions.jts.index.strtree.STRtree;
public class HibernateTest {

	public static void main(String[] args) {

		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();

		for (int i = 0; i < 10; i++) {
			UserDetails kisi = new UserDetails();// 10 kiþi kaydettik
			kisi.setUserName("kisi " + i);
			session.save(kisi);
		}

		Query query1 = (Query) session.getNamedQuery("UserDetail_idsiverilenigetir");
		Query query2 = (Query) session.getNamedQuery("UserDetails_ismiverilenigetir");
		
		query1.setParameter(0,2);
		query2.setParameter("kisi_ismi","kisi 8");//dikkat 0 yazýlýr çünkü o sorgunun ilk soru iþaretidir.
		
		List<UserDetails> users1 = (List<UserDetails>) query1.list();
		List<UserDetails> users2 = (List<UserDetails>) query2.list();
		

		session.getTransaction().commit();
		session.close();
		
		for (UserDetails i : users1) {
			System.out.println(i.getUserName());
		}
		
		for (UserDetails i : users2) {
			System.out.println(i.getUserName());
		}
		

	}
}
