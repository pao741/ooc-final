package ooc.CaseConverter.absFactory.Converters;

public class MySQLFriendlyWithPrefixConveter implements Converter {
    @Override
    public String convert(String name) {
        String prefix = "tbl_";
        MySQLFriendlyConverter mySQLFriendlyConverter = new MySQLFriendlyConverter();
        return prefix+mySQLFriendlyConverter.convert(name);
    }
}
