package baek_2580;

import java.util.Scanner;

public class Baek_2580 {

	static int[][] map = new int[9][9];
	static boolean[][] row = new boolean[9][10];
	static boolean[][] col = new boolean[9][10];
	static boolean[][] sub = new boolean[9][10];

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				map[i][j] = sc.nextInt();
			}
		}

		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (map[i][j] != 0) {
					row[i][map[i][j]] = true;
					col[j][map[i][j]] = true;
					sub[(i / 3) * 3 + (j / 3)][map[i][j]] = true;
				}
			}
		}

		sudoku(0);

	}

	static void sudoku(int a) {
		if (a == 81) {
			print();
			return;
		}
		int x = a / 9;
		int y = a % 9;

		if (map[x][y] != 0) {
			sudoku(a + 1);
		} else {
			for (int i = 1; i < 10; i++) {
				if (!row[x][i] && !col[y][i] && !sub[(x / 3) * 3 + (y / 3)][i]) {
					row[x][i] = true;
					col[y][i] = true;
					sub[(x / 3) * 3 + (y / 3)][i] = true;
					map[x][y] = i;
					sudoku(a + 1);
					map[x][y] = 0;
					row[x][i] = false;
					col[y][i] = false;
					sub[(x / 3) * 3 + (y / 3)][i] = false;
				}
			}
		}

	}

	static void print() {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}

}
