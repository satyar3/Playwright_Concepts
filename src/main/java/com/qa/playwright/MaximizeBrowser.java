package com.qa.playwright;

import com.microsoft.playwright.*;

import java.awt.*;
import java.nio.file.Path;

public class MaximizeBrowser {
    public static void main(String[] args) throws InterruptedException {

        try (Playwright playwright = Playwright.create()) {

            Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();


            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
            //BrowserContext context = browser.newContext(new Browser.NewContextOptions().setViewportSize(1920, 1080));
            BrowserContext context = browser.newContext(new Browser.NewContextOptions().setViewportSize((int)screenSize.getWidth(), (int)screenSize.getHeight()));
            Page page = context.newPage();

            page.navigate("https://google.com");

            page.close();
            browser.close();
            //playwright.close();
        }
    }
}