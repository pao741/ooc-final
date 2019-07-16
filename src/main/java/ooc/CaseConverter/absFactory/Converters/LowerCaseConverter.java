package ooc.CaseConverter.absFactory.Converters;

public class LowerCaseConverter implements Converter {
    @Override
    public String convert(String name) {
        return name.toLowerCase();
    }
}
