package swex_1959;

import java.util.Scanner;

public class SWEX_1959 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int c = sc.nextInt();
		int t = 1;

		while (t <= c) {
			int f = sc.nextInt();
			int s = sc.nextInt();
			int[] fir = new int[f];
			int[] sec = new int[s];
			for (int i = 0; i < f; i++) {
				fir[i] = sc.nextInt();
			}
			for (int i = 0; i < s; i++) {
				sec[i] = sc.nextInt();
			}
			int[] small;
			int[] big;

			if (f < s) {
				small = fir;
				big = sec;
			} else {
				small = sec;
				big = fir;
			}

			int num = big.length - small.length + 1;
			int result = Integer.MIN_VALUE;
			for (int i = 0; i < num; i++) {
				int temp = 0;
				for (int j = 0; j < small.length; j++) {
					temp += small[j] * big[i + j];
				}

				if (temp > result) {
					result = temp;
				}
			}

			System.out.println("#" + (t++) + " " + result);
		}
	}

}
