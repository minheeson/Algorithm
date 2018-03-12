package swex_2001;

import java.util.Scanner;

public class SWEX_2001 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		int t = 1;

		while (t <= tc) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			int[][] map = new int[n][n];

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					map[i][j] = sc.nextInt();
				}
			}

			int result = Integer.MIN_VALUE;

			for (int i = 0; i < n - (m - 1); i++) {
				for (int j = 0; j < n - (m - 1); j++) {
					int temp = 0;

					for (int k = i; k < i + m; k++) {
						for (int l = j; l < j + m; l++) {
							temp += map[k][l];
						}
					}

					if (result < temp) {
						result = temp;
					}
				}
			}

			System.out.println("#" + (t++) + " " + result);

		}
	}

}
