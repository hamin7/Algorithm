package problemSolving;

// 다음과 같이 import를 사용할 수 있습니다.
import java.util.*;

class Main {
    public int solution(int a, int b) {
        ArrayList<Integer> zegob = new ArrayList<>();
        int i = 2;
        while (Math.pow(i, 2) <= b) {
            if (a <= Math.pow(i, 2)) {
                if (isPrime(i))
                    zegob.add((int)Math.pow(i, 2));
            }
            i++;
        }
        ArrayList<Integer> saezegob = new ArrayList<>();
        i = 2;
        while (Math.pow(i, 3) <= b) {
            if (a <= Math.pow(i, 3)) {
                if (isPrime(i))
                    saezegob.add((int)Math.pow(i, 3));
            }
            i++;
        }

        return zegob.size() + saezegob.size();
    }

    public boolean isPrime(int num) {
        int cnt = 0;
        for (int i = 1; i <= num; i++) {
            if (num % i == 0) {
                cnt++;
            }
        }
        if (cnt > 2)
            return false;
        else
            return true;
    }

    // 아래는 테스트케이스 출력을 해보기 위한 main 메소드입니다.
    public static void main(String[] args){
        Main sol = new Main();
        int a = 6;
        int b = 30;
        int ret = sol.solution(a, b);

        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("solution 메소드의 반환 값은 " + ret + " 입니다.");
    }
}