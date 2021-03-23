package com.soap.woowacourse.jyami_precourse.oneweek.io;

import java.io.InputStream;
import java.util.Scanner;

/**
 * 게임시 유저에게 입력을 받을때의 함수들을 저장
 */
public class InputView {
    private static Scanner scanner;

    public InputView(InputStream inputStream) {
        scanner = new Scanner(inputStream);
    }

    public String getNumbers() {
        System.out.print("숫자를 입력해 주세요: ");
        return scanner.next();
    }

    public int newGame() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        return scanner.nextInt();
    }

}