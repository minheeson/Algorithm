package baek_10971;

import java.util.ArrayList;
import java.util.Scanner;

public class Baek_10971 {

	static boolean[] visited;
	static int n; // 도시의 수
	static int[][] cost;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();

		cost = new int[n][n];
		visited = new boolean[n];
		ArrayList<Integer> path = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				cost[i][j] = sc.nextInt();
			}
			visited[i] = false;
		}

		path.add(0);
		System.out.println(shortestPath(path, 0));

	}

	static int shortestPath(ArrayList<Integer> path, int curLength) {

		if (path.size() == n) {
			return curLength + cost[path.get(path.size() - 1)][0];
		}

		int ret = Integer.MAX_VALUE;

		for (int next = 1; next < n; next++) {

			if (visited[next])
				continue;
			System.out.println("next :: " + next);

			int here = path.get(path.size() - 1);
			System.out.println("here :: " + here);
			if (cost[here][next] == 0)
				continue;
			path.add(next);
			visited[next] = true;
			int cand = shortestPath(path, curLength + cost[here][next]);
			System.out.println("<cand> :: " + cand);
			ret = Math.min(ret, cand);
			visited[next] = false;
			System.out.println("----------------  " + next + " 지워짐  ");
			path.remove(path.size() - 1);
		}

		return ret;
	}

}
