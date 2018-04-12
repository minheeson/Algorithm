package swex_2382;

import java.util.ArrayList;
import java.util.Scanner;

public class SWEX_2382 {

	static int[] dx = { 0, -1, 1, 0, 0 };
	static int[] dy = { 0, 0, 0, -1, 1 };
	static int n;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		int t = 1;
		while (t <= tc) {
			n = sc.nextInt(); // map
			int m = sc.nextInt(); // m 시간 후
			int k = sc.nextInt(); // 미생물 군집

			int[][] bug = new int[k][4]; // 세로위치, 가로위치, 군집 수, 이동방향 (1, 2, 3, 4)
			int[][] map = new int[n][n];
			int[][] count = new int[n][n];

			for (int i = 0; i < k; i++) {
				for (int j = 0; j < 4; j++) {
					bug[i][j] = sc.nextInt();
				}
				map[bug[i][0]][bug[i][1]] = i;
			}

			cleanMap(map);

			while (m-- > 0) {

				// 위치 바꿔
				for (int i = 0; i < k; i++) {
					int nowX = bug[i][0];
					int nowY = bug[i][1];
					int nextX = nowX + dx[bug[i][3]];
					int nextY = nowY + dy[bug[i][3]];

					if (bug[i][2] == 0) { // 마리수 0이면 죽은애
						continue;
					}

					if (nextX < 0 || nextY < 0 || nextX >= n || nextY >= n) {
						continue;
					}

					bug[i][0] = nextX;
					bug[i][1] = nextY;

					count[nextX][nextY]++;
				}

				cleanMap(map);

				ArrayList<Integer> node[][] = new ArrayList[n][n];

				for (int i = 0; i < n; i++) {
					for (int j = 0; j < n; j++) {
						node[i][j] = new ArrayList<Integer>();
					}
				}

				// bug[][] 이동 후, 한번에 처리
				for (int i = 0; i < k; i++) {

					if (bug[i][2] == 0) {
						continue;
					}

					int nextX = bug[i][0];
					int nextY = bug[i][1];

					// 약에 걸린경우 먼저 처리하고 continue;
					if (map[nextX][nextY] == -2) {
						bug[i][2] /= 2;
						if (bug[i][3] == 3 || bug[i][3] == 1) {
							bug[i][3]++;
						} else if (bug[i][3] == 2 || bug[i][3] == 4) {
							bug[i][3]--;
						}

						continue;
					}

					/*------------------------------------------------------*/

					if (count[nextX][nextY] > 1) { // 합쳐지는 경우
						node[nextX][nextY].add(i);

					} else { // 그냥 이동
						map[nextX][nextY] = i;
						continue;
					}

				}

				// ArrayList 처리
				for (int i = 0; i < n; i++) {
					for (int j = 0; j < n; j++) {
						if (count[i][j] > 1) {

							int maxSum = bug[node[i][j].get(0)][2];
							int sum = maxSum;
							int maxIndex = node[i][j].get(0);

							for (int l = 1; l < node[i][j].size(); l++) {
								if (maxSum < bug[node[i][j].get(l)][2]) {
									maxSum = bug[node[i][j].get(l)][2];
									maxIndex = node[i][j].get(l);
								}
								sum += bug[node[i][j].get(l)][2];
							}

							for (int l = 0; l < node[i][j].size(); l++) {
								if (node[i][j].get(l) == maxIndex) {

									bug[maxIndex][2] = sum;

								} else {
									bug[node[i][j].get(l)][2] = 0;
								}

							}

						}
					}
				}

				cleanCount(count);

			}

			int ans = 0;
			for (int i = 0; i < k; i++) {
				ans += bug[i][2];
			}

			System.out.println("#" + (t++) + " " + ans);
		}

	}

	static void cleanMap(int[][] map) {

		for (int i = 0; i < n; i++) {
			map[0][i] = -2;
			map[n - 1][i] = -2;
			map[i][0] = -2;
			map[i][n - 1] = -2;
		}

		for (int i = 1; i < n - 1; i++) {
			for (int j = 1; j < n - 1; j++) {
				map[i][j] = -1;
			}
		}

	}

	static void cleanCount(int[][] count) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				count[i][j] = 0;
			}
		}
	}

}
