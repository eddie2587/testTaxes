
package ro.reply.taxes.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ro.reply.taxes.constants.ConfigurationConstants;
import ro.reply.taxes.constants.TaxValues;
import ro.reply.taxes.model.Product;
import ro.reply.taxes.service.CalculatorService;
import ro.reply.taxes.service.RoundingPolicyService;

@Service
public class CalculatorServiceImpl implements CalculatorService {

	@Autowired
	RoundingPolicyService roundingPolicyService;

	@Override
	public double calculateProductTaxes(Product product) {
		// basic tax
		double totalTax = 0d;
		if (!product.isBasicTaxFree()) {
			totalTax = product.getQuantity() * product.getPrice() * TaxValues.BASIC_TAX.getTaxValue();
		}

		// import tax
		if (product.isImported()) {
			totalTax += (product.getQuantity() * product.getPrice() * TaxValues.IMPORT_TAX.getTaxValue());
		}

		return roundingPolicyService.round(totalTax, ConfigurationConstants.ROUND_TARGET.getValue());
	}

	public double truncateToTwoDecimals(double value) {
		return roundingPolicyService.truncate(value, (int) ConfigurationConstants.ROUNDING_SCALE.getValue());
	}

}
