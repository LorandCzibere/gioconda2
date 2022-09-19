package gioconda2;

import jdk.swing.interop.SwingInterOpUtils;
import org.openqa.selenium.*;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Locatable;


import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;

//import java.awt.Rectangle;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Scanner;

public class gioconda2 {

    public static void main(String[] args) throws Exception {

        //Setup the Chrome driver
//        System.setProperty("webdriver.chrome.driver", "C:\\Users\\AlexandruDragos\\Documents\\TEST CASES\\chromedriver.exe");
//
//        ChromeOptions options = new ChromeOptions();
//        options.addExtensions(new File("0.0.2.36_0.crx"));
//        ChromeDriver chrome = new ChromeDriver(options);
//        chrome.get("https://upload.wikimedia.org/wikipedia/commons/thumb/e/ec/Mona_Lisa%2C_by_Leonardo_da_Vinci%2C_from_C2RMF_retouched.jpg/1200px-Mona_Lisa%2C_by_Leonardo_da_Vinci%2C_from_C2RMF_retouched.jpg");
//
//        chrome.manage().window().setPosition(new Point(2000, 0));
//        try {
//            Thread.sleep(500);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//        chrome.manage().window().maximize();
//        try {
//            Thread.sleep(500);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }


        FileWriter writer = new FileWriter("C:\\Users\\Lori Riot\\Downloads\\gioconda\\New Text Document.txt");
        File photo = new File("C:\\Users\\Lori Riot\\Downloads\\gioconda\\monalisa.jpg");
//        BufferedImage img = null;
//        try {
//            img = ImageIO.read(new File("C:\\Users\\AlexandruDragos\\Downloads\\monalisa\\fkkdnb-150x150.jpg"));
//            } catch (IOException e) {
//        }
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
//                writer.append(green+",");
//                writer.append(blue+"");
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
//        chrome.get("https://kleki.com/");
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

//        WebElement fileButton = chrome.findElement(By.xpath("/html/body/div[3]/div[2]/div[1]/div[1]/div[2]"));
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

//        WebElement width = chrome.findElement(By.xpath("/html/body/div[4]/div/div/div[3]/div[2]/div[2]/div[1]/div[1]/input"));
        WebElement width = chrome.findElement(By.xpath("/html/body/div[4]/div[2]/div/table/tbody/tr[1]/td[2]/input"));
        width.sendKeys(Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, "256");
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

//        WebElement height = chrome.findElement(By.xpath("/html/body/div[4]/div/div/div[3]/div[2]/div[2]/div[1]/div[2]/input"));
        WebElement height = chrome.findElement(By.xpath("/html/body/div[4]/div[2]/div/table/tbody/tr[2]/td[2]/input"));
        height.sendKeys(Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, "256");
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

//        WebElement ok = chrome.findElement(By.xpath("/html/body/div[4]/div/div/div[3]/div[3]/button[1]"));
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



//        WebElement brushSize = chrome.findElement(By.xpath("/html/body/div[3]/div[2]/div[1]/div[5]/div[3]/div[1]/div[1]/div[1]"));
        WebElement brushSize = chrome.findElement(By.xpath("/html/body/div[1]/div/div[1]/div[3]/div/div/ul/li[6]/span[2]/input"));
        brushSize.sendKeys(Keys.BACK_SPACE, Keys.BACK_SPACE, Keys.BACK_SPACE, "1");
//        int brushWid = brushSize.getSize().getWidth();
//        System.out.println(brushWid);
//        act.moveToElement(brushSize, brushWid - 40, 0).click().build().perform();
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



//        BufferedReader reader;
//        try {
//            reader = new BufferedReader(new FileReader("C:\\Users\\AlexandruDragos\\Downloads\\monalisa\\New Text Document.txt"));
//            String line = reader.readLine();
//            while (line != null) {
//                System.out.println(line);
//                line = reader.readLine();
//            }
//            reader.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        WebElement canvas = chrome.findElement(By.xpath("/html/body/div[3]/div[1]/canvas"));
        WebElement canvas = chrome.findElement(By.id("catch"));

        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader("C:\\Users\\AlexandruDragos\\Downloads\\monalisa\\New Text Document.txt"));
            String line = reader.readLine();
            while (line != null) {
//                for (int k = 0; k <= line.length(); k++) {
                for (int hei = 0; hei < canvas.getSize().getHeight(); hei++) {
                    for (int wid = 0; wid < canvas.getSize().getWidth(); wid++) {

                        canvas = chrome.findElement(By.id("catch"));
//                            try {
//                                Thread.sleep(500);
//                            } catch (InterruptedException e) {
//                                e.printStackTrace();
//                            }

//                        WebElement color = chrome.findElement(By.xpath("/html/body/div[3]/div[2]/div[1]/div[5]/div[1]/div[2]/div[1]/div[2]"));
                        WebElement color = chrome.findElement(By.xpath("/html/body/div[1]/div/div[3]/div[3]/div/div/table/tbody/tr[9]/td/div"));
                        color.click();
//                            try {
//                                Thread.sleep(500);
//                            } catch (InterruptedException e) {
//                                e.printStackTrace();
//                            }

                        for (int d = 0; d < 6; d++) {
//                            WebElement hex = chrome.findElement(By.xpath("/html/body/div[4]/div/div/div[3]/div[2]/div[2]/input"));
                            WebElement hex = chrome.findElement(By.xpath("/html/body/div[2]/div[1]/div/div[5]/input"));
                            hex.sendKeys(Keys.BACK_SPACE);
                        }
//                            try {
//                                Thread.sleep(500);
//                            } catch (InterruptedException e) {
//                                e.printStackTrace();
//                            }

//                        WebElement hex = chrome.findElement(By.xpath("/html/body/div[4]/div/div/div[3]/div[2]/div[2]/input"));
                        WebElement hex = chrome.findElement(By.xpath("/html/body/div[2]/div[1]/div/div[5]/input"));
                        hex.sendKeys(reader.readLine());
//                            try {
//                                Thread.sleep(500);
//                            } catch (InterruptedException e) {
//                                e.printStackTrace();
//                            }

//                        WebElement hexClick = chrome.findElement(By.xpath("/html/body/div[4]/div/div/div[3]/div[3]/button[1]"));
//                        hexClick.click();


                        act.click().build().perform();
//                            try {
//                                Thread.sleep(500);
//                            } catch (InterruptedException e) {
//                                e.printStackTrace();
//                            }
                        act.moveToElement(canvas, wid-128, hei-128).click().build().perform();
                        //act.moveToElement(canvas, wid-74, hei-76).click().build().perform();
//                            try {
//                                Thread.sleep(500);
//                            } catch (InterruptedException e) {
//                                e.printStackTrace();
//                            }
                    }



//                    WebElement canvas = chrome.findElement(By.id("catch"));
//                    try {
//                        Thread.sleep(500);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//
//                    WebElement color = chrome.findElement(By.xpath("/html/body/div[1]/div/div[3]/div[3]/div/div/table/tbody/tr[9]/td/div"));
//                    color.click();
//                    try {
//                        Thread.sleep(500);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//
//                    for (int d = 0; d < 6; d++) {
//                        WebElement hex = chrome.findElement(By.xpath("/html/body/div[2]/div[1]/div/div[5]/input"));
//                        hex.sendKeys(Keys.BACK_SPACE);
//                    }
//                    try {
//                        Thread.sleep(500);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//
//                    WebElement hex = chrome.findElement(By.xpath("/html/body/div[2]/div[1]/div/div[5]/input"));
//                    hex.sendKeys(reader.readLine());
//                    try {
//                        Thread.sleep(500);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//
//                    Actions act = new Actions(chrome);
//
//                    canvas.click();
//                    act.moveToElement(canvas, -249, -371).click().build().perform();
                }
            }
//            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}









//        for (int w = 0; w < canvas.getRect().getWidth(); w++) {
//            for (int h = 0; h < canvas.getRect().getHeight(); h++) {
//                canvas = chrome.findElement(By.xpath("/html/body/div[1]/div/div[5]/div[3]/div/div/canvas[2]"));
//
//                chrome.findElement(By.xpath("/html/body/div[1]/div/div[3]/div[3]/div/div/table/tbody/tr[9]/td/div")).click();
//                try {
//                    Thread.sleep(500);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//
//                for (int d = 0; d < 6; d++) {
//                    chrome.findElement(By.xpath("/html/body/div[2]/div[1]/div/div[5]/input")).sendKeys(Keys.BACK_SPACE);
//                }
//                try {
//                    Thread.sleep(500);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//
//                chrome.findElement(By.xpath("/html/body/div[2]/div[1]/div/div[5]/input")).clear();
//                try {
//                    Thread.sleep(500);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//
//                BufferedReader reader;
//                try {
//                    reader = new BufferedReader(new FileReader("C:\\Users\\AlexandruDragos\\Downloads\\monalisa\\New Text Document.txt"));
//                    String line = reader.readLine();
//                    while (line != null) {
//                        chrome.findElement(By.xpath("/html/body/div[2]/div[1]/div/div[5]/input")).sendKeys(line);
//                        try {
//                            Thread.sleep(500);
//                        } catch (InterruptedException e) {
//                            e.printStackTrace();
//                        }
//                        chrome.findElement(By.xpath("/html/body/div[1]/div/div[3]/div[3]/div/div/table/tbody/tr[2]/td/div")).click();
//                        try {
//                            Thread.sleep(500);
//                        } catch (InterruptedException e) {
//                            e.printStackTrace();
//                        }
//
//                        for (int o = 0; o < line.length(); o++) {
//                            Actions action = new Actions(chrome);
//                            int xOffset = canvas.getRect().getX();
//                            int xOffset1 = xOffset+1;
//                            try {
//                                Thread.sleep(500);
//                            } catch (InterruptedException e) {
//                                e.printStackTrace();
//                            }
//                            action.dragAndDropBy(canvas, xOffset, xOffset1).perform();
//                            try {
//                                Thread.sleep(500);
//                            } catch (InterruptedException e) {
//                                e.printStackTrace();
//                            }
//                        }
//                    }
//                    reader.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }





//                chrome.findElement(By.xpath("/html/body/div[1]/div/div[3]/div[3]/div/div/table/tbody/tr[2]/td/div")).click();
//                try {
//                    Thread.sleep(500);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//
//                Actions action = new Actions(chrome);
//                int xOffset = canvas.getRect().getX();
//                int xOffset1 = xOffset+1;
//                action.dragAndDropBy(canvas, xOffset, xOffset1).perform();