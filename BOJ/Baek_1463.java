package baek_1463;

import java.util.Arrays;
import java.util.Scanner;

public class Baek_1463 {

	public static int[] dp;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		dp = new int[n + 1];

		Arrays.fill(dp, 0);

		System.out.println(oper(n));
	}

	private static int oper(int input) {
		if (input == 1)
			return 0;
		if (dp[input] > 0)
			return dp[input];

		dp[input] = oper(input - 1) + 1;
		if (input % 3 == 0) {
			int temp = oper(input / 3) + 1;
			if (dp[input] > temp)
				dp[input] = temp;
		}
		if (input % 2 == 0) {
			int temp = oper(input / 2) + 1;
			if (dp[input] > temp)
				dp[input] = temp;
		}

		return dp[input];

	}
}
