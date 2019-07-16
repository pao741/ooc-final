package ooc.CaseConverter.absFactory.Converters;

public class OracleFriendlyConverter implements Converter {
    @Override
    public String convert(String name) {
        SnakeCaseConverter snakeCaseConverter = new SnakeCaseConverter();
        return snakeCaseConverter.convert(name).toUpperCase();
    }
}
