import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

// Реализуйте структуру телефонной книги с помощью HashMap, 
// учитывая, что 1 человек может иметь несколько телефонов.

/**
 * PhoneBook
 */
public class PhoneBook {
    
    public static void addNewContacts(HashMap <String, ArrayList<Integer>> phb) {
        Scanner iScan = new Scanner(System.in);
        System.out.println("Введите имя абонента: ");
        String name = iScan.nextLine();
        System.out.println("Введите номер телефона абонента: ");
        ArrayList<Integer> number = new ArrayList<>();
        number.add(iScan.nextInt());
        phb.put(name, number);
    }

    public static void addToExisting (HashMap <String, ArrayList<Integer>> phb) {
        Scanner iScan = new Scanner(System.in);
        System.out.println("Введите имя абонента: ");
        String name = iScan.nextLine();
        if (phb.containsKey(name)) {
            System.out.println("Введите номер телефона абонента: ");
            phb.get(name).add(iScan.nextInt());
        } else {
            System.out.println("Абонент не найден");
        }
    }

    public static void findContact (HashMap <String, ArrayList<Integer>> phb) {
        Scanner iScan = new Scanner(System.in);
        System.out.println("Введите имя абонента: ");
        String name = iScan.nextLine();
        if (phb.containsKey(name)) System.out.println(phb.get(name));
        else System.out.println("Абонент не найден");
    }

    public static void printMenu() {
        System.out.println("Выберите необходимое действие");
        System.out.println("Введите 1, если хотите создать новый контакт: ");
        System.out.println("Введите 2, если хотите добавить номер к существующему контакту");
        System.out.println("Введите 3, если хотите вывести всю телефонную книгу");
        System.out.println("Введите 4, если хотите найти номер по имени абонента");
        System.out.println("Введите 5, если хотите завершить работу");
    }
    
    public static void main(String[] args) {
        
        HashMap <String, ArrayList<Integer>> phoneBook = new HashMap<>();
        Scanner iScan = new Scanner(System.in);
        while(true) {
            printMenu();
            int choice = iScan.nextInt();
            if (choice == 5) break;
            else {
            switch (choice) {
                case 1:
                    addNewContacts(phoneBook);
                    break;
                case 2:
                    addToExisting(phoneBook);
                    break;
                case 3:
                    phoneBook.entrySet().forEach(System.out::println);
                    break;
                case 4:
                    findContact(phoneBook);
                    break;
            }
            }
            
        }
        iScan.close();
    }
}