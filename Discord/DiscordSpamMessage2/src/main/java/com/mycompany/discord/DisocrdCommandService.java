package com.mycompany.discord;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.openqa.selenium.Keys;

import com.mycompany.json.Jsonto;
import com.mycompany.json.NotePad;
import com.mycompany.model.DiscordDetails;
import com.mycompany.model.LocalVeribles;
import com.mycompany.reminder.ReminderService;
import com.mycompany.selenium.DiscordSignIn;

import net.dv8tion.jda.api.entities.User;

public class DisocrdCommandService {

    public static String message = "";
    public static boolean safety = false;

    public static void setMessage() {
        message = "";
        String[] Split = LocalVeribles.discordBot.getObjMsg().getContentRaw().split(" ");
        System.out.println(Split.length);
        for (int i = 1; i < Split.length; i++) {
            message += Split[i] + " ";
        }
        String reply = message;
        message = message.replace("\n", Keys.chord(Keys.SHIFT, Keys.ENTER));
        message += "\n";
        System.out.println("Message: " + message);
        LocalVeribles.discordBot.sendPM("Current message: \n" + reply);
    }

    public static void twoFA(User Author) {
        String[] Split = LocalVeribles.discordBot.getObjMsg().getContentRaw().split(" ");
        LocalVeribles.discordLogin.setTwoFaCode(Split[1]);
        try {
            DiscordSignIn.signIn();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        if (LocalVeribles.discordLogin.isLoggedIn() == false) {
            LocalVeribles.discordBot.sendPM("Login Attempt Failed.");
        } else {
            ReminderService.startReminader(Author.getId());
            LocalVeribles.discordBot.sendPM("Login Attempt Sucessful.");
            safety = true;
        }
    }

    public static void commandList() {
        LocalVeribles.discordBot.sendMessage("Commands List \n" + "!set <message> - lets you set the message \n"
                + "!send - sends the message in the server \n" + "!load - updates all the servers \n"
                + "!2fa <2fa code> - logs into discord \n" + "!logout - logs off site");
    }

    public static void loadServers() throws JSONException {
        NotePad notePad = new NotePad();
        JSONArray rsGoldObjList = Jsonto.stringToObjectArray(notePad.read("Servers"));
        LocalVeribles.discordDetails.clear();
        System.out.println(rsGoldObjList.length());

//		for (Object i : rsGoldObjList) {
        for (int i = 0; i < rsGoldObjList.length(); i++) {
            JSONObject firstResult = (JSONObject) rsGoldObjList.get(i);
            LocalVeribles.discordDetails.add(new DiscordDetails(firstResult.getString("id"),
                    firstResult.getString("channelName"), firstResult.getString("channelId"),
                    firstResult.getString("serverId"), firstResult.getBoolean("sendMessage")));
        }
    }

    public static void printAllSevers() {
        for (int i = 0; i < LocalVeribles.discordDetails.size(); i++) {
            System.out.println(LocalVeribles.discordDetails.get(i).getChannelName());
        }
    }

    public static void sendMessage() throws InterruptedException {
        // LocalVeribles.discordDetails
        Thread thread = new Thread() {
            public void run() {
                LocalVeribles.bumpstatus = true;
                try {
                    System.out.println("message " + message);
                    if (!message.isEmpty()) {
                        LocalVeribles.discordBot.sendMessage("message starting process has started.");
                        for (DiscordDetails i : LocalVeribles.discordDetails) {
                            if (i.isSendMessage() == true) {
                                try {
                                    Jsonto jsonto = new Jsonto();
                                    System.out.println(jsonto.objectToString(i));
                                    DiscordSignIn.SendMessage(message, i);
                                } catch (Exception e) {
                                    System.out.println(e);
                                }
                            }
                        }
                        LocalVeribles.discordBot.sendPM("Messages are sent.");
                    } else {
                        LocalVeribles.discordBot.sendPM("Message is Empty.");
                    }
                    DiscordSignIn.changeSite();
                } catch (Exception e) {
                }
            }
        };

        thread.start();
        LocalVeribles.bumpstatus = false;
    }

}
