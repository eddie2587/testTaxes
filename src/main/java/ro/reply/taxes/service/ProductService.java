package ro.reply.taxes.service;

import ro.reply.taxes.model.Product;

public interface ProductService {

	public Product createProduct(Product receivedProduct);

	public Product updateProduct(Product receivedProduct);

	public Product getProductById(long id);

}
