package pi0_6_e;

import java.util.Stack;

// PInsight 0.6.e 스택 두 개를 이용하여 큐를 만드는 방법
public class PI0_6_e {

	static Stack<Integer> inStack = new Stack<>();
	static Stack<Integer> outStack = new Stack<>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		enQueue(0);
		enQueue(1);
		enQueue(2);
		enQueue(3);

		System.out.println(deQueue());
		System.out.println(deQueue());
		System.out.println(deQueue());

		enQueue(4);
		enQueue(5);

		System.out.println(deQueue());
		System.out.println(deQueue());

	}

	static void enQueue(int data) {
		inStack.push(data);
	}

	static int deQueue() {

		if (outStack.isEmpty()) {
			while (!inStack.isEmpty()) {
				outStack.push(inStack.pop());
			}
		}

		return outStack.pop();
	}

}
