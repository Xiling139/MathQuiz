import java.text.DecimalFormat;
import java.util.List;

public class AdditionProblem extends Problem {

    private final List<Integer> terms;
    private DecimalFormat df;

    public AdditionProblem(List<Integer> terms) {
        super();
        this.terms = terms;
        this.setAnswer(calculateAnswer());
        this.df = new DecimalFormat("#,###");
    }

    private int calculateAnswer() {
        int total = 0;
        for (int t : this.terms) {
            total += t;
        }

        return total;
    }

    public List<Integer> getTerms() {
        return terms;
    }

    @Override
    public void display() {
        for (int t : this.terms) {
            IO.println(String.format("%7s",
                    df.format(t)));
        }
    }
}
