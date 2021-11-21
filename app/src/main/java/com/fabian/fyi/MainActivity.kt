package com.fabian.fyi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        final TextView textView = findViewById(R.id.clientId);
//        textView.setText("token");


//        textView.setOnClickListener(v -> {
//            ClipboardManager clipboard = (ClipboardManager) getApplicationContext().getSystemService(CLIPBOARD_SERVICE);
//            String text = textView.getText().toString();
//            ClipData myClip = ClipData.newPlainText("text", text);
//            clipboard.setPrimaryClip(myClip);
//            Toast.makeText(getApplicationContext(), text + " 已复制", Toast.LENGTH_SHORT).show();
//        });
    }
}