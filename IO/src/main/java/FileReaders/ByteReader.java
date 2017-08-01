package FileReaders;


import java.io.FileInputStream;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ByteReader {

    private final String[] JAVAWORDS = {
            "byte", "short", "int", "long", "char",
            "float", "double", "boolean", "if", "else",
            "switch", "case:", "default", "while", "do",
            "break", "continue", "for", "try ", "catch",
            "finally", "throw", "throws", "private",
            "protected", "public", "import", "package",
            "class", "interface", "extends", "implements",
            "static ", "final", "void", "abstract"
    };
    private final String DATA_SEPARATOR = " : ";
    private Map<String, Integer> keyWordsCount;

    private String path;

    public ByteReader(final String path){
        this.path = path;
        keyWordsCount = new HashMap<>();
        Arrays.stream(JAVAWORDS)
                .forEach(s -> keyWordsCount.put(s,0));
    }
    public void getResult(final String outFile) throws IOException{
        byte[] bytes;
        FileInputStream fileInputStream = new FileInputStream(path);
        int allBytes = fileInputStream.available();
        bytes = new byte[allBytes];
        fileInputStream.read(bytes, 0, allBytes);
        for(String s: new String(bytes).split("\\s+")){
            if(keyWordsCount.containsKey(s) == true) {
                int count = (int)keyWordsCount.get(s);
                keyWordsCount.put(s, ++count);
            }
        }
        try(Writer writer = Files.newBufferedWriter(Paths.get(outFile))){
            keyWordsCount.forEach((key, value) -> {
                try { writer.write(key + DATA_SEPARATOR + value + System.lineSeparator()); }
                catch (IOException ex) { throw new UncheckedIOException(ex); }
            });
        } catch(UncheckedIOException ex) { throw ex.getCause(); }
    }

    public static void main(String[] args) throws IOException{
        ByteReader byteReader = new ByteReader("~\\Documents\\GitHub\\stringio\\src\\main\\java\\LocaleAndResource\\QaA.java");
        byteReader.getResult("outfile.txt");
    }
}
