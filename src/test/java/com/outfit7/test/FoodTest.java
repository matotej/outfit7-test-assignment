package com.outfit7.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import io.appium.java_client.MobileElement;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class FoodTest extends BaseTest {

    Date date= new Date();
    long time = date.getTime();
    String currentRunFolder = String.format("./Screenshots/%1$s/", time);

    @Test
    @Order(1)
    void feedTomButton() throws IOException, InterruptedException {
        driver.findElement(By.id("com.outfit7.talkingtom:id/foodButton")).click();

        // Wait for animation to end
        Thread.sleep(1000);

        // Click on milk
        driver.findElement(By.id("com.outfit7.talkingtom:id/foodItemMilk")).click();

        // Wait for animation
        Thread.sleep(2000);

        // Save image of Tom eating
        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File(String.format("%1$sTomDrinkingMilk.jpg", this.currentRunFolder)));

        driver.findElement(By.id("com.outfit7.talkingtom:id/foodButton"));

        System.out.println("### Tom is feed! ###");
    }

    @Test
    @Order(2)
    void infoButton() throws InterruptedException {
        // Click on info button
        driver.findElement(By.id("com.outfit7.talkingtom:id/buttonInfo")).click();

        // Click on how to play
        driver.findElement(By.id("com.outfit7.talkingtom:id/infoWebButtonHowToPlay")).click();

        // Get all bullet points
        MobileElement bulletsParent = driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.ViewFlipper/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.RelativeLayout[2]/android.webkit.WebView/android.webkit.WebView/android.widget.ListView"));
        List<MobileElement> howToPlayBullets = (List<MobileElement>) bulletsParent.findElementsByClassName("android.view.View");

        // Get text of first bullet point
        MobileElement firstBullet = howToPlayBullets.get(0);
        // Assert the text of the first bullet point
        assertEquals(firstBullet.getText(), "Talk to Tom and he repeats with a funny voice");

        // Close the info window
        driver.findElement(By.id("com.outfit7.talkingtom:id/infoWebButtonClose")).click();

        driver.findElement(By.id("com.outfit7.talkingtom:id/foodButton"));

        System.out.println("### We know 'How to play'! ###");
    }


    @Test
    @Order(3)
    void recordTom() throws IOException, InterruptedException {
        // Click on recording
        driver.findElement(By.id("com.outfit7.talkingtom:id/recorderButton")).click();

        Thread.sleep(500);

        // Click on gasmask action
        driver.findElement(By.id("com.outfit7.talkingtom:id/gasmask")).click();

        // Wait for animation to end
        Thread.sleep(2000);

        // Click on pawn action
        driver.findElement(By.id("com.outfit7.talkingtom:id/pawn")).click();

        // Wait for animation to end
        Thread.sleep(4000);

        // Stop recording
        driver.findElement(By.id("com.outfit7.talkingtom:id/recorderButton")).click();

        // Play recorded video
        driver.findElement(By.id("com.outfit7.talkingtom:id/recorderMenuButtonPlay")).click();

        // Wait for first screenshot
        Thread.sleep(1500);

        // Save image of Tom for gasmask action
        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File(String.format("%1$sTomGasMask.jpg", this.currentRunFolder)));

        // Wait for second screenshot
        Thread.sleep(3500);

        // Save image of Tom for pawn action
        scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File(String.format("%1$sTomPawn.jpg", this.currentRunFolder)));

        // Wait for animation to end
        Thread.sleep(2000);

        // Close record window
        driver.findElement(By.id("com.outfit7.talkingtom:id/recorderMenuButtonClose")).click();

        driver.findElement(By.id("com.outfit7.talkingtom:id/foodButton"));

        System.out.println("### Video of Tom playing ended! ###");
    }
}
