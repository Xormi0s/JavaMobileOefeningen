package be.ucll.javamobileoefeningen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Ex2_1a extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex2_1a);
    }

    public void explicit(View view) {
        Intent intent = new Intent(this, Ex2_1c.class);
        startActivity(intent);
    }

    public void implicit(View view) {
        Intent intent = new Intent("be.ucll.myapp.Ex2_1b");
        startActivity(intent);
    }
}