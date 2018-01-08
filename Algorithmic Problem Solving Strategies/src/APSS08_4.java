package apss08_4;

public class APSS08_4 {

	static int n = 7;
	static int[][] board = new int[7][7];
	static int[][] cache = new int[7][7];

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	static boolean jump(int y, int x) {
		// 기저 사례 :: 게임판 밖을 벗어난 경우
		if (y >= n || x >= n)
			return false;
		// 기저 사례 :: 마지막 칸에 도착한 경우
		if (y == n - 1 && x == n - 1)
			return true;

		int jumpSize = board[y][x];
		return jump(y + jumpSize, x) || jump(y, x + jumpSize);

	}

	static int jump2(int y, int x) {
		// 기저 사례 처리
		if (y >= n || x >= n)
			return 0;
		if (y == n - 1 && x == n - 1)
			return 1;

		int ret = cache[y][x];
		if (ret != -1)
			return ret;
		int jumpSize = board[y][x];
		return ret = (jump2(y + jumpSize, x) | jump2(y, x + jumpSize));
	}

}
