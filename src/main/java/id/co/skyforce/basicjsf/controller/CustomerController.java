package id.co.skyforce.basicjsf.controller;

import id.co.skyforce.basicjsf.HibernateUtil;
import id.co.skyforce.basicjsf.domain.Address;
import id.co.skyforce.basicjsf.domain.Customer;

import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import org.hibernate.Session;
import org.hibernate.Transaction;

@ManagedBean
public class CustomerController {

	private String email;
	private String password;
	private String firstName;
	private String lastName;
	private Date birthDate;
	private String mobileNo;
	private String homePhone;

	private String street;
	private String city;
	private String postalCode;

	private String salutation;
	private Character gender;
	private Long customerId;
	private Long addressId;

	public Long getAddressId() {
		return addressId;
	}

	public void setAddressId(Long addressId) {
		this.addressId = addressId;
	}

	public String getSalutation() {
		return salutation;
	}

	public void setSalutation(String salutation) {
		this.salutation = salutation;
	}

	public void setGender(Character gender) {
		this.gender = gender;
	}

	public CustomerController() {
		String id = FacesContext.getCurrentInstance().getExternalContext()
				.getRequestParameterMap().get("id");
		if (id != null) {
			customerId = Long.valueOf(id);
			Session session = HibernateUtil.openSession();
			Transaction trx = session.beginTransaction();
			Customer customer = (Customer) session.get(Customer.class, customerId);
			
			firstName = customer.getFirstName();
			lastName = customer.getLastName();
			email = customer.getEmail();
			password = customer.getPassword();
			homePhone = customer.getHomePhone();
			mobileNo = customer.getMobileNo();
			addressId = customer.getAddress().getId();
			birthDate = customer.getBirthDate();
			gender = customer.getGender();
			salutation = customer.getSalutation();
			city = customer.getAddress().getCity();
			postalCode = customer.getAddress().getPostalCode();
			street = customer.getAddress().getStreet();
			trx.commit();
			session.close();
		}

	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public String save() {
		Session session = HibernateUtil.openSession();
		Transaction trx = session.beginTransaction();

		Address address = new Address();
		Customer customer = new Customer();
		customer.setId(customerId);
		customer.setAddress(address);
		customer.setFirstName(firstName);
		customer.setLastName(lastName);
		customer.setEmail(email);
		customer.setHomePhone(homePhone);
		customer.setMobileNo(mobileNo);
		customer.setPassword(password);
		customer.setBirthDate(birthDate);
		customer.setGender(gender);
		customer.setSalutation(salutation);

		address.setId(addressId);
		address.setCity(city);
		address.setPostalCode(postalCode);
		address.setStreet(street);

		session.saveOrUpdate(customer);

		trx.commit();
		session.close();
		return "/customer/list";
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getHomePhone() {
		return homePhone;
	}

	public void setHomePhone(String homePhone) {
		this.homePhone = homePhone;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public Character getGender() {
		return gender;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
}
