package pi02_4;

public class PI02_4 {

	static int[][] memo;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] s = { 6, 9, 13, 14, 20, 21, 22, 30, 49, 55 };
		int n = 10;
		int m = 110;
		memo = new int[n][m];

		System.out.println(possible(s, n, m));
	}

	static int possible(int[] s, int n, int m) {
		if (n == 0) {
			if (m == 0)
				return 1;
			else
				return 0;
		}

		return Math.max(possible(s, n - 1, m - s[n - 1]), possible(s, n - 1, m));
	}

	static void possible_sum(int[] s, int n, int m) {
		for (int i = 0; i < n; i++)
			memo[i][0] = 1;

		for (int i = 0; i < m; i++)
			memo[0][i] = 0;

		for (int i = 1; i < n; i++) {
			for (int j = 1; i < m; j++) {
				memo[i][j] = 0;

				if (j >= s[i - 1]) {
					if (memo[i - 1][j - s[i - 1]] == 1) {
						memo[i][j] = 1;
					}

				}

				if (memo[i - 1][j] == 1) {
					memo[i][j] = 1;
				}
			}
		}
	}

}
