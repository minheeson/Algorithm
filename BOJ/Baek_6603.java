package baek_6603;

import java.util.Scanner;

public class Baek_6603 {

	static int[] lotto;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);

		while (true) {
			int k = sc.nextInt();
			if (k == 0) {
				break;
			}
			int[] order = new int[k];

			for (int i = 0; i < 6; i++) {
				order[i] = 1;
			}
			for (int i = 6; i < k; i++) {
				order[i] = 0;
			}

			lotto = new int[k];
			for (int i = 0; i < k; i++) {
				lotto[i] = sc.nextInt();
			}

			oper(order);
		}

	}

	static void oper(int[] order) {

		do {
			for (int i = 0; i < order.length; i++) {
				if (order[i] == 1) {
					System.out.print(lotto[i] + " ");
				}
			}
			System.out.println();
			order = nextPermutation(order);
		} while (check(order));

		for (int i = 5; i >= 0; i--) {
			System.out.print(lotto[lotto.length - 1 - i] + " ");
		}
		System.out.println();
		System.out.println();

	}

	static boolean check(int[] order) {
		int len = order.length;
		for (int i = len - 1; i >= len - 6; i--) {
			if (order[i] == 0) {
				return true;
			}
		}
		return false;
	}

	static int[] nextPermutation(int[] order) {
		int len = order.length;
		int big = 0;
		int next = 0;

		for (int i = len - 1; i > 0; i--) {
			if (order[i - 1] > order[i]) {
				big = i;
				break;
			}
		}
		int[] tmp = new int[len - big];
		for (int i = 0; i < tmp.length; i++) {
			tmp[i] = order[len - 1 - i];
		}

		for (int i = 0; i < tmp.length; i++) {
			order[big + i] = tmp[i];
		}

		for (int i = big; i < len; i++) {
			if (order[big - 1] > order[i]) {
				next = i;
				break;
			}
		}

		int temp = order[next];
		order[next] = order[big - 1];
		order[big - 1] = temp;

		return order;
	}

}
