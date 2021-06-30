package com.demoqa.automation.pageobjets;


import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;
import java.io.File;


@DefaultUrl("https://www.demoqa.com/automation-practice-form")
public class TextBoxPage extends PageObject {

    public By textBoxFirstName = By.id("firstName");
    public By textBoxLastName = By.id("lastName");
    public By textBoxuserEmail = By.id("userEmail");
    public By textBoxUserNumber = By.id("userNumber");
    public By radioButtonGender = By.xpath("//label[@for='gender-radio-2'][contains(.,'Female')]");
    public By textBoxSubjects = By.className("subjects-auto-complete__control");
    public By radioButtonHobbies = By.xpath("//label[@for='hobbies-checkbox-1'][contains(.,'Sports')]");
    public By closeFrame = By.id("close-fixedban");
    public By buttonSelectFile = By.id("uploadPicture");
    public By textBoxAddress = By.id("currentAddress");
    public By successfulRegisterMessage = By.id("example-modal-sizes-title-lg");
    public By checkBoxState = By.xpath("//div[@class='css-1wa3eu0-placeholder'][contains(.,'Select State')]");
    public By checkBoxCity = By.id("city");


    public void sendFirstName(String data) {
        getDriver().findElement(textBoxFirstName).sendKeys(data);
    }

    public void sendLastName(String data) {
        getDriver().findElement(textBoxLastName).sendKeys(data);
    }

    public void sendEmail(String data) {
        getDriver().findElement(textBoxuserEmail).sendKeys(data);
    }

    public void sendUserNumber(String data) {
        getDriver().findElement(textBoxUserNumber).sendKeys(data);
    }

    public void selectGender() {
        getDriver().findElement(radioButtonGender).click();
    }

    public void closeFrame() {
        getDriver().findElement(closeFrame).click();
    }

    public void sendSubjects(String data) throws InterruptedException {
//        getDriver().findElement(textBoxSubjects).click();
//        System.out.println("di clic en subjects");

        Thread.sleep(2000);
        getDriver().findElement(textBoxSubjects).sendKeys(data);
        System.out.println("copie en subjects");

    }

    public void selectHobbies() {
        getDriver().findElement(radioButtonHobbies).click();
    }

    public void selectFile() {
        File file = new File("C:\\Users\\SOPORTETI\\IdeaProjects\\Imagen.jpg");
        String path = file.getAbsolutePath();
        getDriver().findElement(buttonSelectFile).sendKeys(path);

    }

    public void sendAddress(String data) {
        getDriver().findElement(textBoxAddress).sendKeys(data);

    }

    public boolean validateMessage(By elemento) {
        return getDriver().findElement(elemento).isDisplayed();

    }


}
