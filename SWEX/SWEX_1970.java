package swex_1970;

import java.util.Scanner;

public class SWEX_1970 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int c = sc.nextInt();
		int t = 1;
		while (t <= c) {
			int n = sc.nextInt();
			int result = 0;
			int m1 = 0;
			int m2 = 0;
			int m3 = 0;
			int m4 = 0;
			int m5 = 0;
			int m6 = 0;
			int m7 = 0;
			int m8 = 0;

			if (n / 50000 >= 1) {
				m1 = n / 50000;
				n = n - (m1 * 50000);
			}
			if (n / 10000 >= 1) {
				m2 = n / 10000;
				n = n - (m2 * 10000);
			}
			if (n / 5000 >= 1) {
				m3 = n / 5000;
				n = n - (m3 * 5000);
			}
			if (n / 1000 >= 1) {
				m4 = n / 1000;
				n = n - (m4 * 1000);
			}

			if (n / 500 >= 1) {
				m5 = n / 500;
				n = n - (m5 * 500);
			}
			if (n / 100 >= 1) {
				m6 = n / 100;
				n = n - (m6 * 100);
			}
			if (n / 50 >= 1) {
				m7 = n / 50;
				n = n - (m7 * 50);
			}
			if (n / 10 >= 1) {
				m8 = n / 10;
				n = n - (m8 * 10);
			}
			System.out.println("#" + (t++));
			System.out.println(m1 + " " + m2 + " " + m3 + " " + m4 + " " + m5 + " " + m6 + " " + m7 + " " + m8);

		}
	}

}
