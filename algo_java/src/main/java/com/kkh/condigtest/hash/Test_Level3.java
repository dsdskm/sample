package com.kkh.condigtest.hash;

import org.jetbrains.annotations.NotNull;

import java.util.*;

public class Test_Level3 {
    public Test_Level3() {

        System.out.println(solution(new String[]{"classic", "classic", "classic",}, new int[]{500, 600, 150,}));
        System.out.println(solution(new String[]{"classic", "pop", "classic", "classic", "pop",}, new int[]{500, 600, 150, 800, 2500}));
        System.out.println(solution(new String[]{"classic", "pop", "classic", "classic", "pop", "pop", "Jazz"}, new int[]{500, 600, 150, 800, 2500, 600, 1600}));
    }

    public static void main(String args[]) {
        new Test_Level3();
    }

    class Song implements Comparable<Song> {
        String type;
        int count;
        int index;
        int priority;

        public Song(String type, int count, int index, int priority) {
            this.type = type;
            this.count = count;
            this.index = index;
            this.priority = priority;
        }

        @Override
        public int compareTo(@NotNull Song o) {
            if (priority < o.priority) {
                return -1;
            } else if (priority == o.priority) {
                if (count > o.count) {
                    return -1;
                } else if (count == o.count) {
                    if (index < o.index) {
                        return -1;
                    }
                }
            }
            return 1;
        }

        @Override
        public String toString() {
            return "Song{" +
                    "type='" + type + '\'' +
                    ", count=" + count +
                    ", index=" + index +
                    ", priority=" + priority +
                    '}';
        }
    }

    class Genre implements Comparable<Genre> {
        String genres;
        int count;

        public Genre(String genres, int count) {
            this.genres = genres;
            this.count = count;
        }

        @Override
        public int compareTo(@NotNull Genre o) {
            if (count > o.count) {
                return -1;
            }
            return 1;
        }

        @Override
        public String toString() {
            return "Genre{" +
                    "genres='" + genres + '\'' +
                    ", count=" + count +
                    '}';
        }
    }


    public int[] solution(String[] genres, int[] plays) {
        int[] answer = {};

        /*
        1. 장르별 재생 횟수 계산
        2. ArrayList 추가
        3. 장르 sorting
        4. sorting된 장르값 ArrayList update
        5. 전체 리스트 순회하면서 장르별루 2개이하씩만 cut하여 리스트 생성
        */

        HashMap<String, Integer> hash = new HashMap<>();
        HashMap<String, Integer> priorityHash = new HashMap<>();
        ArrayList<Song> list = new ArrayList<>();
        for (int i = 0; i < genres.length; i++) {
            String g = genres[i];
            int count = plays[i];
            list.add(new Song(g, count, i, 0));
            if (hash.containsKey(g)) {
                int current_count = hash.get(g);
                current_count += count;
                hash.replace(g, current_count);
            } else {
                hash.put(g, count);
            }
        }

        ArrayList<Genre> genrelist = new ArrayList<>();
        Iterator iter = hash.keySet().iterator();
        while (iter.hasNext()) {
            String key = (String) iter.next();
            int count = hash.get(key);
            genrelist.add(new Genre(key, count));
        }

        Collections.sort(genrelist);
        for (int i = 0; i < genrelist.size(); i++) {
            Genre g = genrelist.get(i);
            priorityHash.put(g.genres, i);
        }

        for (int i = 0; i < list.size(); i++) {
            list.get(i).priority = priorityHash.get(list.get(i).type);
        }
        Collections.sort(list);

        // 배열에 삽입

        HashMap<String, Integer> countHash = new HashMap<>();
        ArrayList<Song> resultList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            Song s = list.get(i);
            if (countHash.containsKey(s.type)) {
                int count = countHash.get(s.type);
                if (count >= 2) {
                    continue;
                }
                resultList.add(s);
                count++;
                countHash.replace(s.type, count);
            } else {
                countHash.put(s.type, 1);
                resultList.add(s);
            }
        }
        Collections.sort(resultList);
        answer = new int[resultList.size()];
        for (int i = 0; i < resultList.size(); i++) {
            answer[i] = resultList.get(i).index;
//            System.out.print(answer[i]+ " ");
        }
//        System.out.println();

        return answer;
    }
}
