package ro.reply.taxes.dao;

import org.springframework.stereotype.Repository;

import ro.reply.taxes.model.Product;

@Repository
public class ProductDAO extends GenericDAO<Product> {

	public Product getProductById(long id) {
		return (Product) sessionFactory.getCurrentSession().get(Product.class, id);
	}
}
