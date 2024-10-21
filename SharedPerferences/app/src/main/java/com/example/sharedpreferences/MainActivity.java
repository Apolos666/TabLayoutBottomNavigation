package com.example.sharedpreferences;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private SharedPreferences sharedPreferences;
    private EditText editTextUsername;
    private Switch switchNotifications;
    private Spinner spinnerLanguage;
    private SeekBar seekBarFontSize;
    private TextView textViewFontSize;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sharedPreferences = getSharedPreferences("AppSettings", MODE_PRIVATE);

        editTextUsername = findViewById(R.id.editTextUsername);
        switchNotifications = findViewById(R.id.switchNotifications);
        spinnerLanguage = findViewById(R.id.spinnerLanguage);
        seekBarFontSize = findViewById(R.id.seekBarFontSize);
        textViewFontSize = findViewById(R.id.textViewFontSize);
        Button buttonSave = findViewById(R.id.buttonSave);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.languages, android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinnerLanguage.setAdapter(adapter);

        loadSettings();

        seekBarFontSize.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                textViewFontSize.setText("Kích thước chữ: " + progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

        buttonSave.setOnClickListener(v -> saveSettings());
    }

    private void loadSettings() {
        String username = sharedPreferences.getString("username", "");
        boolean notifications = sharedPreferences.getBoolean("notifications", true);
        int languageIndex = sharedPreferences.getInt("language", 0);
        int fontSize = sharedPreferences.getInt("fontSize", 14);

        editTextUsername.setText(username);
        switchNotifications.setChecked(notifications);
        spinnerLanguage.setSelection(languageIndex);
        seekBarFontSize.setProgress(fontSize);
        textViewFontSize.setText("Kích thước chữ: " + fontSize);
    }

    private void saveSettings() {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("username", editTextUsername.getText().toString());
        editor.putBoolean("notifications", switchNotifications.isChecked());
        editor.putInt("language", spinnerLanguage.getSelectedItemPosition());
        editor.putInt("fontSize", seekBarFontSize.getProgress());
        editor.apply();

        Toast.makeText(this, "Đã lưu cài đặt", Toast.LENGTH_SHORT).show();
    }
}
