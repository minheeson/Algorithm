package swex_4000;

import java.util.Scanner;

public class SWEX_4047 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		int t = 1;

		while (t <= tc) {

			String str = sc.next();
			boolean[] s = new boolean[14];
			boolean[] d = new boolean[14];
			boolean[] h = new boolean[14];
			boolean[] c = new boolean[14];

			String answer = "";
			int num = str.length() / 3;
			for (int i = 0; i < num; i++) {
				int tmp = 0;
				if (str.charAt(i * 3 + 1) == '0') {
					tmp = str.charAt(i * 3 + 2) - '0';
				} else {
					tmp += (str.charAt(i * 3 + 1) - '0') * 10;
					tmp += str.charAt(i * 3 + 2) - '0';
				}

				if (str.charAt(i * 3) == 'S') {
					if (s[tmp]) {
						answer = "ERROR";
						break;
					}
					s[tmp] = true;

				} else if (str.charAt(i * 3) == 'D') {
					if (d[tmp]) {
						answer = "ERROR";
						break;
					}
					d[tmp] = true;

				} else if (str.charAt(i * 3) == 'H') {
					if (h[tmp]) {
						answer = "ERROR";
						break;
					}
					h[tmp] = true;
				} else if (str.charAt(i * 3) == 'C') {
					if (c[tmp]) {
						answer = "ERROR";
						break;
					}
					c[tmp] = true;
				}
			}

			if (!answer.equals("")) {
				System.out.println("#" + (t++) + " " + answer);
			} else {
				int c1 = 0, c2 = 0, c3 = 0, c4 = 0;
				for (int i = 1; i <= 13; i++) {
					if (!s[i]) {
						c1++;
					}

					if (!d[i]) {
						c2++;
					}

					if (!h[i]) {
						c3++;
					}

					if (!c[i]) {
						c4++;
					}
				}

				System.out.println("#" + (t++) + " " + c1 + " " + c2 + " " + c3 + " " + c4);

			}

		}
	}

}
