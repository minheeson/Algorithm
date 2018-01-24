package baek_10972;

import java.util.Scanner;

public class Baek_10972 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];

		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}

		if (check(arr) < 0) {
			System.out.println(-1);
		} else {
			arr = next_permutation(arr);

			for (int i = 0; i < arr.length; i++) {
				System.out.print(arr[i] + " ");
			}
			System.out.println();

		}

	}

	static int[] next_permutation(int[] arr) {

		int big = 0;
		int next = 0;

		for (int i = arr.length - 1; i > 0; i--) {
			if (arr[i-1] < arr[i]) {
				big = i;
				break;
			}
		}

		for (int j = arr.length - 1; j >= big; j--) {
			if (arr[big - 1] < arr[j]) {
				next = j;
				break;
			}
		}

		int temp = arr[big - 1];
		arr[big - 1] = arr[next];
		arr[next] = temp;

		int[] tmp = new int[arr.length - big];
		for (int i = 0; i < tmp.length; i++) {
			tmp[i] = arr[arr.length - (i + 1)];
		}

		for (int i = 0; i < tmp.length; i++) {
			arr[big + i] = tmp[i];
		}

		return arr;
	}

	static int check(int[] arr) {
		int ret = -1;

		for (int i = 0; i < arr.length - 1; i++) {
			if (arr[i] < arr[i + 1])
				ret = 1;
		}
		return ret;
	}

}
