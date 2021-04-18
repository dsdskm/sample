package com.kkh.algo.coupang;

import java.io.File;
import java.util.HashMap;
import java.util.StringTokenizer;

public class CoupangDemo {
    public static void main(String args[]) {
        System.out.println("main");
        FileSystem fileSystem = new FileSystem();
        System.out.println(fileSystem.createPath("/a", 1));
        System.out.println(fileSystem.get("/a"));
        System.out.println();
        System.out.println(fileSystem.createPath("/leet", 1));
        System.out.println(fileSystem.createPath("/leet/code", 2));
        System.out.println(fileSystem.get("/leet/code"));
        System.out.println("/c/d = " + fileSystem.createPath("/c/d", 1));
        System.out.println(fileSystem.get("/c"));
    }
}

class FileSystem {
    public static final boolean DEBUG_MODE = false;
    private HashMap<String, Integer> mHashMap;
    private String DELIM = "/";

    public FileSystem() {
        mHashMap = new HashMap<>();
        mHashMap.clear();
    }

    private void printText(String text) {
        if (DEBUG_MODE) {
            System.out.println(text);
        }
    }

    public boolean createPath(String path, int value) {
        boolean ret = false;
        StringTokenizer st = new StringTokenizer(path, DELIM);
        String current_path = "";
        StringBuilder sb = new StringBuilder(current_path);
        while (st.hasMoreTokens()) {
            current_path = DELIM + st.nextToken();
            sb.append(current_path);
            boolean hasValue = mHashMap.containsKey(current_path);
            boolean hasMore = st.hasMoreTokens();
            printText("total path = " + sb.toString() + " , hasValue = " + hasValue);

            if (hasValue) {
                // path가 존재
                if (!hasMore) {
                    // 체크할게 없다면
                    ret = true;
                }
            } else {
                if (hasMore) {
                    ret = false;
                    break;
                } else {
                    mHashMap.put(sb.toString(), value);
                    ret = true;
                }
            }
        }
        return ret;
    }

    public int get(String path) {
        if (mHashMap != null && mHashMap.containsKey(path)) {
            return mHashMap.get(path);
        }
        return -1;
    }

    public boolean createPath2(String path, Object value) {
        boolean ret = true;
        StringTokenizer st = new StringTokenizer(path, DELIM);
        File file;
        String current_path = "";
        StringBuilder sb = new StringBuilder(current_path);
        while (st.hasMoreTokens()) {
            // parent -> root
            current_path = DELIM + st.nextToken();
            boolean hasSubFolder = st.hasMoreElements();
            sb.append(current_path);
            file = new File(current_path);
            System.out.println("total path = " + sb.toString() + " , current path = " + current_path + " , hasSubFolder  : " + hasSubFolder);

            if (file.exists()) {
                // 존재한다
                if (hasSubFolder) {
                    // 확인할 서브 폴더가 있으면
                    // 계속
                } else {
                    // 서브 폴더가 없다
                    // 이미 폴더가 존재한다
                    ret = false;
                }
            } else {
                // 존재하지 않는다
                if (hasSubFolder) {
                    // 확인할 서브 폴더가 있으면
                    // 상위 패스가 존재하지 않음
                    ret = false;
                } else {
                    // 확인할 서브 폴더가 없다
                    // 만든다
                    file.mkdir();
                    ret = true;
                }
            }
        }
        return ret;
    }

}
