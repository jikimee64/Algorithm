package main.java.com.soap.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class game_1926 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        for(int i = 1; i <= n; i++){
            if(String.valueOf(i).contains("3") || String.valueOf(i).contains("6") || String.valueOf(i).contains("9")){
                int count = 0;
                int temp = i;

                while(temp > 0){
                    int num = temp % 10;
                    if(num == 3 || num == 6 || num == 9){
                        count++;
                    }
                    temp = temp / 10;
                }

                for(int j = 0; j < count; j++){
                    sb.append("-");
                }
                sb.append(" ");
            }else{
                sb.append(i + " ");
            }
        } //for문
        System.out.println(sb.toString());
    }
}
