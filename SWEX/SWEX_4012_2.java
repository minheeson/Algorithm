package swex_4012;

import java.util.Scanner;

public class SWEX_4012_2 {

	static boolean[] check;
	static int[][] map;
	static int ans;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		int t = 1;

		while (t <= tc) {

			int n = sc.nextInt();
			map = new int[n][n];

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					map[i][j] = sc.nextInt();
				}
			}

			check = new boolean[n];
			ans = Integer.MAX_VALUE;

			recursion(n, 0, n / 2);
			System.out.println("#" + (t++) + " " + ans);

		}
	}

	static void recursion(int n, int cnt, int food) {

		if (n == cnt) { // finish
			int sA = 0, sB = 0;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (i == j)
						continue;
					if (check[i] && check[j])
						sA += map[i][j];
					if (!check[i] && !check[j])
						sB += map[i][j];
				}

			}

			int temp = sA - sB;
			if (temp < 0)
				temp *= (-1);

			ans = Math.min(ans, temp);
			return;
		}

		if (food > 0) {
			check[cnt] = true;
			recursion(n, cnt + 1, food - 1);
			check[cnt] = false;
		}
		recursion(n, cnt + 1, food);
	}

}
