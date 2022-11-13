package problemSolving;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public int solution(int n) {
        int[][] soyongdoli = new int[n][n];
        int i = 0, j = 0;
        int dir = 0;	// dir 0 : →, dir 1 : ↓, dir 2 : ←, dir 3 : ↑
        int num = 1;

        while (true) {
            soyongdoli[i][j] = num;

            if(dir==0 && (j==n-1 || j<n-1 && soyongdoli[i][j+1]!=0))
                dir++;
            else if(dir==1 && (i==n-1 || i<n-1 && soyongdoli[i+1][j]!=0))
                dir++;
            else if(dir==2 && (j==0 || j>0 && soyongdoli[i][j-1]!=0))
                dir++;
            else if(dir==3 && (i==0 || i>0 && soyongdoli[i-1][j]!=0))
                dir=0;

            if(dir==0)j++;
            else if(dir==1)i++;
            else if(dir==2)j--;
            else if(dir==3)i--;

            if(num == Math.pow(n,2)) break;
            num++;
        }

        int answer = 0;
        for (int index = 0; index < n; index++) {
            answer += soyongdoli[index][index];
        }
        return answer;
    }

    // 아래는 테스트케이스 출력을 해보기 위한 main 메소드입니다.
    public static void main(String[] args) {
        Main sol = new Main();
        int n1 = 3;
        int ret1 = sol.solution(n1);
        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("solution 메소드의 반환 값은 " + ret1 + " 입니다.");

        int n2 = 2;
        int ret2 = sol.solution(n2);
        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("solution 메소드의 반환 값은 " + ret2 + " 입니다.");
    }
}