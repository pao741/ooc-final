package ooc.CaseConverter.absFactory;

import ooc.CaseConverter.absFactory.Converters.Converter;
import ooc.CaseConverter.absFactory.Converters.PascalConverter;

public class PascalCaseFactory implements ConverterFactory {
    @Override
    public Converter create() {
        return new PascalConverter();
    }
}
