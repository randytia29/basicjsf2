package id.co.skyforce.basicjsf.domain;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;

import java.util.Date;
import java.util.List;

public class TestMahasiswa {

	public static void main(String[] args) {
		Mahasiswa randy = new Mahasiswa();
		randy.setNim("A12");
		randy.setNamaDepan("Randytia");
		randy.setNamaBelakang("Akbar");
		randy.setAlamat("Pasadena");
		randy.setTempatLahir("Kudus");
		randy.setTanggalLahir(new Date());

		SessionFactory sessionFactory = new Configuration().configure()
				.buildSessionFactory();
		
		// contoh save ***
		// Session session = sessionFactory.openSession();
		// Transaction transaction = session.beginTransaction();
		// session.save(randy);
		// transaction.commit();
		// session.close();

		// contoh get ***
		//Session session = sessionFactory.openSession();
		//Transaction transaction = session.beginTransaction();
		//Mahasiswa m = (Mahasiswa) session.get(Mahasiswa.class, "A12");
		//m.setNamaBelakang("Test");
		//System.out.println(m.getNamaDepan());
		//transaction.commit();
		//session.close();*/
		
		
		//Session session = sessionFactory.openSession();
		//Transaction transaction = session.beginTransaction();
		//Query query = session.createQuery("from Mahasiswa");
		//List<Mahasiswa> listMahasiswa = query.list();
		//for(Mahasiswa daftar : listMahasiswa){
			//System.out.println(daftar.getNamaDepan());
		//}
		//transaction.commit();
		//session.close();
		
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Query query = session.createQuery("from Mahasiswa m where m.nim = :nim");
		query.setString("nim", "A12");
		Mahasiswa m = (Mahasiswa) query.uniqueResult();
		
		System.out.println(m.getAlamat());
		transaction.commit();
		session.close();
	}

}
