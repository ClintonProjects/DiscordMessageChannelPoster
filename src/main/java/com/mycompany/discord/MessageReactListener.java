package com.mycompany.discord;
import org.json.JSONException;
import com.mycompany.model.LocalVeribles;
import com.mycompany.selenium.BrowserConfig;
import com.mycompany.selenium.DiscordSignIn;
import net.dv8tion.jda.api.events.message.priv.PrivateMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class MessageReactListener extends ListenerAdapter {

    @Override
    public void onPrivateMessageReceived(PrivateMessageReceivedEvent evt) {
        if (evt.getAuthor().getId().equalsIgnoreCase("User Discord Unique Id Goes Here")) { // This needs to be changed
            LocalVeribles.discordBot.setAuthor(evt.getAuthor());
            LocalVeribles.discordBot.setChannel(evt.getChannel());
            LocalVeribles.discordBot.setObjMsg(evt.getMessage());

            if (LocalVeribles.discordBot.getObjMsg().getContentRaw().startsWith("!cmd")) {
                DisocrdCommandService.commandList();
            } else if (LocalVeribles.discordLogin.isLoggedIn() == true && DisocrdCommandService.safety == true) {
                if (LocalVeribles.discordBot.getObjMsg().getContentRaw().startsWith("!set")) {
                    DisocrdCommandService.setMessage();
                } else if (LocalVeribles.discordBot.getObjMsg().getContentRaw().equalsIgnoreCase("!send")) {
                    try {
                        DisocrdCommandService.sendMessage();
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                } else if (LocalVeribles.discordBot.getObjMsg().getContentRaw().equalsIgnoreCase("!load")) {
                    try {
                        DisocrdCommandService.loadServers();
                    } catch (JSONException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    LocalVeribles.discordBot.sendMessage("Loading compeleted");
                } else if (LocalVeribles.discordBot.getObjMsg().getContentRaw().equalsIgnoreCase("!logout")) {
                    DiscordSignIn.changeSite();
                } else if (LocalVeribles.discordBot.getObjMsg().getContentRaw().equalsIgnoreCase("!list")) {
                    DisocrdCommandService.printAllSevers();
                }
            } else {
                if (LocalVeribles.discordBot.getObjMsg().getContentRaw().startsWith("!2fa")) {
                    LocalVeribles.discordBot.sendMessage("Login process has started");
                    DisocrdCommandService.twoFA(evt.getAuthor());
                }
            }
            if (LocalVeribles.discordBot.getObjMsg().getContentRaw().startsWith("!shutdown")) {
                LocalVeribles.discordBot.sendMessage("System shutting down");
                BrowserConfig.driver.close();
                System.exit(0);
            }
        }
    }
}
