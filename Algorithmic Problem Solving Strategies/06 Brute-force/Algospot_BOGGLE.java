package algospot_boggle;

/**
 * algospot ID : BOGGLE
 * @author sonminhee
 *
 */
public class Algospot_BOGGLE {

	static int[] dx = { -1, -1, -1, 1, 1, 1, 0, 0 };
	static int[] dy = { -1, 0, 1, -1, 0, 1, -1, 1 };

	static char[][] board = { { 'U', 'R', 'L', 'P', 'M' }, { 'X', 'P', 'R', 'E', 'T' }, { 'G', 'I', 'A', 'E', 'T' },
			{ 'X', 'T', 'N', 'Z', 'Y' }, { 'X', 'O', 'Q', 'R', 'S' } };

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(hasWord(1, 1, "PRETTY"));

	}

	static boolean hasWord(int y, int x, String word) {
		System.out.println(word);
		// 기저 사례 1 : 시작 위치가 범위 밖이면 실패
		if (!inRange(y, x))
			return false;
		// 기저 사례 2 : 첫 글자가 일치하지 않으면 실패
		if (board[y][x] != word.charAt(0))
			return false;
		// 기저 사례 3 : 단어 길이가 1이면 성공
		if (word.length() == 1)
			return true;

		for (int direction = 0; direction < 8; direction++) {
			int nextY = y + dy[direction];
			int nextX = x + dx[direction];
			System.out.println(nextY + " " + nextX);
			if (hasWord(nextY, nextX, word.substring(1))) {
				return true;
			}

		}

		return false;

	}

	static boolean inRange(int y, int x) {
		if (y < 0 || y > 4 || x < 0 || x > 4) {
			return false;
		} else
			return true;

	}

}
