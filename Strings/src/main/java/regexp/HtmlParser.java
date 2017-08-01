package regexp;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HtmlParser {

    private final String regexp = "((?<=\\s|^)[A-ZА-Я][^.]*?((\\s|\\()[Рр]ис(\\.|ун(ок|ку|ка|ке)))+(\\s\\d|\\d)(.*)?\\.)";
    private List<String> allLinks = new ArrayList<>();

    public void readFile() throws IOException{

        StringBuilder stringBuilder = new StringBuilder();
        Files.lines(Paths.get("C:\\Users\\Павел\\Documents\\GitHub\\stringio\\src\\main\\resources\\article.html"), StandardCharsets.ISO_8859_1)
                .forEach(s -> stringBuilder
                        .append(s)
                        .append("\n"));
        Pattern pattern = Pattern.compile(regexp);
        Matcher matcher = pattern.matcher(stringBuilder);
        while (matcher.find())
            allLinks.add(matcher.group());
    }


    public static void main(String[] args) throws IOException {
        HtmlParser htmlParser = new HtmlParser();
        htmlParser.readFile();
    }

}
