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
        HashMap<Character, Integer> termsMap = mkTermsMap(terms);
        ArrayList<Date> expireDates = calculateExpireDates(termsMap, privacies);
        Date todayDate = mkTodayDate(today);
        ArrayList<Integer> expiredList = cmpTodayExpire(todayDate, expireDates);
        return listToString(expiredList);
    }

    static int[] listToString(ArrayList<Integer> expiredList) {
        int[] answer = new int[expiredList.size()];
        for (int i = 0; i < expiredList.size(); i++) {
            answer[i] = expiredList.get(i);
//            System.out.println(answer[i]);
        }
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

    static ArrayList<Date> calculateExpireDates(HashMap<Character, Integer> termsMap, String[] privacies) {
        ArrayList<Date> expireDates = new ArrayList<>();
        for(int i = 0; i < privacies.length; i++) {
            String[] privacy = privacies[i].split(" ");
            int year = Integer.parseInt(privacy[0].substring(0, 4));
            int month = Integer.parseInt(privacy[0].substring(5, 7));
            int day = Integer.parseInt(privacy[0].substring(8, 10));

            month += termsMap.get(privacy[1].charAt(0));
            if (month > 12) {
                year++;
                month -= 12;
            }
            Date date = new Date(year, month, day);
            expireDates.add(date);
        }
        return expireDates;
    }

    static Date mkTodayDate(String today) {
        int year = Integer.parseInt(today.substring(0, 4));
        int month = Integer.parseInt(today.substring(5, 7));
        int day = Integer.parseInt(today.substring(8, 10));
        return new Date(year, month, day);
    }

    static ArrayList<Integer> cmpTodayExpire(Date todayDate, ArrayList<Date> expireDates) {
        ArrayList<Integer> expireList = new ArrayList<>();
        int index = 1;

        for (Date expire : expireDates) {
            if (expire.year < todayDate.year) {
                expireList.add(index);
            }
            if ((expire.year == todayDate.year) && (expire.month < todayDate.month)) {
                expireList.add(index);
            }
            if ((expire.year == todayDate.year) && (expire.month == todayDate.month) && (expire.day <= todayDate.day)) {
                expireList.add(index);
            }
            index++;
        }

        return expireList;
    }

    static class Date {
        int year, month, day;
        Date(int year, int month, int day) {
            this.year = year;
            this.month = month;
            this.day = day;
        }
    }
}