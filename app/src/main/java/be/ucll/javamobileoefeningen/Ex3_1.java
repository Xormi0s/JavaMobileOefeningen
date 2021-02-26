package be.ucll.javamobileoefeningen;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;

public class Ex3_1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex3_1);
    }

    public void toggle(View view) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        Fragment fragment = fragmentManager.findFragmentById(R.id.fragment);
        FragmentTransaction transaction = fragmentManager.beginTransaction();

        if(fragment.isAdded()){
            transaction.hide(fragment);
        }
        if(fragment.isHidden()){
            transaction.show(fragment);
        }
        transaction.commit();
    }

    public void add(View view){
        FragmentManager fragmentManager = getSupportFragmentManager();
        Fragment fragment = fragmentManager.findFragmentById(R.id.fragment);

        Class fragmentToAdd;
        if(fragment instanceof Ex3_1Fragment1){
            fragmentToAdd = Ex3_1Fragment2.class;
        } else{
            fragmentToAdd = Ex3_1Fragment1.class;
        }

        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.fragment, fragmentToAdd, null);
        transaction.commit();
    }
}