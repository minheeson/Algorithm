package pi01_6;

public class PI01_6 {

	static int[][] memo = new int[200][200];

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(partition(5, 3));

	}

	static int partition(int n, int m) {
		int count = 0;

		if (n < m) {
			m = n;
		}
		if (n == 0) {
			return 1;
		}

		for (int i = 1; i <= m; i++) {
			count += partition(n - i, i);
		}

		return count;
	}

	static int partition2(int n, int m) {
		int count = 0;

		if (n < m) {
			m = n;
		}
		if (memo[n][m] > 0) {
			return memo[n][m];
		}
		if (n == 0) {
			return memo[n][m] = 1;
		}

		for (int i = 1; i <= m; i++) {
			count += partition2(n - i, i);
		}
		return memo[n][m] = count;
	}

}
