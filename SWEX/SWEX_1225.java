package swex_1225;

import java.util.Scanner;

public class SWEX_1225 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int t = 1;
		while (t++ <= 10) {
			int tcase = sc.nextInt();
			int[] map = new int[8];

			for (int i = 0; i < 8; i++) {
				map[i] = sc.nextInt();
			}
			boolean go = true;
			while (go) {
				for (int i = 1; i <= 5; i++) {
					map[0] -= i;
					if (map[0] <= 0) {
						map[0] = 0;
					}
					rotate(map);
					if (map[7] == 0) {
						go = false;
						break;
					}

				}
			}
			System.out.print("#" + tcase + " ");
			for (int i = 0; i < 8; i++) {
				System.out.print(map[i] + " ");
			}
			System.out.println();
		}

	}

	static void rotate(int[] map) {
		int temp = map[0];
		for (int i = 1; i < map.length; i++) {
			map[i - 1] = map[i];
		}
		map[map.length - 1] = temp;
	}

}
