package baek_2193;

import java.util.Scanner;

public class Baek_2193 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		long[][] d = new long[n + 1][2];
		d[1][0] = 0;
		d[1][1] = 1;

		for (int i = 2; i <= n; i++) {
			d[i][0] = d[i - 1][0] + d[i - 1][1];
			d[i][1] = d[i - 1][0];
		}

		long result = d[n][0] + d[n][1];
		
		System.out.println(result);

	}

}
