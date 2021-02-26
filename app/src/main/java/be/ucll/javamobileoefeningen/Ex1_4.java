package be.ucll.javamobileoefeningen;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.ToggleButton;

public class Ex1_4 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex1_4);

        CheckBox checkBox = findViewById(R.id.checkBox);
        EditText editText = findViewById(R.id.editTextTextPersonName4);
        TextView textView = findViewById(R.id.textView);
        SeekBar seekBar = findViewById(R.id.seekBar);
        ProgressBar progressBar = findViewById(R.id.progressBar2);
        Switch switchButton = findViewById(R.id.switch1);
        ToggleButton toggleButton = findViewById(R.id.toggleButton);
        ImageView imageView = findViewById(R.id.imageView3);

        imageView.setVisibility(View.INVISIBLE);

        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    editText.setEnabled(true);
                    seekBar.setEnabled(true);
                    progressBar.setEnabled(true);
                    switchButton.setEnabled(true);
                    toggleButton.setEnabled(true);
                }
                if(!isChecked){
                    editText.setEnabled(false);
                    seekBar.setEnabled(false);
                    progressBar.setEnabled(false);
                    switchButton.setEnabled(false);
                    toggleButton.setEnabled(false);
                }
            }
        });

        editText. addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                textView.setText(s);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                progressBar.setProgress(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        switchButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked && toggleButton.isChecked()) {
                    imageView.setVisibility(View.VISIBLE);
                }else{
                    imageView.setVisibility(View.INVISIBLE);
                }
            }
        });

        toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked && switchButton.isChecked()) {
                    imageView.setVisibility(View.VISIBLE);
                }else{
                    imageView.setVisibility(View.INVISIBLE);
                }
            }
        });
    }
}