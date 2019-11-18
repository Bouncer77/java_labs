import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    private static final String fileName = "War_and_Peace.txt";

    private static Map<Character, Integer> frequencyAppearances = new HashMap<>();

    public static void main(String[] args)  {

        String buf; // буфер для временной строки, считанной из сканера
        try (Scanner scanner = new Scanner(
                new FileReader(".\\src\\main\\resources\\" + fileName))) {

            while (scanner.hasNextLine()) {
                buf = scanner.nextLine();


                //majorityMap(buf, frequencyAppearances);


                for (Character ch : buf.toCharArray()) {
                    // возвращает true, если коллекция содержит ключ k (ch)
                    if (frequencyAppearances.containsKey(ch)) {
                        frequencyAppearances.replace(ch,
                                frequencyAppearances.get(ch) + 1);
                    } else {
                        frequencyAppearances.put(ch, 1);
                    }
                }
            }
        } catch (FileNotFoundException e) {
            System.out.printf("File \"%s\" did not found", fileName);
        }
        /*catch (NullPointerException e) {
            System.out.println("NULL EXEPTION");
        }*/

        // сортировка
        frequencyAppearances.entrySet().stream()
                .sorted(Map.Entry.<Character, Integer> comparingByValue().reversed())
                .forEach(System.out::println); // или любой другой конечный метод

        // вывод в стандартный поток вывода
        for (Map.Entry<Character, Integer> entry :
                frequencyAppearances.entrySet()) {
            Character key = entry.getKey();
            Integer val = entry.getValue();
            System.out.println(key + " - " + val);
        }
    }

    public static void majorityMap(String str, Map<Character, Integer> map) {

        //HashMap<Character, Integer> map = new HashMap<>();
        // заранее неизвестное число строк (N)
        for (int i = 0; i < str.length(); ++i) {
            // у следующего такой же элемент, как у стоящих? тогда встанет вместе с ними
            if (map.containsKey(str.charAt(i)))
                map.replace(str.charAt(i), map.get(str.charAt(i)) + 1);
            else
                if (map.size() < str.length() - 1)
                    map.put(str.charAt(i), 1);
                    //map.replace(str.charAt(i), 1);
            else
                for (char ch : str.toCharArray()) {
                    if (map.containsKey(ch))
                    if (map.get(ch) == 0) {
                        //map.replace(ch, map.get(ch) - 1);
                        map.remove(ch);
                    }
                }
        }
    }

/*    int[] majority(int[] array, int N, int k) {
        // словарь стоящих людей изначально пуст
        Dictionary<int,uint> candidates = new Dictionary<int,uint>{};

        // проходим по массиву и усаживаем группы по k
        for (int i = 0; i<N; i++) {

            // у следующего такой же элемент, как у стоящих? тогда встанет вместе с ними
            if (candidates.ContainsKey(array[i]))
                candidates[array[i]]++;
            else // может, стоят менее чем с k-1 элементами?
                if (candidates.Count < k - 1)
                    candidates[array[i]] = 1;
                else // стоят с k-1 другими элементами, так что усаживаем всю группу
                    foreach(int l in candidates.Keys)
            if (candidates[l]-- == 0)              // (**)
                candidates.Remove(l);                // (*)
        }

        return candidates.Keys.ToArray();
    }*/
}
