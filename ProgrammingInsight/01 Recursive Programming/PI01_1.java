package pi01_1;

import java.util.Arrays;

public class PI01_1 {

	static long[][] memo = new long[200][200];
	static long[] memo2 = new long[200];

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(factorial(3) + "\n");

		System.out.println(factorial2(3) + "\n");

		System.out.println("choose(30, 10) " + choose(30, 10) + "\n");

		System.out.println("choose(20, 10) " + choose(20, 10) + "\n");

		for (int i = 0; i < memo.length; i++) {
			for (int j = 0; j < memo[0].length; j++) {
				memo[i][j] = 0;
			}
			memo2[i] = 0;
		}

		System.out.println("choose2(50, 20) " + choose2(50, 20) + "\n");
		
		//System.out.println("fibo(20) " + fibo(20) + "\n");
		System.out.println("fibo2(50) " + fibo2(50) + "\n");

	}

	static int factorial(int n) {
		int ret = 1;
		for (int i = 2; i <= n; i++) {
			ret *= i;
		}
		return ret;
	}

	static int factorial2(int n) {
		if (n == 1)
			return 1;
		else
			return n * factorial2(n - 1);
	}

	static long choose(int n, int r) {

		if (r == 0 || n == r)
			return 1;
		return choose(n - 1, r - 1) + choose(n - 1, r);
	}

	static long choose2(int n, int r) {
		if (memo[n][r] > 0)
			return memo[n][r];

		if (r == 0 || n == r)
			return memo[n][r] = 1;

		return memo[n][r] = choose2(n - 1, r - 1) + choose2(n - 1, r);
	}

	static long fibo(int n) {
		if (n == 1 || n == 2)
			return 1;
		return fibo(n - 1) + fibo(n - 2);
	}

	static long fibo2(int n) {
		if (memo2[n] > 0)
			return memo2[n];

		if (n == 1 || n == 2)
			return memo2[n] = 1;

		return memo2[n] = fibo2(n - 1) + fibo2(n - 2);

	}

}
