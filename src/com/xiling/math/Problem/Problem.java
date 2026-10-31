package com.xiling.math.Problem;

public abstract class Problem {

    private int answer;

    public Problem() {
    }

    public abstract void display();

    public int getAnswer() {
        return answer;
    }

    public void setAnswer(int answer) {
        this.answer = answer;
    }
}
