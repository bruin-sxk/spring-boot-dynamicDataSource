package com.sxk.leetcode.sort;

import java.util.Arrays;

public class QuickSort {

	public static void main(String[] args) {
		int count = 0;
		int[] ints = new int[100];
		for (int i = 100; i > 0; i--) {
			ints[count++] = i + 1;
		}

		quickSort(ints, 0, ints.length - 1);

		System.out.println(Arrays.toString(ints));
	}

	private static void quickSort(int[] ints, int low, int hight) {
		if (low < hight) {
			// ���һ�׼������ȷ����
			int index = getIndex(ints, low, hight);

			quickSort(ints, low, index - 1);
			quickSort(ints, index + 1, hight);
		}
	}


	private static int getIndex(int[] ints, int low, int hight) {
		// ��׼����
		int temp = ints[low];
		while (low < hight) {
			// �Ӷ�β��ʼ������ֱ���ҵ���һ���Ȼ�׼ֵС�������� low ���ڸ�λ�õ�ֵ
			// Ҳ�������Ϊ��������λ�õ�����
			while (low < hight && temp < ints[hight])
				hight--;
			ints[low] = ints[hight];
			// �ڴӶ�ͷ��ʼ���� �����ͻ�׼ֵ���бȽ� ֱ���ҵ���һ���Ȼ�׼ֵ���
			// hight ���� ��λ�õ�ֵ(Ҳ�����Ϊ��������λ�õ�����)
			while (low < hight && temp > ints[low])
				low++;
			ints[hight] = ints[low];
		}
		// ����ѭ��Ҳ����ζ�� ��һ�ε����н��� ����֮�� ��׼ֵ���ȫ�����ǱȻ�׼ֵС��,�ұߵ�ȫ�����ǱȻ�׼ֵ���
		ints[low] = temp;
		return low;
	}

}
