package swex_2105;

import java.util.Scanner;

public class SWEX_2105 {

	static int[] dx = { 1, 1, -1, -1 };
	static int[] dy = { 1, -1, -1, 1 };
	static int[][] map;
	static boolean[][] visited;
	static boolean[] checked;
	static int ans;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		int t = 1;

		while (t <= tc) {
			int n = sc.nextInt();
			map = new int[n][n];
			visited = new boolean[n][n];
			checked = new boolean[101];
			ans = -1;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					map[i][j] = sc.nextInt();
				}
			}

			for (int i = 0; i < n - 2; i++) {
				for (int j = 0; j < n - 1; j++) {
					visited[i][j] = true;
					checked[map[i][j]] = true;
					recursion(i, j, 0, i, j, 1);
					visited[i][j] = false;
					checked[map[i][j]] = false;
				}
			}

			System.out.println("#" + (t++) + " " + ans);

		}
	}

	static void recursion(int x, int y, int dir, int fx, int fy, int length) {
		for (int i = dir; i < 4; i++) {
			int nextX = x + dx[i];
			int nextY = y + dy[i];

			if (nextX < 0 || nextX >= map.length || nextY < 0 || nextY >= map.length) {
				continue;
			}

			if (nextX == fx && nextY == fy && length >= 4) {
				ans = Math.max(ans, length);
				return;
			}

			if (checked[map[nextX][nextY]] || visited[nextX][nextY]) {
				continue;
			}

			visited[nextX][nextY] = true;
			checked[map[nextX][nextY]] = true;
			recursion(nextX, nextY, i, fx, fy, length + 1);
			visited[nextX][nextY] = false;
			checked[map[nextX][nextY]] = false;

		}

	}

}
