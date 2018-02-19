package baek_1261;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Baek_1261_2 {

	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, 1, -1 };

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();
		int n = sc.nextInt();

		int[][] map = new int[n][m];
		for (int i = 0; i < n; i++) {
			String temp = sc.next();
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(String.valueOf(temp.charAt(j)));
			}
		}

		System.out.println(oper(map, m, n));

	}

	static int oper(int[][] map, int m, int n) {

		int[][] route = new int[n][m];
		boolean[][] visited = new boolean[n][m];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				route[i][j] = Integer.MAX_VALUE;
			}
		}

		PriorityQueue<Node> queue = new PriorityQueue<Node>();
		queue.add(new Node(0, 0, map[0][0]));
		route[0][0] = map[0][0];

		while (!queue.isEmpty()) {
			int nowX = queue.peek().x;
			int nowY = queue.remove().y;

			for (int i = 0; i < 4; i++) {
				int nextX = nowX + dx[i];
				int nextY = nowY + dy[i];

				if (nextX >= 0 && nextX < n && nextY >= 0 && nextY < m) {
					if (!visited[nextX][nextY]) {
						route[nextX][nextY] = route[nowX][nowY] + map[nextX][nextY];
						queue.add(new Node(nextX, nextY, map[nextX][nextY]));
						visited[nextX][nextY] = true;
					}
				}
			}
		}

		return route[n - 1][m - 1];

	}

	static class Node implements Comparable<Node> {

		int x;
		int y;
		int w;

		Node(int x, int y, int w) {
			this.x = x;
			this.y = y;
			this.w = w;
		}

		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			if (this.w > o.w) {
				return 1;
			} else if (this.w < o.w) {
				return -1;
			}
			return 0;
		}

	}

}
