package com.kkh.codingtest.hash;

import org.jetbrains.annotations.NotNull;

import java.util.*;

public class LV3CodingTest_Hash4_Solution {
    /*
    스트리밍 사이트에서 장르 별로 가장 많이 재생된 노래를 두 개씩 모아 베스트 앨범을 출시하려 합니다.
    노래는 고유 번호로 구분하며, 노래를 수록하는 기준은 다음과 같습니다.
    속한 노래가 많이 재생된 장르를 먼저 수록합니다.
    장르 내에서 많이 재생된 노래를 먼저 수록합니다.
    장르 내에서 재생 횟수가 같은 노래 중에서는 고유 번호가 낮은 노래를 먼저 수록합니다.
    노래의 장르를 나타내는 문자열 배열 genres와 노래별 재생 횟수를 나타내는 정수 배열 plays가 주어질 때,
    베스트 앨범에 들어갈 노래의 고유 번호를 순서대로 return 하도록 solution 함수를 완성하세요.
     */
    public static void main(String args[]) {
        String g[];
        int p[];
        g = new String[]{"classic", "pop", "classic", "classic", "pop"};
        p = new int[]{500, 600, 150, 800, 2500};
        answer(g, p);
        g = new String[]{"classic", "pop", "classic", "classic", "pop", "pop", "classic","Jazz","Jazz"};
        p = new int[]{900, 600, 800, 800, 2500, 900, 800,400,2000};
        answer(g, p);
        g = new String[]{"classic", "pop"};
        p = new int[]{500, 700};
        answer(g, p);
        g = new String[]{"classic"};
        p = new int[]{500};
        answer(g, p);
        g = new String[]{"classic","Jazz","Balad"};
        p = new int[]{500,300,700};
        answer(g, p);

    }

    private static void answer(String[] g, int[] p) {
        int res[] = new LV3CodingTest_Hash4_Solution().solution(g, p);
        System.out.println();
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }
        System.out.println();
    }

    public int[] solution(String[] genres, int[] plays) {
        /*
        1. 장르별 총 재생횟수를 위한 hash 생성
        2. 인덱스, 총 재생횟수, 재생횟수 class Comparable 까지 구현하여 리스트 생성
        3. 장르별 리스트를 갖는 hash2 생성
        4. hash2를 순회하면서 각 리스트 별로 1개 or 2개씩 추출하여 결과리스트에 넣음
         */
        int[] answer = {};

        // 장르별 총 재생횟수를 위한 hash
        HashMap<String, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < genres.length; i++) {
            String g = genres[i];
            if (hashMap.containsKey(g)) {
                int count = hashMap.get(g);
                hashMap.replace(g, count + plays[i]);
            } else {
                hashMap.put(g, plays[i]);
            }
        }


        // dto list 생성
        ArrayList<Genres> list = new ArrayList<>();
        for (int i = 0; i < genres.length; i++) {
            String g = genres[i];
            int total = hashMap.get(g);
            list.add(new Genres(g, i, plays[i], total));
        }

        // 총 재생횟수, 재생횟수, 인덱스 순으로 정렬
        Collections.sort(list);
        for (int i = 0; i < genres.length; i++) {
//            System.out.println(list.get(i));
        }

        // 2개씩 빼서 넣음
        int size = list.size();
        if (size == 1) {
            // 전체 곡이 하나인 경우
            int index = list.get(0).index;
            answer = new int[]{index};
        } else {
            // 전체 곡이 하나이상인 경우
            // 장르별 리스트를 hash로 생성
            HashMap<String, ArrayList<Genres>> resultHash = new HashMap<>();
            for (int i = 0; i < list.size(); i++) {
                Genres g = list.get(i);
                if (resultHash.containsKey(g.name)) {
                    ArrayList<Genres> tmp = resultHash.get(g.name);
                    tmp.add(g);
                    resultHash.replace(g.name, tmp);
                } else {
                    ArrayList<Genres> tmp = new ArrayList<>();
                    tmp.add(g);
                    resultHash.put(g.name, tmp);
                }
            }
            // hash를 순회하면서 짝수개씩 총 결과 리스트에 추가
            ArrayList<Genres> resultList = new ArrayList<>();
            Iterator iter = resultHash.keySet().iterator();
            while (iter.hasNext()) {
                String key = String.valueOf(iter.next());
                ArrayList<Genres> gList = resultHash.get(key);
                int gListSize = gList.size();
                if (gListSize > 2) {
                    Genres one = gList.get(0);
                    Genres two = gList.get(1);
                    gList.clear();
                    gList.add(one);
                    gList.add(two);
                }
                resultList.addAll(gList);
            }
            Collections.sort(resultList);
            answer = new int[resultList.size()];
            for (int i = 0; i < resultList.size(); i++) {
                answer[i] = resultList.get(i).index;
            }
        }

        return answer;
    }

    class Genres implements Comparable<Genres> {
        public Genres(String name, int index, int play, int total) {
            this.name = name;
            this.index = index;
            this.play = play;
            this.total = total;
        }

        String name;
        int index;
        int play;
        int total;

        @Override
        public int compareTo(Genres o) {
            if (total < o.total) {
                return 1;
            } else if (total == o.total) {
                if (play < o.play) {
                    return 1;
                } else if (play == o.play) {
                    if (index > o.index) {
                        return 1;
                    } else if (index == o.index) {
                        return 0;
                    } else {
                        return -1;
                    }
                } else {
                    return -1;
                }
            } else {
                return -1;
            }
        }

        @Override
        public String toString() {
            return "Genres{" +
                    "name='" + name + '\'' +
                    ", index=" + index +
                    ", play=" + play +
                    ", total=" + total +
                    '}';
        }
    }
}
