package problemSolving;

class Main {
    public int solution(int[] arr) {
        int increaseCnt = 0;
        int curMax = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i-1] < arr[i]) {
                increaseCnt++;
                if (curMax < increaseCnt) {
                    curMax = increaseCnt;
                }
            } else {
                increaseCnt = 0;
            }
        }
        return curMax+1;
    }

    // 아래는 테스트케이스 출력을 해보기 위한 main 메소드입니다.
    public static void main(String[] args) {
        Main sol = new Main();
        int[] arr = {3, 1, 2, 4, 5, 1, 2, 2, 3, 4};
        int ret = sol.solution(arr);

        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("solution 메소드의 반환 값은 " + ret + " 입니다.");
    }
}