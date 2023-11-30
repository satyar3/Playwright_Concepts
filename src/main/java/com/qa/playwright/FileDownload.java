package com.qa.playwright;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.FilePayload;

import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileDownload {
    public static void main(String[] args) throws InterruptedException {

        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
            BrowserContext context = browser.newContext();
            Page page = context.newPage();

            page.navigate("https://google.com");

            Download download = page.waitForDownload(() -> page.click("a:text('chromedriver_mac64.zip')"));
            download.path(); // temp path with some random name
            download.saveAs(Path.of("some path"));
            String failureReason = download.failure();
            String suggestedFilename = download.suggestedFilename();

            page.close();
            browser.close();
            //playwright.close();
        }
    }
}