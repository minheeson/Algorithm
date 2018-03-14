package swex_1215;

import java.util.Scanner;

public class SWEX_1215 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int tc = 10;
		int t = 1;

		while (t <= tc) {
			int len = sc.nextInt();
			char[][] map = new char[8][8];

			for (int i = 0; i < 8; i++) {
				String str = sc.next();
				for (int j = 0; j < 8; j++) {
					map[i][j] = str.charAt(j);
				}
			}

			int result = 0;
			for (int i = 0; i < 8; i++) {
				for (int j = 0; j < 8 - len + 1; j++) {
					int check = 0;
					for (int k = 0; k < len / 2; k++) {
						if (map[i][j + k] != map[i][j + len - (k + 1)]) {
							break;
						} else {
							check++;
						}
						if (check == len / 2) {
							result++;
						}
					}
				}

			}

			for (int i = 0; i < 8; i++) {
				for (int j = 0; j < 8 - len + 1; j++) {
					int check = 0;
					for (int k = 0; k < len / 2; k++) {
						if (map[j + k][i] != map[j + len - (k + 1)][i]) {
							break;
						} else {
							check++;
						}
						if (check == len / 2) {
							result++;
						}
					}
				}

			}

			System.out.println("#" + (t++) + " " + result);

		}
	}

}
