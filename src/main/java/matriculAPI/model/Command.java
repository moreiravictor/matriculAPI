package matriculAPI.model;

import lombok.Getter;

@Getter
public enum Command {

    all("list"),
    subject("dis"),
    course("curso");

    public final String value;

    Command(String value) {
        this.value = value;
    }

    public static Command getOption(String value) {
        if (value.equals("list")) {
            return Command.all;
        } else if (value.equals("dis")) {
            return  Command.subject;
        } else if (value.equals("curso")) {
            return Command.course;
        }
        return Command.all;
    }
}
