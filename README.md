# Math Problem Generator

## Description
A simple Java console application that generates random math problems (addition, multiplication, and division) based on a chosen difficulty level. The user answers 10 questions, and the program checks each answer and displays the correct one if needed.

### Features
- Five difficulty levels (1–5)
- Three problem types:
    - Addition – multiple terms, with a chance of negative numbers at higher counts
    - Multiplication – two operands with digit ranges based on difficulty
    - Division – always produces a whole-number answer
- Random problem selection (weighted: 40% addition, 30% multiplication, 30% division)
- Number formatting with thousands separators (e.g. 1,234)
- Input validation for difficulty and answers

## Project Structure
```
com.xiling.math
├── Main.java # Entry point, game loop
├── Generator
│ └── ProblemGenerator.java # Generates problems by difficulty
└── Problem
    ├── Problem.java # Abstract base class
    ├── AdditionProblem.java
    ├── MultiplicationProblem.java
    └── DivisionProblem.java
```
---

## Instructions

1. Make sure you have a Java development environment (JDK 25+ required, since the code uses `java.lang.IO`).

2. Clone the repository to the destination:

```
git clone https://github.com/Xiling139/MathQuiz.git MathQuiz
cd MathQuiz
```

3. Run the jar file:

```
java -jar MathQuiz.jar
```

### Usage
1. Enter a difficulty level between 1 and 5.
2. The program will show 10 problems at a single execution
3. Type your answer after each Answer > prompt.
4. The program tells you whether you are correct and shows the correct answer if you are wrong.

### Example Session

```
Input Difficulty > 2
     73
     20
     26
     10
    -49
     70
Answer > 150
Correct Answer!
     23
     95
     11
    -90
     62
Answer > 101
Correct Answer!
1,240 / 62
Answer > abc
Wrong Answer...
The answer is 20
...
```

## Difficulty Mapping
|Difficulty	|Addition digits	|Multiplication digits|	Division digits|
|- | - | - | -|
|1|	1–2|	2 × 1|	2 / 1|
|2|2–2 |	2 × 2|	2 / 2|
|3|2–3	|2 × 3	|2 / 3|
|4|3–4	|3 × 3	|3 / 3|
|5|	4–5	|3 × 4|	3 / 4|

For multiplication and division, the digit order is randomly swapped, so e.g. difficulty 1 can produce either `2-digit × 1-digit` or `1-digit × 2-digit.`

## Notes
- Division problems are constructed so the answer is always an integer: the numerator is co`mputed as answer * denominator.
- Invalid answer input is treated as `0`.