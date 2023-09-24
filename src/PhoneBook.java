import java.util.*;

public class PhoneBook {
    /**
     * Реализуйте структуру телефонной книги с помощью HashMap.
     * Программа также должна учитывать, что во входной структуре
     * будут повторяющиеся имена с разными телефонами, их необходимо
     * считать, как одного человека с разными телефонами.
     * Вывод должен быть отсортирован по убыванию числа телефонов.
     */

    private HashMap<String, Set<Integer>> hashMap = new HashMap<>();

    public void add(String name, Integer phone) {
        if (hashMap.containsKey(name)) {
            hashMap.get(name).add(phone);
        } else {
            Set<Integer> numbers = new HashSet<>();
            numbers.add(phone);
            hashMap.put(name, numbers);
        }
    }

    public void printBook() {
        hashMap.entrySet().stream()
                .sorted(Map.Entry.comparingByValue((o1, o2) -> o2.size() - o1.size()))
                .forEach(n -> System.out.printf("Имя: %s \n Телефоны: %s \n", n.getKey(), n.getValue()));
    }
}
