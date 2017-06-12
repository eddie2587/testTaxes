package ro.reply.taxes.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import ro.reply.taxes.model.Receipt;

@Repository
public class ReceiptDAO extends GenericDAO<Receipt> {

	public List<Receipt> getAllReceipts() {
		return sessionFactory.getCurrentSession().createQuery("from Receipt").list();
	}
}
