package com.qa.playwright;

import com.microsoft.playwright.*;

import java.awt.*;
import java.nio.file.Paths;

public class VideoRecording {
    public static void main(String[] args) throws InterruptedException {

        try (Playwright playwright = Playwright.create()) {

            Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();


            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
            BrowserContext context = browser.newContext(new Browser.NewContextOptions()
                    .setRecordVideoDir(Paths.get("myvids/"))
                    .setRecordVideoSize(1020,890));

            Page page = context.newPage();

            page.navigate("https://google.com");

            //Don't forget to close thr browser context otherwise video won't be recorded
            context.close();
            page.close();
            browser.close();
            //playwright.close();
        }
    }
}