package swex_4013;

import java.util.Scanner;

public class SWEX_4013 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		int t = 1;

		int[] score = { 1, 2, 4, 8 };

		while (t <= tc) {

			int k = sc.nextInt();

			int[][] mag = new int[4][8];
			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < 8; j++) {
					mag[i][j] = sc.nextInt();
				}
			}

			int[][] map = new int[k][2];
			for (int i = 0; i < k; i++) {
				for (int j = 0; j < 2; j++) {
					map[i][j] = sc.nextInt();
				}
			}

			// 1 : rotateRight
			// -1 : rotateLeft

			for (int i = 0; i < k; i++) {
				int[] check = new int[4];
				int now = map[i][0] - 1; // mag num
				int dir = map[i][1]; // mag dir

				check[now] = dir;
				for (int j = now; j > 0; j--) {
					if (mag[j][6] != mag[j - 1][2]) {
						check[j - 1] = check[j] * (-1);
					} else {
						break;
					}
				}

				for (int j = now + 1; j < 4; j++) {
					if (mag[j - 1][2] != mag[j][6]) {
						check[j] = check[j - 1] * (-1);
					} else {
						break;
					}
				}

				for (int j = 0; j < 4; j++) {
					if (check[j] == 1) {
						ratateRight(j, mag);
					} else if (check[j] == -1) {
						rotateLeft(j, mag);
					}

				}

			}

			int result = 0;
			for (int i = 0; i < 4; i++) {
				if (mag[i][0] == 1) {
					result += score[i];
				}
			}

			System.out.println("#" + (t++) + " " + result);

		}

	}

	static void ratateRight(int num, int[][] mag) {

		int temp = mag[num][7];
		for (int i = 6; i >= 0; i--) {
			mag[num][i + 1] = mag[num][i];
		}
		mag[num][0] = temp;
	}

	static void rotateLeft(int num, int[][] mag) {
		int temp = mag[num][0];

		for (int i = 1; i < 8; i++) {
			mag[num][i - 1] = mag[num][i];
		}

		mag[num][7] = temp;
	}

}
