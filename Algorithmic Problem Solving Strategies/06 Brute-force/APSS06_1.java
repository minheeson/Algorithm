package apss06_1;

public class APSS06_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(sum(10));
		System.out.println(recursiveSum(10));

	}

	static int sum(int n) {
		int ret = 0;
		for (int i = 1; i <= n; i++) {
			ret += i;
		}

		return ret;
	}

	static int recursiveSum(int n) {
		if (n == 1)
			return 1; // 더이상 쪼개지지 않을 때     
		return n + recursiveSum(n - 1);
	}

}
