package com.kkh.algo.codejam.online_2019;

import com.kkh.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

import static com.kkh.Utils.*;

public class ProblemA {
    boolean isDebug = true;
    int T = 0;
    String ARR[][];

    public static void main(String args[]) {
        new ProblemA();
    }

    public ProblemA() {
        if (isDebug) {
            fileRead("./data/online2019_1/A/");
            //test("./data/online2019_1/A/P1-data-001.in", "./data/online2019_1/A/P1-data-001.out");

        } else {

        }
        solution(ARR);
    }

    public String solution(String[][] ARR) {
        StringBuilder result = new StringBuilder();

        // 1. 2가지 배열 판 초기화(0,1) 0:black, 1:white
        HashMap<String, Integer> hash = new HashMap<>();
        HashMap<String, Integer> hash2 = new HashMap<>();
        char col[] = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H'};
        int index = 1;
        for (int i = 0; i < col.length; i++) {
            int toggle = i % 2;
            for (int j = 1; j <= 8; j++) {
                //System.out.println("key = " + (col[i] + String.valueOf(j)) + " , value = " + toggle);
                hash.put(col[i] + String.valueOf(j), toggle);
                hash2.put(String.valueOf(index), toggle);
                if (toggle == 0) {
                    toggle = 1;
                } else {
                    toggle = 0;
                }
                index++;
            }
        }
        //printHash(hash2);
        // 2. 색 확인
        // 3. 비교
        for (int i = 0; i < ARR.length; i++) {
            //System.out.println("ARR[i][0]="+ARR[i][0]);
            int result1 = hash.get(ARR[i][0]);
            int result2 = hash2.get(ARR[i][1]);
            String ret = "YES";
            if (result1 != result2) {
                ret = "NO";
            }
            result.append(ret + "\n");
        }

        return result.toString();
    }

    private void fileRead(String folder) {
        String pre = folder;
        ArrayList<String> mInList = new ArrayList<>();
        ArrayList<String> mOutList = new ArrayList<>();
        ArrayList<Test> mTestList = new ArrayList<>();
        for (File file : new File(folder).listFiles()) {
            if (file.isDirectory()) {
                for (File sub : new File(pre + file.getName()).listFiles()) {
                    if (sub.getName().contains(".out")) {
                        mOutList.add(sub.getName());
                    } else if (sub.getName().contains(".in")) {
                        mInList.add(sub.getName());
                    }
                }
            } else {
                if (file.getName().contains(".out")) {
                    mOutList.add(file.getName());
                } else if (file.getName().contains(".in")) {
                    mInList.add(file.getName());
                }
            }
        }

        print(mInList);
        print(mOutList);
        for (int i = 0; i < mInList.size(); i++) {
            mTestList.add(new Test(pre + mInList.get(i), pre + mOutList.get(i)));
        }

        for (int i = 0; i < mTestList.size(); i++) {
            test(mTestList.get(i).input, mTestList.get(i).output);
        }
    }

    public void test(String input, String output) {
        println(input);
        println(output);
        // input
        File file = new File(input);
        try {
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String line = "";
            int line_number = 1;
            int ARR_COUNT = 0;
            while ((line = br.readLine()) != null) {
                if (line_number == 1) {
                    T = Integer.parseInt(line);
                    ARR = new String[T][2];
                } else {
                    String value = line;
                    StringTokenizer st = new StringTokenizer(value, " ");
                    int index = 0;
                    while (st.hasMoreTokens()) {
                        ARR[ARR_COUNT][index++] = st.nextToken();
                    }
                    ARR_COUNT++;

                }
                line_number++;
            }
            br.close();
            fr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // output
        file = new File(output);
        StringBuilder result = new StringBuilder();
        try {
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String line = "";
            while ((line = br.readLine()) != null) {
                result.append(line).append("\n");
            }
            br.close();
            fr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


        if (solution(ARR).equalsIgnoreCase(result.toString())) {
            System.out.println("SUCCESS");
        } else {
            System.out.println("Failed");
            printArr(ARR);
            System.out.println(solution(ARR));
            System.out.println(result);
        }
    }
}
