package com.mycompany.discord;

import java.awt.Color;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.security.auth.login.LoginException;

import com.mycompany.model.DiscordConnection;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.JDABuilder;

public class DiscordBot extends DiscordConnection {

    public DiscordBot(String discordToken) {
        super(discordToken);
        // TODO Auto-generated constructor stub
    }

    public void Discord() throws LoginException, InterruptedException, UnsupportedEncodingException, IOException {
        jda = JDABuilder.createLight(discordToken).addEventListeners(new MessageReactListener()).build().awaitReady();
    }

    public void sendPM(String message) {
        EmbedBuilder embed = new EmbedBuilder();
        embed.setAuthor(getJda().getSelfUser().getName(), null, getJda().getSelfUser().getEffectiveAvatarUrl());
        embed.setColor(Color.yellow);
        embed.setDescription(message);
        jda.openPrivateChannelById().queue(); //long channel id goes here of user to private message, this will error if empty
        channel.sendMessage(embed.build()).queue();
    }

    public void sendMessage(String message) {
        EmbedBuilder embed = new EmbedBuilder();
        embed.setAuthor(getJda().getSelfUser().getName(), null, getJda().getSelfUser().getEffectiveAvatarUrl());
        embed.setColor(Color.yellow);
        embed.setDescription(message);
        jda.openPrivateChannelById().queue();  //long channel id goes here of user to private message, this will error if empty
        channel.sendMessage(embed.build()).queue();
    }

}
