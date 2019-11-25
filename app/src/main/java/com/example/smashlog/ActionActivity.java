package com.example.smashlog;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;

public class ActionActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private Spinner spinner1, spinner2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_action);

        //character spinners
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.characters_array,
                android.R.layout.simple_spinner_dropdown_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner1 = findViewById(R.id.spinner);
        spinner1.setAdapter(adapter);
        spinner1.setOnItemSelectedListener(this);

        spinner2 = findViewById(R.id.spinner2);
        spinner2.setAdapter(adapter);
        spinner2.setOnItemSelectedListener(this);

        try {
            SheetsConnectivity.printSheet();
        } catch (Exception e){
            System.out.println("ERROR CONNECTING TO GOOGLE SHEETS");
            System.out.println(e.toString());
        }
    }

    public void onItemSelected(AdapterView<?> parent, View view, int pos, long id){
        String name = parent.getItemAtPosition(pos).toString();
        switch(parent.getId()){
            case R.id.spinner:
                //update the image for player1
                UpdateCharacterImage((ImageView)findViewById(R.id.imageView), name);
                break;
            case R.id.spinner2:
                //update the image for player2
                UpdateCharacterImage((ImageView)findViewById(R.id.imageView2), name);
                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    public void UpdateCharacterImage(ImageView imageView, String name){
        name = name.toLowerCase();
        name = name.replaceAll("\\s", "");
        name = name.replace(".", "");
        int id = getResources().getIdentifier(name, "drawable", getPackageName());
        imageView.setImageResource(id);
    }
}
