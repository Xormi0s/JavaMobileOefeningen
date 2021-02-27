package be.ucll.javamobileoefeningen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Ex2_2b extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex2_2b);
    }

    public void back(View view){
        EditText voornaam = findViewById(R.id.editTextTextPersonName5);
        EditText achternaam = findViewById(R.id.editTextTextPersonName6);
        EditText geboortedatum = findViewById(R.id.editTextDate);

        Intent intent = new Intent();
        intent.putExtra("voornaam", voornaam.getText().toString());
        intent.putExtra("achternaam", achternaam.getText().toString());
        intent.putExtra("geboortedatum", geboortedatum.getText().toString());

        setResult(RESULT_OK, intent);
        finish();
    }
}