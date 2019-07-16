package ooc.CaseConverter.absFactory;

import ooc.CaseConverter.absFactory.Converters.Converter;
import ooc.CaseConverter.absFactory.Converters.OracleFriendlyConverter;

public class OracleFriendlyFactory implements ConverterFactory {
    @Override
    public Converter create() {
        return new OracleFriendlyConverter();
    }
}
