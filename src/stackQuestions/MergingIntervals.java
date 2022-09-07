package stackQuestions;

import java.util.*;

class Interval {
    int begin, end;
    Interval(int begin, int end) {
        this.begin = begin;
        this.end = end;
    }
    public String toString() {
        return "{" + begin + ", " + end + "}";
    }
}
public class MergingIntervals {
    public static void mergeIntervals(List<Interval> intervals) {

        // sort interval on basis of begin element
        Collections.sort(intervals, Comparator.comparing(a -> a.begin));

        // create an empty stack
        Stack<Interval> stack= new Stack<Interval>();

        // do for each interval
        for(Interval interval: intervals) {
            if(stack.empty() || interval.begin > stack.peek().end) {
                stack.push(interval);
            }
            if(stack.peek().end < interval.end) {
                stack.peek().end = interval.end;
            }
        }

        while(!stack.empty()) {
            System.out.println(stack.pop());
        }
    }
   // this problem can be done in plenty number of ways
    // but as we are using stack to solve our problems
    public static void main(String[] args) {
        List<Interval> intervals = Arrays.asList(new Interval(1, 5),
                                    new Interval(2, 3),
                                    new Interval(4, 6),
                                    new Interval(8, 10),
                                    new Interval(7, 8),
                                    new Interval(12, 15));
        mergeIntervals(intervals);
    }
}
