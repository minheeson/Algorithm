package pi1_8_a;

public class PI1_8_a {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(oper(5, 2));
	}

	static int oper(int n, int k) {
		int sum = 1;
		if (n == 1) {
			return 1;
		}

		for (int i = 0; i < k; i++) {
			sum *= n;
		}
		sum += oper(n - 1, k);
		return sum;
	}

}
