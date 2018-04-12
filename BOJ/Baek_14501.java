package baek_14501;

import java.util.Scanner;

public class Baek_14501 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] t = new int[n];
		int[] p = new int[n];

		for (int i = 0; i < n; i++) {
			t[i] = sc.nextInt();
			p[i] = sc.nextInt();
		}

		int ans = Integer.MIN_VALUE;
		for (int i = 0; i < (1 << n); i++) {

			boolean[] go = new boolean[n];

			for (int j = 0; j < n; j++) {
				if ((i & (1 << j)) != 0) {
					// 회사 가는날
					go[j] = true;
				}
			}

		
			int tmp = 0;
			int day = 0;

			for (int j = 0; j < n; j++) {
				if (go[j]) {
					if (day <= j) {
						if (j + t[j] > n) {
							continue;
						}
						day = j + t[j];
						tmp += p[j];
					}

				}
			}

			if (ans < tmp) {
				ans = tmp;
			}

		}

		System.out.println(ans);

	}

}
