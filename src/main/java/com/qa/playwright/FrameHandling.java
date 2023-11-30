package com.qa.playwright;

import com.microsoft.playwright.*;

import java.util.List;

public class FrameHandling {

    public static void main(String[] args) {

        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

        BrowserContext browserContext = browser.newContext();
        Page page = browserContext.newPage();

        page.navigate("http://londonfreelance.org/courses/frames/index.html");
        List<Frame> frames = page.frames();
        frames.forEach(frame -> System.out.println(frame.name()));

        FrameLocator frameLocator = page.frameLocator("frame[name='main']");
        String textContent = frameLocator.locator("h2").textContent();
        System.out.println(textContent);


        playwright.close();
    }
}
