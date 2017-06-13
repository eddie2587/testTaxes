package ro.reply.taxes.service.impl;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;

import ro.reply.taxes.service.RoundingPolicyService;

/**
 * Contains policies for rounding
 */
@Service
public class RoundingPolicyServiceImpl implements RoundingPolicyService {

	/**
	 * Round the given value to the nearest round target
	 * 
	 * @param val
	 *            the value
	 * @param scale
	 *            the precision
	 * @return the rounded value
	 */
	public double round(final double value, double roundTarget) {
		return (int) (value / roundTarget + 0.5) * roundTarget;
	}

	public double truncate(double value, int scale) {
		return BigDecimal.valueOf(BigDecimal.valueOf(value).setScale(scale, BigDecimal.ROUND_HALF_UP).doubleValue())
				.setScale(scale, BigDecimal.ROUND_DOWN).doubleValue();
	}
}
