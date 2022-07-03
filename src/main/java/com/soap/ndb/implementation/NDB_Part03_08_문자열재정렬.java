package main.java.com.soap.ndb.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;


public class NDB_Part03_08_문자열재정렬 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String N = br.readLine();
        List list = new ArrayList();
        int temp = 0;

        for (int i = 0; i < N.length(); i++) {
            /*
             알파벳인 경우 결과 리스트에 삽입
            if (Character.isLetter(str.charAt(i))) {
                result.add(str.charAt(i));
            }
             */

            if (N.charAt(i) >= 48 && N.charAt(i) <= 57) { //숫자면 더하기 말고 그냥 더하기
                temp += N.charAt(i) - '0';
            } else {
                list.add(N.charAt(i));
            }
        }

        Collections.sort(list);

        list.add(temp);
        Iterator it = list.iterator();

        while (it.hasNext()) {
            System.out.print(it.next());
        }

        /*
            List를 제네릭 Character타입을 주고 숫자는 따로 출력하는 방법
            숫자가 하나라도 존재하는 경우 가장 뒤에 출력
            if (value != 0) System.out.print(value);
            System.out.println();
         */

    }
}
