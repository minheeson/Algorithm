package swex_3000;

import java.util.Scanner;

public class SWEX_3750 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		int t = 1;

		while (t <= tc) {

			long n = sc.nextLong();
			long answer = oper(n);

			while (answer >= 10) {
				answer = oper(answer);
			}

			System.out.println("#" + (t++) + " " + answer);

		}
	}

	static long oper(long n) {

		long rtn = 0;
		long tmp = n;

		while (tmp >= 10) {
			long md = tmp % 10;
			tmp = tmp / 10;
			rtn += md;
		}
		return rtn += tmp;

	}

}
