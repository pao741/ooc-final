package ooc.CaseConverter.service;


import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;

import com.sun.xml.internal.ws.util.StringUtils;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
public class ConverterService {


    public String toCamelCase(String text){
        StringBuilder stringBuilder = new StringBuilder();
        char[] chars = text.toCharArray();
        for (int i = 0; i < chars.length; i++){
            if (i == 0 && Character.isUpperCase(chars[i])){
                chars[i] = Character.toLowerCase(chars[i]);
            }
            stringBuilder.append(chars[i]);
        }
        return stringBuilder.toString();
    }

    public String toSnakeCase(String text){
        StringBuilder stringBuilder = new StringBuilder();
        char[] chars = text.toCharArray();
        for (int i = 0; i < chars.length; i++){
            if (i == 0 && Character.isUpperCase(chars[i])){
                chars[i] = Character.toLowerCase(chars[i]);
            }
            if (Character.isUpperCase(chars[i])){
                stringBuilder.append("_");
                chars[i] = Character.toLowerCase(chars[i]);
            }
            stringBuilder.append(chars[i]);
        }
        return stringBuilder.toString();
    }

    public String toLowerCase(String text){ return text.toLowerCase(); }

    public String toUpperCase(String text){ return text.toUpperCase(); }

    public String toKebabCase(String text){
        StringBuilder stringBuilder = new StringBuilder();
        char[] chars = text.toCharArray();
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

    public String toPascalCase(String text){
        StringBuilder stringBuilder = new StringBuilder();
        char[] chars = text.toCharArray();
        for (int i = 0; i < chars.length; i++){
            if (i == 0 && Character.isLowerCase(chars[i])){
                chars[i] = Character.toUpperCase(chars[i]);
            }
            stringBuilder.append(chars[i]);
        }
        return stringBuilder.toString();
    }

    public String toMySQLFriendly(String text){
        return toSnakeCase(text);
    }

    public String toOracleFriendly(String text){ return toSnakeCase(text).toUpperCase(); }

    public String toMySQLFriendlyWithPrefix(String text){
        String prefix = "tbl_";
        return prefix+toMySQLFriendly(text);
    }

    public String toOracleFriendlyWithPrefix(String text){
        String prefix = "TBL_";
        return prefix+toOracleFriendly(text);
    }

}
