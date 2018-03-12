package swex_1983;

import java.util.Scanner;

public class SWEX_1983 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		int t = 1;
		String[] scores = { "A+", "A0", "A-", "B+", "B0", "B-", "C+", "C0", "C-", "D0" };

		while (t <= tc) {
			int n = sc.nextInt();
			int k = sc.nextInt();

			int[] mid = new int[n];
			int[] fin = new int[n];
			int[] hw = new int[n];

			for (int i = 0; i < n; i++) {
				mid[i] = sc.nextInt();
				fin[i] = sc.nextInt();
				hw[i] = sc.nextInt();
			}

			double[] score = new double[n];
			for (int i = 0; i < n; i++) {
				score[i] = mid[i] * 0.35 + fin[i] * 0.45 + hw[i] * 0.2;
			}

			double student = score[k - 1];
			int count = 1;

			for (int i = 0; i < n; i++) {
				if (student < score[i]) {
					count++;
				}
			}

			String result = scores[count / (n / 10)];
			if (count % (n / 10) == 0) {
				result = scores[(count / (n / 10)) - 1];
			}
			System.out.println("#" + (t++) + " " + result);

		}

	}

}
