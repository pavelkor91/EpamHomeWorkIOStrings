package LocaleAndResource;



import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

public class QaA {
    private ResourceBundle resourceBundle;

    public void loadQuestions(){
        System.out.println("Choose your language");
        System.out.println("1. Russian");
        System.out.println("2. English");
        Scanner scanner = new Scanner(System.in);
        switch(scanner.nextInt()){
            case 1:
                resourceBundle = ResourceBundle.getBundle("quest", new Locale("ru-RU"));
                break;
            case 2:
                resourceBundle = ResourceBundle.getBundle("quest",new Locale("en"));
                break;
                default:
                    System.out.println("unknown language, choose again");
                    loadQuestions();
        }
        getQuestion();
    }

    private void getQuestion(){
        String[] allStrings;
        resourceBundle.keySet().stream()
                .filter(s -> s.contains("question"))
                .forEach( s -> System.out.println(resourceBundle.getString(s))
                );
        System.out.println(resourceBundle.getString("requst"));
        getAnswer();
    }

    private void getAnswer(){
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        System.out.println(resourceBundle.getString("answer." + input));
    }

    public static void main(String[] args) {
        QaA qaA = new QaA();
        qaA.loadQuestions();
    }
}
