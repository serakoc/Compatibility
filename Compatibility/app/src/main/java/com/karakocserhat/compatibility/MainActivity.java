package com.karakocserhat.compatibility;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.text.Normalizer;

public class MainActivity extends AppCompatActivity {

    protected String nom1, nom2;
    protected EditText eNom1, eNom2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void valider(View view) {
        eNom1 = findViewById(R.id.name1);
        eNom2 = findViewById(R.id.name2);

        nom1 = eNom1.getText().toString().toLowerCase();
        nom2 = eNom2.getText().toString().toLowerCase();

        nom1 = Normalizer.normalize(nom1, Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "");
        nom2 = Normalizer.normalize(nom2, Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "");

        int res1 = 0;
        int res2 = 0;

        for(int i = 0; i < nom1.length(); i++)
        {
            res1 =+ (int)(nom1.charAt(i))-96;
        }

        for(int i = 0; i < nom2.length(); i++)
        {
            res2 =+ (int)(nom2.charAt(i)) - 96;
        }

        Toast.makeText(getApplicationContext(), (res1) + "\n" + (res2) + " :: " + ((int)nom1.charAt(0)-96), Toast.LENGTH_SHORT).show();


    }
}