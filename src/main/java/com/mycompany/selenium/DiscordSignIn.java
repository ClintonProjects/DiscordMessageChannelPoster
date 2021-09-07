package com.mycompany.selenium;

import com.mycompany.model.DiscordDetails;
import com.mycompany.model.LocalVeribles;

public class DiscordSignIn extends BrowserConfig {

    public static void signIn() throws InterruptedException {
        driver.get("https://discord.com/login");
        findXpathSendKey("//*[@name='email']", LocalVeribles.discordLogin.getUsername());
        findXpathSendKey("//*[@name='password']", LocalVeribles.discordLogin.getPassword());
        findXpathClick("//*[@type='submit']");
        Thread.sleep(1000 * 30);
        findXpathSendKey("//*[@class='inputDefault-_djjkz input-cIJ7To']", LocalVeribles.discordLogin.getTwoFaCode());
        findXpathClick("//*[@type='submit']");
        if (elementExists("//*[@class='homeIcon-tEMBK1']") == true) {
            LocalVeribles.discordLogin.setLoggedIn(true);
        }
    }

    public static void SendMessage(String message, DiscordDetails discordDetails) throws InterruptedException {
        try {
            driver.get(discordDetails.discordLink());
            findXpathSendKey("//*[@data-slate-object='block'] ", message);
            Thread.sleep(1000 * 2);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void changeSite() {
        driver.get("https://www.google.com/");
    }
}
