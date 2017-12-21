package baek_2178;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


public class Baek_2178 {

	public static int[][] map;
	public static boolean[][] visited;
	public static int[] dx = { -1, 1, 0, 0 };
	public static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int row = sc.nextInt();
		int col = sc.nextInt();

		map = new int[row][col];
		visited = new boolean[row][col];

		for (int i = 0; i < row; i++) {
			String temp = sc.next();
			for (int j = 0; j < col; j++) {
				map[i][j] = (int) temp.charAt(j) - 48;
			}
		}

		System.out.println(oper(0, 0));

	}

	public static int oper(int startX, int startY) {
		int ans = 0;

		Queue<Position> queue = new LinkedList<Position>();
		if (map[startX][startY] != 0) {
			queue.add(new Position(startX, startY, 1));
			visited[startX][startY] = true;
		}

		while (!queue.isEmpty()) {
			int nowX = queue.peek().nowX;
			int nowY = queue.peek().nowY;
			int nowP = queue.remove().nowP;

			if (nowX == map.length - 1 && nowY == map[0].length - 1) {
				ans = nowP;
				break;
			}

			for (int i = 0; i < 4; i++) {
				int nextX = nowX + dx[i];
				int nextY = nowY + dy[i];

				if (nextX < map.length && nextX >= 0 && nextY < map[0].length && nextY >= 0) {
					if (!visited[nextX][nextY] && map[nextX][nextY] != 0) {
						queue.add(new Position(nextX, nextY, nowP + 1));
						visited[nextX][nextY] = true;
					}
				}
			}
		}
		return ans;
	}

	static class Position {
		int nowX;
		int nowY;
		int nowP;

		Position(int nowX, int nowY, int nowP) {
			this.nowX = nowX;
			this.nowY = nowY;
			this.nowP = nowP;

		}
	}
}
