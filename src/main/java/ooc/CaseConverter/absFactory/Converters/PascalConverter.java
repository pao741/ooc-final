package ooc.CaseConverter.absFactory.Converters;

public class PascalConverter implements Converter {
    @Override
    public String convert(String name) {
        StringBuilder stringBuilder = new StringBuilder();
        char[] chars = name.toCharArray();
        for (int i = 0; i < chars.length; i++){
            if (i == 0 && Character.isLowerCase(chars[i])){
                chars[i] = Character.toUpperCase(chars[i]);
            }
            stringBuilder.append(chars[i]);
        }
        return stringBuilder.toString();
    }
}
