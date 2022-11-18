package problemSolving;

// 다음과 같이 import를 사용할 수 있습니다.
import java.util.*;

class Main {
    static ArrayList<Integer> sumList = new ArrayList<>();
    public int solution(int[] arr, int K) {
        int answer = 0;
        boolean[] visited = new boolean[arr.length];
        combination(arr, visited, 0, arr.length, K);

        return cntKs(K);
    }

    public static void combination(int[] arr, boolean[] visited, int start, int n, int r) {

        if (r == 0) {
            sumList.add(sumAllFactor(arr, visited, n));
            return;
        }

        for (int i = start; i < n; i++) {
            visited[i] = true;
            combination(arr, visited, i + 1, n, r-1);
            visited[i] = false;
        }
    }

    public static int sumAllFactor(int[] arr, boolean[] visited, int n) {
        int sum = 0;
        for (int i = 0; i < n; i++) {
            if (visited[i]) {
                sum += arr[i];
            }
        }
        return sum;
    }

    public int cntKs(int K) {
        int cnt = 0;
        for (int i = 0; i < sumList.size(); i++) {
            if (sumList.get(i) % K == 0) {
                cnt++;
            }
        }
        return cnt;
    }

    // 아래는 테스트케이스 출력을 해보기 위한 main 메소드입니다.
    public static void main(String[] args) {
        Main sol = new Main();
        int[] arr = {1, 2, 3, 4, 5};
        int K = 3;
        int ret = sol.solution(arr, K);


        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("solution 메소드의 반환 값은 " + ret + " 입니다.");
    }
}