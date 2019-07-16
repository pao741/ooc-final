package ooc.CaseConverter.absFactory.Converters;

public class KebabCaseConverter implements Converter {
    @Override
    public String convert(String name) {
        StringBuilder stringBuilder = new StringBuilder();
        char[] chars = name.toCharArray();
        for (int i = 0; i < chars.length; i++){
            if (i == 0 && Character.isUpperCase(chars[i])){
                chars[i] = Character.toLowerCase(chars[i]);
            }
            if (Character.isUpperCase(chars[i])){
                stringBuilder.append("-");
                chars[i] = Character.toLowerCase(chars[i]);
            }
            stringBuilder.append(chars[i]);
        }
        return stringBuilder.toString();
    }
}
