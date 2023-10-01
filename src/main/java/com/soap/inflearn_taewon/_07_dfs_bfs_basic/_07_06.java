package com.soap.inflearn_taewon._07_dfs_bfs_basic;

public class _07_06 {
    static int n;
    static int[] ch; //이 배열을 부분집합으로 사용하는지 안하는지 체크배열

    public static void main(String[] args) {
        _07_06 T = new _07_06();
        n = 3;
        ch = new int[n + 1];
        T.DFS(1);
    }

    //연습
    public void DFS2(int l) {
        if (l == n + 1) {
            String tmp = "";
            for (int i = 1; i <= n; i++) {
                if (ch[i] == 1) {
                    tmp += (i + " ");
                }
            }
            if (tmp.length() > 0) {
                System.out.println(tmp);
            }
        } else {
            ch[l] = 1;
            DFS(l + 1);
            ch[l] = 0;
            DFS(l + 1);
        }
    }

    public void DFS(int l) {
        if (l == n + 1) {
            String tmp = "";
            for (int i = 1; i <= n; i++) {
                if (ch[i] == 1) {
                    tmp += (i + " ");
                }
            }
            if (tmp.length() > 0) {
                System.out.println(tmp);
            }
        } else {
            ch[l] = 1;
            DFS(l + 1); //왼쪽
            ch[l] = 0;
            DFS(l + 1); //오른쪽
        }
    }

}
