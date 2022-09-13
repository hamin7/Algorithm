package problemSolving;

import java.io.*;
import java.util.*;

public class Main {

    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N, M;
    static ArrayList<ArrayList> inputBirdList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        input();
        HashMap<Integer, Integer> removedBirdAndMaxDisturb = getMinimumDisturb();

        // Comparator 정의
        Comparator<Map.Entry<Integer, Integer>> comparator = new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> e1, Map.Entry<Integer, Integer> e2) {
                return e1.getValue().compareTo(e2.getValue());
            }
        };

        // Min Value의 key, value
        Map.Entry<Integer, Integer> minEntry = Collections.min(removedBirdAndMaxDisturb.entrySet(), comparator);
        print(minEntry);
    }

    static void input() throws IOException {
        System.setIn(new FileInputStream("/Users/hamin/eclipse-workspace/BaekjoonOnlineJudge/src/problemSolving/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            char direction = st.nextToken().charAt(0);
            String tempSing = st.nextToken();
            ArrayList<Integer> birdSing = new ArrayList<>();
            for (int j = 0; j < M; j++) {
                if ((tempSing.charAt(j) - '0') == 1) {
                    if (direction == 'L') {
                        birdSing.add(-1);
                    } else {
                        birdSing.add(1);
                    }
                } else {
                    birdSing.add(0);
                }
            }
            inputBirdList.add(birdSing);
        }
    }

    static ArrayList<ArrayList> removeOneBird(ArrayList<ArrayList> birdList, int removeIndex) {
        ArrayList<ArrayList> tempList = new ArrayList<>();
        for (int i = 0; i < birdList.size(); i++) {
            tempList.add(birdList.get(i));
        }
        tempList.remove(removeIndex);
        return tempList;
    }

    static HashMap<Integer, Integer> getMinimumDisturb() {
        HashMap<Integer, Integer> removedBirdAndMaxDisturb = new HashMap<>();
        for (int removedIndex = 0; removedIndex < inputBirdList.size(); removedIndex++) {
            // i번째 새를 제거
            ArrayList<ArrayList> removedOneBird = removeOneBird(inputBirdList, removedIndex);
            int maxDisturb = 0;
            if (removedOneBird.size() != 0) {
                maxDisturb = getMaxDisturbSecond(removedOneBird);
            }
            removedBirdAndMaxDisturb.put(removedIndex+1, maxDisturb);          // 새번호 = index +1
        }
        return removedBirdAndMaxDisturb;
    }

    static int getMaxDisturbSecond(ArrayList<ArrayList> list) {
        int maxDisturbSize = 0;
        ArrayList<Integer> disturbAtSecondList = new ArrayList<>();
        int disturbAtSecond = 0;
        for (int second = 0; second < list.get(0).size(); second++) {
            for (int birdNum = 0; birdNum < list.size(); birdNum++) {
                disturbAtSecond += Integer.parseInt(list.get(birdNum).get(second).toString());
            }
            if (disturbAtSecond < 0) {
                //음수이면 절대값 넣기
                disturbAtSecondList.add(disturbAtSecond*(-1));
            } else {
                disturbAtSecondList.add(disturbAtSecond);
            }
        }
        maxDisturbSize = Collections.max(disturbAtSecondList);
        return maxDisturbSize;
    }

    static void print(Map.Entry<Integer, Integer> minEntry) {
        System.out.println(minEntry.getKey());
        System.out.println(minEntry.getValue());
    }
}