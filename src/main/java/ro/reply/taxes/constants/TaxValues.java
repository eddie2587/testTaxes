package ro.reply.taxes.constants;

public enum TaxValues {

	IMPORT_TAX(0.05), BASIC_TAX(0.1);

	private double taxValue;

	private TaxValues(double value) {
		this.taxValue = value;
	}

	public double getTaxValue() {
		return this.taxValue;
	}
}
