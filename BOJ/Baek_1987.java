package baek_1987;

import java.util.Scanner;

public class Baek_1987 {

	public static final int[] dx = { -1, 1, 0, 0 }; // 상 하 좌 우
	public static final int[] dy = { 0, 0, 1, -1 };
	public static char[][] map;
	public static boolean[] visited;
	static int maxLength = 0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int r = sc.nextInt();
		int c = sc.nextInt();

		visited = new boolean[26];
		map = new char[r][c];

		for (int i = 0; i < r; i++) {
			String input = sc.next();
			for (int j = 0; j < c; j++) {
				map[i][j] = input.charAt(j);
			}
		}

		oper(0, 0, 1);
		System.out.println(maxLength);

	}

	public static void oper(int nowX, int nowY, int length) {
		maxLength = maxLength > length ? maxLength : length;

		visited[map[nowX][nowY] - 'A'] = true;

		for (int i = 0; i < 4; i++) {
			int nextX = nowX + dx[i];
			int nextY = nowY + dy[i];

			if (nextX >= 0 && nextY >= 0 && nextX < map.length && nextY < map[0].length) {
				if (!visited[map[nextX][nextY] - 'A']) {
					oper(nextX, nextY, length + 1);
				}
			}
		}

		visited[map[nowX][nowY] - 'A'] = false;

	}
}
