package ooc.CaseConverter.absFactory;

import ooc.CaseConverter.absFactory.Converters.Converter;
import ooc.CaseConverter.absFactory.Converters.SnakeCaseConverter;

public class SnakeCaseFactory implements ConverterFactory {
    @Override
    public Converter create() {
        return new SnakeCaseConverter();
    }
}
