package ro.reply.taxes.service;

import org.springframework.stereotype.Service;

/**
 * Contains policies for rounding
 */
@Service
public interface RoundingPolicyService {

	/**
	 * Round the given value to the nearest round target
	 * 
	 * @param val
	 *            the value
	 * @param scale
	 *            the precision
	 * @return the rounded value
	 */
	public double round(final double value, double roundTarget);

	public double truncate(double value, int scale);
}
