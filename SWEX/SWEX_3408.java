package swex_3000;

import java.util.Scanner;

public class SWEX_3408 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		int t = 1;

		while (t <= tc) {
			int n = sc.nextInt();

			long s1 = 0, s2 = 0, s3 = 0;

			s1 = (1 + n) * (n / 2);
			s2 = (1 + (2 * n - 1)) * (n / 2);
			s3 = (2 + (2 * n)) * (n / 2);

			

			System.out.println("#" + (t++) + " " + s1 + " " + s2 + " " + s3);

		}
	}

}
