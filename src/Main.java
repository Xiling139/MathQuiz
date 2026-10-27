public class Main {
    public static void main(String[] args) {

        int difficulty = -1;

        // Difficulty Setup
        while (difficulty == -1) {
            String diffInput = IO.readln("Input Difficulty > ");
            try {
                difficulty = Integer.parseInt(diffInput);
            } catch (NumberFormatException e) {
                continue;
            }

            if (!(difficulty > 0 && difficulty < 6)) {
                IO.println("Difficulty must be between 1 and 5.");
                difficulty = -1;
            }
        }

        ProblemGenerator generator = new ProblemGenerator(difficulty);
       Problem problem = generator.generateRandomProblem();

        problem.display();
        int answer;
        String answerString = IO.readln("Answer > ");
        try {
            answer = Integer.parseInt(answerString);
        } catch (NumberFormatException e) {
            answer = 0; // Using Default value for illegal input
        }

        if (answer == problem.getAnswer()) {
            IO.println("Correct Answer!");
        } else {
            IO.println("Wrong Answer...");
            IO.println("The answer is " + problem.getAnswer());
        }
    }
}