package baek_15000;

import java.util.Scanner;

/**
 * 삼성 2018 상반기 CEIM
 * 
 * @author sonminhee
 *
 */
public class Baek_15686 {

	static int[][] map;
	static boolean[] visited;
	static Chicken[] output;
	static Chicken[] chicken;
	static Person[] person;

	static int m;
	static int answer;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt(); // map size
		m = sc.nextInt(); // 치킨집의 개수

		map = new int[n][n];
		output = new Chicken[m];
		int chCnt = 0;
		int pCnt = 0;
		answer = Integer.MAX_VALUE;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				map[i][j] = sc.nextInt();
				if (map[i][j] == 1) {
					pCnt++;
				}
				if (map[i][j] == 2) {
					chCnt++;
				}
			}
		}

		chicken = new Chicken[chCnt];
		person = new Person[pCnt];
		visited = new boolean[chCnt];
		chCnt = pCnt = 0;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (map[i][j] == 2) {
					chicken[chCnt++] = new Chicken(i, j);
				}
				if (map[i][j] == 1) {
					person[pCnt++] = new Person(i, j);
				}
			}
		}

		for (int i = 0; i < chicken.length; i++) {
			if (!visited[i]) {
				visited[i] = true;
				output[0] = new Chicken(chicken[i].x, chicken[i].y);
				recursion(i, 1);
				visited[i] = false;
			}
		}

		System.out.println(answer);

		long end = System.currentTimeMillis();

	}

	static void recursion(int start, int num) {

		if (num == m) {
			chickenToPerson();

			return;
		}

		for (int i = start; i < chicken.length; i++) {
			if (!visited[i]) {
				visited[i] = true;
				output[num] = new Chicken(chicken[i].x, chicken[i].y);
				recursion(i, num + 1);
				visited[i] = false;
			}
		}

	}

	static void chickenToPerson() {
		int tmp = 0;

		for (int i = 0; i < person.length; i++) {
			int x = person[i].x;
			int y = person[i].y;
			int min = Integer.MAX_VALUE;

			for (int j = 0; j < m; j++) {
				int cx = output[j].x;
				int cy = output[j].y;

				int mx = x - cx;
				int my = y - cy;

				if (mx < 0) {
					mx *= (-1);
				}

				if (my < 0) {
					my *= (-1);
				}

				// System.out.println(mx + " " + my);

				if (min > mx + my) {
					min = mx + my;
				}

			}

			// System.out.println(min);
			person[i].min = min;
			tmp += min;
			if (tmp > answer) {
				return;
			}
		}

		if (tmp < answer) {
			answer = tmp;
		}

	}

	static class Chicken {
		int x;
		int y;

		Chicken(int x, int y) {
			this.x = x;
			this.y = y;
		}

	}

	static class Person {
		int x;
		int y;
		int min;

		Person(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

}
