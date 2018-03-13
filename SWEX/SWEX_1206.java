package swex_1206;

import java.util.Scanner;

public class SWEX_1206 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int t = 1;

		while (t <= 10) {
			int n = sc.nextInt();
			int[] map = new int[n];

			for (int i = 0; i < n; i++) {
				map[i] = sc.nextInt();
			}

			int result = 0;
			for (int i = 2; i < n - 2; i++) {
				int small = Math.max(map[i - 2], map[i - 1]);
				int big = Math.max(map[i + 1], map[i + 2]);

				int view = 0;
				if (map[i] - Math.max(small, big) > 0) {
					view = map[i] - Math.max(small, big);
				}
				result += view;

			}

			System.out.println("#" + (t++) + " " + result);

		}
	}

}
