package ooc.CaseConverter;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter

@NoArgsConstructor
@AllArgsConstructor
public class Input {

    private String name;
    private String format;
    private String type;

    public String getName() {
        return name;
    }

    public String getFormat() {
        return format;
    }

    public String getType() {
        return type;
    }

    public static InputBuilder builder(){
        return new InputBuilder();
    }

    public static class InputBuilder{

        private String name;
        private String format;
        private String type;

        public InputBuilder name(String name) {
            this.name = name;
            return this;
        }


        public InputBuilder format(String format) {
            this.format = format;
            return this;
        }


        public InputBuilder type(String type) {
            this.type = type;
            return this;
        }

        public Input build(){
            Input input = new Input();
            input.format = this.format;
            input.name = this.name;
            input.type = this.type;
            return input;
        }
    }


}
