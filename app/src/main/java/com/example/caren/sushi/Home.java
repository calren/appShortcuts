package com.example.caren.sushi;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ShortcutInfo;
import android.content.pm.ShortcutManager;
import android.graphics.drawable.Icon;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Collections;

public class Home extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }

    private void createDynamicShortcut() {
        ShortcutManager shortcutManager = getSystemService(ShortcutManager.class);


        ShortcutInfo restaurantShortcut = new ShortcutInfo.Builder(this, "shortcut_restaurant")
                .setShortLabel("Last Restaurant")
                .setLongLabel("Order again from the last restaurant")
                .setIcon(Icon.createWithResource(this, R.drawable.sushi))
                .setIntent(new Intent(Intent.ACTION_VIEW, Uri.parse("https://google.com")))
                .build();
        
        shortcutManager.setDynamicShortcuts(Collections.singletonList(restaurantShortcut));
    }
}
