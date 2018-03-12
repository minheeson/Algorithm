package swex_1974;

import java.util.Scanner;

public class SWEX_1974 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		int t = 1;

		while (t <= tc) {
			int[][] map = new int[9][9];

			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					map[i][j] = sc.nextInt();
				}
			}

			int result = 1;

			boolean[][] row = new boolean[9][9];
			boolean[][] col = new boolean[9][9];
			boolean[][] sub = new boolean[9][9];

			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					row[i][map[i][j] - 1] = true;
					col[i][map[j][i] - 1] = true;
					sub[(i / 3) * 3 + (j / 3)][map[i][j] - 1] = true;
				}
			}

			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					if (!row[i][j] || !col[i][j] || !sub[i][j]) {
						result = 0;
					}
				}
			}

			System.out.println("#" + (t++) + " " + result);

		}
	}

}
