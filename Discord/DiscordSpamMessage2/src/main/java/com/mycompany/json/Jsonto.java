package com.mycompany.json;

import java.io.IOException;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Jsonto {

    public static String objectToString(Object object) {
        JSONObject jsonObject = new JSONObject(object);
        String myJson = jsonObject.toString();
        return myJson;
    }

    public static JSONArray stringToObjectArray(String JsonString) throws JSONException {
        return new JSONArray(JsonString);
    }

    public static void printJson(JSONArray arr, int size) throws JSONException {
        System.out.println(arr.toString(size));
    }

    public static void addObjectToFile(JSONObject obj) throws JSONException, IOException {
        NotePad notePad = new NotePad();
        JSONArray arr = new JSONArray();
        arr.put(obj);
        JSONArray rsGoldObjList = Jsonto.stringToObjectArray(notePad.read("Servers"));
        for (int i = 0; i < rsGoldObjList.length(); i++) {
            arr.put(rsGoldObjList.get(i));
        }
        System.out.println(arr.toString(4));
        notePad.writeData("Servers", arr.toString(4));
    }
}
