package com.example.mytodolistapps;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPreferenceHelper {
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    public SharedPreferenceHelper(Context context) {
        this.sharedPreferences = context.getSharedPreferences("MyPref", Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }

    public void InsertAccountData(String username, String password) {
        editor.putString("KEY_USERNAME", username);
        editor.putString("KEY_PASSWORD", password);
        editor.apply();
    }

    public String GetUsername() {
        return sharedPreferences.getString("KEY_USERNAME", "");
    }

    public String GetPassword() {
        return sharedPreferences.getString("KEY_PASSWORD", "");
    }
}
