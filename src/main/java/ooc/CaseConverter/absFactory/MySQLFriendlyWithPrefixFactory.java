package ooc.CaseConverter.absFactory;

import ooc.CaseConverter.absFactory.Converters.Converter;
import ooc.CaseConverter.absFactory.Converters.MySQLFriendlyWithPrefixConveter;

public class MySQLFriendlyWithPrefixFactory implements ConverterFactory {
    @Override
    public Converter create() {
        return new MySQLFriendlyWithPrefixConveter();
    }
}
