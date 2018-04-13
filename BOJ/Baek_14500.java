package baek_14000;

import java.util.Scanner;

public class Baek_14500 {

	static int n, m;
	static int[][] map;
	static boolean[][] visited;
	static int answer;
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		map = new int[n][m];
		visited = new boolean[n][m];
		answer = 0;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				map[i][j] = sc.nextInt();
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				visited[i][j] = true;
				dfs(i, j, 1, map[i][j]);
				visited[i][j] = false;
			}
		}

		int t = dfs_x();

		if (answer < t) {
			System.out.println(t);
		} else {
			System.out.println(answer);
		}

	}

	// 재귀로 가능한 모형
	static void dfs(int x, int y, int num, int sum) {
		if (num == 4) {

			if (answer < sum) {
				answer = sum;
			}
			return;

		}

		for (int i = 0; i < 4; i++) {
			int nextX = x + dx[i];
			int nextY = y + dy[i];

			if (nextX < 0 || nextX >= n || nextY < 0 || nextY >= m) {
				continue;
			}

			if (visited[nextX][nextY]) {
				continue;
			}

			visited[nextX][nextY] = true;
			dfs(nextX, nextY, num + 1, sum + map[nextX][nextY]);
			visited[nextX][nextY] = false;

		}

	}

	// 재귀로 불가능한 모형
	static int dfs_x() {
		int ans = 0;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				int tmp = map[i][j];
				int min = Integer.MAX_VALUE;
				int sum = 0;
				int cnt = 0;

				for (int k = 0; k < 4; k++) {
					int nx = i + dx[k];
					int ny = j + dy[k];

					if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
						continue;
					}
					cnt++;
					sum += map[nx][ny];
					if (min > map[nx][ny]) {
						min = map[nx][ny];
					}

				}

				if (cnt == 4) {
					sum -= min;
					tmp += sum;
				} else if (cnt == 3) {
					tmp += sum;
				}

				if (tmp > ans) {
					ans = tmp;
				}

			}
		}

		return ans;

	}

}
