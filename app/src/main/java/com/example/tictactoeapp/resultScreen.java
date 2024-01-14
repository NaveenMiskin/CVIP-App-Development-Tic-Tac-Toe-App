package com.example.tictactoeapp;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class resultScreen extends Dialog {

    private final String message;
    private final MainActivity mainActivity;

    public resultScreen(@NonNull Context context, String message, MainActivity mainActivity) {
        super(context);
        this.message = message;
        this.mainActivity = mainActivity;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_screen);

        TextView messageText = findViewById(R.id.msgText);
        Button startAgainButton = findViewById(R.id.startAgainButn);
        messageText.setText(message);


        startAgainButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(@NonNull View view) {
                mainActivity.restartMatch();
                dismiss();
            }
        });
    }
}