package swex_1500;

import java.util.Scanner;

public class SWEX_1952_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		int t = 1;

		while (t <= tc) {
			int[] fare = new int[4];
			for (int i = 0; i < 4; i++) {
				fare[i] = sc.nextInt();
			}

			int[] use = new int[13];
			for (int i = 1; i < 13; i++) {
				use[i] = sc.nextInt();
			}

			for (int i = 1; i <= 12; i++) {
				int day = use[i - 1] + use[i] * fare[0];
				int month = use[i - 1] + fare[1];
				int post3 = use[i - 1] + fare[2];
				int pre3 = 0;
				if (i > 2) {
					pre3 = use[i - 3] + fare[2];
				} else {
					pre3 = fare[2];
				}

				int year = fare[3];

				use[i] = Math.min(day, Math.min(month, Math.min(pre3, Math.min(post3, year))));
			}

			System.out.println("#" + (t++) + " " + use[12]);

		}
	}

}
