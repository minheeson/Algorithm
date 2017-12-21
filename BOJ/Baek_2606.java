package baek_2606;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


public class Baek_2606 {

	public static int[][] map;
	public static boolean[][] visited;
	public static boolean[] virus;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int com = sc.nextInt();
		int size = sc.nextInt();
		map = new int[com][com];
		visited = new boolean[com][com];
		virus = new boolean[com];

		for (int i = 0; i < com; i++)
			for (int j = 0; j < com; j++) {
				map[i][j] = 0;
				if (i == j) {
					map[i][j] = 1;
					map[j][i] = 1;
				}
			}

		for (int i = 0; i < size; i++) {
			int tempX = sc.nextInt();
			int tempY = sc.nextInt();
			map[tempX - 1][tempY - 1] = 1;
			map[tempY - 1][tempX - 1] = 1;
		}

		System.out.println(oper());
	}

	public static int oper() {
		int ans = 0;

		Queue<Position> queue = new LinkedList<Position>();
		visited[0][0] = true;
		virus[0] = true;
		queue.add(new Position(0, 0));

		while (!queue.isEmpty()) {
			int nowX = queue.peek().nowX;
			int nowY = queue.remove().nowY;

			for (int i = 0; i < map.length; i++) {
				if (map[nowX][i] == 1) {
					if (!visited[nowX][i]) {
						queue.add(new Position(nowX, i));
						visited[nowX][i] = true;
						visited[i][nowX] = true;
						visited[i][i] = true;
						virus[nowX] = true;
						virus[i] = true;
					}
				}
				if (map[nowY][i] == 1) {
					if (!visited[nowY][i]) {
						queue.add(new Position(nowY, i));
						visited[nowY][i] = true;
						visited[i][nowY] = true;
						visited[i][i] = true;
						virus[nowY] = true;
						virus[i] = true;
					}
				}

			}

		}

		for (int i = 0; i < virus.length; i++)
			if (virus[i]) {
				ans++;
			}

		return ans - 1;
	}

	static class Position {
		int nowX;
		int nowY;

		Position(int nowX, int nowY) {
			this.nowX = nowX;
			this.nowY = nowY;
		}
	}

}
