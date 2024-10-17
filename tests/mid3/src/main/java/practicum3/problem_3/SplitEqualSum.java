package practicum3.problem_3;
import java.util.*;
import practicum3.backtracker.Backtracker;
import practicum3.backtracker.Configuration;

public class SplitEqualSum implements Configuration<SplitEqualSum>{
    private List<Integer> values1;
    private List<Integer> values2;

    public SplitEqualSum(List<Integer> values1,List<Integer> values2) {
        this.values1 = values1;
        this.values2 = values2;
    }

    private int getSum(List<Integer> a) {
        int result = 0;
        for (int num : a) {
            result += num; 
        }
        return result;

    }

    @Override
    public Collection<SplitEqualSum> getSuccessors() {
        Collection<SplitEqualSum> successors = new LinkedList<>();

        List<Integer> listOneCopy = new ArrayList<>(this.getValues1());
        List<Integer> listTwoCopy = new ArrayList<>(this.getValues2());
        int i = 0;
        while(getSum(listOneCopy) > getSum(listTwoCopy)) {
            listTwoCopy.add(listOneCopy.get(i));
            listOneCopy.remove(i); 
            successors.add(new SplitEqualSum(listOneCopy, listTwoCopy));
            i++;
        }

        return successors; 
    }

    @Override
    public boolean isValid() {
        if (this.getValues1() != null) {
            if (this.getValues2() != null) {
                return true;
            }
        } 
        return false;
    }
        
    @Override
    public boolean isGoal() {
        return isValid() && (getSum(this.getValues1()) == getSum(this.getValues2()));
    }

    public List<Integer> getValues1() { return values1; }
    public List<Integer> getValues2() { return values2; }

    @Override
    public String toString() {
        int one = getSum(getValues1()) + getSum(getValues1()
        return "";
    }

    public static void main(String[] args) {
        SplitEqualSum ses = new SplitEqualSum(Arrays.asList(3,9,4,2),new ArrayList<Integer>());
        Backtracker<SplitEqualSum> solver = new Backtracker<>(true);
        SplitEqualSum solution = solver.solve(ses);
        System.out.println(solution);
    }
}
