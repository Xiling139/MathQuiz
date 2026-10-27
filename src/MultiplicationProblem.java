import java.text.DecimalFormat;

public class MultiplicationProblem extends Problem {

    private final int term1;
    private final int term2;
    private final DecimalFormat df;

    public MultiplicationProblem(int term1, int term2) {
        this.term1 = term1;
        this.term2 = term2;
        this.setAnswer(term1 * term2);
        this.df = new DecimalFormat("#,###");
    }

    @Override
    void display() {
        IO.println(String.format("%s", df.format(term1) +
                " * " + String.format("%s", df.format(term2))));
    }
}
