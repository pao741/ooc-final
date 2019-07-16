package ooc.CaseConverter.service;

import ooc.CaseConverter.Input;
import ooc.CaseConverter.controller.ConverterController;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.apache.commons.io.IOUtils;
import org.springframework.http.ResponseEntity;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

public class TestCaseService {

    private ConverterController converterController = new ConverterController();

    public void checkTestCase() {
        InputStream ins = null;
        try {
            ins = getClass().getResourceAsStream("/test-cases.csv");
            Reader reader = new InputStreamReader(ins, "UTF-8");
            CSVParser parser = new CSVParser(reader, CSVFormat.EXCEL.withHeader());
            for (final CSVRecord record : parser) {
                String name = record.get("name").trim();
                String type = record.get(" type").trim();
                String format = record.get(" format").trim();
                String output = record.get(" output").trim();
                Input input = Input.builder().name(name).format(format).type(type).build();
                ResponseEntity<String> responseEntity =  converterController.doConvert(input);
                String answer = responseEntity.getBody();
                assert (answer.equals(output));
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            IOUtils.closeQuietly(ins);
        }
    }
}
