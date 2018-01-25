package baek_1722;

import java.util.Scanner;

public class Baek_1722 {

	static long[] fact;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int type = sc.nextInt();

		fact = new long[n + 1];
		fact[0] = 1;
		for (int i = 1; i <= n; i++) {
			fact[i] = fact[i - 1] * i;
		}

		if (type == 1) { // k 번째 수열 구하기
			long order = sc.nextLong();
			printPermutation(n, order);

		} else if (type == 2) { // 어떤 순열이 몇 번째 순열인지 구하는 방법

			int[] arr = new int[n];
			for (int i = 0; i < n; i++) {
				arr[i] = sc.nextInt();
			}

			System.out.println(orderOfPermutation(n, arr));

		}

	}

	static void printPermutation(int n, long order) {
		int[] arr = new int[n];
		boolean[] check = new boolean[n + 1];

		for (int i = 0; i < n; i++) {
			for (int j = 1; j <= n; j++) {
				if (check[j])
					continue;
				if (fact[n - i - 1] < order) {
					order = order - fact[n - i - 1];
				} else {
					arr[i] = j;
					check[j] = true;
					break;
				}
			}
		}

		for (int i = 0; i < n; i++) {
			System.out.print(arr[i] + " ");
		}

	}

	static long orderOfPermutation(int n, int[] arr) {
		long ret = 1;
		boolean[] check = new boolean[n + 1];

		for (int i = 0; i < n; i++) {
			for (int j = 1; j < arr[i]; j++) {
				if (!check[j]) {
					ret += fact[n - i - 1];
				}
			}
			check[arr[i]] = true;
		}

		return ret;
	}

}
