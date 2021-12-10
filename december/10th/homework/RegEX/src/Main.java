import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    private static final String PHONE = "+375(29)123-12-12";
    private static final String EMAIL = "gn@sdn.ksdm";
    private static final String TEXT = "Foreign languages are absolutely necessary for people nowadays." +
            " More and more people of different professions decide to study foreign languages in order to raise" +
            " their professional level. Making business nowadays means the ability to speak at least one" +
            " foreign language. Among the most popular foreign languages in Russia are English, German, Spanish." +
            " French and Italian.\n English is the language of business correspondence, many foreign newspapers" +
            " and magazines, and communication between people of different nationalities all over the world." +
            " Reading foreign literature in the original, understanding foreign films without translation," +
            " making friends with people of other nationalities may make our intellectual and cultural horizons" +
            " wider.\n Foreign languages often bring new perspectives in career and private life. Many aspects" +
            " of our Life, like science, entertainment, business, studying became international. Many Russians" +
            " decide to receive good education, start their career or just spend some time abroad. Upon returning" +
            " to Russia they are able to share their knowledge, experience and information gained abroad with their" +
            " colleagues and friends.";

    public static void main(String[] args) {
        Pattern patternPhone = Pattern.compile("^\\+375\\((29|33)\\)\\d{3}(?:\\-\\d{2}){2}");
        Matcher matcherPhone = patternPhone.matcher(PHONE);
        while (matcherPhone.find()) {
            System.out.println("Phone: " + matcherPhone.group());
        }


        Pattern patternEmail = Pattern.compile(".*@.*\\..*");
        Matcher matcherEmail = patternEmail.matcher(EMAIL);
        while (matcherEmail.find()) {
            System.out.println("Email: " + matcherEmail.group());
        }


        Pattern patternWordsAtBeginningSentence = Pattern.compile("(\\.\\s*|^)([A-Z][a-z]+|[0-9]+)");
        Matcher matcher = patternWordsAtBeginningSentence.matcher(TEXT);
        System.out.print("Words at the beginning of sentence: ");
        while (matcher.find()) {
            System.out.print(matcher.group(2) + " ");
        }

        System.out.println();

        Pattern patternWordsAtEndSentence = Pattern.compile("\\s([^\\W]+?)\\.");
        Matcher matcherText = patternWordsAtEndSentence.matcher(TEXT);
        System.out.print("Words at the end of sentence: ");
        while (matcherText.find()) {
            System.out.print(matcherText.group(1) + " ");
        }
    }
}
