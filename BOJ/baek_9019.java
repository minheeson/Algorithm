package baek_9019;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class baek_9019 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int count = sc.nextInt();

		int from, to = 0;
		String[] command = new String[10000];
		boolean[] checked = new boolean[10000];

		while (count > 0) {
			from = sc.nextInt();
			to = sc.nextInt();

			Queue<Integer> queue = new LinkedList<Integer>();

			for (int i = 0; i < command.length; i++) {
				command[i] = "";
				checked[i] = false;
			}

			queue.add(from);
			checked[from] = true;

			while (!queue.isEmpty()) {
				int now = queue.remove();

				int doD = doD(now);
				if (!checked[doD]) {
					checked[doD] = true;
					queue.add(doD);
					command[doD] = command[now] + "D";
				}

				int doS = doS(now);
				if (!checked[doS]) {
					checked[doS] = true;
					queue.add(doS);
					command[doS] = command[now] + "S";
				}

				int doL = doL(now);
				if (!checked[doL]) {
					checked[doL] = true;
					queue.add(doL);
					command[doL] = command[now] + "L";
				}

				int doR = doR(now);
				if (!checked[doR]) {
					checked[doR] = true;
					queue.add(doR);
					command[doR] = command[now] + "R";
				}
			}

			System.out.println(command[to]);
			count--;
		}
	}

	private static int doD(int input) {
		return (input * 2) % 10000;
	}

	private static int doS(int input) {
		if (input == 0)
			return 9999;

		return input - 1;
	}

	private static int doL(int input) {
		int front = input % 1000;
		int back = input / 1000;
		return front * 10 + back;
	}

	private static int doR(int input) {
		int back = input / 10;
		int front = input % 10;

		return front * 1000 + back;
	}

}
