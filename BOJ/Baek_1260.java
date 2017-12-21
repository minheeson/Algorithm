package baek_1260;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Baek_1260 {

	public static int[][] map;
	public static boolean[] visited;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int ver = sc.nextInt();
		int edge = sc.nextInt();
		int start = sc.nextInt();
		map = new int[ver][ver];
		visited = new boolean[ver];

		for (int i = 0; i < edge; i++) {
			int tempX = sc.nextInt();
			int tempY = sc.nextInt();

			map[tempX - 1][tempY - 1] = 1;
			map[tempY - 1][tempX - 1] = 1;
		}

		operDFS(start - 1);

		for (int i = 0; i < visited.length; i++) {
			visited[i] = false;
		}
		System.out.println();
		operBFS(start - 1);

	}

	public static void operDFS(int start) {
		visited[start] = true;
		System.out.print((start + 1) + " ");

		for (int i = 0; i < map.length; i++) {
			if (map[start][i] == 1 && !visited[i]) {
				operDFS(i);
			}
		}
	}

	public static void operBFS(int start) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(start);
		visited[start] = true;
		System.out.print((start + 1) + " ");

		while (!queue.isEmpty()) {
			int nowX = queue.remove();
			for (int i = 0; i < map.length; i++) {
				if (map[nowX][i] == 1 && !visited[i]) {
					queue.add(i);
					visited[i] = true;
					System.out.print((i + 1) + " ");
				}
			}
		}

	}

}
