import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Phone {
    private String number;
    private String model;
    private double weight;

    public Phone(String number, String model, double weight) {
        this.number = number;
        this.model = model;
        this.weight = weight;
    }

    public void receiveCall(String name) {
        System.out.println("Дзвонить " + name);
    }

    public String getNumber() {
        return number;
    }

    public static void main(String[] args) {
        List<Phone> phones = new ArrayList<>();
        phones.add(new Phone("380671755817", "Xiamomi", 0.5));
        phones.add(new Phone("380932381723", "Samsung", 0.3));
        phones.add(new Phone("380678234524", "Apple", 0.4));

        for (Phone phone : phones) {
            phone.receiveCall("Денис");
            System.out.println("Номер телефону: " + phone.getNumber());
        }

        writeToFile(phones, "phones.txt");
    }

    public static void writeToFile(List<Phone> phones, String fileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (Phone phone : phones) {
                writer.write("Номер: " + phone.getNumber() + ", Модель: " + phone.model + ", Вага: " + phone.weight + "\n");
            }
            System.out.println("Інформацію про абонентів записано у файл " + fileName);
        } catch (IOException e) {
            System.out.println("Помилка при записі у файл: " + e.getMessage());
        }
    }
}