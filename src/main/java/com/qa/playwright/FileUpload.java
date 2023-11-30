package com.qa.playwright;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.FilePayload;

import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileUpload {
    public static void main(String[] args) throws InterruptedException {

        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
            BrowserContext context = browser.newContext();
            Page page = context.newPage();

            page.navigate("https://google.com");

            //input type = file --> This attribute should be there, then only playwright can handle it
            page.setInputFiles("//input[@type='file']", Paths.get("path to the file"));

            //de-attach the file
            page.setInputFiles("//input[@type='file']", new Path[0]);

            //multiple file upload
            page.setInputFiles("//input[@type='file']",
                    new Path[]{Paths.get("file1 path"),Paths.get("file2 path")});

            //Create and upload file at run time
            //File type mime --- for 2nd argument i.e. text/plain, application/zip, audio/mpeg
            page.setInputFiles("//input[@type='file']",
                    new FilePayload("demo.txt","text/plain","content of the file".getBytes(StandardCharsets.UTF_8)));

            page.close();
            browser.close();
            //playwright.close();
        }
    }
}