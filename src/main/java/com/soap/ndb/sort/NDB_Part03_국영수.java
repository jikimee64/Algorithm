package main.java.com.soap.ndb.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/10825
public class NDB_Part03_국영수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Student> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            list.add(new Student(st.nextToken(), Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        } //for문

        Collections.sort(list);

        list.stream().forEach(student -> System.out.println(student.getName()));
    }
}

class Student implements Comparable<Student> {
    private String name;
    private int korean;
    private int english;
    private int math;

    public Student(String name, int korean, int english, int math) {
        this.name = name;
        this.korean = korean;
        this.english = english;
        this.math = math;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getKorean() {
        return korean;
    }

    public void setKorean(int korean) {
        this.korean = korean;
    }

    public int getMath() {
        return math;
    }

    public void setMath(int math) {
        this.math = math;
    }

    public int getEnglish() {
        return english;
    }

    public void setEnglish(int english) {
        this.english = english;
    }

    @Override
    public int compareTo(Student o) {
        if (this.korean != o.korean) { //국어 점수가 다르면 국어 점수가 감소하는 순서로
            return o.korean - this.korean;
        }
        if (this.english != o.english) { //국어점수는 같은데 영어 점수가 다르면 영어 점수가 증가하는 순서로
            return this.english - o.english;
        }
        if (this.math != o.math) { //국어 점수와 영어 점수가 같으면 수학점수가 감소하는 순서로
            return o.math - this.math;
        }
        return this.name.compareTo(o.name); //국어,영어,수학 점수가 같으면 이름을 사전순으로
    }
}