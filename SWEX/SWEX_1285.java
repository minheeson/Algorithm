package swex_1285;

import java.util.Scanner;

public class SWEX_1285 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int c = sc.nextInt();
		int t = 1;

		while (t <= c) {
			int person = 0;
			int min = 100000;

			int size = sc.nextInt();
			for (int i = 0; i < size; i++) {
				int temp = sc.nextInt();
				if (temp < 0) {
					temp *= (-1);
				}

				if (temp < min) {
					min = temp;
					person = 1;
				} else if (temp == min) {
					person++;
				}
			}
			
			System.out.println("#" + (t++) + " " + min + " " + person);
		}

	}

}
