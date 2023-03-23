package org.example;

public class Main {
    public static void main(String[] args) {

        Person mom = new PersonBuilder()
                .setName("Анна")
                .setSurname("Вольф")
                .setAge(21)
                .setAddress("Сидней")
                .build();

        Person son = mom.newChildBuilder()
                .setName("Антошка")
                .build();

        mom.happyBirthday();
        son.happyBirthday();

        System.out.println("У " + mom + " есть сын, " + son);


        try {
            // Возраст недопустимый
            new PersonBuilder().setName("Александр").setSurname("Ким").setAge(200).build();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }

        try {
            // Не хватает обязательных полей
            new PersonBuilder().setSurname("Ким").build();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }
    }
}
