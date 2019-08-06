package abstract_factory_pattern;

public interface AbstractFactory <T> {
    T create(String type);
}
