package ro.reply.taxes.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ro.reply.taxes.dao.ReceiptEntryDAO;
import ro.reply.taxes.model.ReceiptEntry;
import ro.reply.taxes.service.ReceiptEntryService;

@Service
public class ReceiptServiceImpl implements ReceiptEntryService {

	@Autowired
	private ReceiptEntryDAO receiptEntryDAO;

	@Transactional
	@Override
	public ReceiptEntry createReceiptEntry(ReceiptEntry entry) {

		receiptEntryDAO.persist(entry);
		return entry;
	}

}
