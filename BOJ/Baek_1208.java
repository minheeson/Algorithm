package baek_1208;

import java.util.Arrays;
import java.util.Scanner;

public class Baek_1208 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int s = sc.nextInt();

		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}

		int m = n / 2;
		n = n - m;

		int[] front = new int[1 << n];
		int[] back = new int[1 << m];

		for (int i = 0; i < (1 << n); i++) {
			for (int k = 0; k < n; k++) {
				if ((i & (1 << k)) == (1 << k)) {
					front[i] += arr[k];
				}
			}
		}

		for (int i = 0; i < (1 << m); i++) {
			for (int k = 0; k < m; k++) {
				if ((i & (1 << k)) == (1 << k)) {
					back[i] += arr[k + n];
				}
			}
		}

		Arrays.sort(front);
		Arrays.sort(back);

		n = (1 << n);
		m = (1 << m);
		int left = 0;
		int right = back.length - 1;
		long ans = 0;

		while (left < n && right >= 0) {
			if (front[left] + back[right] == s) {
				long c1 = 1;
				long c2 = 1;
				left++;
				right--;

				while (left < n && front[left] == front[left - 1]) {
					c1++;
					left++;
				}
				while (right >= 0 && back[right] == back[right + 1]) {
					c2++;
					right--;
				}
				ans += c1 * c2;

			} else if (front[left] + back[right] < s) {
				left++;
			} else {
				right--;
			}
		}

		if (s == 0)
			ans -= 1;

		System.out.println(ans);

	}

}
