package id.co.skyforce.basicjsf.domain;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("T")
public class PartTimeEmployee extends Employee {

	@Column(name = "workhour")
	private int workhour;

	public int getWorkhour() {
		return workhour;
	}

	public void setWorkhour(int workhour) {
		this.workhour = workhour;
	}

}
