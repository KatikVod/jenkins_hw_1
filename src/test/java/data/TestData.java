package data;

import com.github.javafaker.Faker;

public class TestData {
    Faker faker = new Faker();
    public String firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            email = faker.internet().emailAddress(),
            gender = faker.options().option("Male", "Female", "Other"),
            userNumber = faker.phoneNumber().subscriberNumber(10),
            userBirthDay = String.format("%02d", faker.number().numberBetween(1, 28)),
            userBirthMonth = faker.options().option("January", "February", "March", "April",
                    "May", "June", "July", "August", "September", "October", "November", "December"),
            userBirthYear = String.format("%s",faker.number().numberBetween(1900,2100)),
            hobby = faker.options().option("Sports", "Reading", "Music"),
            subject = faker.options().option("Maths", "Art", "Accounting", "Physics", "Chemistry", "Economics", "English",
                    "Biology", "History", "Civics", "Computer Science", "Social Studies", "Hindi", "Commerce"),
            currentAddress = faker.address().fullAddress(),
            state = faker.options().option("NCR", "Uttar Pradesh", "Haryana", "Rajasthan"),
            city = getRandomCity(),
            picture = faker.options().option("1.png", "2.jpeg", "3.bmp");

    public String getRandomCity() {
        if (state.equals("NCR")) city = faker.options().option("Delhi", "Gurgaon", "Noida");
        if (state.equals("Uttar Pradesh")) city = faker.options().option("Agra", "Lucknow", "Merrut");
        if (state.equals("Haryana")) city = faker.options().option("Karnal", "Panipat");
        if (state.equals("Rajasthan")) city = faker.options().option("Jaipur", "Jaiselmer");
        return city;
    }
}
