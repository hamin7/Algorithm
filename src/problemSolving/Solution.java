package problemSolving;

import java.util.*;

public class Solution {
    public int solution(int x, int y, int n) {
        int result = 1;
        int currentNode = x;
        Set<Integer> nodeSet = new HashSet<>();

        // 처음에 x가 y와 같으면 0 리턴
        if (x == y) return 0;

        // 처음 nodeSet 만들기
        // 연산 1
        currentNode = x + n;
        if (currentNode < y)
            nodeSet.add(currentNode);
        else if (currentNode == y)
            return 1;

        // 연산 2
        currentNode = x * 3;
        if (currentNode < y)
            nodeSet.add(currentNode);
        else if (currentNode == y)
            return 1;

        // 연산 3
        currentNode = x * 2;
        if (currentNode < y)
            nodeSet.add(currentNode);
        else if (currentNode == y)
            return 1;

        // nodeSet에서 node 확장
        mainLoop:
        while (true) {
            result++;
            Set<Integer> newNodeSet = new HashSet<>();

            for (int parentNode : nodeSet) {
                // 연산 1
                currentNode = parentNode + n;
                if (currentNode < y)
                    newNodeSet.add(currentNode);
                else if (currentNode == y)
                    break mainLoop;

                // 연산 2
                currentNode = parentNode * 3;
                if (currentNode < y)
                    newNodeSet.add(currentNode);
                else if (currentNode == y)
                    break mainLoop;

                // 연산 3
                currentNode = parentNode * 2;
                if (currentNode < y)
                    newNodeSet.add(currentNode);
                else if (currentNode == y)
                    break mainLoop;
            }

            // 새로 생긴 노드가 없다면 -1을 리턴
            if (newNodeSet.size() == 0) return -1;

            // nodeSet 최신화
            nodeSet = newNodeSet;
        }

        return result;
    }

    public static void main(String[] args) {

        Solution sol = new Solution();
        int x = 10;
        int y = 40;
        int n = 5;
        long result = sol.solution(x, y, n);

        System.out.println("solution 메소드의 반환 값은 \"" + result + "\" 입니다.");
    }
}