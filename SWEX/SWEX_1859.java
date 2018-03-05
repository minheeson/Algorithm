package swex_1859;

import java.util.Scanner;

public class SWEX_1859 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int c = sc.nextInt();
		int t = 1;
		while (t <= c) {
			int n = sc.nextInt();
			int[] price = new int[n];
			for (int i = 0; i < n; i++) {
				price[i] = sc.nextInt();
			}

			System.out.println("#" + (t++) + " " + profit(n, price));
		}
	}

	static long profit(int n, int[] price) {
		int max = price[n - 1];
		long profit = 0;


		for (int i = n - 2; i >= 0; i--) {
			if (price[i] > max) {
				max = price[i];
			} else {
				profit -= price[i];
				profit += max;
			}

		}
		return profit;
	}

}
