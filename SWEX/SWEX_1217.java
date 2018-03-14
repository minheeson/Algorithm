package swex_1217;

import java.util.Scanner;

public class SWEX_1217 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int tc = 10;
		int t = 1;

		while (t <= tc) {
			t++;
			int tcase = sc.nextInt();
			int n = sc.nextInt();
			int m = sc.nextInt();

			System.out.println("#" + tcase + " " + mul(n, m, 1));
		}
	}

	static int mul(int n, int m, int result) {

		if (m == 0) {
			return result;
		} else {
			return mul(n, m - 1, result * n);

		}
	}

}
