## 00 Getting Started

#### 0.3 배열 회전 

- 배열의 일부를 **오른쪽으로** 1만큼 회전시키는 right_rotate() 함수를 작성 


  ```java
  static void rotate_right(int[] input, int s, int t) {
  		int last = input[t];
  		for (int i = t - 1; i >= s; i--) {
  			input[i + 1] = input[i];
  		}
  		input[s] = last;
  	}
  ```

- 배열의 일부를 **왼쪽으로** 1만큼 회전시키는 left_roate() 함수를 작성 

  ```java
  static void rotate_left(int[] input, int s, int t) {
  		int first = input[s];
  		for (int i = s + 1; i <= t; i++) {
  			input[i - 1] = input[i];
  		}
  		input[t] = first;
  	}
  ```

- k를 인자로 받아서 **k만큼 오른쪽으로** 회전시키는 함수를 작성 

