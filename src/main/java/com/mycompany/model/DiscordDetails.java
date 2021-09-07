package com.mycompany.model;

public class DiscordDetails {

    private String id;
    private String channelName;
    private String channelId;
    private String serverId;
    private boolean sendMessage;

    public DiscordDetails(String id, String channelName, String channelId, String serverId, boolean sendMessage) {
        this.id = id;
        this.channelName = channelName;
        this.channelId = channelId;
        this.serverId = serverId;
        this.sendMessage = sendMessage;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getChannelName() {
        return channelName;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    public String getServerId() {
        return serverId;
    }

    public void setServerId(String serverId) {
        this.serverId = serverId;
    }

    public boolean isSendMessage() {
        return sendMessage;
    }

    public void setSendMessage(boolean sendMessage) {
        this.sendMessage = sendMessage;
    }

    public String discordLink() {
        return "https://discord.com/channels/" + serverId + "/" + channelId;
    }

}
