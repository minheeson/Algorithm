package baek_1806;

import java.util.Scanner;

public class Baek_1806 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int s = sc.nextInt();

		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}

		System.out.println(operMin(arr, n, s));
	}

	static int operMin(int[] arr, int n, int s) {
		int left = 0, right = 0;
		int sum = arr[0];
		int len = n + 1;

		while (left <= right && right < n) {
			if (sum < s) {
				if (right < n - 1) {
					right++;
					sum += arr[right];
				} else {
					break;
				}

			} else if (sum == s) {
				System.out.println(left + " " + right);
				len = Math.min(len, right - left + 1);
				if (right < n - 1) {
					right++;
					sum += arr[right];
				} else {
					break;
				}
			} else if (sum > s) {
				len = Math.min(len, right - left + 1);
				sum -= arr[left];
				left++;
			}
		}

		if (len > n) {
			len = 0;
		}

		return len;
	}

}
