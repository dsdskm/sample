package com.kkh.codinginterview.ch09.sub01_array_string;

public class Practice1_8 {
    /*
    1.8 0 행렬 : M*N 행렬의 한 원소가 0일 경우, 해당 원소가 속한 행과 열의 모든 원소를 0으로 설정하는 알고리즘을 작성
     */
    public static void main(String args[]) {
        new Practice1_8();
    }

    public Practice1_8() {
        solution(5, 4);
    }

    private void solution(int M, int N) {
        int arr[][] = new int[M][N];
        int value = 1;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                arr[i][j] = value++;
            }
        }
        arr[2][2] = 0;

        int index1 = 0;
        int index2 = 0;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (arr[i][j] == 0) {
                    index1 = i;
                    index2 = j;
                    break;
                }
            }
        }

        for (int i = 0; i < M; i++) {
            arr[i][index1] = 0;
        }
        for (int i = 0; i < N; i++) {
            arr[index2][i] = 0;
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
