package id.co.skyforce.basicjsf;

import id.co.skyforce.basicjsf.domain.Address;
import id.co.skyforce.basicjsf.domain.Customer;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class CustomerServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {

		String action = req.getParameter("action");
		if (action.equals("create")) {
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

			Address address = new Address();
			Customer customer = new Customer();
			customer.setAddress(address);
			customer.setFirstName(firstName);
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

			session.save(customer);
			session.save(address);

			trx.commit();
			session.close();
		} else if (action.equals("edit")) {

			String idCus = req.getParameter("idCus");
			long IdCustomer = Long.parseLong(idCus);
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

			Session session = HibernateUtil.openSession();
			Transaction trx = session.beginTransaction();
			Address address = new Address();
			Customer customer = (Customer) session.get(Customer.class,
					IdCustomer);

			if (IdCustomer == customer.getId()) {
				customer.setFirstName(firstName);
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

				session.save(customer);
				session.save(address);

				trx.commit();
				session.close();
			}

		} else if (action.equals("hapus")) {

			String idCus = req.getParameter("idCus");
			long IdCustomer = Long.parseLong(idCus);
			Session session = HibernateUtil.openSession();
			Transaction trx = session.beginTransaction();
			Customer customer = (Customer) session.get(Customer.class,
					IdCustomer);

			if (IdCustomer == customer.getId()) {
				session.delete(customer);
				trx.commit();
				session.close();
			}
		}

	}

	protected void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {

		Session session = HibernateUtil.openSession();
		Transaction trx = session.beginTransaction();

		Query query = session.createQuery("FROM Customer");
		List<Customer> cus = query.list();

		req.setAttribute("customers", cus);

		RequestDispatcher rd = req.getRequestDispatcher("list.jsp");
		rd.forward(req, res);
		session.close();

	}

}