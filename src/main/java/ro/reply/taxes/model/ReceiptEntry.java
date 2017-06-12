package ro.reply.taxes.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Configurable;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Configurable
@Table(name = "receipt_entries")
public class ReceiptEntry {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@JsonIgnore
	@Column(name = "id")
	private Long id;

	@Column(name = "priceWithTaxes", nullable = false)
	@JsonProperty
	private double priceWithTaxes;

	@JsonProperty
	@Column(name = "quantity", nullable = false)
	private int quantity;

	@JsonProperty(value = "product")
	@ManyToOne
	@JoinColumn(name = "product", nullable = false)
	private Product product;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public double getPriceWithTaxes() {
		return priceWithTaxes;
	}

	public void setPriceWithTaxes(double priceWithTaxes) {
		this.priceWithTaxes = priceWithTaxes;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product products) {
		this.product = products;
	}
}
