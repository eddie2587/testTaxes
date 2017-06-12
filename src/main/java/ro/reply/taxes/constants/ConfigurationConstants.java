package ro.reply.taxes.constants;

public enum ConfigurationConstants {

	ROUNDING_SCALE(2), ROUND_TARGET(0.05);

	private double value;

	private ConfigurationConstants(double value) {
		this.value = value;
	}

	public double getValue() {
		return this.value;
	}
}
