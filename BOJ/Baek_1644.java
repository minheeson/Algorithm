package baek_1644;

import java.util.Arrays;
import java.util.Scanner;

public class Baek_1644 {

	static boolean[] prime;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		int count = 0;
		prime = new boolean[n + 1];
		Arrays.fill(prime, true);
		prime[0] = false;
		prime[1] = false;

		for (int i = 2; i * i <= n; i++) {
			for (int j = i * i; j <= n; j += i) {
				if (prime[j]) {
					prime[j] = false;
				}
			}
		}

		for (int i = 0; i <= n; i++) {
			if (prime[i]) {
				count++;
			}
		}

		int[] primenum = new int[count];
		int point = 0;

		for (int i = 0; i <= n; i++) {
			if (prime[i]) {
				primenum[point++] = i;
			}
		}

		if(n==1) {
			System.out.println(0);
		}else {
			System.out.println(oper(primenum, count, n));
		}
		

	}

	static int oper(int[] arr, int s, int n) {
		int count = 0;
		int left = 0, right = 0;
		int sum = arr[0];

		while (left <= right && right < s) {
			if (sum < n) {
				if (right < s - 1) {
					right++;
					sum += arr[right];
				} else {
					break;
				}
			} else if (sum == n) {
				count++;
				if (right < s - 1) {
					right++;
					sum += arr[right];
				} else {
					break;
				}

			} else if (sum > n) {
				sum -= arr[left];
				left++;
			}
		}

		return count;
	}

}
