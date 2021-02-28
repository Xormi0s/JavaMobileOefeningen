package be.ucll.javamobileoefeningen;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Ex2_3 extends AppCompatActivity {

    ActivityResultLauncher<Intent> mGetContent = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    TextView textView = findViewById(R.id.textView6);
                    if(result.getResultCode() == RESULT_OK){
                        textView.setText("Contact toegevoegd !");
                    } else {
                        textView.setText("Contact toevoegen mislukt !");
                    }
                }
            });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex2_3);
    }

    public void addContact(View view){
        String voornaam = ((EditText) findViewById(R.id.editTextTextPersonName10)).getText().toString();
        String achternaam = ((EditText) findViewById(R.id.editTextTextPersonName11)).getText().toString();
        String email = ((EditText) findViewById(R.id.editTextTextEmailAddress)).getText().toString();
        String telefoon = ((EditText) findViewById(R.id.editTextPhone)).getText().toString();

        Intent intent = new Intent(Intent.ACTION_INSERT);
        intent.setType(ContactsContract.Contacts.CONTENT_TYPE);
        intent.putExtra(ContactsContract.Intents.Insert.NAME, voornaam + " " + achternaam);
        intent.putExtra(ContactsContract.Intents.Insert.PHONE, telefoon);
        intent.putExtra(ContactsContract.Intents.Insert.EMAIL, email);
        intent.putExtra("finishActivityOnSaveCompleted", true);


        mGetContent.launch(intent);
    }
}