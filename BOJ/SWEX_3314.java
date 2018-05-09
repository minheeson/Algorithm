package swex_3000;

import java.util.Scanner;

public class SWEX_3314 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		int t = 1;

		while (t <= tc) {

			int[] map = new int[5];
			int sum = 0;
			for (int i = 0; i < 5; i++) {
				map[i] = sc.nextInt();
				if (map[i] < 40) {
					map[i] = 40;
				}
				sum += map[i];
			}

			System.out.println("#" + (t++) + " " + sum / 5);

		}
	}

}
