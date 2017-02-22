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
        createDynamicShortcut();
    }

    private void createDynamicShortcut() {
        ShortcutManager shortcutManager = getSystemService(ShortcutManager.class);


        ShortcutInfo restaurantShortcut = new ShortcutInfo.Builder(this, "shortcut_restaurant")
                .setShortLabel("Last Restaurant")
                .setLongLabel("Order again from the last restaurant")
                .setIcon(Icon.createWithResource(this, R.drawable.sushi))
                .setIntents(
                        new Intent[]{
                                new Intent(Intent.ACTION_MAIN, Uri.EMPTY, this, Home.class)
                                        .setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK),
                                new Intent(DetailActivity.INTENT_RECEIVER)
                        })
                .build();

        shortcutManager.setDynamicShortcuts(Collections.singletonList(restaurantShortcut));
    }
}
