package ro.reply.taxes.service;

import java.util.List;

import ro.reply.taxes.model.Receipt;

public interface ReceiptService {

	public Receipt createReceipt(Receipt receipt);

	public List<Receipt> getAllReceipts();

}
