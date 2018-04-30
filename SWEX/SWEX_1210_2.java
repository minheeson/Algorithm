package swex_1000;

import java.util.LinkedList;
import java.util.Queue;

public class SWEX_1210_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[][] map = { { 1, 0, 0, 0, 1, 0, 1, 0, 0, 1 }, { 1, 0, 0, 0, 1, 0, 1, 1, 1, 1 },
				{ 1, 0, 0, 0, 1, 0, 1, 0, 0, 1 }, { 1, 0, 0, 0, 1, 1, 1, 0, 0, 1 }, { 1, 0, 0, 0, 1, 0, 1, 0, 0, 1 },
				{ 1, 1, 1, 1, 1, 0, 1, 1, 1, 1 }, { 1, 0, 0, 0, 1, 0, 1, 0, 0, 1 }, { 1, 1, 1, 1, 1, 0, 1, 0, 0, 1 },
				{ 1, 0, 0, 0, 1, 1, 1, 0, 0, 1 }, { 1, 0, 0, 0, 1, 0, 1, 0, 0, 1 } };

		Queue<Integer> q = new LinkedList<Integer>();
		for (int i = 0; i < 10; i++) {
			if (map[0][i] == 1) {
				q.add(i);
			}
		}

		while (!q.isEmpty()) {
			int nowX = 0;
			int nowY = q.remove();
			System.out.println(nowY);
			int nextX = nowX;
			int nextY = nowY;

			while (nextX != 9) {
				
			}

			System.out.println("출발 지점 : " + nowY + "   도착 지점 : " + nextY);

		}

	}

}
