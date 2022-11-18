package problemSolving;

// 다음과 같이 import를 사용할 수 있습니다.
import java.util.*;

class Main {
    public int solution(int[] card, int n) {
        int answer = -1;
        Arrays.sort(card);
        HashMap<Integer, Integer> cntEachCard = new HashMap<>();
        for (int i = 0; i < card.length; i++) {
            if (!cntEachCard.containsKey(card[i]))
                cntEachCard.put(card[i], 1);
            else
                cntEachCard.replace(card[i], cntEachCard.get(card[i] + 1));
        }

        int numerator = factorial(card.length);
        int caseCnt = 0;

        if (cntEachCard.size() == 1) {
            caseCnt = numerator / numerator;
        } else if (cntEachCard.size() == 2) {
            if (cntEachCard.containsKey(3)) {
                caseCnt = numerator / 6;
            } else if (cntEachCard.containsValue(2)) {
                caseCnt = numerator / 4;
            }
        } else if (cntEachCard.size() == 3) {
            caseCnt = numerator / 2;
        }

        HashMap<String, Integer> numbers = new HashMap<>();
        int numOfCase = 0;
        while (numOfCase < caseCnt) {
            String str = "";
            Integer[] temp = shuffle(card);
            for (int i = 0; i < temp.length; i++) {
                str += Integer.toString(temp[i]);
            }

            if (!numbers.containsKey(str)) {
                numbers.put(str, 1);
                numOfCase++;
            }
        }

        int[] arr = new int[numbers.size()];
        Iterator<String> ir = numbers.keySet().iterator();
        int i = 0;
        while (ir.hasNext()) {
            arr[i++] = Integer.parseInt(ir.next());
        }
        Arrays.sort(arr);

        for(int k = 0; k < arr.length; k++) {
            if (arr[k] == n) {
                answer = k + 1;
                break;
            }
            if (k == arr.length -1 && answer == 0)
                answer = -1;
        }

        return answer;
    }

    public Integer[] shuffle(int[] arr) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            list.add(arr[i]);
        }
        Collections.shuffle(list);

        return list.toArray(new Integer[list.size()]);
    }

    public int factorial (int num) {
        if (num > 1)
            return factorial(num -1) * num;
        else
            return 1;
    }

    // 아래는 테스트케이스 출력을 해보기 위한 main 메소드입니다.
    public static void main(String[] args) {
        Main sol = new Main();
        int card1[] = {1, 2, 1, 3};
        int n1 = 1312;
        int ret1 = sol.solution(card1, n1);

        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("solution 메소드의 반환 값은 " + ret1 + " 입니다.");

        int card2[] = {1, 1, 1, 2};
        int n2 = 1122;
        int ret2 = sol.solution(card2, n2);

        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("solution 메소드의 반환 값은 " + ret2 + " 입니다.");
    }
}