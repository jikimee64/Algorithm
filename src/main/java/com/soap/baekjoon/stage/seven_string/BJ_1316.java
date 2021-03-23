package main.java.com.soap.baekjoon.stage.seven_string;

import java.io.*;

public class BJ_1316 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {


        int N = Integer.parseInt(br.readLine());
        int count = 0;
        for (int i = 0; i < N; i++) {
            if (check()) {
                count++;
            }
        }
        System.out.print(count);
    }


    public static boolean check() throws IOException {
        boolean[] check = new boolean[26];
        int prev = 0;
        String str = br.readLine();

        for (int i = 0; i < str.length(); i++) {
            int now = str.charAt(i); //i 번째 문장 저장(현재 문자)

            if (prev != now) { //앞선 문자와 i 번째 문자가 같지 않다면
                if (!check[now - 'a']) { //해당 문자가 처음 나오는 경우(false인 경우)
                    check[now - 'a'] = true; //true로 바꿔준다.
                    prev = now; //다음턴을 위해 prev도 바꿔준다
                }
                //해당 문자가 이미 나온 적이 있는 경우(그룹단어가 아니가 됨)
                else {
                    return false; //함수종료
                }
            }
        }
        return true;

    }
}
