package swex_1945;

import java.util.Scanner;

public class SWEX_1945 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		int p = 1;

		while (p <= t) {
			int n = sc.nextInt();
			int a = 0, b = 0, c = 0, d = 0, e = 0;
			while (n % 11 == 0) {
				n = n / 11;
				e++;
			}

			while (n % 7 == 0) {
				n = n / 7;
				d++;
			}

			while (n % 5 == 0) {
				n = n / 5;
				c++;
			}

			while (n % 3 == 0) {
				n = n / 3;
				b++;
			}

			while (n % 2 == 0) {
				n = n / 2;
				a++;
			}
			System.out.println("#" + (p++) + " " + a + " " + b + " " + c + " " + d + " " + e);
		}

	}

}
