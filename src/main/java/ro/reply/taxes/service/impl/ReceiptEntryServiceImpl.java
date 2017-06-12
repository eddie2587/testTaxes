package ro.reply.taxes.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ro.reply.taxes.dao.ReceiptDAO;
import ro.reply.taxes.model.Receipt;
import ro.reply.taxes.service.ReceiptService;

@Service
public class ReceiptEntryServiceImpl implements ReceiptService {

	@Autowired
	private ReceiptDAO receiptDAO;

	@Transactional
	@Override
	public Receipt createReceipt(Receipt receipt) {
		receiptDAO.persist(receipt);
		return receipt;
	}

	@Override
	@Transactional
	public List<Receipt> getAllReceipts() {
		return receiptDAO.getAllReceipts();
	}

}
