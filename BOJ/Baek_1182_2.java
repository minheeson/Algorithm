package baek_1182;

import java.util.Scanner;

public class Baek_1182_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int s = sc.nextInt();

		int[] arr = new int[n];

		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}

		System.out.println(countSub(arr, n, s));
	}

	static int countSub(int[] arr, int n, int s) {
		int count = 0;
		for (int i = 1; i < (1 << n); i++) {
			int sum = 0;
			for (int j = 0; j < n; j++) {
				if ((i & (1 << j)) != 0) {
					sum += arr[j];
				}
			}

			if (sum == s) {
				count++;
			}
		}

		return count;
	}

}
