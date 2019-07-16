package ooc.CaseConverter.absFactory;

import ooc.CaseConverter.absFactory.Converters.CamelCaseConverter;
import ooc.CaseConverter.absFactory.Converters.Converter;

public class CamelCaseFactory implements ConverterFactory {
    @Override
    public Converter create() {
        return new CamelCaseConverter();
    }
}
