package ooc.CaseConverter.absFactory;

import ooc.CaseConverter.absFactory.Converters.Converter;
import ooc.CaseConverter.absFactory.Converters.OracleFriendlyWithPrefixConverter;

public class OracleFriendlyWithPrefixFactory implements ConverterFactory {
    @Override
    public Converter create() {
        return new OracleFriendlyWithPrefixConverter();
    }
}
