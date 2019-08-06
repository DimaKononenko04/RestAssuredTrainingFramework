package abstract_factory_pattern;

public class ColorFactory implements AbstractFactory<Color> {
    @Override
    public Color create(String type) {
        if ("Brown".equalsIgnoreCase(type)) {
            return new Brown();
        } else if ("Black".equalsIgnoreCase(type)) {
            return new Black();
        }

        return null;
    }
}
