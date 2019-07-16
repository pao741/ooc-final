package ooc.CaseConverter.absFactory;

import ooc.CaseConverter.absFactory.Converters.Converter;
import ooc.CaseConverter.absFactory.Converters.MySQLFriendlyConverter;

public class MySQLFriendlyFactory implements ConverterFactory {
    @Override
    public Converter create() {
        return new MySQLFriendlyConverter();
    }
}
