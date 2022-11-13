package problemSolving;

class Main {
    int[] dx = {-1, -2, -1, -2, 1, 2, 1, 2};
    int[] dy = {-2, -1, 2, 1, -2, -1, 2, 1};
    public int solution(String pos) {
        int answer = 0;
        int col = (int)(pos.charAt(0) - 'A');
        int row = 8 - (int)(pos.charAt(1) - '0');
        for (int i = 0; i < 8; i++) {
            int nx = row + dx[i];
            int ny = col + dy[i];
            if (nx>=0 && nx<8 && ny>=0 && ny<8)
                answer++;
        }
        return answer;
    }

    // 아래는 테스트케이스 출력을 해보기 위한 main 메소드입니다.
    public static void main(String[] args) {
        Main sol = new Main();
        String pos = "A7";
        int ret = sol.solution(pos);

        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("solution 메소드의 반환 값은 " + ret + " 입니다.");
    }
}