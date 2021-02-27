package be.ucll.javamobileoefeningen;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.LocaleList;
import android.view.Choreographer;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Ex2_2a extends AppCompatActivity {

    ActivityResultLauncher<Intent> mGetContent = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    Intent intent = result.getData();
                    ImageView imageView = findViewById(R.id.imageView);
                    TextView textView = findViewById(R.id.textView2);

                    LocalDate now = LocalDate.now();
                    DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("d[d]/M[M]/yyyy");
                    LocalDate geboortedatum = LocalDate.parse(intent.getExtras().getString("geboortedatum"), dateTimeFormatter).withYear(now.getYear());

                    if (now.isAfter(geboortedatum)){
                        geboortedatum = geboortedatum.plusYears(1);
                    }

                    long maanden = ChronoUnit.MONTHS.between(now, geboortedatum);
                    long dagen = ChronoUnit.DAYS.between(now.plusMonths(maanden), geboortedatum);

                    String geboortedatumText = "";
                    if(maanden == 0 && dagen == 0){
                        imageView.setVisibility(View.VISIBLE);
                        geboortedatumText = "Proficiat het is vandaag jou verjaardag !";
                    } else {
                        geboortedatumText = "Dit betekend dat je verjaardag binnen " + maanden + " maand(en) is en " + dagen + " dag(en)!";
                    }

                    String output = "Hallo " + intent.getExtras().getString("voornaam") + " " + intent.getExtras().getString("achternaam")
                            + ", je bent geboren op " + intent.getExtras().getString("geboortedatum") + " en de datum vandaag is " + DateTimeFormatter.ofPattern("dd/MM/yyyy").format(now)
                            + ". " + geboortedatumText;

                    textView.setText(output);
                }
            });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex2_2a);
    }

    public void start(View view){
        ImageView imageView = findViewById(R.id.imageView);
        imageView.setVisibility(View.INVISIBLE);
        mGetContent.launch(new Intent(this, Ex2_2b.class));
    }
}