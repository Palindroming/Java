package fc.java.course2.part2;

public class GenericLimitTest {


    public static void main(String[] args) {
        Integer[] integers = {1,2,3,4,5};
        Double[] doubles = {1.0,2.0,3.0,4.0,5.0};

        AverageCalculator<Integer> IC = new AverageCalculator<>(integers);
        System.out.println(IC.calculateAverage());

        AverageCalculator<Double> DC = new AverageCalculator<>(doubles);
        System.out.println(DC.calculateAverage());
    }
}
