package swex_1948;

import java.util.Scanner;

public class SWEX_1948 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] last = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		Scanner sc = new Scanner(System.in);
		int c = sc.nextInt();
		int t = 1;
		while (t <= c) {
			int firstM = sc.nextInt();
			int firstL = sc.nextInt();
			int secondM = sc.nextInt();
			int secondL = sc.nextInt();
			int result = 0;

			if (firstM == secondM) {
				result = secondL - firstL + 1;
			} else {
				result += last[firstM] - firstL + 1;

				for (int i = firstM + 1; i <= secondM - 1; i++) {
					result += last[i];
				}

				result += secondL;
			}

			System.out.println("#" + (t++) + " " + result);

		}
	}

}
