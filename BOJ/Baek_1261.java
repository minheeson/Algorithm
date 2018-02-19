package baek_1261;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Baek_1261 {

	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();

		int[][] map = new int[m][n];
		for (int i = 0; i < m; i++) {
			String temp = sc.next();
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(String.valueOf(temp.charAt(j)));
			}
		}

		System.out.println(oper(n, m, map));

	}

	static int oper(int n, int m, int[][] map) {

		int[][] route = new int[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				route[i][j] = -1;
			}
		}

		Queue<Node> queue = new LinkedList<>();
		Queue<Node> nextQueue = new LinkedList<>();

		queue.add(new Node(0, 0));
		route[0][0] = map[0][0];

		while (!queue.isEmpty()) {
			int nowX = queue.peek().x;
			int nowY = queue.remove().y;

			for (int i = 0; i < 4; i++) {
				int nextX = nowX + dx[i];
				int nextY = nowY + dy[i];

				if (nextX >= 0 && nextX < m && nextY >= 0 && nextY < n) {
					if (route[nextX][nextY] == -1) {
						if (map[nextX][nextY] == 0) {
							route[nextX][nextY] = route[nowX][nowY];
							queue.add(new Node(nextX, nextY));
						} else {
							route[nextX][nextY] = route[nowX][nowY] + map[nextX][nextY];
							nextQueue.add(new Node(nextX, nextY));
						}
					}
				}
			}
			
			if(queue.isEmpty()) {
				queue = nextQueue;
				nextQueue = new LinkedList<Node>();
			}

		}

		return route[m - 1][n - 1];
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
