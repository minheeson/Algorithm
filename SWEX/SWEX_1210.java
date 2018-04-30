package swex_1000;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SWEX_1210 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int t = 1;

		int[] dx = { 1, 0, 0 };
		int[] dy = { 0, 1, -1 };

		while (t <= 1) {
			int[][] map = new int[100][100];

			Queue<Integer> q = new LinkedList<Integer>();
			for (int i = 0; i < 100; i++) {
				for (int j = 0; j < 100; j++) {
					map[i][j] = sc.nextInt();
				}
				if (map[0][i] == 1) {
					q.add(i);
				}
			}

			while (!q.isEmpty()) {
				int nowY = q.remove();
				int nowX = 0;
				int nextX = 0;
				int nextY = 0;

				while (nextX != 99) {

					if (nowX >= 0 && nowX < 99 && nowY + 1 >= 0 && nowY + 1 < 99 && map[nowX][nowY + 1] == 1) { // 오른쪽이
						nextX = nowX;
						nextY = nowY + 1;
						while (nextY >= 0 && nextY < 99 && map[nextX][nextY] != 0) {
							nextX = nowX;
							nextY = nowY + 1;
						}

					} else if (nowX >= 0 && nowX < 99 && nowY - 1 >= 0 && nowY - 1 < 99 && map[nowX][nowY - 1] == 1) { // 왼쪽이
						nextX = nowX;
						nextY = nowY - 1;
						while (nextY >= 0 && nextY < 99 && map[nextX][nextY] != 0) {
							nextX = nowX;
							nextY = nowY - 1;
						}

					} else if (nowX + 1 >= 0 && nowX + 1 < 99 && nowY >= 0 && nowY < 99 && map[nowX + 1][nowY] == 1) { // 그냥
						// 아래로
						nextX = nowX + 1;
						nextY = nowY;
						while (nextX >= 0 && nextX < 99 && map[nextX][nextY] != 0) {
							nextX = nowX + 1;
							nextY = nowY;
						}
						// 쭉

					}
				}

				// if :: map[현재위치]==2 break;
				if (map[nextX][nextY] == 2) {
					System.out.println(nextX + " " + nextY);
				}
			}

		}
	}

}
