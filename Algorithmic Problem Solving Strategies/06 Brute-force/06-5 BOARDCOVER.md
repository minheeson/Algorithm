## 06-5 BOARDCOVER

### 문제 : 게임판 덮기 (문제 ID : BOARDCOVER)

> H*W 크기의 게임판이 있습니다. 게임판은 검은 칸과 흰 칸으로 구성된 격자 모양을 하고 있는데 이 중 모든 흰 칸을 3칸짜리 L자 모양의 블록으로 덮고 싶습니다. 이 때 블록들은 자유롭게 회전해서 놓을 수 있지만, 서로 겹치거나, 검은 칸을 덮거나, 게임판 밖으로 나가서는 안 됩니다. 
>
> 게임판이 주어질 때 이를 덮는 방법의 수를 계산하는 프로그램을 작성하세요.

- **중복으로 세는 문제** 
  - 재귀 호출의 각 단계마다 아직 빈 칸 중에서 가장 윗 줄, 그 중에서도 가장 왼쪽에 있는 칸을 덮도록 함 

    ```java
    // 주어진 칸을 덮을 수 있는 네 가지 방법
    // 블록을 구성하는 세 칸의 상대적 위치 (dy, dx)의 목록
    static int[][][] coverType = { 
    	{ { 0, 0 }, { 1, 0 }, { 0, 1 } }, 
    	{ { 0, 0 }, { 0, 1 }, { 1, 1 } }, 
    	{ { 0, 0 }, { 1, 0 }, { 1, 1 } }, 
    	{ { 0, 0 }, { 1, 0 }, { 1, -1 } } 
    };
    ```


- **구현**

  ```java
  // board의 (y, x)를 type번 방법으로 덮거나, 덮었던 블록을 없앤다.
  // delta = 1 이면 덮고, -1 이면 덮었던 블록을 없앤다.
  // 만약 블록이 제대로 덮이지 않은 경우 (게임판 밖으로 나가거나, 겹치거나, 검은 칸을 덮을 때) false를 리턴.
  static boolean set(int[][] board, int y, int x, int type, int delta) {
  	boolean ok = true;
  	for (int i = 0; i < 3; i++) {
  		int ny = y + coverType[type][i][0];
  		int nx = x + coverType[type][i][1];
  		if (ny < 0 || ny >= board.length || nx < 0 || nx <= board[0].length) {
  			ok = false;
  		} else if ((board[ny][nx] += delta) > 1) {
  			ok = false;
  		}
  	}

  	return ok;
  }

  // board의 모든 빈 칸을 덮을 수 있는 방법의 수를 리턴
  // board[i][j] = 1 이미 덮인 칸 혹은 검은 칸
  // board[i][j] = 0 아직 덮이지 않은 칸
  static int cover(int[][] board) {
  	// 아직 채우지 못한 칸 중 가장 윗중 왼쪽에 있는 칸을 찾는다.
  	int y = -1, x = -1;

  	for (int i = 0; i < board.length; i++) {
  		for (int j = 0; j < board[i].length; j++) {
  			if (board[i][j] == 0) {
  				y = i;
  				x = j;
  				break;
  			}
  		}
  		if (y != -1)
  			break;
  	}

  	// 기저 사례 : 모든 칸을 채웠으면 1을 반환한다.
  	if (y == -1)
  		return 1;

  	int ret = 0;
  	for (int type = 0; type < 4; type++) {
  		// 만약 board[y][x] 를 type 형태로 덮을 수 있으면 재귀 호출한다.
  		if (set(board, y, x, type, 1))
  			ret += cover(board);
  		// 덮었던 블록을 치운다.
  		set(board, y, x, type, -1);
  	}

  	return ret;
  }
  ```

  - *set()* 은 *delta* 에 따라 블록을 놓는 역할과 치우는 역할을 같이 할 수 있음 
  - set() 은 해당 위치에 블록을 놓을 수 있는지 여부도 판단함 
    - 과정 중 블록이 두 번 놓인 곳의 나중에 덮었던 블록을 치울 때, *set()* 은 그 자리에 그냥 1을 더함으로써 이 칸에는 두 개의 블록이 겹쳐져 있었다고 표시함 