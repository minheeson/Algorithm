package baek_2468;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Baek_2468 {

	static int[][] map;
	static boolean[][] visited;
	static int n;
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();

		map = new int[n][n];
		int[][] copy = new int[n][n];
		visited = new boolean[n][n];

		int maxR = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				map[i][j] = sc.nextInt();
				copy[i][j] = map[i][j];
				if (map[i][j] > maxR) {
					maxR = map[i][j];
				}
			}
		}

		int ans = 0;

		for (int i = maxR; i >= 0; i--) { // i: 비높이
			copy(copy);
			clear();
			int temp = oper(i);
			if (ans < temp)
				ans = temp;
		}

		System.out.println(ans);

	}

	static void clear() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				visited[i][j] = false;
			}
		}
	}

	static void copy(int[][] copy) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				map[i][j] = copy[i][j];
			}
		}
	}


	static int oper(int rain) {
		int ans = 0;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (map[i][j] <= rain) {
					map[i][j] = 0;
				} else {
					map[i][j] = 1; // 1 그룹핑 해야됨
				}
			}
		}


		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (map[i][j] == 1 && !visited[i][j]) {
					ans += bfs(i, j);
				}
			}
		}

		return ans;
	}

	static int bfs(int x, int y) {

		Queue<Node> q = new LinkedList<Node>();
		q.add(new Node(x, y));
		visited[x][y] = true;

		while (!q.isEmpty()) {
			int nowX = q.peek().x;
			int nowY = q.remove().y;

			for (int i = 0; i < 4; i++) {
				int nextX = nowX + dx[i];
				int nextY = nowY + dy[i];

				if (nextX < 0 || nextX >= n || nextY < 0 || nextY >= n) {
					continue;
				}

				if (map[nextX][nextY] == 0 || visited[nextX][nextY]) {
					continue;
				}

				visited[nextX][nextY] = true;
				q.add(new Node(nextX, nextY));

			}
		}

		return 1;
	}

	static class Node {
		int x;
		int y;

		Node(int x, int y) {
			this.x = x;
			this.y = y;

		}
	}

}
