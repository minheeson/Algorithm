package chap_01;

import java.util.LinkedList;
import java.util.Queue;

public class p01_07 {

	static int[][] arr = { { 1, 2, 4, 0 }, { 2, 4, 5, 4 }, { 4, 0, 7, 4 }, { 6, 8, 0, 4 } };

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				System.out.print(arr[i][j] + "\t");
			}
			System.out.println();
		}
		System.out.println();

		checkAns(4, 4);

	}

	static void check(int m, int n) {
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (arr[i][j] == 0) {
					for (int k = 0; k < n; k++) {
						arr[i][k] = 0;
					}

					for (int k = 0; k < m; k++) {
						arr[k][j] = 0;
					}
				}
			}
		}
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				System.out.print(arr[i][j] + "\t");
			}
			System.out.println();
		}

	}

	static void checkAns(int m, int n) {

		Queue<Node> q = new LinkedList<Node>();

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (arr[i][j] == 0) {
					q.add(new Node(i, j));
				}
			}
		}

		while (!q.isEmpty()) {
			int x = q.peek().x;
			int y = q.remove().y;

			for (int i = 0; i < n; i++) {
				arr[x][i] = 0;
			}

			for (int i = 0; i < m; i++) {
				arr[i][y] = 0;
			}
		}

		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				System.out.print(arr[i][j] + "\t");
			}
			System.out.println();
		}
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
