package com.bruin.util;

import java.math.BigDecimal;
import java.util.Objects;

public class DoubleUtil {

	public static double multiplication(Double d1, Double d2) {
		return multiplication(d1, d2, 2);
	}

	/**
	 *
	 * @param d1 ��һ������
	 * @param d2 �ڶ�������
	 * @param num С���㱣��λ��
	 * @return ����һ��double���͵�ֵ
	 */
	public static double multiplication(Double d1, Double d2, int num) {
		if (Objects.isNull(d1) && Objects.isNull(d2)) {
			throw new NullPointerException("�������Ϊ��!");
		}
		return new BigDecimal(d1.toString()).multiply(new BigDecimal(d2.toString()))
				.setScale(num, BigDecimal.ROUND_HALF_UP).doubleValue();
	}


	public static double divide(Double dividend, Double divisor) {
		return divide(dividend, divisor, 2);
	}

	/**
	 * double ���
	 * 
	 * @param dividend ������
	 * @param divisor ����
	 * @param num С������汣��λ��
	 * @return double ���͵�ֵ
	 */
	public static double divide(Double dividend, Double divisor, int num) {
		if (Objects.isNull(divisor) && Objects.isNull(dividend)) {
			throw new NullPointerException("�����򱻳���Ϊnull");
		}
		return new BigDecimal(dividend.toString()).divide(new BigDecimal(divisor.toString()), BigDecimal.ROUND_HALF_UP)
				.setScale(num, BigDecimal.ROUND_HALF_UP).doubleValue();
	}

}
