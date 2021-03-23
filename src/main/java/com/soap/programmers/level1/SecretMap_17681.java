package main.java.com.soap.programmers.level1;

import java.util.ArrayList;
import java.util.List;

public class SecretMap_17681 {

    //내풀이
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        int[][] map1 = new int[n][n];
        int[][] map2 = new int[n][n];
        int[][] result = new int[n][n];

        int map1_index = 0;
        int map2_index = 0;

        for(int num : arr1){
            //System.out.println("num : " + num);
            String binaryString = String.format("%0"+n+"d", Long.parseLong(Integer.toBinaryString(num)));
            //System.out.println("ss : " + binaryString);
            for(int i = 0; i < n; i++){
                map1[map1_index][i] = binaryString.charAt(i) - '0';
                //map1[map1_index][i] = Integer.parseInt(binaryString.charAt(i));
            }
            map1_index++;
        }

        for(int num : arr2){
            String binaryString = String.format("%0"+n+"d", Long.parseLong(Integer.toBinaryString(num)));
            for(int i = 0; i < n; i++){
                map2[map2_index][i] = binaryString.charAt(i) - '0';
                //map2[map2_index][i] = Integer.parseInt(binaryString.charAt(i));
            }
            map2_index++;
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                result[i][j] = map1[i][j] | map2[i][j];
            }
        }

        for(int i = 0; i < n; i++){
            String a = "";
            for(int j = 0; j < n; j++){
                if(result[i][j] == 1){
                    a += "#";
                }else{
                    a += " ";
                }
            }
            answer[i] = a;
        }




        return answer;
    }


}
