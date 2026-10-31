package com.xiling.math.Generator;

import com.xiling.math.Problem.AdditionProblem;
import com.xiling.math.Problem.DivisionProblem;
import com.xiling.math.Problem.MultiplicationProblem;
import com.xiling.math.Problem.Problem;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ProblemGenerator {

    private final int difficulty;
    private final Random random;

    public ProblemGenerator(int difficulty) {
        this.difficulty = difficulty;
        this.random = new Random();
    }

    public AdditionProblem generateAddition() {

        List<Integer> additionTerms = new ArrayList<>();
        int minDigit = 0, maxDigit = 0;
        int numberOfTerms = this.random.nextInt(3, 6) + this.difficulty;

        switch (this.difficulty) {
            case 1 -> {minDigit = 1; maxDigit = 2;}
            case 2 -> {minDigit = 2; maxDigit = 2;}
            case 3 -> {minDigit = 2; maxDigit = 3;}
            case 4 -> {minDigit = 3; maxDigit = 4;}
            case 5 -> {minDigit = 4; maxDigit = 5;}
        }

        double negativeProbability = 0.00;

        for (int i = 0; i < numberOfTerms; i++) {
            int term = random.nextInt((int)Math.pow(10, maxDigit));
            term = Math.clamp(term, (int)Math.pow(10, minDigit - 1),
                    (int)Math.pow(10, maxDigit));

            // Randomly generate negative number
            if (random.nextDouble() < negativeProbability) {
                term *= -1;
                negativeProbability = 0.00;
            } else negativeProbability += 0.15;
            additionTerms.add(term);
        }

        return new AdditionProblem(additionTerms);
    }

    public MultiplicationProblem generateMultiplication() {
        int term1, term2;
        int digit1 = 0, digit2 = 0;

        switch (this.difficulty) {
            case 1 -> {digit1 = 2; digit2 = 1;}
            case 2 -> {digit1 = 2; digit2 = 2;}
            case 3 -> {digit1 = 2; digit2 = 3;}
            case 4 -> {digit1 = 3; digit2 = 3;}
            case 5 -> {digit1 = 3; digit2 = 4;}
        }

        // Swap Digit order randomly
        if (digit1 != digit2 && random.nextDouble() < 0.5) {
            int temp = digit1;
            digit1 = digit2;
            digit2 = temp;
        }

        term1 = random.nextInt((int)Math.pow(10, digit1 - 1),
                (int)Math.pow(10, digit1));
        term2 = random.nextInt((int)Math.pow(10, digit2 - 1),
                (int)Math.pow(10, digit2));

        return new MultiplicationProblem(term1, term2);
    }

    public DivisionProblem generateDivision() {
        int answer, denominator;
        int digit1 = 0, digit2 = 0;

        switch (this.difficulty) {
            case 1 -> {digit1 = 2; digit2 = 1;}
            case 2 -> {digit1 = 2; digit2 = 2;}
            case 3 -> {digit1 = 2; digit2 = 3;}
            case 4 -> {digit1 = 3; digit2 = 3;}
            case 5 -> {digit1 = 3; digit2 = 4;}
        }

        // Swap Digit order randomly
        if (digit1 != digit2 && random.nextDouble() < 0.5) {
            int temp = digit1;
            digit1 = digit2;
            digit2 = temp;
        }

        answer = random.nextInt((int)Math.pow(10, digit1 - 1),
                (int)Math.pow(10, digit1));
        denominator = random.nextInt((int)Math.pow(10, digit2 - 1),
                (int)Math.pow(10, digit2));

        return new DivisionProblem(denominator, answer);
    }

    public Problem generateRandomProblem() {
        double rand = random.nextDouble();
        if (rand < 0.4) return generateAddition();
        else if (rand < 0.7) {
            return generateMultiplication();
        } else return generateDivision();
    }

    @SuppressWarnings("unused")
    public int getDifficulty() {
        return difficulty;
    }
}
