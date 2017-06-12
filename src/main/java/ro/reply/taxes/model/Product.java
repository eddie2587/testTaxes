package ro.reply.taxes.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.beans.factory.annotation.Configurable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Configurable
@Table(name = "products")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", unique = true, nullable = false)
	private Long id;

	@Column(name = "name", nullable = false, length = 255, unique = true)
	@JsonProperty
	private String name;

	@Column(name = "price", nullable = false)
	@JsonProperty
	private double price;

	@Column(name = "isImported", nullable = false)
	@JsonProperty(value = "isImported")
	private boolean isImported = false;

	@Column(name = "isBasicTaxFree", nullable = false)
	@JsonProperty(value = "isBasicTaxFree")
	private boolean isBasicTaxFree = false;

	@JsonInclude()
	@Transient
	private int quantity;

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public boolean isImported() {
		return isImported;
	}

	public void setImported(boolean isImported) {
		this.isImported = isImported;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public boolean isBasicTaxFree() {
		return isBasicTaxFree;
	}

	public void setBasicTaxFree(boolean isBasicTaxFree) {
		this.isBasicTaxFree = isBasicTaxFree;
	}

}
