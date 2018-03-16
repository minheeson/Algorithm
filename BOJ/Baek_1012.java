package baek_1012;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Baek_1012 {

	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { 1, -1, 0, 0 };
	static boolean[][] visited;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		int t = 1;
		while (t++ <= tc) {
			int m = sc.nextInt();
			int n = sc.nextInt();

			int[][] map = new int[n][m];
			visited = new boolean[n][m];
			int bae = sc.nextInt();
			for (int i = 0; i < bae; i++) {
				int y = sc.nextInt();
				int x = sc.nextInt();
				map[x][y] = 1;
			}

			System.out.println(worm(map, n, m));
		}
	}

	static int worm(int[][] map, int n, int m) {
		int count = 0;
		Queue<Node> q = new LinkedList<Node>();

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] == 1 && !visited[i][j]) {
					visited[i][j] = true;
					q.add(new Node(i, j, count++));

					while (!q.isEmpty()) {
						int nowX = q.peek().x;
						int nowY = q.peek().y;
						int nowC = q.remove().count;

						for (int k = 0; k < 4; k++) {
							int nextX = nowX + dx[k];
							int nextY = nowY + dy[k];

							if (nextX >= 0 && nextX < n && nextY >= 0 && nextY < m) {
								if (map[nextX][nextY] == 1 && !visited[nextX][nextY]) {
									q.add(new Node(nextX, nextY, nowC));
									visited[nextX][nextY] = true;
								}
							}

						}

					}
					
				}
			}
		}

		return count;
	}

	static class Node {
		int x;
		int y;
		int count;

		Node(int x, int y, int count) {
			this.x = x;
			this.y = y;
			this.count = count;
		}
	}

}
