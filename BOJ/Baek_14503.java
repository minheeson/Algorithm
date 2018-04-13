package baek_14000;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Baek_14503 {

	static int n, m;
	static int count = 1;

	// 북 동 남 서
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static boolean[][] visited;
	static int[][] map;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		visited = new boolean[n][m];
		map = new int[n][m];

		int nowX = sc.nextInt();
		int nowY = sc.nextInt();
		int nowD = sc.nextInt();

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				map[i][j] = sc.nextInt();
			}
		}

		map[nowX][nowY] = 2; // 현재위치청소 
		dfs(nowX, nowY, nowD);
		System.out.println(count);

	}

	static void dfs(int x, int y, int d) {
		int cx, cy, cd = d;

		for (int i = 0; i < 4; i++) {
			cd = (cd + 3) % 4; // 방향의 왼쪽 검사   
			cx = x + dx[cd];
			cy = y + dy[cd];

			if (cx >=n || cx < 0 || cy >=m || cy < 0 || map[cx][cy] == 1) {
				continue;
			}

			if (map[cx][cy] == 0) { // 청소가능   
				count++;
				map[cx][cy] = 2;
				dfs(cx, cy, cd);
				return;

			}
		}

		// 청소할 곳이 없음   
		cd = (d + 2) % 4; // 후진 방향   
		cx = x + dx[cd];
		cy = y + dy[cd];
		if (map[cx][cy] == 1) // 후진했는데 그것마저 벽이야   
			return;
		else
			dfs(cx, cy, d);

	}

}
