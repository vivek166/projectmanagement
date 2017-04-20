package com.synerzip.project.dbconnection;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.synerzip.project.model.Project;

public class HibernateUtils {
	
	
	public static Session getSession() {
		Configuration con = new Configuration().configure().addAnnotatedClass(Project.class);
		SessionFactory sf = con.buildSessionFactory();
		return sf.openSession();
	}
}
