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
		dp[1] = 0;
		Arrays.fill(dp, 0);

		System.out.println(oper(n));
	}

	static int oper(int input) {
		for (int i = 2; i <= input; i++) {
			dp[i] = dp[i - 1] + 1;
			if (i % 3 == 0) {
				dp[i] = Math.min(dp[i], dp[i / 3] + 1);
			}
			if (i % 2 == 0) {
				dp[i] = Math.min(dp[i], dp[i / 2] + 1);
			}
		}

		return dp[input];
	}

}
