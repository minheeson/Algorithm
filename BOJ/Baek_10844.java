package baek_10844;

import java.util.Scanner;

public class Baek_10844 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] map = new int[n + 1][10];

		for (int i = 1; i <= 9; i++) {
			map[1][i] = 1;
		}

		for (int i = 2; i <= n; i++) {
			for (int j = 0; j <= 9; j++) {
				if (j >= 1) {
					map[i][j] += map[i - 1][j - 1];
				}

				if (8 >= j) {
					map[i][j] += map[i - 1][j + 1];
				}

				map[i][j] %= 1000000000;
			}
		}

		long ans = 0;
		for (int i = 0; i <= 9; i++) {
			ans += map[n][i];
		}

		System.out.println(ans % 1000000000);
	}

}
