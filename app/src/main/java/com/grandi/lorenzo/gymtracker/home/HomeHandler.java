package com.grandi.lorenzo.gymtracker.home;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.fragment.app.FragmentActivity;

import com.grandi.lorenzo.gymtracker.FlagList;
import com.grandi.lorenzo.gymtracker.R;
import com.grandi.lorenzo.gymtracker.scanner.ScannerActivity;
import com.grandi.lorenzo.gymtracker.taskactivity.TaskActivityHandler;
import com.grandi.lorenzo.gymtracker.task.CalendarHandler;

import static com.grandi.lorenzo.gymtracker.KeyLoader.*;

public class HomeHandler extends FragmentActivity {

    private TextView tv_date, tv_name, tv_account_id;
    AppCompatImageButton acib_profile, acib_scanner, acib_settings, acib_training;
    private String name, account_id;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_handler);

        preferenceLoader(this);
        initViewComponents(this);
        initTaskComponents();

        this.acib_profile.setOnClickListener(v -> {
            preferenceSaver(this);
            this.acib_profile.setPressed(true);

            Intent intent = new Intent(this, TaskActivityHandler.class);
            new FlagList(intent);
            intent.putExtra(EXTRA_TASK_SELECTOR.getValue(), "profile");
            startActivity(intent);
        });
        this.acib_scanner.setOnClickListener(v -> {
            preferenceSaver(this);
            this.acib_scanner.setPressed(true);

            Intent intent = new Intent(this, ScannerActivity.class);
            new FlagList(intent);
            startActivity(intent);
        });
        this.acib_training.setOnClickListener(v -> {
            preferenceSaver(this);
            this.acib_training.setPressed(true);

            Intent intent = new Intent(this, TaskActivityHandler.class);
            new FlagList(intent);
            intent.putExtra(EXTRA_TASK_SELECTOR.getValue(), "training");
            startActivity(intent);
        });
        this.acib_settings.setOnClickListener(v -> {
            preferenceSaver(this);
            this.acib_settings.setPressed(true);

            Intent intent = new Intent(this, TaskActivityHandler.class);
            new FlagList(intent);
            intent.putExtra(EXTRA_TASK_SELECTOR.getValue(), "settings");
            startActivity(intent);
        });
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finishAffinity();
    }

    private void preferenceLoader(Activity activity) {
        SharedPreferences sharedPreferences;
        sharedPreferences = (SharedPreferences) activity.getSharedPreferences(LOGIN_PREFERENCE_FILE.getValue(), MODE_PRIVATE);
        this.name = sharedPreferences.getString(nameKey.getValue(), nameKey.getValue());
        this.account_id = sharedPreferences.getString(accountIdKey.getValue(), accountIdKey.getValue());
    }
    private void preferenceSaver(Activity activity) {
        SharedPreferences sharedPreferences;
        sharedPreferences = (SharedPreferences) activity.getSharedPreferences(LOGIN_PREFERENCE_FILE.getValue(), MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(nameKey.getValue(), this.name);
        editor.putString(accountIdKey.getValue(), this.account_id);
        editor.apply();
    }
    private void initViewComponents(Activity activity) {
        this.tv_name = activity.findViewById(R.id.tv_name);
        this.tv_account_id = activity.findViewById(R.id.tvLogin);
        this.tv_date = activity.findViewById(R.id.tv_date);

        this.acib_profile = activity.findViewById(R.id.profile_opener);
        this.acib_scanner = activity.findViewById(R.id.scanner_opener);
        this.acib_training = activity.findViewById(R.id.training_opener);
        this.acib_settings = activity.findViewById(R.id.settings_opener);
    }
    private void initTaskComponents(){
        this.tv_date.setText((new CalendarHandler()).getDate());
        if (!name.isEmpty() && !name.equals(nameKey.getValue())) this.tv_name.setText(this.name);
        if (!account_id.isEmpty() && !account_id.equals(nameKey.getValue())) this.tv_account_id.setText(this.account_id);
    }
}