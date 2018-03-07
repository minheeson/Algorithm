package swex_1288;

import java.util.Scanner;

public class SWEX_1288 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int c = sc.nextInt();
		int t = 1;
		while (t <= c) {
			int n = sc.nextInt();
			long temp = n;
			boolean[] check = new boolean[10];
			int count = 0;
			int result = 0;
			int mul = 1;

			while (count != 10) {
				int m = (int) (temp % 10);
				if (!check[m]) {
					check[m] = true;
					count++;
				}
				temp /= 10;
				if (count == 10) {
					break;
				}
				if (temp == 0) {
					mul++;
					temp = n * mul;
					result = n * mul;
				}

			}

			System.out.println("#" + (t++) + " " + result);

		}
	}

}
