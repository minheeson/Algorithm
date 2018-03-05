package swex_1284;

import java.util.Scanner;

public class SWEX_1284 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int c = sc.nextInt();
		int t = 1;

		while (t <= c) {
			int p = sc.nextInt(); // a사 : 1리터당 p원
			int q = sc.nextInt();
			int r = sc.nextInt();
			int s = sc.nextInt();
			int w = sc.nextInt();

			int a = w * p;
			int b = 0;
			if (w <= r) {
				b = q;
			} else {
				b = q + (w - r) * s;
			}

			int result = Math.min(a, b);

			System.out.println("#" + (t++) + " " + result);

		}
	}

}
