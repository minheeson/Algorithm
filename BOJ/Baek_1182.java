package baek_1182;

import java.util.Scanner;

public class Baek_1182 {
	static int[] arr;
	static int s;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		s = sc.nextInt();
		arr = new int[n];

		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}

		int ans = countSub(0, 0);
		if (s == 0) {
			ans--;
		}
		System.out.println(ans);

	}

	static int countSub(int i, int sum) {
		if (i == arr.length) {
			if (sum == s) {
				return 1;
			} else {
				return 0;
			}
		}

		return countSub(i + 1, sum + arr[i]) + countSub(i + 1, sum);
	}

}
