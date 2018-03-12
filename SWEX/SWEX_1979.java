package swex_1979;

import java.util.ArrayList;
import java.util.Scanner;

public class SWEX_1979 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		int t = 1;
		while (t <= tc) {
			int n = sc.nextInt();
			int k = sc.nextInt();

			int[][] map = new int[n][n];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			// 0 : 이동 못함

			ArrayList<Integer> list = new ArrayList<Integer>();

			int result = 0;

			for (int i = 0; i < n; i++) {
				int count = 0;
				int count2 = 0;
				for (int j = 0; j < n - 1; j++) {
					if (map[i][j] == 1) {
						count++;
					}

					if (map[i][j + 1] == 0 || j + 1 == n - 1) {
						list.add(count + map[i][j + 1]);
						count = 0;
					}
				}

				for (int j = 0; j < n - 1; j++) {
					if (map[j][i] == 1) {
						count2++;
					}
					if (map[j + 1][i] == 0 || j + 1 == n - 1) {
						list.add(count2 + map[j + 1][i]);
						count2 = 0;
					}
				}

			}

			for (int j = 0; j < list.size(); j++) {
				if (list.get(j) == k) {
					result++;
				}
			}

			System.out.println("#" + (t++) + " " + result);

		}

	}

}
