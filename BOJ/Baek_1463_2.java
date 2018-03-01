package baek_1463;

import java.util.Scanner;

public class Baek_1463_2 {

	static int[] d;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		d = new int[n + 1];

		System.out.println(go(n));
	}

	static int go(int n) {
		if (n == 1)
			return 0;
		if (d[n] > 0)
			return d[n];

		d[n] = go(n - 1) + 1;
		if (n % 2 == 0) {
			d[n] = Math.min(go(n / 2) + 1, d[n]);
		}
		if (n % 3 == 0) {
			d[n] = Math.min(go(n / 3) + 1, d[n]);
		}
		return d[n];

	}

}
