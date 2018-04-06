package swex_4008;

import java.util.Scanner;

public class SWEX_4008_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		int t = 1;

		while (t <= tc) {
			int n = sc.nextInt();
			int[] ops = new int[4];
			// int[] perm = new int[4];
			int[] num = new int[n];

			int count = 0;

			// +:0 -:1 *:2 /:3
			for (int i = 0; i < 4; i++) {
				ops[i] = sc.nextInt();
				if (ops[i] != 0) {
					count += ops[i];
				}
			}

			// int[] perm = {0,1,2,3};
			int[] perm = new int[count];
			int x = 0;
			for (int i = 0; i < 4; i++) {
				if (ops[i] != 0) {
					for (int j = 0; j < ops[i]; j++) {
						perm[x++] = i;
					}
				}
			}

			for (int i = 0; i < n; i++) {
				num[i] = sc.nextInt();
			}

			int min = Integer.MAX_VALUE;
			int max = Integer.MIN_VALUE;

			boolean check = checkLast(perm);

			while (!check) {
				int result = num[0];
				int pos = 0;

				for (int i = 1; i < n; i++) {
					if (perm[pos] == 0) {
						result += num[i];
						pos++;
					} else if (perm[pos] == 1) {
						result -= num[i];
						pos++;
					} else if (perm[pos] == 2) {
						result *= num[i];
						pos++;
					} else {
						result /= num[i];
						pos++;
					}
				}

				if (result < min) {
					min = result;
				}

				if (result > max) {
					max = result;
				}

				check = checkLast(perm);
				if (check) {
					break;
				}
				nextPermutation(perm);

			}

			int result = num[0];
			int pos = 0;

			for (int i = 1; i < n; i++) {
				if (perm[pos] == 0) {
					result += num[i];
					pos++;
				} else if (perm[pos] == 1) {
					result -= num[i];
					pos++;
				} else if (perm[pos] == 2) {
					result *= num[i];
					pos++;
				} else {
					result /= num[i];
					pos++;
				}
			}

			if (result < min) {
				min = result;
			}

			if (result > max) {
				max = result;
			}

			System.out.println("#" + (t++) + " " + (max - min));

		}
	}

	static void nextPermutation(int[] arr) {
		int big = 0;

		for (int i = arr.length - 1; i >= 1; i--) {
			if (arr[i - 1] < arr[i]) {
				big = i;
				break;
			}
		}

		int next = 0;
		for (int i = arr.length - 1; i >= big; i--) {
			if (arr[big - 1] < arr[i]) {
				next = i;
				break;
			}
		}

		int temp = arr[big - 1];
		arr[big - 1] = arr[next];
		arr[next] = temp;

		int[] tmp = new int[arr.length - big];
		for (int i = 0; i < tmp.length; i++) {
			tmp[i] = arr[i + big];
		}

		for (int i = 0; i < tmp.length; i++) {
			arr[i + big] = tmp[tmp.length - i - 1];
		}

	}

	static boolean checkLast(int[] arr) {
		for (int i = 1; i < arr.length; i++) {
			if (arr[i - 1] < arr[i]) {
				return false;
			}
		}

		// 마지막 맞음
		return true;
	}

}
