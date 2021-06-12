package com.mycompany.model;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.entities.User;

public class DiscordConnection {

    protected String discordToken;
    protected JDA jda;
    protected User Author;
    protected MessageChannel channel;
    protected Message objMsg;
    protected Guild guild;

    public DiscordConnection(String discordToken) {
        super();
        this.discordToken = discordToken;
    }

    public String getDiscordToken() {
        return discordToken;
    }

    public void setDiscordToken(String discordToken) {
        this.discordToken = discordToken;
    }

    public JDA getJda() {
        return jda;
    }

    public void setJda(JDA jda) {
        this.jda = jda;
    }

    public User getAuthor() {
        return Author;
    }

    public void setAuthor(User author) {
        Author = author;
    }

    public MessageChannel getChannel() {
        return channel;
    }

    public void setChannel(MessageChannel channel) {
        this.channel = channel;
    }

    public Message getObjMsg() {
        return objMsg;
    }

    public void setObjMsg(Message objMsg) {
        this.objMsg = objMsg;
    }

    public Guild getGuild() {
        return guild;
    }

    public void setGuild(Guild guild) {
        this.guild = guild;
    }
}
