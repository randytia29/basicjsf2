package id.co.skyforce.basicjsf.controller;

import id.co.skyforce.basicjsf.HibernateUtil;
import id.co.skyforce.basicjsf.domain.Category;
import id.co.skyforce.basicjsf.domain.Product;

import java.math.BigDecimal;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.hibernate.Session;
import org.hibernate.Transaction;

@ManagedBean
public class ProductController {

	private String kategori;

	private Long id;
	private String nama;
	private BigDecimal harga;
	private Integer stok;
	private String deskripsi;

	private Long productId;
	private Long kategoriId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getKategori() {
		return kategori;
	}

	public void setKategori(String kategori) {
		this.kategori = kategori;
	}

	public String getNama() {
		return nama;
	}

	public void setNama(String nama) {
		this.nama = nama;
	}

	public BigDecimal getHarga() {
		return harga;
	}

	public void setHarga(BigDecimal harga) {
		this.harga = harga;
	}

	public Integer getStok() {
		return stok;
	}

	public void setStok(Integer stok) {
		this.stok = stok;
	}

	public String getDeskripsi() {
		return deskripsi;
	}

	public void setDeskripsi(String deskripsi) {
		this.deskripsi = deskripsi;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public Long getKategoriId() {
		return kategoriId;
	}

	public void setKategoriId(Long kategoriId) {
		this.kategoriId = kategoriId;
	}

	public ProductController() {
		String id = FacesContext.getCurrentInstance().getExternalContext()
				.getRequestParameterMap().get("id");
		if (id != null) {
			productId = Long.valueOf(id);
			Session session = HibernateUtil.openSession();
			Transaction trx = session.beginTransaction();
			Product product = (Product) session.get(Product.class, id);

			// kategori = product.getCategory().getName();
			nama = product.getName();
			harga = product.getPrice();
			stok = product.getStock();
			deskripsi = product.getDescription();
			trx.commit();
			session.close();
		}

	}

	public Long getproductId() {
		return productId;
	}

	public void setproductId(Long productId) {
		this.productId = productId;
	}

	public String save() {
		Session session = HibernateUtil.openSession();
		Transaction trx = session.beginTransaction();

		Category category = new Category();
		Product product = (Product) session.get(Product.class, id);
		product.setId(productId);
		product.setCategory(category);
		product.setName(nama);
		product.setPrice(harga);
		product.setStock(stok);
		product.setDescription(deskripsi);

		session.saveOrUpdate(product);

		trx.commit();
		session.close();
		return "/product/list";
	}
}
