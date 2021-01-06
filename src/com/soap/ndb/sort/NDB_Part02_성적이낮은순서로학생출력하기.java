//package com.soap.ndb.sort;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.*;
//
//class Student implements Comparable<Student>{
//
//    private String Name;
//    private int score;
//
//    public Student(String name, int score) {
//        Name = name;
//        this.score = score;
//    }
//
//    public String getName() {
//        return Name;
//    }
//
//    public void setName(String name) {
//        Name = name;
//    }
//
//    public int getScore() {
//        return score;
//    }
//
//    public void setScore(int score) {
//        this.score = score;
//    }
//
//    @Override
//    public int compareTo(Student  o) {
//        return this.score - o.score; //오름차순
//    }
//}
//
//public class NDB_Part02_성적이낮은순서로학생출력하기 {
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        List<Student> list = new ArrayList<>();
//        int n = Integer.parseInt(br.readLine());
//
//        for(int i = 0; i < n; i++){
//            StringTokenizer st = new StringTokenizer(br.readLine());
//            list.add(new Student(st.nextToken(), Integer.parseInt(st.nextToken())));
//        }
//
//        Collections.sort(list);
//
//        for(int i = 0; i < n; i++){
//            System.out.print(list.get(i).getName() + " ");
//        }
//
//    }
//}
