package com.qa.playwright;

import com.microsoft.playwright.*;

import java.nio.file.Path;
import java.nio.file.Paths;

public class TraceViewer {
    public static void main(String[] args) {

        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch();
            BrowserContext context = browser.newContext();

            // Start tracing before creating / navigating a page.
            context.tracing().start(new Tracing.StartOptions()
                    .setScreenshots(true)
                    .setSnapshots(true)
                    .setSources(true));

            Page page = context.newPage();
            page.navigate("https://playwright.dev");
            page.navigate("https://google.com");
            String pageTitle = page.title();
            System.out.println("Current Page title is : "+pageTitle);

            page.fill("textarea[name='q']", "Satya");
            page.click("//input[@name='btnK']");

            // Stop tracing and export it into a zip archive.
            context.tracing().stop(new Tracing.StopOptions()
                    .setPath(Paths.get("trace.zip")));
        }
    }
}