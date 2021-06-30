package com.demoqa.automation.steps;

import com.demoqa.automation.pageobjets.TextBoxPage;
import com.demoqa.automation.utils.Excel;
import net.thucydides.core.annotations.Step;
import org.mockito.internal.verification.Times;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

public class TextBoxSteps {
    Robot robot;
    TextBoxPage textBoxPage;
    WebDriver driver = new ChromeDriver();

    private static ArrayList<Map<String, String>> lecturaExcel = new ArrayList<Map<String, String>>();


    @Step
    public void openBrowser() {
        textBoxPage.open();
    }

    @Step
    public void fillFields() throws InterruptedException {

        try {
            lecturaExcel = Excel.readExcel("‪‪C:\\Users\\SOPORTETI\\IdeaProjects\\UserInfo.xlsx", "Hoja1");

        } catch (IOException e) {
            e.printStackTrace();
        }


        textBoxPage.closeFrame();
        textBoxPage.sendFirstName(lecturaExcel.get(0).get("Nombre"));
        textBoxPage.sendLastName(lecturaExcel.get(0).get("Apellido"));
        textBoxPage.sendEmail(lecturaExcel.get(0).get("Email"));
        textBoxPage.selectGender();
        textBoxPage.sendUserNumber(lecturaExcel.get(0).get("Celular"));
        textBoxPage.selectHobbies();
        textBoxPage.selectFile();
        textBoxPage.sendAddress(lecturaExcel.get(0).get("Direccion"));
        Thread.sleep(1000);


        try {
            robot = new Robot();
            robot.keyPress(KeyEvent.VK_TAB);
            robot.keyPress(KeyEvent.VK_DOWN);
            robot.keyPress(KeyEvent.VK_ENTER);

            robot.keyPress(KeyEvent.VK_TAB);
            robot.keyPress(KeyEvent.VK_DOWN);
            robot.keyPress(KeyEvent.VK_ENTER);

            Thread.sleep(2000);

            robot.keyPress(KeyEvent.VK_TAB);
            Thread.sleep(1000);
            robot.keyPress(KeyEvent.VK_ENTER);

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

            textBoxPage.validateMessage(textBoxPage.successfulRegisterMessage);



    }

    @Step
    public void quitBrowser() {
        driver.quit();

    }


}
