package org.koushikhibernate;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.javabrains.koushik.dto.Address;
import org.javabrains.koushik.dto.FourWheeler;
import org.javabrains.koushik.dto.TwoWheeler;
import org.javabrains.koushik.dto.UserDetails;
import org.javabrains.koushik.dto.Vehicle;

public class HibernateTest {

	public static void main(String[] args) 
	{
		
		Vehicle v1=new Vehicle();
		v1.setVehicleName("Car");
		
		TwoWheeler bike=new TwoWheeler();
		bike.setVehicleName("Bike");
		bike.setDireksiyonTopuzu("bisiklet direksiyon topuzu");
		
		FourWheeler car =new FourWheeler();
		car.setVehicleName("Porche");
		car.setDireksiyon("Porsche direksiyonu");
		
	
	
	
	
	SessionFactory sf=new Configuration().configure().buildSessionFactory();
	Session session=sf.openSession();
	session.beginTransaction();
	
	session.save(v1);
	session.save(bike);
	session.save(car);
	
	session.getTransaction().commit();
	session.close();
	
	
	
	
	}}

