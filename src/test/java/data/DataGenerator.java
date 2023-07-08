package data;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Random;

import com.github.javafaker.Faker;
import lombok.Value;

public class DataGenerator {

    private DataGenerator() {
    }

    @Value
    public static class UserInfo {
        String city;
        String name;
        String phone;
    }

    public static String generateDate(int shift) {
        return LocalDate.now().plusDays(shift).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
    }

    public static String generateCity(String locale) {
//        Faker faker = new Faker(new Locale(locale));
//        return faker.address().city();
        Random random = new Random();
        String[] cities = {"Уфа", "Петрозаводск", "Архангельск", "Киров", "Йошкар-Ола", "Смоленск", "Великий Новгород"};
        int index = random.nextInt(cities.length);
        return (cities[index]);
    }

    public static String generateName(String locale) {
        Faker faker = new Faker(new Locale(locale));
        return faker.name().fullName();
    }

    public static String generatePhone(String locale) {
        Faker faker = new Faker(new Locale(locale));
        return faker.phoneNumber().phoneNumber();
    }

    public static class Registration {
        private Registration() {
        }

        public static UserInfo generateUser(String locale) {
            return new UserInfo(generateCity(locale), generateName(locale), generatePhone(locale));
        }
    }
}
