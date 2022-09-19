package gioconda2;

import org.openqa.selenium.*;


import org.openqa.selenium.Point;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;



import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;



public class gioconda2 {
    public static void main(String[] args) throws Exception {


        FileWriter writer = new FileWriter("C:\\Users\\Lori Riot\\Downloads\\gioconda\\New Text Document.txt");
        File photo = new File("C:\\Users\\Lori Riot\\Downloads\\gioconda\\monalisa.jpg");

        BufferedImage img = ImageIO.read(photo);
        for (int y = 0; y < img.getHeight(); y++) {
            for (int x = 0; x < img.getWidth(); x++) {
                int pixel = img.getRGB(x, y);
                Color color = new Color(pixel, true);
                int red = color.getRed();
                int green = color.getGreen();
                int blue = color.getBlue();
                String hex = String.format("%02x%02x%02x", red, green, blue);
                writer.append(hex);
                writer.append("\n");
                writer.flush();
            }
        }

        writer.close();
        System.out.println("HEX values of each pixel are stored to the file.");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Lori Riot\\Downloads\\gioconda\\chromedriver.exe");
        ChromeDriver chrome = new ChromeDriver();
        chrome.get("https://www.youidraw.com/apps/painter/#");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        chrome.manage().window().setPosition(new Point(2000, 0));
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        chrome.manage().window().maximize();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement fileButton = chrome.findElement(By.xpath("/html/body/div[1]/div/div[1]/div[3]/div/div/ul/li[1]/button/span[1]"));
        fileButton.click();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement newImage = chrome.findElement(By.xpath("/html/body/ul[4]/li[1]/a"));
        newImage.click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement width = chrome.findElement(By.xpath("/html/body/div[4]/div[2]/div/table/tbody/tr[1]/td[2]/input"));
        width.sendKeys(Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, "256");
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement height = chrome.findElement(By.xpath("/html/body/div[4]/div[2]/div/table/tbody/tr[2]/td[2]/input"));
        height.sendKeys(Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, "256");
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement ok = chrome.findElement(By.xpath("/html/body/div[4]/div[4]/input[1]"));
        ok.click();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement brush = chrome.findElement(By.xpath("/html/body/div[1]/div/div[3]/div[3]/div/div/table/tbody/tr[3]/td/div"));
        brush.click();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement type = chrome.findElement(By.xpath("/html/body/div[1]/div/div[1]/div[3]/div/div/ul/li[3]/div"));
        type.click();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement brushType = chrome.findElement(By.xpath("/html/body/ul[1]/li[34]/div"));
        brushType.click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Actions act = new Actions(chrome);



        WebElement brushSize = chrome.findElement(By.xpath("/html/body/div[1]/div/div[1]/div[3]/div/div/ul/li[6]/span[2]/input"));
        brushSize.sendKeys(Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, "1");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement brushSpace = chrome.findElement(By.xpath("/html/body/div[1]/div/div[1]/div[3]/div/div/ul/li[7]/span/input"));
        brushSpace.sendKeys(Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, "1");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        WebElement canvas = chrome.findElement(By.id("catch"));

        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader("C:\\Users\\AlexandruDragos\\Downloads\\monalisa\\New Text Document.txt"));
            String line = reader.readLine();
            while (line != null) {
                for (int hei = 0; hei < canvas.getSize().getHeight(); hei++) {
                    for (int wid = 0; wid < canvas.getSize().getWidth(); wid++) {

                        canvas = chrome.findElement(By.id("catch"));

                        WebElement color = chrome.findElement(By.xpath("/html/body/div[1]/div/div[3]/div[3]/div/div/table/tbody/tr[9]/td/div"));
                        color.click();

                        for (int d = 0; d < 6; d++) {
                            WebElement hex = chrome.findElement(By.xpath("/html/body/div[2]/div[1]/div/div[5]/input"));
                            hex.sendKeys(Keys.BACK_SPACE);
                        }

                        WebElement hex = chrome.findElement(By.xpath("/html/body/div[2]/div[1]/div/div[5]/input"));
                        hex.sendKeys(reader.readLine());

                        act.click().build().perform();

                        act.moveToElement(canvas, wid - 128, hei - 128).click().build().perform();
                    }
                }
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}