package swex_1966;

import java.util.Arrays;
import java.util.Scanner;

public class SWEX_1966 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int c = sc.nextInt();
		int t = 1;

		while (t <= c) {
			int n = sc.nextInt();
			int[] nums = new int[n];
			for (int i = 0; i < n; i++) {
				nums[i] = sc.nextInt();
			}

			Arrays.sort(nums);
			System.out.print("#" + (t++) + " ");
			for (int i = 0; i < n; i++) {
				System.out.print(nums[i] + " ");
			}
			System.out.println();
		}
	}

}
