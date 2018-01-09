## 06 Brute-force

#### 무식하게 풀기 (brute-force)

- 완전 탐색 : 가능한 방법을 전부 만들어보는 알고리즘


#### 재귀 호출과 완전 탐색 

- 컴퓨터가 수행하는 많은 작업들은 대개 작은 조각들로 나누어 볼 수 있는데, 들여다보는 범위가 작아지면 작아질수록 __각 조각들의 형태가 유사해지는__ 작업들을 볼 수 있음 

  - 이런 작업을 구현할 때 유용하게 사용되는 **재귀 함수(recursive function), 재귀 호출(recursion)**

- 재귀 함수 : 자신이 수행할 작업을 유사한 형태의 여러 조각으로 쪼갠 뒤 그 중 한 조각을 수행하고, 나머지를 자기 자신을 호출해 실행하는 함수

- 자연수 n이 주어졌을 때 1부터 n까지의 합을 반환하는 함수 

  ```java
  static int recursiveSum(int n) {
  		if (n == 1)
  			return 1; // 더이상 쪼개지지 않을 때     
  		return n + recursiveSum(n - 1);
  }
  ```

  - 모든 재귀 함수는 이와 같이 **'더이상 쪼개지지 않는' 최소한의 작업에 도달했을 때** 답을 곧장 반환하는 조건문을 포함해야 함
  - 기저 사례 (base case) : 쪼개지지 않는 가장 작은 작업들 

- 재귀 호출은 단순한 반복문보다 **간결하고 유연한 코드 작성**

- n개의 원소 중 m개를 고르는 모든 조합을 찾는 알고리즘 

  ```java
  /**
  	 * @param n : 전체 원소의 수
  	 * @param picked : 지금까지 고른 원소들의 번호
  	 * @param toPick : 더 고를 원소의 수
  	 */
  static void pick(int n, ArrayList<Integer> picked, int toPick) {
  	// 기저 사례 : 더 고를 원소가 없을 때 고른 원소들을 출력   
  	if (toPick == 0) {
  		printPicked(picked);
  		return;
  	}
  		
  	// 고를 수 있는 가장 작은 번호를 계산     
  	int smallest = picked.isEmpty() ? 0 : picked.get(picked.size() - 1) + 1;

  	for (int next = smallest; next < n; ++next) {
  		picked.add(next);
  		pick(n, new ArrayList<Integer>(picked), toPick - 1);
  		picked.remove(picked.size() - 1);
  	}
  }
  ```



#### 예제 : 보글 게임 (문제 ID : BOGGLE)

>보글(Boggle) 게임은 5x5 크기의 알파벳 격자인 게임판의 한 글자에서 시작해서 펜을 움직이면서 만나는 글자를 그 순서대로 나열하여 만들어지는 영어 단어를 찾아내는 게임입니다. 펜은 상하좌우, 혹은 대각선으로 인접한 칸으로 이동할 수 있으며 글자를 건너뛸 수는 없습니다. 지나간 글자를 다시 지나가는 것은 가능하지만, 펜을 이동하지않고 같은 글자를 여러번 쓸 수는 없습니다.
>
>보글 게임판과 알고 있는 단어들의 목록이 주어질 때, 보글 게임판에서 각 단어를 찾을 수 있는지 여부를 출력하는 프로그램을 작성하세요.
>
>hasWord(y, x, word) = 보글 게임판의 (y, x) 에서 시작하는 단어 word의 존재 여부를 반환한다.

- **문제의 분할** 

  - hasWord()가 하는 일을 조각내는 방법은 각 글자를 하나의 조각으로 만드는 것 

- **기저 사례의 선택** 

  - 위치 (y, x)에 있는 글자가 원하는 단어의 첫 글자가 아닌 경우 항상 실패
  - (위의 경우에 해당하지 않을 경우) 원하는 단어가 한 글자인 경우 항상 성공 

- **구현** 

  ```java
  static boolean hasWord(int y, int x, String word) {
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
  		if (hasWord(nextY, nextX, word.substring(1))) {
  			return true;
  		}
  	}
    
  	return false;
  }
  ```

