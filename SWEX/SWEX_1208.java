package swex_1208;

import java.util.Scanner;

public class SWEX_1208 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int tc = 10;
		int t = 1;
		while (t <= tc) {
			int count = sc.nextInt();
			int min = 100;
			int max = 0;

			int[] map = new int[100];
			for (int i = 0; i < 100; i++) {
				map[i] = sc.nextInt();
			}

			while (count-- > 0) {
				int minIndex = 0;
				int maxIndex = 0;
				
				for (int i = 0; i < 100; i++) {
					if (min > map[i]) {
						min = map[i];
						minIndex = i;
					}
					if (max < map[i]) {
						max = map[i];
						maxIndex = i;
					}
				}

				map[maxIndex]--;
				map[minIndex]++;
				min = 100;
				max = 0;

			}

			for (int i = 0; i < 100; i++) {
				if (min > map[i]) {
					min = map[i];
				}
				if (max < map[i]) {
					max = map[i];
				}
			}

			System.out.println("#" + (t++) + " " + (max - min));

		}
	}

}
