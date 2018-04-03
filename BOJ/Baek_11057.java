package baek_11057;

import java.util.Scanner;

public class Baek_11057 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		int[][] d = new int[n + 1][10];
		for (int i = 0; i <= 9; i++) {
			d[1][i] = 1;
		}

		for (int i = 2; i <= n; i++) {
			for (int j = 0; j <= 9; j++) {
				for (int k = 0; k <= j; k++) {
					d[i][j] += d[i - 1][k];
				}

				d[i][j] %= 10007;
			}
		}

		int result = 0;

		for (int i = 0; i <= 9; i++) {
			result += d[n][i];
		}

		System.out.println(result % 10007);

	}

}
