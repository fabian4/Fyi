package com.fabian.Fyi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView textView = findViewById(R.id.clientId);
        textView.setText("啊");

        textView.setOnClickListener(v -> {
            ClipboardManager clipboard = (ClipboardManager) getApplicationContext().getSystemService(CLIPBOARD_SERVICE);
            String text = textView.getText().toString();
            ClipData myClip = ClipData.newPlainText("text", text);
            clipboard.setPrimaryClip(myClip);
            Toast.makeText(getApplicationContext(), text + " 已复制", Toast.LENGTH_SHORT).show();
        });
    }
}