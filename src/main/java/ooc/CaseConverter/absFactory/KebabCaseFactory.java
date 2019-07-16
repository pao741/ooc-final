package ooc.CaseConverter.absFactory;

import ooc.CaseConverter.absFactory.Converters.Converter;
import ooc.CaseConverter.absFactory.Converters.KebabCaseConverter;

public class KebabCaseFactory implements ConverterFactory {
    @Override
    public Converter create() {
        return new KebabCaseConverter();
    }
}
