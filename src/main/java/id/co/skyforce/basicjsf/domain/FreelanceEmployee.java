package id.co.skyforce.basicjsf.domain;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("F")
public class FreelanceEmployee extends Employee {

	@Column(name = "rateperhour")
	private BigDecimal rateperhour;

	public void setRateperhour(BigDecimal rateperhour) {
		this.rateperhour = rateperhour;
	}

	public BigDecimal getRateperhour() {
		return rateperhour;
	}

}
