package com.example.yourkeys;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class PreferenciasUser {

    //identificador do banco de dados destas preferencias
    public static final String PREF_ID = "yourkeys";

    public static void setValuesBoolean(Context context, String chave, boolean valor) {
        SharedPreferences preferences = context.getSharedPreferences(PREF_ID, 0);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean(chave, valor);
        editor.commit();
    }

    public static boolean getValuesBoolean(Context context, String chave) {
        SharedPreferences preferences = context.getSharedPreferences(PREF_ID, 0);
        boolean b = preferences.getBoolean(chave, false);
        return b;
    }

    public static void setValuesInt(Context context, String chave, int valor) {
        SharedPreferences preferences = context.getSharedPreferences(PREF_ID, 0);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putInt(chave, valor);
        editor.commit();
    }

    public static int getValuesInt(Context context, String chave) {
        SharedPreferences preferences = context.getSharedPreferences(PREF_ID, 0);
        int b = preferences.getInt(chave, 0);
        return b;
    }

    public static void setValuesString(Context context, String chave, String valor) {
        SharedPreferences preferences = context.getSharedPreferences(PREF_ID, 0);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(chave, valor);
        editor.commit();
    }

    public static String getValuesString(Context context, String chave) {
        SharedPreferences preferences = context.getSharedPreferences(PREF_ID, 0);
        String b = preferences.getString(chave, "");
        return b;
    }

    public static boolean isCheckNotification(final Context context) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        return preferences.getBoolean("PREF_CHECK_NOTIFICATION", false);
    }
}
