package swex_1976;

import java.util.Scanner;

public class SWEX_1976 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int c = sc.nextInt();
		int t = 1;
		while (t <= c) {
			int ft = sc.nextInt();
			int fm = sc.nextInt();
			int st = sc.nextInt();
			int sm = sc.nextInt();

			int rt = 0, rm = 0;

			if (fm + sm >= 60) {
				rt += 1;
				rm = fm + sm - 60;
			} else {
				rm = fm + sm;
			}

			if (rt + ft + st >= 12) {
				rt = rt + ft + st - 12;

			} else {
				rt = rt + ft + st;
			}

			System.out.println("#" + (t++) + " " + rt + " " + rm);
		}
	}

}
