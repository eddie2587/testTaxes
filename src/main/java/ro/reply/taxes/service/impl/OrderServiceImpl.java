package ro.reply.taxes.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ro.reply.taxes.constants.ConfigurationConstants;
import ro.reply.taxes.exceptions.BadRequestException;
import ro.reply.taxes.model.Order;
import ro.reply.taxes.model.Product;
import ro.reply.taxes.model.Receipt;
import ro.reply.taxes.model.ReceiptEntry;
import ro.reply.taxes.service.OrderService;
import ro.reply.taxes.service.ProductService;
import ro.reply.taxes.service.ReceiptEntryService;
import ro.reply.taxes.service.ReceiptService;
import ro.reply.taxes.service.RoundingPolicyService;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private ProductService productService;

	@Autowired
	private ReceiptService receiptService;

	@Autowired
	private ReceiptEntryService receiptEntryService;

	@Autowired
	CalculatorServiceImpl calculatorServiceImpl;

	@Autowired
	RoundingPolicyService roundingPolicyService;

	@Override
	public Receipt processOrder(Order receivedOrder) throws BadRequestException {
		double salesTaxes = 0d;
		double total = 0d;
		Receipt receipt = new Receipt();

		for (Product product : receivedOrder.getProducts()) {
			if (product.getId() == null || productService.getProductById(product.getId()) == null) {
				throw new BadRequestException("The product does not exist.", "The product does not exist.");
			}
			if (product.getQuantity() != 0) {
				ReceiptEntry entry = new ReceiptEntry();

				double productTax = calculatorServiceImpl.calculateProductTaxes(product);
				double productPriceAfterTaxes = calculatorServiceImpl
						.truncateToTwoDecimals(productTax + product.getPrice());

				entry.setPriceWithTaxes(productPriceAfterTaxes);
				entry.setQuantity(product.getQuantity());
				entry.setProduct(product);
				receiptEntryService.createReceiptEntry(entry);

				total += (product.getQuantity() * productPriceAfterTaxes);
				salesTaxes += productTax;

				receipt.getEntries().add(entry);
			}
		}

		receipt.setSalesTaxes(roundingPolicyService.round(salesTaxes, ConfigurationConstants.ROUND_TARGET.getValue()));
		receipt.setTotal(roundingPolicyService.truncate(total, (int) ConfigurationConstants.ROUNDING_SCALE.getValue()));

		return receiptService.createReceipt(receipt);
	}

}
