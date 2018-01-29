package baek_10819;

import java.util.Scanner;

public class Baek_10819 {

	static int[] arr;
	static int[] order;
	// static int[] fact;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		arr = new int[n];
		order = new int[n];
		// fact = new int[n + 1];
		//
		// fact[0] = 1;
		// for (int i = 1; i <= n; i++) {
		// fact[i] = fact[i - 1] * i;
		// }

		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
			order[i] = i;
		}

		System.out.println(findMax(arr));

	}

	static int findMax(int[] input) {
		int ret = 0;
		//int cal = 0;

		while (check(input)) {
			int cal = 0;
			for (int i = 1; i < input.length; i++) {
				if (input[i - 1] > input[i]) {
					cal += input[i - 1] - input[i];
					//System.out.println(input[i - 1] - input[i]);
				} else {
					cal += input[i] - input[i - 1];
					//System.out.println(input[i] - input[i - 1]);
				}
			}
			if (ret < cal) {
				ret = cal;
			}
			input = orderToReal(nextPermutation(order));

		}
		return ret;
	}

	static boolean check(int[] input) {
		for (int i = 0; i < input.length; i++) {
			if (input[i] != arr[arr.length - i - 1]) {
				return true;
			}
		}

		// 마지막 순열
		return false;
	}

	static int[] orderToReal(int[] input) {
		int[] ret = new int[input.length];
		for (int i = 0; i < input.length; i++) {
			ret[i] = arr[input[i]];
		}

		return ret;
	}

	static int[] nextPermutation(int[] input) {
		int big = 0;
		int next = 0;
		for (int i = input.length - 1; i > 0; i--) {
			if (input[i - 1] < input[i]) {
				big = i;
				break;
			}
		}

		for (int i = input.length - 1; i >= big; i--) {
			if (input[big - 1] < input[i]) {
				next = i;
				break;
			}
		}

		int temp = input[next];
		input[next] = input[big - 1];
		input[big - 1] = temp;

		int[] tmp = new int[input.length - big];
		for (int i = 0; i < tmp.length; i++) {
			tmp[i] = input[input.length - i - 1];
		}
		for (int i = 0; i < tmp.length; i++) {
			input[big + i] = tmp[i];
		}

		return input;
	}

}
