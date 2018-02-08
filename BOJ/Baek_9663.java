package baek_9663;

import java.util.Scanner;

public class Baek_9663 {

	static int n;
	static boolean[][] hasQueen;
	static int ans = 0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		hasQueen = new boolean[n][n];

		oper(0);
		System.out.println(ans);
	}

	static void oper(int row) {
		if (row == n) {
			ans++;
		}
		if (row >= n) {
			return;
		}

		for (int i = 0; i < n; i++) {
			hasQueen[row][i] = true;
			if (checkQueen(row, i)) {

				oper(row + 1);

			}
			hasQueen[row][i] = false;
		}

	}

	static boolean checkQueen(int row, int col) {
		for (int i = 0; i < n; i++) {
			if (i == row)
				continue;
			if (hasQueen[i][col]) {
				return false;
			}
		}

		int tempX = row - 1;
		int tempY = col - 1;
		while (tempX >= 0 && tempY >= 0) {
			if (hasQueen[tempX][tempY]) {
				return false;
			}
			tempX--;
			tempY--;
		}

		tempX = row - 1;
		tempY = col + 1;

		while (tempX >= 0 && tempY <= n - 1) {
			if (hasQueen[tempX][tempY]) {
				return false;
			}

			tempX--;
			tempY++;
		}

		return true;
	}

}
