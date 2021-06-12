package com.mycompany.discordspammessage2;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.security.auth.login.LoginException;

import org.json.JSONException;

import com.mycompany.discord.DiscordBot;
import com.mycompany.discord.DisocrdCommandService;
import com.mycompany.model.DiscordLogin;
import com.mycompany.model.LocalVeribles;
import com.mycompany.selenium.BrowserConfig;

public class onStart {

    public static void onstart()
            throws LoginException, UnsupportedEncodingException, InterruptedException, IOException, JSONException {
        BrowserConfig.setBrowserConfig();
        DisocrdCommandService.loadServers();
        LocalVeribles.discordBot = new DiscordBot("discord token"); // This cannot be empty
        LocalVeribles.discordBot.Discord();
        LocalVeribles.discordLogin = new DiscordLogin("discord user name", "discord password", "2fa code"); // This cannot be empty
    } 
}
