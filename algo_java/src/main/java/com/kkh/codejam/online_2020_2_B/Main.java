package com.kkh.codejam.online_2020_2_B;

import java.util.*;

public class Main {

    public static int T;
    public static int N;
    public static int M;

    ArrayList<Integer> list[];
    boolean visited[];

    public static void main(String args[]) {
        HashSet<Integer> groupA = new HashSet<>();
        HashSet<Integer> groupB = new HashSet<>();
        HashMap<Integer, HashSet<Integer>> hash = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        Scanner scanner = new Scanner(System.in);
        T = scanner.nextInt();
        for (int t = 0; t < T; t++) {
            N = scanner.nextInt();
            M = scanner.nextInt();
            hash.clear();
            groupA.clear();
            groupB.clear();

            for (int i = 0; i < M; i++) {
                int a = scanner.nextInt();
                int b = scanner.nextInt();
//            System.out.println(groupA);
//            System.out.println(groupB);
                if (hash.containsKey(a)) {
                    HashSet<Integer> set = hash.get(a);
                    set.add(b);
                    hash.replace(a, set);
                } else {
                    HashSet<Integer> set = new HashSet<>();
                    set.add(b);
                    hash.put(a, set);
                }
                if (hash.containsKey(b)) {
                    HashSet<Integer> set = hash.get(b);
                    set.add(a);
                    hash.replace(b, set);
                } else {
                    HashSet<Integer> set = new HashSet<>();
                    set.add(a);
                    hash.put(b, set);
                }
                Iterator iterator = hash.keySet().iterator();
                while (iterator.hasNext()) {
                    int key = (int) iterator.next();
//                    System.out.println("key = " + key + " , set = " + hash.get(key));
                }
                if (groupA.isEmpty() && groupB.isEmpty()) {
                    groupA.add(a);
                    groupB.add(b);
                } else {
                    // a를 group A에 넣을 수 있을지
                    HashSet copy = new HashSet(groupA);
                    copy.retainAll(hash.get(a));
//                    System.out.println(copy + " , " + hash.get(a) + " , a = " + a);
                    if (copy.size() >= 1) {
                        // 있다면 패스
                    } else {
                        // 없다면 추가
                        if (!groupB.contains(a)) {
                            groupA.add(a);
                        }
                    }

                    // a를 group B에 넣을 수 있을지
                    copy.clear();
                    copy.addAll(groupB);
                    copy.retainAll(hash.get(a));
                    if (copy.size() >= 1) {

                    } else {
                        if (!groupA.contains(a)) {
                            groupB.add(a);
                        }
                    }

                    // b를 group A에 넣을 수 있을지
                    copy.clear();
                    copy.addAll(groupA);
                    copy.retainAll(hash.get(b));
                    if (copy.size() >= 1) {
                        // 있다면 패스
                    } else {
                        // 없다면 추가
                        if (!groupB.contains(b)) {
                            groupA.add(b);
                        }
                    }

                    // b를 group B에 넣을 수 있을지
                    copy.clear();
                    copy.addAll(groupB);
                    copy.retainAll(hash.get(b));
                    if (copy.size() >= 1) {

                    } else {
                        if (!groupA.contains(b)) {
                            groupB.add(b);
                        }
                    }

                    // 나중에 들어간 것들은 삭제

                    if(groupA.contains(a) && groupA.contains(b)){
                        groupA.remove(a);
                        groupA.remove(b);
                    }
                    if(groupB.contains(a) && groupB.contains(b)){
                        groupB.remove(a);
                        groupB.remove(b);
                    }
                }
//                System.out.println(groupA);
//                System.out.println(groupB);
            }

//            System.out.println(groupA);
//            System.out.println(groupB);
            if (groupA.size() + groupB.size() == N) {
                sb.append("YES");
            } else {
                sb.append("NO");
            }
            if (t != T - 1) {
                sb.append("\n");
            }
        }
        System.out.println(sb.toString());
    }


    public Main() {
        //solution1();
        solution2();

    }

    class Node {
        int a;
        HashSet<Integer> adj = new HashSet<>();
    }

