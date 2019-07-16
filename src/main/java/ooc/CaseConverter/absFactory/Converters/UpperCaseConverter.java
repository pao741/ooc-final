package ooc.CaseConverter.absFactory.Converters;

public class UpperCaseConverter implements Converter {
    @Override
    public String convert(String name) {
        return name.toUpperCase();
    }
}
