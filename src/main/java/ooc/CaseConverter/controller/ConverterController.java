package ooc.CaseConverter.controller;

import ooc.CaseConverter.absFactory.*;
import ooc.CaseConverter.absFactory.Converters.Converter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ooc.CaseConverter.Input;

import javax.validation.Valid;

@RestController
public class ConverterController {

    @PostMapping(value = {"/"})
    public ResponseEntity<String> doConvert(
            @Valid @RequestBody Input input){
        String format = input.getFormat();
        String name = input.getName();
        String type = input.getType();
        boolean converted = false;
        ConverterFactory converterFactory = null;
        switch (format){
            case "camelCase":
                converterFactory = new CamelCaseFactory();
                converted = true;
                break;
            case "snake_case":
                converterFactory = new SnakeCaseFactory();
                converted = true;
                break;
            case "lowercase":
                converterFactory = new LowerCaseFactory();
                converted = true;
                break;
            case "UPPERCASE":
                converterFactory = new UpperCaseFactory();
                converted = true;
                break;
            case "kebab-case":
                converterFactory = new KebabCaseFactory();
                converted = true;
                break;
            case "PascalCase":
                converterFactory = new PascalCaseFactory();
                converted = true;
                break;
            case "MySQLFriendly":
                converterFactory = new MySQLFriendlyFactory();
                converted = true;
                break;
            case "OracleFriendly":
                converterFactory = new OracleFriendlyFactory();
                converted = true;
                break;
            case "MySQLFriendlyWithPrefix":
                if (type.equals("class")){
                    converterFactory = new MySQLFriendlyWithPrefixFactory();
                }else{
                    converterFactory = new MySQLFriendlyFactory();
                }
                converted = true;
                break;
            case "OracleFriendlyWithPrefix":
                if (type.equals("class")){
                    converterFactory = new OracleFriendlyWithPrefixFactory();
                }else{
                    converterFactory = new OracleFriendlyFactory();
                }
                converted = true;
                break;
        }
        if (!converted){
            return ResponseEntity.badRequest().body("Invalid format");
        }
        Converter converter = converterFactory.create();
        return ResponseEntity.ok().body(converter.convert(name));
    }


}