    private void solution2() {
        HashSet<Integer> groupA = new HashSet<>();
        HashSet<Integer> groupB = new HashSet<>();
        HashMap<Integer, HashSet<Integer>> hash = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        Scanner scanner = new Scanner(System.in);
        T = scanner.nextInt();
        for (int t = 0; t < T; t++) {
            N = scanner.nextInt();
            M = scanner.nextInt();
            hash.clear();
            groupA.clear();
            groupB.clear();

            for (int i = 0; i < M; i++) {
                int a = scanner.nextInt();
                int b = scanner.nextInt();
//            System.out.println(groupA);
//            System.out.println(groupB);
                if (hash.containsKey(a)) {
                    HashSet<Integer> set = hash.get(a);
                    set.add(b);
                    hash.replace(a, set);
                } else {
                    HashSet<Integer> set = new HashSet<>();
                    set.add(b);
                    hash.put(a, set);
                }
                if (hash.containsKey(b)) {
                    HashSet<Integer> set = hash.get(b);
                    set.add(a);
                    hash.replace(b, set);
                } else {
                    HashSet<Integer> set = new HashSet<>();
                    set.add(a);
                    hash.put(b, set);
                }
                Iterator iterator = hash.keySet().iterator();
                while (iterator.hasNext()) {
                    int key = (int) iterator.next();
//                    System.out.println("key = " + key + " , set = " + hash.get(key));
                }
                if (groupA.isEmpty() && groupB.isEmpty()) {
                    groupA.add(a);
                    groupB.add(b);
                } else {
                    // a를 group A에 넣을 수 있을지
                    HashSet copy = new HashSet(groupA);
                    copy.retainAll(hash.get(a));
//                    System.out.println(copy + " , " + hash.get(a) + " , a = " + a);
                    if (copy.size() >= 1) {
                        // 있다면 패스
                    } else {
                        // 없다면 추가
                        if (!groupB.contains(a)) {
                            groupA.add(a);
                        }
                    }

                    // a를 group B에 넣을 수 있을지
                    copy.clear();
                    copy.addAll(groupB);
                    copy.retainAll(hash.get(a));
                    if (copy.size() >= 1) {

                    } else {
                        if (!groupA.contains(a)) {
                            groupB.add(a);
                        }
                    }

                    // b를 group A에 넣을 수 있을지
                    copy.clear();
                    copy.addAll(groupA);
                    copy.retainAll(hash.get(b));
                    if (copy.size() >= 1) {
                        // 있다면 패스
                    } else {
                        // 없다면 추가
                        if (!groupB.contains(b)) {
                            groupA.add(b);
                        }
                    }

                    // b를 group B에 넣을 수 있을지
                    copy.clear();
                    copy.addAll(groupB);
                    copy.retainAll(hash.get(b));
                    if (copy.size() >= 1) {

                    } else {
                        if (!groupA.contains(b)) {
                            groupB.add(b);
                        }
                    }

                    // 나중에 들어간 것들은 삭제

                    if(groupA.contains(a) && groupA.contains(b)){
                        groupA.remove(a);
                        groupA.remove(b);
                    }
                    if(groupB.contains(a) && groupB.contains(b)){
                        groupB.remove(a);
                        groupB.remove(b);
                    }
                }
//                System.out.println(groupA);
//                System.out.println(groupB);
            }

//            System.out.println(groupA);
//            System.out.println(groupB);
            if (groupA.size() + groupB.size() == N) {
                sb.append("YES");
            } else {
                sb.append("NO");
            }
            if (t != T - 1) {
                sb.append("\n");
            }
        }
        System.out.println(sb.toString());
    }


    private void solution1() {
        StringBuilder sb = new StringBuilder();
        Scanner scanner = new Scanner(System.in);
        T = scanner.nextInt();
        for (int t = 0; t < T; t++) {
            N = scanner.nextInt();
            M = scanner.nextInt();
            list = new ArrayList[N + 1];
            for (int i = 1; i <= N; i++) {
                list[i] = new ArrayList<>();
            }
            for (int i = 1; i <= M; i++) {
                int u = scanner.nextInt();
                int v = scanner.nextInt();
                list[u].add(v);
                list[v].add(u);
            }
            visited = new boolean[N + 1];
            if (isDfsCycle(1, -1)) {
                sb.append("NO");
            } else {
                sb.append("YES");
            }

            if (t != T - 1) {
                sb.append("\n");
            }

        }
        System.out.print(sb.toString());
    }

    private boolean isDfsCycle(int curr, int parent) {
        visited[curr] = true;
        for (int next : list[curr]) {
            if (!visited[next]) {
                if (isDfsCycle(next, curr)) {
                    return true;
                }
            } else if (next != parent) {
                return true;
            }
        }
        return false;
    }

}
