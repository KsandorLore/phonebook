import java.util.*;

public class PhoneBook {

    private Map<String, List<String>> phoneBook;

    public PhoneBook() {
        this.phoneBook = new HashMap<>();
    }

    public void addContact(String name, String phoneNumber) {
        List<String> phoneNumbers = phoneBook.getOrDefault(name, new ArrayList<>());
        phoneNumbers.add(phoneNumber);
        phoneBook.put(name, phoneNumbers);
    }

    public void displayPhoneBook() {
        phoneBook.entrySet().stream()
                .sorted((entry1, entry2) -> Integer.compare(entry2.getValue().size(), entry1.getValue().size()))
                .forEach(entry -> {
                    System.out.print(entry.getKey() + ": ");
                    System.out.print(entry.getValue());
                });
    }

    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();

        phoneBook.addContact("Alena", "123");
        phoneBook.addContact("Ivan", "456");
        phoneBook.addContact("Victor", "789");
        phoneBook.addContact("Alena", "111");
        phoneBook.addContact("Victor", "999");
        phoneBook.addContact("Alena", "333");

        phoneBook.displayPhoneBook();
    }
}