package CrazyLogger;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

public class CrazyLogger {

    private StringBuilder stringBuilder = new StringBuilder();
    private final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-YYYY : hh-mm");

    public void log(final String message){
        LocalDateTime localDateTime = LocalDateTime.now();
        stringBuilder.append(localDateTime.format(dateTimeFormatter)).append(" : ")
                            .append(message)
                            .append("; \n");
    }

    public void search(final String message){
        String[] allStrings = stringBuilder.toString().split("\n");
        Arrays.stream(allStrings)
                .filter(s -> s.contains(message))
                .forEach(System.out::println);
    }

/*   public static void main(String[] args) {
        CrazyLogger cl = new CrazyLogger();

        cl.log("andrew abd rsa");
        cl.log("andrew vsdg as");
        cl.log("asafs");
        cl.log("12151s");

        cl.search("andrew");
    }*/
}
