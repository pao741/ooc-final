package ooc.CaseConverter.absFactory.Converters;

public class OracleFriendlyWithPrefixConverter implements Converter {
    @Override
    public String convert(String name) {
        String prefix = "TBL_";
        OracleFriendlyConverter oracleFriendlyConverter = new OracleFriendlyConverter();
        return prefix+oracleFriendlyConverter.convert(name);
    }
}
