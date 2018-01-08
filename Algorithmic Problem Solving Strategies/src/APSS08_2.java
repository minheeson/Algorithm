package apss08_2;

public class APSS08_2 {

	static int[][] cache = new int[30][30];

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		for (int i = 0; i < cache.length; i++)
			for (int j = 0; j < cache[0].length; j++)
				cache[i][j] = -1;

	}

	static int bino(int n, int r) {
		if (r == 0 || n == r)
			return 1;
		return bino(n - 1, r - 1) + bino(n - 1, r);
	}

	static int bino2(int n, int r) {
		if (r == 0 || n == r)
			return 1;
		if (cache[n][r] != -1)
			return cache[n][r];
		return cache[n][r] = bino2(n - 1, r - 1) + bino2(n - 1, r);
	}

}
