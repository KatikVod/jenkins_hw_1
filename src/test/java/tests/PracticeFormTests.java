package tests;

import org.junit.jupiter.api.Test;
import pages.PracticeFormPage;

public class PracticeFormTests extends TestBase {
    PracticeFormPage practiceFormPage = new PracticeFormPage();

    @Test
    void fillAllFieldsTest() {

        practiceFormPage.openPage()
                .removeBanners()
                .setFirstName(data.firstName)
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
                .submit()

                .checkResult("Student Name", data.firstName + " " + data.lastName)
                .checkResult("Student Email", data.email)
                .checkResult("Gender", data.gender)
                .checkResult("Mobile", data.userNumber)
                .checkResult("Date of Birth", data.userBirthDay + " " + data.userBirthMonth + "," + data.userBirthYear)
                .checkResult("Subjects", data.subject)
                .checkResult("Hobbies", data.hobby)
                .checkResult("Picture", data.picture)
                .checkResult("Address", data.currentAddress)
                .checkResult("State and City", data.state + " " + data.city);

    }

    @Test
    void fillOnlyRequiredFieldsTest() {
        practiceFormPage.openPage()
                .removeBanners()
                .setFirstName(data.firstName)
                .setLastName(data.lastName)
                .setGender(data.gender)
                .setUserNumber(data.userNumber)
                .setDateOfBirth(data.userBirthDay, data.userBirthMonth, data.userBirthYear)
                .submit()

                .checkResult("Student Name", data.firstName + " " + data.lastName)
                .checkResult("Gender", data.gender)
                .checkResult("Mobile", data.userNumber)
                .checkResult("Date of Birth", data.userBirthDay + " " + data.userBirthMonth + "," + data.userBirthYear);
    }

    @Test
    void emptyFirstNameTest() {
        practiceFormPage.openPage()
                .removeBanners()
                .setLastName(data.lastName)
                .setGender(data.gender)
                .setUserNumber(data.userNumber)
                .setDateOfBirth(data.userBirthDay, data.userBirthMonth, data.userBirthYear)
                .submit()

                .checkEmptyFirstNameResult();

    }
}
