package ooc.CaseConverter.absFactory;

import ooc.CaseConverter.absFactory.Converters.Converter;
import ooc.CaseConverter.absFactory.Converters.UpperCaseConverter;

public class UpperCaseFactory implements ConverterFactory {
    @Override
    public Converter create() {
        return new UpperCaseConverter();
    }
}
