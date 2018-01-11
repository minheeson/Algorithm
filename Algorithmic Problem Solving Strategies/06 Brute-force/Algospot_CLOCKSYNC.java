package algospot_clocksync;

public class Algospot_CLOCKSYNC {

	public static int SWITCHES = 10;
	public static int CLOCKS = 16;
	public static int[][] linked;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// 모든 시계가 12시를 가리키고 있는지 확인한다.
	static boolean areAligned(int[] clocks) {

		for (int i = 0; i < clocks.length; i++) {
			if (clocks[i] != 12)
				return false;
		}
		return true;
	}

	// switchN 번 만큼 스위치를 누른다.
	static void push(int[] clocks, int swtch) {
		for (int clock = 0; clock < CLOCKS; clock++) {
			if (linked[swtch][clock] == 1) {
				clocks[clock] += 3;
				if (clocks[clock] == 15)
					clocks[clock] = 3;
			}

		}
	}

	/**
	 * 
	 * @param clocks : 현재 시계들의 상태    
	 * @param swtch : 이번에 누를 스위치의 번호      
	 * @return : 남은 스위치들을 눌러서 clocks를 12시로 맞출 수 있는 최소 횟수를 반환 
	 * 만약 불가능 하다면 MAX_VALUE 이상의 큰 수를 반환한다.     
	 */
	static int solve(int[] clocks, int swtch) {
		if (swtch == SWITCHES) {
			return areAligned(clocks) ? 0 : Integer.MAX_VALUE;
		}

		// 이 스위치를 0번 누르는 경우부터 3번 누르는 경우까지를 모두 시도한다.
		int ret = Integer.MAX_VALUE;
		for (int cnt = 0; cnt < 4; cnt++) {
			ret = Math.min(ret, cnt + solve(clocks, swtch + 1));
			push(clocks, swtch);
		}

		// push(clocks, swtch)가 네 번 호출되었으니 clocks는 원래와 같은 상태가 된다.
		return ret;
	}
}
