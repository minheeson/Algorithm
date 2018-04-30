package swex_1000;

import java.util.Scanner;

public class SWEX_1204 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int t = 1;
		while (t++ <= 10) {

			int tc = sc.nextInt();
			int[] map = new int[101];
			for (int i = 0; i < 1000; i++) {
				int s = sc.nextInt();
				map[s]++;
			}

			int most = 0;
			int result = 0;
			for (int i = 0; i < 101; i++) {
				if (most <= map[i]) {
					most = map[i];
					result = i;
				}
			}

			System.out.println("#" + tc + " " + result);
		}
	}

}
