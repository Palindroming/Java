package fc.java.model2;
@FunctionalInterface
public interface PersonFactory {
     Person create(String name, int age);

}
