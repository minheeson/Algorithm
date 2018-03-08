package swex_1954;

import java.util.Scanner;

public class SWEX_1954 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int c = sc.nextInt();
		int t = 1;
		while (t <= c) {

			int n = sc.nextInt();
			int[][] arr = new int[n][n];
			int count = 1;
			for (int i = 0; i < (n + 1) / 2; i++) {
				int num = (n - i) * 4 - 4;

				for (int k = i; k < num / 4; k++) {
					arr[i][k] = count++;
				}

				for (int k = i; k < num / 4; k++) {
					arr[k][n - i - 1] = count++;
				}

				for (int k = i; k < num / 4; k++) {
					arr[n - i - 1][n - 1 - k] = count++;
				}

				for (int k = i; k < num / 4; k++) {
					arr[n - 1 - k][i] = count++;
				}

			}

			if (n % 2 == 1) {
				arr[n / 2][n / 2] = count;
			}

			System.out.println("#" + (t++));
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					System.out.print(arr[i][j] + " ");
				}
				System.out.println();
			}
		}
	}

}
