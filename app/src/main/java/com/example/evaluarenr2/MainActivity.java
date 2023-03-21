package com.example.evaluarenr2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText editText;
    private Button button;
    private TextView resultText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.edit_text);

        Button countButton = findViewById(R.id.count_button);
        countButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = editText.getText().toString().trim();
                if (text.isEmpty()) {
                    showMessage("Introduceți textul în cutia de editare!");
                } else {
                    try {
                        int wordCount = countWords(text);
                        showMessage("Textul introdus conține " + wordCount + " cuvinte.");
                    } catch (Exception e) {
                        showMessage("A apărut o eroare: " + e.getMessage());
                    }
                }
            }
        });
    }

    private int countWords(String text) throws Exception {
        if (text.isEmpty()) {
            throw new Exception("Textul este gol!");
        }

        String[] words = text.split("\\s+");
        return words.length;
    }

    private void showMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }
}