package com.mycompany.reminder;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import com.mycompany.discord.DisocrdCommandService;
import com.mycompany.model.LocalVeribles;

public class ReminderService {

    public static ScheduledExecutorService LottoWinnier;

    public static void startReminader(String userId) {

        System.out.println("reminder");
        LottoWinnier = Executors.newScheduledThreadPool(3);
        LottoWinnier.scheduleAtFixedRate(MessageReminders, 0, 60, TimeUnit.MINUTES);
    }

    static Thread MessageReminders = new Thread() {
        public void run() {
            try {
                LocalVeribles.discordBot.sendMessage(
                        "Hey, \n" + "Current message: " + DisocrdCommandService.message + "\n \n"
                        + "!send - sends the message in the server \n" + "!logout - logs off site");
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    };

}
