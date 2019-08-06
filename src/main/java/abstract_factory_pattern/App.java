package abstract_factory_pattern;

public class App {
    public static void main(String[] args) {
        Animal dog = (Animal) FactoryProvider.getFactory("Animal").create("Dog");
        System.out.println(dog.makeSound());
    }
}
