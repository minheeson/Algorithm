package swex_2005;

import java.util.Scanner;

public class SWEX_2005 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		int t = 1;

		while (t <= tc) {
			int n = sc.nextInt();
			int[][] map = new int[n][n];

			for (int i = 0; i < n; i++) {
				for (int j = 0; j <= i; j++) {
					if (j == 0 || j == i) {
						map[i][j] = 1;
					} else {
						map[i][j] = map[i - 1][j - 1] + map[i - 1][j];
					}
				}
			}

			System.out.println("#" + (t++));
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (map[i][j] != 0) {
						System.out.print(map[i][j] + " ");
					}

				}
				System.out.println();
			}

		}
	}

}
