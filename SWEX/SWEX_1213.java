package swex_1213;

import java.util.Scanner;

public class SWEX_1213 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int tc = 10;
		int t = 1;
		while (t <= tc) {
			t++;

			int tcase = sc.nextInt();
			String word = sc.next();
			String sen = sc.next();

			char[] words = word.toCharArray();
			char[] stcs = sen.toCharArray();

			int result = 0;
			for (int i = 0, len = stcs.length; i < len; i++) {
				if (words[0] == stcs[i]) {
					int cnt = 1;
					for (int j = 1; j < words.length; j++) {
						if (i+j<stcs.length && words[j] == stcs[i + j]) {
							cnt++;
						} else {
							break;
						}
						if (cnt == words.length) {
							result++;
						}
					}
				}
			}

			System.out.println("#" + tcase + " " + result);

		}
	}

}
