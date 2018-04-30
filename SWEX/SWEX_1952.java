package swex_1500;

import java.util.Scanner;

public class SWEX_1952 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		int t = 1;
		while (t <= tc) {
			int day = sc.nextInt();
			int month = sc.nextInt();
			int month3 = sc.nextInt();
			int year = sc.nextInt();

			int[] pool = new int[12];
			for (int i = 0; i < 12; i++) {
				pool[i] = sc.nextInt();
			}

			int d = 0, m = 0, m3 = 0, y = 0;

			int[] money = new int[12];
			for (int i = 0; i < 12; i++) {
				if (pool[i] > 0) {
					if (pool[i] > month / day) { // 달로 구매
						money[i] += month;
					} else { // 일로 구매
						money[i] += pool[i] * day;
					}
				}
			}

			int temp = 0;
			int count = 0;
			for (int i = 0; i < 10; i++) {
				if (money[i] + money[i + 1] + money[i + 2] > month3) {
					money[i] = month3;
					money[i + 1] = 0;
					money[i + 2] = 0;
				}

			}

			int result = 0;
			for (int i = 0; i < 12; i++) {
				result += money[i];
			}

			if (result > year) {
				result = year;
			}

			System.out.println(result);
			t++;

		}

	}

}
