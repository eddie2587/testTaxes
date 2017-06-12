package ro.reply.taxes.service;

import ro.reply.taxes.model.Product;

public interface CalculatorService {
	/**
	 * 
	 * @param price
	 * @param tax
	 * @param imported
	 * @return
	 */
	public double calculateProductTaxes(Product product);

}
