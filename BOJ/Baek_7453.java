package baek_7453;

import java.util.Arrays;
import java.util.Scanner;

public class Baek_7453 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int size = sc.nextInt();
		int[] a = new int[size];
		int[] b = new int[size];
		int[] c = new int[size];
		int[] d = new int[size];

		for (int i = 0; i < size; i++) {
			a[i] = sc.nextInt();
			b[i] = sc.nextInt();
			c[i] = sc.nextInt();
			d[i] = sc.nextInt();
		}

		int[] sum = new int[size * size];
		int[] sum2 = new int[size * size];
		int s = 0;
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				sum[s] = a[i] + b[j];
				sum2[s++] = c[i] + d[j];
			}
		}

		Arrays.sort(sum);
		Arrays.sort(sum2);

		long count = 0;
		int mid, left = 0;
		int right = sum2.length - 1;

		long c1 = 0;
		long c2 = 0;
		int t1, t2;

		while (left < size * size && right >= 0) {
			if (sum[left] + sum2[right] < 0)
				left++;
			else if (sum[left] + sum2[right] == 0) {
				c1 = 0;
				c2 = 0;

				t1 = sum[left];
				t2 = sum2[right];
				for (; left < size * size; left++) {
					if (sum[left] == t1)
						c1++;
					else
						break;
				}
				for (; right >= 0; right--) {
					if (sum2[right] == t2)
						c2++;
					else
						break;

				}

				count += c1 * c2;
			} else
				right--;
		}

		System.out.println(count);

	}

}
