package com.example.caren.sushi;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ShortcutInfo;
import android.content.pm.ShortcutManager;
import android.graphics.drawable.Icon;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;

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

        ForegroundColorSpan purpleSpan = new ForegroundColorSpan
                (getResources().getColor(android.R.color.holo_red_light, getTheme()));
        String label = "Last";
        SpannableStringBuilder colouredLabel = new SpannableStringBuilder(label);
        colouredLabel.setSpan(purpleSpan, 0, label.length(), Spanned.SPAN_INCLUSIVE_INCLUSIVE);


        ShortcutInfo restaurantShortcut = new ShortcutInfo.Builder(this, "shortcut_restaurant")
                .setShortLabel(colouredLabel)
                .setLongLabel("Order again")
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
