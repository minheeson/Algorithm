package swex_1986;

import java.util.Scanner;

public class SWEX_1986 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		int t = 1;
		while (t <= tc) {

			int n = sc.nextInt();
			int result = 0;
			for (int i = 1; i <= n; i += 2) {
				result += i;
			}
			for (int i = 2; i <= n; i += 2) {
				result -= i;
			}

			System.out.println("#" + (t++) + " " + result);
		}
	}

}
