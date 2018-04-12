package swex_4172;

import java.util.Scanner;

public class SWEX_4172 {

	static int money;
	static boolean[] checked;
	static int n;
	static int[][] map;

	static int ans;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		int t = 1;

		while (t <= tc) {
			money = sc.nextInt();
			n = sc.nextInt();
			checked = new boolean[n];
			ans = 0;

			map = new int[n][2];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < 2; j++) {
					map[i][j] = sc.nextInt();
				}
			}

			recursion(0, 0, 0);

			System.out.println("#" + (t++) + " " + ans);

		}

	}

	static void recursion(int index, int price, int happy) {

		if (price > money) {
			return;
		}

		if (index == n) {
			if (happy > ans) {
				ans = happy;
			}
			return;
		}

		recursion(index + 1, price + map[index][0], happy + map[index][1]);
		recursion(index + 1, price, happy);

	}

}
