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