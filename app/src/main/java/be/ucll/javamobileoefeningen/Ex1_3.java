package be.ucll.javamobileoefeningen;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Ex1_3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex1_3);
        EditText editText = findViewById(R.id.editTextTextPersonName3);

        Button button = findViewById(R.id.button);
        /*button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(null, "Via de code: " + editText.getText());
            }
        });*/
    }

    public void clickMe(View view){
        EditText editText = findViewById(R.id.editTextTextPersonName3);
        Log.d(null, "Via de UI: " + editText.getText());
    }
}