package problemSolving;

import java.util.*;

public class Solution {

    public String[] solution(String[] players, String[] callings) {
        String[] answer = new String[players.length];

        HashMap<String, Integer> mappedByPlayer = new HashMap<>();
        HashMap<Integer, String> mappedByRank = new HashMap<>();

        // 각각의 맵을 초기화
        for (int i = 0; i < players.length; i++) {
            mappedByPlayer.put(players[i], i);
            mappedByRank.put(i, players[i]);
        }

        for (int i = 0; i < callings.length; i++) {

            // 추월한 유저 순위
            // 추월한 유저 이름
            int currentRank = mappedByPlayer.get(callings[i]);
            String player = mappedByRank.get(currentRank);

            // 바로 앞 플레이어
            String frontPlayer = mappedByRank.get(currentRank - 1);

            // swap
            mappedByPlayer.put(player, currentRank - 1);
            mappedByPlayer.put(frontPlayer, currentRank);

            mappedByRank.put(currentRank - 1, player);
            mappedByRank.put(currentRank, frontPlayer);
        }

        for (int i = 0; i < players.length; i++) {
            answer[i] = mappedByRank.get(i);
        }

        return answer;
    }

    public static void main(String[] args) {

        Solution sol = new Solution();
        String[] players = {"mumu", "soe", "poe", "kai", "mine"};
        String[] callings = {"kai", "kai", "mine", "mine"};
        String[] ret1 = sol.solution(players, callings);

        System.out.println("solution 메소드의 반환 값은 \"" + ret1 + "\" 입니다.");
    }
}