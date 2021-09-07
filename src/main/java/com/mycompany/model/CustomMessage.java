package com.mycompany.model;

public class CustomMessage extends DiscordDetails {

    private String message;

    public CustomMessage(String id, String channelName, String channelId, String serverId, String message, boolean sendMessage) {
        super(id, channelName, channelId, serverId, sendMessage);
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
