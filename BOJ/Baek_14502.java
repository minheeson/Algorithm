package baek_14502;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Baek_14502 {

	static int n;
	static int m;
	static int[][] map;
	static boolean[][] visited;
	static boolean[][] checked;
	static int answer;
	static int[][] copy;

	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		map = new int[n][m];
		checked = new boolean[n][m];
		answer = 0;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				map[i][j] = sc.nextInt();
			}
		}

		copy = new int[n][m];
		setCopy();

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] == 0) {
					map[i][j] = 1;
					dfs(1);
					map[i][j] = 0;
				}

			}
		}

		System.out.println(answer);


	}

	static void dfs(int num) {

		if (num == 3) {
			
			setCopy();
			int tmp = count();
			if (answer < tmp) {
				answer = tmp;
			}
			setMap();

			return;
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] == 0) {
					map[i][j] = 1;
					dfs(num + 1);
					map[i][j] = 0;
				}
			}
		}
	}

	static void setCopy() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				copy[i][j] = map[i][j];
			}
		}
	}

	
	static void setMap() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				map[i][j] = copy[i][j];
			}
		}
	}
	
	
	
	static int count() { // ok
		int ans = 0;

		visited = new boolean[n][m];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] == 2 && !visited[i][j]) {
					bfs(i, j);
				}
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] == 0) {
					ans++;
				}
			}
		}

		return ans;

	}

	static void bfs(int x, int y) { // ok
		Queue<Node> q = new LinkedList<Node>();
		q.add(new Node(x, y));
		visited[x][y] = true;

		while (!q.isEmpty()) {
			int nowX = q.peek().x;
			int nowY = q.remove().y;

			for (int i = 0; i < 4; i++) {
				int nextX = nowX + dx[i];
				int nextY = nowY + dy[i];

				if (nextX < 0 || nextY < 0 || nextX >= n || nextY >= m) {
					continue;
				}
				if (map[nextX][nextY] != 0 || visited[nextX][nextY]) {
					continue;
				}

				visited[nextX][nextY] = true;
				map[nextX][nextY] = 2;
				q.add(new Node(nextX, nextY));

			}
		}

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
