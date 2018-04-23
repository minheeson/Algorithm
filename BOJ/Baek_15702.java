package baek_15000;

import java.util.Scanner;

public class Baek_15702 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] score = new int[n];

		int m = sc.nextInt();
		int[][] info = new int[m][2];

		for (int i = 0; i < n; i++) {
			score[i] = sc.nextInt();
		}

		for (int i = 0; i < m; i++) {
			info[i][0] = sc.nextInt();
			int count = 0;
			for (int j = 0; j < n; j++) {
				String tmp = sc.next();
				if (tmp.equals("O")) {
					count += score[j];

				}
			}
			info[i][1] = count;

		}

		int maxI = 0;
		int maxS = info[0][1];
		for (int i = 1; i < m; i++) {
			if (maxS < info[i][1]) {
				maxS = info[i][1];
				maxI = i;
			} else if (maxS == info[i][1]) {
				if (info[maxI][0] > info[i][0]) {
					maxI = i;

				}
			}
		}

		System.out.println(info[maxI][0] + " " + maxS);

	}

}
