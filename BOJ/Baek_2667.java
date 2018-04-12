package baek_2667;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Baek_2667 {

	static int n;
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = { 1, -1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		map = new int[n][n];
		visited = new boolean[n][n];

		for (int i = 0; i < n; i++) {
			String tmp = sc.next();
			for (int j = 0; j < n; j++) {
				map[i][j] = tmp.charAt(j) - '0';
			}
		}

		int num = 1;
		ArrayList<Integer> list = new ArrayList<Integer>();

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (!visited[i][j] && map[i][j] == 1) {
					int a = bfs(i, j, num++);
					list.add(a);
				}
			}
		}

		int[] answer = new int[list.size()];
		for (int i = 0; i < answer.length; i++) {
			answer[i] = list.get(i);
		}

		Arrays.sort(answer);

		System.out.println(answer.length);
		for (int i = 0; i < answer.length; i++) {
			System.out.println(answer[i]);
		}

	}

	static int bfs(int x, int y, int num) {

		Queue<Node> q = new LinkedList<Node>();
		q.add(new Node(x, y));
		visited[x][y] = true;
		int ans = 1;

		while (!q.isEmpty()) {
			int nowX = q.peek().x;
			int nowY = q.remove().y;

			for (int i = 0; i < 4; i++) {
				int nextX = nowX + dx[i];
				int nextY = nowY + dy[i];

				if (nextX < 0 || nextX >= n || nextY < 0 || nextY >= n) {
					continue;
				}

				if (visited[nextX][nextY] || map[nextX][nextY] == 0) {
					continue;
				}

				visited[nextX][nextY] = true;
				ans++;
				q.add(new Node(nextX, nextY));

			}
		}

		return ans;

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
