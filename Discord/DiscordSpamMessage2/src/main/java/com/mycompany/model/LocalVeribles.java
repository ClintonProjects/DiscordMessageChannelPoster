package com.mycompany.model;
import java.util.ArrayList;
import com.mycompany.discord.DiscordBot;
import com.mycompany.discord.DisocrdCommandService;

public class LocalVeribles {

    public static DisocrdCommandService disocrdCommandService = new DisocrdCommandService();
    public static DiscordBot discordBot;
    public static ArrayList<DiscordDetails> discordDetails = new ArrayList();
    public static DiscordLogin discordLogin;
    public static boolean bumpstatus = false;
}
