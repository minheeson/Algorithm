package swex_1209;

import java.util.Scanner;

public class SWEX_1209 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int tc = 10;
		int t = 1;

		while (t <= tc) {
			t++;
			int tcase = sc.nextInt();
			int[][] map = new int[100][100];

			for (int i = 0; i < 100; i++) {
				for (int j = 0; j < 100; j++) {
					map[i][j] = sc.nextInt();
				}
			}

			int[] sum = new int[202];
			int index = 0;
			int dig1 = 0;
			int dig2 = 0;

			for (int i = 0; i < 100; i++) {
				int row = 0;
				int col = 0;
				dig1 += map[i][i];
				dig2 += map[i][99 - i];
				for (int j = 0; j < 100; j++) {
					row += map[i][j];
					col += map[j][i];
				}
				sum[index++] = row;
				sum[index++] = col;
			}
			
			
			sum[index++] = dig1;
			sum[index] = dig2;

			int result = Integer.MIN_VALUE;
			for (int i = 0; i < 202; i++) {
				if (result < sum[i]) {
					result = sum[i];
				}
			}

			System.out.println("#" + tcase + " " + result);

		}
	}

}
