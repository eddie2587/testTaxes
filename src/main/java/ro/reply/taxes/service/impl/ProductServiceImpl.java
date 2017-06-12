package ro.reply.taxes.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ro.reply.taxes.dao.ProductDAO;
import ro.reply.taxes.model.Product;
import ro.reply.taxes.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDAO productDAO;

	@Transactional
	@Override
	public Product createProduct(Product receivedProduct) {
		productDAO.persist(receivedProduct);
		return receivedProduct;
	}

	@Transactional
	@Override
	public Product updateProduct(Product receivedProduct) {
		productDAO.update(receivedProduct);
		return receivedProduct;
	}

	@Transactional
	@Override
	public Product getProductById(long id) {
		return productDAO.getProductById(id);
	}

}
