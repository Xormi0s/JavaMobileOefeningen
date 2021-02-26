package be.ucll.javamobileoefeningen;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;

public class Ex1_5 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex1_5);

        TextView textView = findViewById(R.id.textView4);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
    }
}