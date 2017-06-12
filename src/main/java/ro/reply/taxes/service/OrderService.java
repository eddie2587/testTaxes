package ro.reply.taxes.service;

import ro.reply.taxes.exceptions.BadRequestException;
import ro.reply.taxes.model.Order;
import ro.reply.taxes.model.Receipt;

public interface OrderService {

	/**
	 * 
	 * @param receivedOrder
	 * @return
	 * @throws BadRequestException
	 */
	public Receipt processOrder(Order receivedOrder) throws BadRequestException;

}
