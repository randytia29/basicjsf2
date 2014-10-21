package id.co.skyforce.basicjsf;

import id.co.skyforce.basicjsf.domain.Address;
import id.co.skyforce.basicjsf.domain.Customer;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




import org.hibernate.Session;
import org.hibernate.Transaction;

public class CustomerServletEdit extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		String firstName = req.getParameter("firstName");
		String lastName = req.getParameter("lastName");
		String email = req.getParameter("email");

		SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd");
		Date birthDay = null;
		try {
			birthDay = formatter.parse(req.getParameter("birthday"));
		} catch (Exception e) {
			e.printStackTrace();
		}

		String homePhone = req.getParameter("homePhone");
		String mobilePhone = req.getParameter("mobilePhone");
		String password = req.getParameter("password");
		String kota = req.getParameter("city");
		String kodePos = req.getParameter("postalCode");
		String jalan = req.getParameter("street");

//		boolean cek = false;
//		for (OrderDetail orderDetail : order.getOrderDetails()) {
//			if (orderDetail.getProduct().getId() == productId)
//				;
//			{
//				orderDetail.setQuantity(jumlahBaru);
//				cek = true;
//			}
//			if (cek == false) {
//				System.out.println("Id tidak ada");
//			}
//		}
		
		
		
		Address address = new Address();
		Customer customer = new Customer();
		
		if(firstName.equals(customer.getFirstName())){
			customer.setAddress(address);
			customer.setLastName(lastName);
			customer.setEmail(email);
			customer.setHomePhone(homePhone);
			customer.setMobileNo(mobilePhone);
			customer.setPassword(password);
			customer.setBirthDate(birthDay);
			
			address.setCity(kota);
			address.setPostalCode(kodePos);
			address.setStreet(jalan);
			
			Session session = HibernateUtil.openSession();
			Transaction trx = session.beginTransaction();
			
			session.update(customer);
			session.update(address);
			
			
			trx.commit();
			session.close();
		}
		
//		customer.setAddress(address);
//		customer.setFirstName(firstName);
//		customer.setLastName(lastName);
//		customer.setEmail(email);
//		customer.setHomePhone(homePhone);
//		customer.setMobileNo(mobilePhone);
//		customer.setPassword(password);
//		customer.setBirthDate(birthDay);
//
//		address.setCity(kota);
//		address.setPostalCode(kodePos);
//		address.setStreet(jalan);
//
//		Session session = HibernateUtil.openSession();
//		Transaction trx = session.beginTransaction();
//		
//		session.save(customer);
//		session.save(address);
//		
//		trx.commit();
//		session.close();

	}
}
