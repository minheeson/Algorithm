package baek_9019;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Baek_9019_2 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int count = sc.nextInt();

		while (count-- > 0) {
			int input = sc.nextInt();
			int output = sc.nextInt();

			System.out.println(operDSLR(input, output));
		}

	}

	static String operDSLR(int input, int output) {
		boolean[] check = new boolean[10001];
		Node[] nodes = new Node[10001];
		Queue<Node> queue = new LinkedList<>();
		Node start = new Node(input, "", -1);
		nodes[input] = start;
		check[input] = true;
		queue.add(start);

		while (!queue.isEmpty()) {
			Node now = queue.remove();

			int next = operD(now.value);
			if (!check[next]) {
				Node nextN = new Node(next, "D", now.value);
				check[next] = true;
				nodes[next] = nextN;
				queue.add(nextN);
			}

			next = operS(now.value);
			if (!check[next]) {
				Node nextN = new Node(next, "S", now.value);
				check[next] = true;
				nodes[next] = nextN;
				queue.add(nextN);
			}

			next = operL(now.value);
			if (!check[next]) {
				Node nextN = new Node(next, "L", now.value);
				check[next] = true;
				nodes[next] = nextN;
				queue.add(nextN);
			}

			next = operR(now.value);
			if (!check[next]) {
				Node nextN = new Node(next, "R", now.value);
				check[next] = true;
				nodes[next] = nextN;
				queue.add(nextN);
			}

			if (now.value == output) {
				break;
			}

		}

		StringBuffer sb = new StringBuffer();
		int temp = output;
		while (nodes[temp].preValue != -1) {
			sb.append(nodes[temp].preCommand);
			temp = nodes[temp].preValue;
		}

		return sb.reverse().toString();
	}

	static int operD(int n) {
		if (2 * n > 9999) {
			return (2 * n) % 10000;
		} else {
			return 2 * n;
		}
	}

	static int operS(int n) {
		if (n == 0) {
			return 9999;
		} else {
			return n - 1;
		}
	}

	static int operL(int n) {
		return (n % 1000) * 10 + (int) n / 1000;
	}

	static int operR(int n) {
		return (n % 10) * 1000 + (int) n / 10;
	}

	static class Node {
		String preCommand;
		int value;
		int preValue;

		Node(int value, String preCommand, int preValue) {
			this.value = value;
			this.preCommand = preCommand;
			this.preValue = preValue;
		}
	}

}
