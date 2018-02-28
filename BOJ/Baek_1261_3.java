package baek_1261;

import java.util.ArrayDeque;
import java.util.Scanner;

public class Baek_1261_3 {
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

		int[][] route = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				route[i][j] = -1;
			}
		}

		ArrayDeque<Node> deque = new ArrayDeque<Node>();
		deque.add(new Node(0, 0));
		route[0][0] = 0;

		while (!deque.isEmpty()) {
			int x = deque.peek().x;
			int y = deque.remove().y;

			for (int k = 0; k < 4; k++) {
				int nextX = x + dx[k];
				int nextY = y + dy[k];
				if (0 <= nextX && nextX < n && 0 <= nextY && nextY < m) {
					if (route[nextX][nextY] == -1) {
						if (map[nextX][nextY] == 0) {
							route[nextX][nextY] = route[x][y];
							deque.addFirst(new Node(nextX, nextY));
						} else {
							route[nextX][nextY] = route[x][y] + 1;
							deque.addLast(new Node(nextX, nextY));
						}
					}
				}
			}
		}
		System.out.println(route[n - 1][m - 1]);

	}

	static class Node {
		int x, y;

		Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

}
