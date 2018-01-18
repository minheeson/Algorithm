package pi0_6_h;

public class PI0_6_h {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] arr = { -7, 4, -3, 6, 3, -8, 3, 4 };
		System.out.println(selectMax(arr));
		System.out.println(selectMax2(arr));
	}

	static int selectMax(int[] arr) {
		int ret = 0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = i; j < arr.length; j++) {
				int sum = 0;
				for (int k = i; k <= j; ++k) {
					sum += arr[k];
				}
				ret = Math.max(ret, sum);
			}
		}

		return ret;
	}

	static int selectMax2(int[] arr) {
		int ret = 0;

		for (int i = 0; i < arr.length; i++) {
			int sum = 0;
			for (int j = i; j < arr.length; j++) {
				sum += arr[j];
				ret = Math.max(sum, ret);
			}
		}

		return ret;
	}

}
