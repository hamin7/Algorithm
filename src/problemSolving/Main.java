package problemSolving;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Solution s = new Solution();
        String today = "2022.05.19";
        String[] terms = {"A 6", "B 12", "C 3"};
        String[] privacies = {"2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"};
        s.solution(today, terms, privacies);
    }
}

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        HashMap<Character, Integer> temrsMap = mkTermsMap(terms);

//        String[] expireDates = calculateExpireDates(terms, privacies);

        int[] answer = {};
        return answer;
    }

    static HashMap<Character, Integer> mkTermsMap(String[] terms) {
        HashMap<Character, Integer> termsMap = new HashMap<>();
        for (int i = 0; i < terms.length; i++) {
            String[] term = terms[i].split(" ");
            Character termKind = term[0].charAt(0);
            Integer validity = Integer.parseInt(term[1]);
            termsMap.put(termKind, validity);
        }
        return termsMap;
    }

//    static String[] calculateExpireDates(String[] terms, String[] privacies) {
//
//    }
}