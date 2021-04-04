package com.kkh.codinginterview.ch09.sub01_array_string;

public class Practice1_7 {
    /*
   1.7 행렬 회전 : 이미지를 표현하는 N*N 행렬이 있다. 이미지를 90도 회전하는 메서드를 작성
	추가 행렬을 사용하지 않고 구현
     */
    public static void main(String args[]) {
        new Practice1_7();
    }

    public Practice1_7() {
        solution(4);
    }

    private void solution(int N) {
        int arr[][] = new int[N][N];
        int value = 1;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = value++;
            }
        }
        for (int i = 0; i < arr.length / 2; i++) {
            int first = i;
            int last = arr.length - 1 - first;

            int tmp[] = arr[i];
            for (int j = first; j < last; j++) {
                // top to tmp
                int offset = i - first;
                int top = arr[first][i];

                // left tp top
                arr[first][i] = arr[last - offset][first];
                // bottom to left
                arr[last - offset][first] = arr[last][last - offset];
                // right to bottom
                arr[last][last - offset] = arr[i][last];
                // tmp to left
                arr[j][last] = top;

            }
            System.out.println();
        }
        print(arr);
    }


    private void print(int arr[][]) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
