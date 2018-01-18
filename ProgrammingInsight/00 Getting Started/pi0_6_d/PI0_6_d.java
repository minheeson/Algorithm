package pi0_6_d;

// PInsight 0.6.d 연결리스트를 이용하여 스택 자료구조를 구현   
public class PI0_6_d implements Stack {

	Node head;
	Node tail;

	public PI0_6_d() {
		head = tail = null;
	}

	private Node createNode(int item) {
		return new Node(item);
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		if (head == null)
			return true;
		else
			return false;
	}

	@Override
	public void push(int item) {
		// TODO Auto-generated method stub
		if (isEmpty()) {
			head = createNode(item);
			tail = head;
		} else {
			Node node = head;
			while (node.next != null) {
				node = node.next;
			}
			node.next = createNode(item);
			tail = node.next;

		}

	}

	@Override
	public int pop() {
		// TODO Auto-generated method stub
		int popData;
		if (!isEmpty()) {
			popData = tail.item;
			Node node = head;

			if (head == tail) { // 데이터가 1개일 때
				head = tail = null;
			} else { // 데이터가 여러 개 일 때
				while (node.next != null) {
					node = node.next;
				}

				node.next = null;
				tail = node;
			}
			return popData;
		}
		return -1;
	}

	@Override
	public void delere() {
		// TODO Auto-generated method stub

	}

	@Override
	public int peek() {
		// TODO Auto-generated method stub
		return 0;
	}
}
