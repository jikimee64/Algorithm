package main.java.com.soap.ndb.dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/14888
public class NDB_Part03_연산자끼워넣기 {

    static List<Integer> list = new ArrayList<>();
    static int N = 0;
    static int[] op = new int[4]; //덧셈, 뺄셈, 곱셈, 나눗셈 개수
    static int max = 10_0000_0000 * -1;
    static int min = 10_0000_0000;

    public static void dfs(int result, int count) {

        if (count == N) {
            max = Math.max(max, result);
            min = Math.min(min, result);
        } else {
            if (op[0] > 0) {
                op[0]--;
                dfs(result + list.get(count), count + 1);
                op[0]++;
            }
            if (op[1] > 0) {
                op[1]--;
                dfs(result - list.get(count), count + 1);
                op[1]++;
            }
            if (op[2] > 0) {
                op[2]--;
                dfs(result * list.get(count), count + 1);
                op[2]++;
            }
            if (op[3] > 0) {
                op[3]--;
                if (result < 0) {
                    dfs((result * -1 / list.get(count)) * -1, count + 1);
                } else {
                    dfs(result / list.get(count), count + 1);
                }
                op[3]++;
            }
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            list.add(Integer.valueOf(st.nextToken()));
        }

        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            op[i] = Integer.parseInt(st2.nextToken());
        }

        dfs(list.get(0), 1);

        System.out.println(max);
        System.out.println(min);

    }
}
