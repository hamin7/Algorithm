package problemSolving;

import java.util.*;

public class Solution {
    HashMap<Integer, Integer> map = new HashMap<>();

    public int solution(int k, int[] tangerine) {

        for (int each : tangerine) {
            map.put(each, map.getOrDefault(each, 0) + 1);
        }

        List<Integer> quantityList = mapToList(map);
        quantityList.sort(Comparator.reverseOrder());

        return packaging(quantityList, k);
    }

    public List<Integer> mapToList(HashMap<Integer, Integer> map) {
        return new ArrayList<>(map.values());
    }

    public int packaging(List<Integer> quantityList, int k) {
        int cnt = 0;
        int idx = 0;
        while (k > 0) {
            k -= quantityList.get(idx);
            idx++;
            cnt++;
        }
        return cnt;
    }

    public static void main(String[] args) {

        Solution sol = new Solution();
        int k = 6;
        int[] arr = {1, 3, 2, 5, 4, 5, 2, 3};
        int ret1 = sol.solution(k, arr);

        System.out.println("solution 메소드의 반환 값은 \"" + ret1 + "\" 입니다.");
    }
}