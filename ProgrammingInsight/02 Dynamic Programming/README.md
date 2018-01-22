## 02 Dynamic Programming

#### 2.1 출근길   

- 동적 프로그래밍 이용 


  ```java
  static void calculate_path(int m, int n) {
  	path[0][0] = map[0][0];
  		
  	for(int i=1; i<m; i++) {
  		if(map[i][0] == 0) {
  			path[i][0]= 0;
  		}else {
  			path[i][0] = path[i-1][0];
  		}
  	}
  		
  	for(int j=1; j<n; j++) {
  		if(map[0][j] == 0) {
  			path[0][j] = 0;
  		}else {
  			path[0][j] = path[0][j-1];
  		}
  	}
  		
  	for(int i=1; i<m; i++) {
  		for(int j=1; j<n; j++) {
  			if(map[i][j] == 0) {
  				path[i][j] =0;
  			}else {
  				path[i][j] = path[i-1][j] + path[i][j-1];
  			}
  		}
  	}
  }
  ```


- 메모이제이션 : 아래로 (top-down) 문제를 해결 
  - 함수를 호출하는 비용이 발생
- **동적 프로그래밍** : 아래에서 위로 *(bottom-up)* 해결 
  - 함수 호출이 없음 



#### 2.3 출근길은 즐거워 

- 동적 프로그래밍 이용 (경로 출력)

  ```java
  static void max_joy(int m, int n) {
  	joy[0][0] = map[0][0];

  	for (int i = 1; i < m; i++) {
  		joy[i][0] = joy[i - 1][0] + map[i][0];
  		from[i][0] = Type.LEFT;
  	}

  	for (int i = 1; i < n; i++) {
  		joy[0][i] = joy[0][i - 1] + map[0][i];
  		from[0][i] = Type.UP;
  	}

  	for (int i = 1; i < m; i++) {
  		for (int j = 1; j < n; j++) {
  			int max = 0;
  			if (joy[i - 1][j] >= joy[i][j - 1]) {
  				max = joy[i - 1][j];
  				from[i][j] = Type.LEFT;
  			} else {
  				max = joy[i][j - 1];
  				from[i][j] = Type.UP;
  			}
  			joy[i][j] = max + map[i][j];
  		}
  	}
  }
  ```

  ​

#### 2.4 부분집합의 합

> 원하는 합과 집합이 주어졌을 때 부분집합을 고르는 것이 가능한지 출력하는 프로그램 작성

- *possible(s, n, m)* : {s[0], s[1], … , s[n-1]} 의 부분집합 중 합이 m인 것이 있으면 1, 아니면 0 

- 동적 프로그래밍 이용

  ```java
  static void possible_sum(int[] s, int n, int m) {
  	for (int i = 0; i < n; i++)
  		memo[i][0] = 1;

  	for (int i = 0; i < m; i++)
  		memo[0][i] = 0;

  	for (int i = 1; i < n; i++) {
  		for (int j = 1; i < m; j++) {
  			memo[i][j] = 0;

  			if (j >= s[i - 1]) {
  				if (memo[i - 1][j - s[i - 1]] == 1) {
  					memo[i][j] = 1;
  				}
  			}
  			if (memo[i - 1][j] == 1) {
  				memo[i][j] = 1;
  			}
  		}
  	}
  }
  ```



#### 2.5 최대 이익 투자

> 투자액과 기업의 개수와 각 기업이 돌려주는 이익이 주어질 때, 투자로 얻을 수 있는 최대 이익을 구하는 프로그램 