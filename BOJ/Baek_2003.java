package baek_2003;

import java.util.Scanner;

public class Baek_2003 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();

		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}

		System.out.println(oper(arr, n, m));

	}

	static int oper(int[] arr, int n, int m) {
		int count = 0;
		int sum = arr[0];
		int right = 0, left = 0;
		while (left <= right && right < n) {
			if (sum < m) {
				if (right < n - 1) {
					right++;
					sum += arr[right];
				} else {
					break;
				}
			} else if (sum == m) {
				count++;

				if (right < n - 1) {
					right++;
					sum += arr[right];
				} else {
					break;
				}
			} else if (sum > m) {
				sum -= arr[left];
				left++;
				if (left > right && left < n) {
					right = left;
					sum = arr[left];
				}
			}

		}

		return count;
	}

}