- **시간 복잡도 분석**

  - 완전 탐색은 가능한 답 후보들을 모두 만들어 보기 때문에, 시간 복잡도를 계산하기 위해서는 가능한 후보의 수를 전부 세어 보기만 하면 됨 
  - 마지막 글자에 도달하기 전에는 주변의 모든 칸에 대해 재귀 호출을 하게 됨 
  - 각 칸에는 최대 8개의 이웃이 있고, 탐색은 단어의 길이 *N*에 대해 *N-1*단계 진행됨
  - 따라서, 검사하는 후보의 수는 최대 **8^*N-1* = O(8^*N*)**



#### 완전 탐색 레시피

- 완전 탐색은 존재하는 모든 답을 하나씩 검사하므로, 걸리는 시간은 가능한 답의 수에 정확히 비례
  - 최대 크기의 입력을 가정했을 때 답의 개수를 계산하고 이들을 모두 제한 시간 안에 생성할 수 있을 지를 가늠
- 가능한 모든 답의 후보를 만드는 과정을 여러 개의 선택으로 나눔 (조각)
- 그 중 하나의 조각을 선택해 답의 일부를 만들고, 나머지 답을 재귀 호출을 통해 완성
- 조각이 하나밖에 남지 않은 경우, 혹은 하나도 남지 않은 경우에는 답을 생성했으므로, 이것을 기저 사례로 선택해 처리 


#### 문제 : 소풍 (문제 ID : PICNIC)

>안드로메다 유치원 익스프레스반에서는 다음 주에 율동공원으로 소풍을 갑니다. 원석 선생님은 소풍 때 학생들을 두 명씩 짝을 지어 행동하게 하려고 합니다. 그런데 서로 친구가 아닌 학생들끼리 짝을 지어 주면 서로 싸우거나 같이 돌아다니지 않기 때문에, 항상 서로 친구인 학생들끼리만 짝을 지어 줘야 합니다.
>
>각 학생들의 쌍에 대해 이들이 서로 친구인지 여부가 주어질 때, 학생들을 짝지어줄 수 있는 방법의 수를 계산하는 프로그램을 작성하세요. 짝이 되는 학생들이 일부만 다르더라도 다른 방법이라고 봅니다. 

- **완전 탐색** 
  - 전체 문제를 *n/2* 개의 조각으로 나눠서 한 조각마다 두 학생을 짝지어 줌 


- **구현**

  ```java
  /**
   * 
   * @param taken[i] = i번째 학생이 짝을 이미 찾았으면 true, 아니면 false
   * @return
   */
  static int countPairings(boolean taken[]) {
  	// 남은 학생들 중 가장 번호가 빠른 학생을 찾는다.
  	int firstFree = -1;
  	for (int i = 0; i < n; i++) {
  		if (!taken[i]) {
  			firstFree = i;
  			break;
  		}
  	}

  	// 기저 사례 : 모든 학생이 짝을 찾았으면 한 가지 방법을 찾았으니 종료
  	if (firstFree == -1)
  		return 1;
  	int ret = 0;
  	// 이 학생과 짝지을 학생을 결정
  	for (int pairWith = firstFree + 1; pairWith < n; pairWith++) {
  		if (!taken[pairWith] && areFriends[firstFree][pairWith]) {
  			taken[firstFree] = taken[pairWith] = true;
  			ret += countPairings(taken);
  			taken[firstFree] = taken[pairWith] = false;
  		}
  	}
  	return ret;
  }
  ```

- **중복으로 세는 문제** 

  - 같은 학생 쌍을 두 번 짝지어주는 실수 : (0, 1)과 (1,0)을 따로 세는 것
  - 다른 순서로 학생들을 짝지어 주는 것을 서로 다른 경우로 세는 실수 : (0, 1) 후에 (2, 3)을 짝지어 주는 것과 (2, 3) 후에 (0, 1)을 짝지어주는 것은 완전히 같은 방법 
  - 같은 답을 중복으로 세는 상황에는 **같은 답 중에서 사전순으로 가장 먼저 오는 답** 하나만을 세도록 함 

