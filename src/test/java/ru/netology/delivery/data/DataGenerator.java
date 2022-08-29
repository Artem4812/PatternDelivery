package ru.netology.delivery.data;

import com.github.javafaker.Faker;
import lombok.Value;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class DataGenerator {
    private DataGenerator() {
    }

    public static String generateDate(int shift) {
        String date = LocalDate.now().plusDays(shift).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        return date;
    }

    public static String generateCity(String locale) {
        // генерацию можно выполнить с помощью Faker, либо используя массив валидных городов и класс Random
        List<String> cities = Arrays.asList("Самара", "Москва", "Пермь", "Санкт-Петербург", "Нальчик", "Брянск", "Краснодар", "Пенза", "Владимир", "Октябрьск", "Челябинск", "Волгоград", "Пермь");
        Random random = new Random();
        String city = cities.get(random.nextInt(cities.size()));
        return city;
    }





    public static String generateName(String locale) {
        Faker faker = new Faker(new Locale(locale));
        String name = faker.name().fullName();
        return name;
    }



    public static String generatePhone(String locale) {
        Faker faker = new Faker(new Locale("ru"));
        String phone = faker.numerify("[+7]##########");
        return phone;
    }
}