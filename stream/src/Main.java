import java.util.Arrays;
import java.util.stream.IntStream;

public class Main {


    static int [] ints={10,0,3,-7,15,-90,20,23,27,76};
    public static void main(String[] args) {
	// write your code here
        System.out.println("average " + averageWithAverage());
        System.out.println("average2 " +averageWithOutAverage());
        System.out.println("=Zero " +amountZero());
        System.out.println(">Zero " + moreThenZero());
        System.out.println("multiply ");
        Arrays.stream(multiplyElements(2)).forEach(x->System.out.println(x));
        System.out.println("min value " + ints[findMinIndex()]);
        System.out.println("min value index " + findMinIndex());


    }

    private static double averageWithAverage(){
        return Arrays.stream(ints).average().getAsDouble();
    }
    private static double averageWithOutAverage(){
        return Arrays.stream(ints).mapToDouble(x -> x).map(x -> x/ints.length).sum();
    }
    static int findMinIndex(){
        return IntStream.range(0, ints.length).
                reduce((i,j) -> ints[i] >  ints[j] ? j : i ).
                orElseThrow(IllegalArgumentException::new);
    }
    static long amountZero(){
        return Arrays.stream(ints).filter(x -> x == 0).count();
    }
    static long moreThenZero(){
        return Arrays.stream(ints).filter(x -> x > 0).count();
    }
    static int[] multiplyElements(int num){
        return Arrays.stream(ints).map(x -> x * num).toArray();
    }

}
