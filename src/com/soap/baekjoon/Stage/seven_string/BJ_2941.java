package com.soap.baekjoon.Stage.seven_string;

import java.io.*;

public class BJ_2941 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String sen = br.readLine().trim();
        String[] arr = new String[]{"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};

        for(int i = 0; i < arr.length; i++) {
            sen = sen.replace(arr[i], "*");
        }

        int result = sen.length();

        bw.write(result + "");
        bw.flush();

        br.close();
        bw.close();
    }
}
