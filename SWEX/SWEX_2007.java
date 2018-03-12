package swex_2007;

import java.util.Scanner;

public class SWEX_2007 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		int t = 1;

		while (t <= tc) {
			String pattern = sc.next();
			char[] pArr = pattern.toCharArray();

			char fir = pArr[0];
			int count = 0;
			for (int i = 1; i < pArr.length - 1; i++) {
				if (pArr[i] == fir) {
					count = 0;

					for (int j = 0; j < i; j++) {
						if (pArr[j] != pArr[j + i]) {
							continue;
						} else {
							count++;

						}
					}

					if (count == i) {
						break;
					}
				}
			}

			System.out.println("#" + (t++) + " " + count);

		}
	}

}
