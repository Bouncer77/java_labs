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

        String buf; // ����� ��� ��������� ������, ��������� �� �������
        try (Scanner scanner = new Scanner(
                new FileReader(".\\src\\main\\resources\\" + fileName))) {

            while (scanner.hasNextLine()) {
                buf = scanner.nextLine();


                //majorityMap(buf, frequencyAppearances);


                for (Character ch : buf.toCharArray()) {
                    // ���������� true, ���� ��������� �������� ���� k (ch)
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

        // ����������
        frequencyAppearances.entrySet().stream()
                .sorted(Map.Entry.<Character, Integer> comparingByValue().reversed())
                .forEach(System.out::println); // ��� ����� ������ �������� �����

        // ����� � ����������� ����� ������
        for (Map.Entry<Character, Integer> entry :
                frequencyAppearances.entrySet()) {
            Character key = entry.getKey();
            Integer val = entry.getValue();
            System.out.println(key + " - " + val);
        }
    }

    public static void majorityMap(String str, Map<Character, Integer> map) {

        //HashMap<Character, Integer> map = new HashMap<>();
        // ������� ����������� ����� ����� (N)
        for (int i = 0; i < str.length(); ++i) {
            // � ���������� ����� �� �������, ��� � �������? ����� ������� ������ � ����
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
        // ������� ������� ����� ���������� ����
        Dictionary<int,uint> candidates = new Dictionary<int,uint>{};

        // �������� �� ������� � ��������� ������ �� k
        for (int i = 0; i<N; i++) {

            // � ���������� ����� �� �������, ��� � �������? ����� ������� ������ � ����
            if (candidates.ContainsKey(array[i]))
                candidates[array[i]]++;
            else // �����, ����� ����� ��� � k-1 ����������?
                if (candidates.Count < k - 1)
                    candidates[array[i]] = 1;
                else // ����� � k-1 ������� ����������, ��� ��� ��������� ��� ������
                    foreach(int l in candidates.Keys)
            if (candidates[l]-- == 0)              // (**)
                candidates.Remove(l);                // (*)
        }

        return candidates.Keys.ToArray();
    }*/
}
