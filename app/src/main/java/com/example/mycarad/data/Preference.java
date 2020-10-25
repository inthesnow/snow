package com.example.mycarad.data;

import android.content.Context;
import android.content.SharedPreferences;

public class Preference {

    private static final String PREFERENCE = "PREFERENCE";
    private static final String ID = "ID";
    private static final String PW = "PW";

    public String getId(Context context) {
        SharedPreferences sp = context.getSharedPreferences(PREFERENCE, Context.MODE_PRIVATE);
        return sp.getString(ID, "");
    }

    public void setId(Context context, String id) {
        SharedPreferences sp = context.getSharedPreferences(PREFERENCE, Context.MODE_PRIVATE);
        SharedPreferences.Editor eidtor = sp.edit();
        eidtor.putString(ID, id);
        eidtor.apply();
    }

    public String getPw(Context context) {
        SharedPreferences sp = context.getSharedPreferences(PREFERENCE, Context.MODE_PRIVATE);
        return sp.getString(PW, "");
    }

    public void setPw(Context context, String pw) {
        SharedPreferences sp = context.getSharedPreferences(PREFERENCE, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString(PW, pw);
        editor.apply();
    }
}
