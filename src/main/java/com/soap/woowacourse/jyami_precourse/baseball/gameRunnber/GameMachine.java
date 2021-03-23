package com.soap.woowacourse.jyami_precourse.oneweek.gameRunnber;

import com.soap.woowacourse.jyami_precourse.oneweek.generator.RandomGameNumbersGenerator;
import com.soap.woowacourse.jyami_precourse.oneweek.io.InputView;

/**
 * 게임을 실행 할 수 있는 함수가 담긴 클래스 여러개의 숫자야구게임(BaseBallGame)을 실행 할 수 있다.
 */
public class GameMachine {

    private final int START = 1;
    private final int END = 2;

    private InputView inputView;

    public GameMachine() {
        this.inputView = new InputView(System.in);
    }

    public void runBaseBallGameOnce(){
        BaseBallGame baseBallGame = new BaseBallGame(new RandomGameNumbersGenerator());
        baseBallGame.executeUserInput(this.inputView);
        startNewBaseBallGame();
    }

    private void startNewBaseBallGame(){
        int newGameResponse = inputView.newGame();
        validateNewGameInput(newGameResponse);
        if(newGameResponse == START)
            runBaseBallGameOnce();
    }

    private void validateNewGameInput(int newGameResponse){
        if(newGameResponse != START  && newGameResponse != END)
            throw new IllegalStateException("잘못된 입력값 입니다.");
    }



}
