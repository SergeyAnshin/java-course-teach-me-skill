import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

//        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("taskOneOriginal.txt"));
//             BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("taskOneResult.txt"))) {
//            String word;
//            while ((word = bufferedReader.readLine()) != null) {
//                if (TextFormatter.isPalindrome(word)) {
//                    bufferedWriter.write(word + "\n");
//                }
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("taskTwoOriginal.txt"));
//             BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("taskTwoResult.txt"))) {
//            String sentence;
//            while ((sentence = bufferedReader.readLine()) != null) {
//                int numberWordsInSentence = TextFormatter.getNumberWordsInSentence(sentence);
//                if (TextFormatter.thereIsPalindromeInSentence(sentence) ||
//                        (numberWordsInSentence >= 3 && numberWordsInSentence <= 5)) {
//                    bufferedWriter.write(sentence + "\n");
//
//                }
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }


//        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("taskThreeOriginal.txt"));
//             BufferedReader blackListReader = new BufferedReader(new FileReader("taskThreeBlackList.txt"))) {
//            List<String> sentences = new ArrayList<>();
//            String sentence;
//            while ((sentence = bufferedReader.readLine()) != null) {
//                sentences.add(sentence);
//            }
//
//            List<String> words = new ArrayList<>();
//            String line;
//            while ((line = blackListReader.readLine()) != null) {
//                words.addAll(List.of(line.split(",")));
//            }
//
//            List<String> sentencesWithInvalidWords = TextFormatter.getSentencesWithInvalidWords(sentences, words);
//            if (sentencesWithInvalidWords.size() == 0) {
//                System.out.println("Текст прошёл проверку на цензуру");
//            } else {
//                System.out.println("Количество предложений не прошедших проверку: " + sentencesWithInvalidWords.size());
//                System.out.println("Предложения подлежащие исправлению: " + sentencesWithInvalidWords);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

//
//        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("taskThreeOriginal.txt"));
//             BufferedReader blackListReader = new BufferedReader(new FileReader("taskThreeBlackList.txt"))) {
//
//            List<String> words = new ArrayList<>();
//            String line;
//            while ((line = blackListReader.readLine()) != null) {
//                words.addAll(List.of(line.split(",")));
//            }
//
//            List<String> sentencesWithInvalidWords = new ArrayList<>();
//            String sentence;
//            while ((sentence = bufferedReader.readLine()) != null) {
//                if (!TextFormatter.getSentencesWithInvalidWordsTwo(sentence, words).isEmpty()) {
//                    sentencesWithInvalidWords.add(sentence);
//                }
//            }
//
//            if (sentencesWithInvalidWords.size() == 0) {
//                System.out.println("Текст прошёл проверку на цензуру");
//            } else {
//                System.out.println("Количество предложений не прошедших проверку: " + sentencesWithInvalidWords.size());
//                System.out.println("Предложения подлежащие исправлению: " + sentencesWithInvalidWords);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

//        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("taskThreeOriginal.txt"));
//             BufferedReader blackListReader = new BufferedReader(new FileReader("taskThreeBlackList.txt"))) {
//
//            List<String> words = new ArrayList<>();
//            String line;
//            while ((line = blackListReader.readLine()) != null) {
//                words.addAll(List.of(line.split(",")));
//            }
//
//            List<String> sentencesWithInvalidWords = new ArrayList<>();
//            String sentence;
//            while ((sentence = bufferedReader.readLine()) != null) {
//                if (TextFormatter.isInvalidWordsInSentence(sentence, words)) {
//                    sentencesWithInvalidWords.add(sentence);
//                }
//            }
//
//            if (sentencesWithInvalidWords.size() == 0) {
//                System.out.println("Текст прошёл проверку на цензуру");
//            } else {
//                System.out.println("Количество предложений не прошедших проверку: " + sentencesWithInvalidWords.size());
//                System.out.println("Предложения подлежащие исправлению: " + sentencesWithInvalidWords);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        ArrayList<Long> arrayList = new ArrayList<>();
        int x = 0;
        while (x < 100) {
            long start = System.currentTimeMillis();

            try (BufferedReader bufferedReader = new BufferedReader(new FileReader("taskThreeOriginal.txt"));
                 BufferedReader blackListReader = new BufferedReader(new FileReader("taskThreeBlackList.txt"))) {

                List<String> words = new ArrayList<>();
                String line;
                while ((line = blackListReader.readLine()) != null) {
                    words.addAll(List.of(line.split(",")));
                }

                List<String> sentencesWithInvalidWords = new ArrayList<>();
                String sentence;
                while ((sentence = bufferedReader.readLine()) != null) {
                    if (TextFormatter.isInvalidWordsInSentenceBinarySearch(sentence, words)) {
                        sentencesWithInvalidWords.add(sentence);
                    }
                }

                if (sentencesWithInvalidWords.size() == 0) {
                    System.out.println("Текст прошёл проверку на цензуру");
                } else {
                    System.out.println("Количество предложений не прошедших проверку: " + sentencesWithInvalidWords.size());
                    System.out.println("Предложения подлежащие исправлению: " + sentencesWithInvalidWords);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            long end = System.currentTimeMillis();
            arrayList.add(end-start);
            x++;
        }

        System.out.println(arrayList.stream().mapToLong(num -> num).average());







    }
}
