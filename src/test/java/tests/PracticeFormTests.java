package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.PracticeFormPage;
import static io.qameta.allure.Allure.step;

public class PracticeFormTests extends TestBase {
    PracticeFormPage practiceFormPage = new PracticeFormPage();

    @Test
    @DisplayName("Регистрация с заполнением всех полей формы")
    void fillAllFieldsTest() {

        step("Открыть форму регистрации", () -> {
            practiceFormPage.openPage()
                    .removeBanners();
        });

        step("Заполнить все поля формы и нажать submit", () -> {
            practiceFormPage.setFirstName(data.firstName)
                    .setLastName(data.lastName)
                    .setEmail(data.email)
                    .setGender(data.gender)
                    .setUserNumber(data.userNumber)
                    .setDateOfBirth(data.userBirthDay, data.userBirthMonth, data.userBirthYear)
                    .setSubjects(data.subject)
                    .setHobbies(data.hobby)
                    .uploadPicture(data.picture)
                    .setCurrentAddress(data.currentAddress)
                    .setState(data.state)
                    .setCity(data.city)
                    .submit();
        });

        step("Проверить результат заполнения формы", () -> {
            practiceFormPage.checkResult("Student Name", data.firstName + " " + data.lastName)
                    .checkResult("Student Email", data.email)
                    .checkResult("Gender", data.gender)
                    .checkResult("Mobile", data.userNumber)
                    .checkResult("Date of Birth", data.userBirthDay + " " + data.userBirthMonth + "," + data.userBirthYear)
                    .checkResult("Subjects", data.subject)
                    .checkResult("Hobbies", data.hobby)
                    .checkResult("Picture", data.picture)
                    .checkResult("Address", data.currentAddress)
                    .checkResult("State and City", data.state + " " + data.city);
        });
    }

    @Test
    @DisplayName("Регистрация с заполнением только обязательных полей формы")
    void fillOnlyRequiredFieldsTest() {

        step("Открыть форму регистрации", () -> {
            practiceFormPage.openPage()
                    .removeBanners();
        });

        step("Заполнить обязательные поля формы и нажать submit", () -> {
            practiceFormPage.setFirstName(data.firstName)
                    .setLastName(data.lastName)
                    .setGender(data.gender)
                    .setUserNumber(data.userNumber)
                    .setDateOfBirth(data.userBirthDay, data.userBirthMonth, data.userBirthYear)
                    .submit();
        });

        step("Проверить результат заполнения формы", () -> {
            practiceFormPage.checkResult("Student Name", data.firstName + " " + data.lastName)
                    .checkResult("Gender", data.gender)
                    .checkResult("Mobile", data.userNumber)
                    .checkResult("Date of Birth", data.userBirthDay + " " + data.userBirthMonth + "," + data.userBirthYear);
        });
    }

    @Test
    @DisplayName("Регистрация с незаполненным обязательным полем email")
    void emptyFirstNameTest() {

        step("Открыть форму регистрации", () -> {
            practiceFormPage.openPage()
                    .removeBanners();
        });

        step("Заполнить обязательные поля формы, кроме email, и нажать submit", () -> {
            practiceFormPage.setLastName(data.lastName)
                    .setGender(data.gender)
                    .setUserNumber(data.userNumber)
                    .setDateOfBirth(data.userBirthDay, data.userBirthMonth, data.userBirthYear)
                    .submit();
        });

        step("Проверить, что поле email выделено красной рамкой", () -> {
            practiceFormPage.checkEmptyFirstNameResult();
        });
    }
}
