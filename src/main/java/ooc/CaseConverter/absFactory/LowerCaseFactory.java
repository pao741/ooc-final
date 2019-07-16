package ooc.CaseConverter.absFactory;

import ooc.CaseConverter.absFactory.Converters.Converter;
import ooc.CaseConverter.absFactory.Converters.LowerCaseConverter;

public class LowerCaseFactory implements ConverterFactory {
    @Override
    public Converter create() {
        return new LowerCaseConverter();
    }
}
