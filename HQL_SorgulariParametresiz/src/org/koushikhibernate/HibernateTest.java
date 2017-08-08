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
	
	Query query1=(Query) session.createQuery("from UserDetails");//tablo ismi de�il class ismi yaz�l�yor dikkat
	Query query2=(Query) session.createQuery("from UserDetails where UserId>5");//buyuk k���k harf farketmiyor
	Query query3=(Query) session.createQuery("select userName from UserDetails");
	/*
	 HQL Nesneye y�nelik sorgulama yapar demistik. Eger nitelik degil de nesne getirmek istersek 
	 �select� ifadesini kullanmamiz gerekmez. Ama eger sorgu sonucunda d�nen degerimiz �zel olarak 
	 belirtilen bir veya birka� alan ise �Select� ifadesini kullanmak zorundayiz.
	 */
	
	//query1.setFirstResult(3);// Bu methot, aldigi integer sayi ile listemize eklemeye baslayacagimiz ilk degeri belirleriz.yani 3.kay�ttan itibaren sorguyu �al��t�r.
	//query1.setMaxResults(2);//Bu methot, sorgu sonucunda d�necek satirlarin maksimum sayisini belirler.Yani sadece 2 sat�r getir.
	
	List<UserDetails> users1=(List<UserDetails>) query1.list();
	List users2=query2.list();
	List<String> users3=(List<String>) query3.list();//sorgudan d�nen de�er string oldu�u i�in listemiz string oldu
	
	session.getTransaction().commit();
	session.close();
	
	System.out.println("Listenin uzunlugu "+users1.size());
	System.out.println("Listenin uzunlugu "+users2.size());
	
	
	for(UserDetails i:users1)
	{
		System.out.println(i.getUserName());
	}
	for(String i:users3)//user3 listesi string oldu�u i�in String tipindedir i
	{
		System.out.println(i);
	}
	
	
	
	}}

