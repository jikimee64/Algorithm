package main.java.com.soap.baekjoon.stage.three_for;

import java.io.*;

public class BJ_15552 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        /*
        String[] arr = new String[T];

        for(int i = 0; i < T; i++){
            String temp = br.readLine();
            arr = temp.split(" ");

            int a = Integer.parseInt(arr[0]);
            int b = Integer.parseInt(arr[1]);

            bw.write(a+b+"\n");
        }
        bw.flush();
        bw.close(); */

        //방법2(방법1과는 StringTokenizer을 썻냐 안썻냐의 차이)
       /* StringTokenizer st;

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine()," ");
            bw.write((Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken()))+ "\n");
        }
        br.close();

        bw.flush();
        bw.close();*/

        //방법3 StringBuilder
      /*  StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine()," ");
            sb.append(Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken())).append('\n');
        }
        br.close();

        System.out.println(sb);*/

        //방법4
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < T; i++) {
            String str = br.readLine();
            int target = str.indexOf(" ");
            int result = Integer.parseInt(str.substring(0,target)) + Integer.parseInt(str.substring(target + 1));
            sb.append(result+"\n");
        }

        br.close();
        System.out.print(sb);



    }

}

//https://st-lab.tistory.com/30
