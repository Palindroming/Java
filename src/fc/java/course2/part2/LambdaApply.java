package fc.java.course2.part2;

@FunctionalInterface
 interface StringOperation{
    String apply(String s);
}


public class LambdaApply {

    public static void main(String[] args) {

     StringOperation upperCase = (s) -> s.toUpperCase();
     StringOperation lowerCase = (s) -> s.toLowerCase();

     System.out.println(upperCase.apply("Hello"));
     System.out.println(lowerCase.apply("Hello"));

    }


    String processStirng(String input, StringOperation sto){

        return   sto.apply(input);
    }


    
}

