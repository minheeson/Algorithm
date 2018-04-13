package baek_15000;

import java.util.Arrays;
import java.util.Scanner;

public class Baek_15649 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();

		int[] arr = new int[m];
		forAsMethod(n, m, arr, 0);

	}

	static void forAsMethod(int N, int n, int[] arr, int p) {
		LOOP: for (int i = 0; i < N; i++) {
			arr[p] = i;
			for (int j = 0; j < p; j++) {
				if (arr[p] == arr[j])
					continue LOOP;
			}

			if (p == n - 1) {
				for (int a : arr) {
					System.out.print((a+1) + " ");
				}
				System.out.println();
			} else {
				forAsMethod(N, n, arr, p + 1);
			}
		}
	}

}
