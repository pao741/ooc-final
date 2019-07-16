package ooc.CaseConverter.controller;

import ooc.CaseConverter.absFactory.*;
import ooc.CaseConverter.absFactory.Converters.Converter;
import ooc.CaseConverter.service.ConverterService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ooc.CaseConverter.Input;

import javax.validation.Valid;
import javax.xml.ws.http.HTTPException;
import java.time.LocalDateTime;

@RestController
public class ConverterController {

    private ConverterService converterService = new ConverterService();

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
            case "snake_case":
                converterFactory = new SnakeCaseFactory();
                converted = true;
            case "lowercase":
                converterFactory = new LowerCaseFactory();
                converted = true;
            case "UPPERCASE":
                converterFactory = new UpperCaseFactory();
                converted = true;
            case "kebab-case":
                converterFactory = new KebabCaseFactory();
                converted = true;
            case "MySQLFriendly":
                converterFactory = new MySQLFriendlyFactory();
                converted = true;
            case "OracleFriendly":
                converterFactory = new OracleFriendlyFactory();
                converted = true;
            case "MySQLFriendlyWithPrefix":
                if (type.equals("class")){
                    converterFactory = new MySQLFriendlyWithPrefixFactory();
                }else{
                    converterFactory = new MySQLFriendlyFactory();
                }
                converted = true;
            case "OracleFriendlyWithPrefix":
                if (type.equals("class")){
                    converterFactory = new OracleFriendlyWithPrefixFactory();
                }else{
                    converterFactory = new OracleFriendlyFactory();
                }
                converted = true;
        }if (!converted){
            return ResponseEntity.badRequest().body("Invalid format");
        }
        Converter converter = converterFactory.create();
        return ResponseEntity.ok().body(converter.convert(name));
    }


}
