package swex_1500;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SWEX_1953_3 {

	// 상 하 좌 우
	static boolean[][] pipe = { { false, false, false, false }, { true, true, true, true },
			{ true, true, false, false }, { false, false, true, true }, { true, false, false, true },
			{ false, true, false, true }, { false, true, true, false }, { true, false, true, false } };

	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static int[][] map;

	static boolean[][] visited;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		int t = 1;

		while (t <= tc) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			int r = sc.nextInt();
			int c = sc.nextInt();
			int l = sc.nextInt();

			map = new int[n][m];

			visited = new boolean[n][m];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					map[i][j] = sc.nextInt();
				}
			}

			System.out.println("#" + (t++) + " " + oper(r, c, l));

		}
	}

	static int oper(int x, int y, int time) {
		Queue<Node> q = new LinkedList<Node>();
		q.add(new Node(x, y, 1)); // 시작
		int ans = 0;

		while (!q.isEmpty()) {
			int nowX = q.peek().x;
			int nowY = q.peek().y;
			int p = map[nowX][nowY];
			int nowT = q.remove().time;
			
			//System.out.println(nowX +" " + nowY +" " + nowT);
			visited[nowX][nowY] = true;

			if (nowT > time) {
				break;
			}
			ans++;

			for (int i = 0; i < 4; i++) { // 다음 위치 (상 하 좌 우)
				int nextX = nowX + dx[i];
				int nextY = nowY + dy[i];

				if (nextX < 0 || nextY < 0 || nextX >= map.length || nextY >= map[0].length) {
					continue;
				}

				if (visited[nextX][nextY]) {
					continue;
				}

				if (map[nextX][nextY] == 0) {
					continue;
				}

				if (!pipe[p][i]) {
					continue;
				}

				if (i == 0) {
					if (!pipe[map[nextX][nextY]][1]) {
						continue;
					}
				} else if (i == 1) {
					if (!pipe[map[nextX][nextY]][0]) {
						continue;
					}
				} else if (i == 2) {
					if (!pipe[map[nextX][nextY]][3]) {
						continue;
					}
				} else {
					if (!pipe[map[nextX][nextY]][2]) {
						continue;
					}
				}

				q.add(new Node(nextX, nextY, nowT + 1));
				visited[nextX][nextY] = true;

			}
		}

		return ans;

	}

	static class Node {
		int x;
		int y;
		int time;

		Node(int x, int y, int time) {
			this.x = x;
			this.y = y;
			this.time = time;
		}
	}

}
