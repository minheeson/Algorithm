## 06-4 PICNIC

### 문제 : 소풍 (문제 ID : PICNIC)

> 안드로메다 유치원 익스프레스반에서는 다음 주에 율동공원으로 소풍을 갑니다. 원석 선생님은 소풍 때 학생들을 두 명씩 짝을 지어 행동하게 하려고 합니다. 그런데 서로 친구가 아닌 학생들끼리 짝을 지어 주면 서로 싸우거나 같이 돌아다니지 않기 때문에, 항상 서로 친구인 학생들끼리만 짝을 지어 줘야 합니다.
>
> 각 학생들의 쌍에 대해 이들이 서로 친구인지 여부가 주어질 때, 학생들을 짝지어줄 수 있는 방법의 수를 계산하는 프로그램을 작성하세요. 짝이 되는 학생들이 일부만 다르더라도 다른 방법이라고 봅니다. 

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