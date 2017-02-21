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


        ShortcutInfo webShortcut = new ShortcutInfo.Builder(this, "shortcut_web")
                .setShortLabel("novoda.com")
                .setLongLabel("Open novoda.com web site")
//                .setIcon(Icon.createWithResource(this, R.drawable.ic_dynamic_shortcut))
                .setIntent(new Intent(Intent.ACTION_VIEW, Uri.parse("https://novoda.com")))
                .build();


        shortcutManager.setDynamicShortcuts(Collections.singletonList(webShortcut));

        Intent myIntent = new Intent(Home.this, DetailActivity.class);
        myIntent.putExtra("key", 123); //Optional parameters
        Home.this.startActivity(myIntent);
    }
}
