package com.example.smashlog;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;

import org.w3c.dom.Text;

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

        /*
        try {
            //SheetsConnectivity.printSheet(getAssets(), getBaseContext());
        } catch (Exception e){
            System.out.println("ERROR CONNECTING TO GOOGLE SHEETS");
            System.out.println(e.toString());
        }
         */


        //spreadsheet import logic

        //from cell 0,0
        String originCell; // get cell 0,0 which is organized as ("player name"(down) vs "playername" (top))
        //String[] originCellArray = originCell.split(" ");
        String playername1; //= originCellArray[0];
        String playername2; //= originCellArray[3];//1 is the (down), 2 is the vs, 3 should be the playername

        //change button names
        Button buttonPlayer1 = findViewById(R.id.buttonPlayer1);
        Button buttonPlayer2 = findViewById(R.id.buttonPlayer2);
        //buttonPlayer1.setText(playername1 + " Wins");
        //buttonPlayer2.setText(platername2 + " Wins");

        //change player names
        TextView textPlayer1 = findViewById(R.id.textPlayer1);
        TextView textPlayer2 = findViewById(R.id.textPlayer2);
        //textPlayer1.setText(playername1);
        //textPlayer2.setText(playername2);


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

    public void p1Win(View view){
        //
        int row = 0; // = player 1 character value;
        int column = 0; // = player 2 character value
        recordWin(1, row, column, view);
    }

    public void p2Win(View view){
        //
        int row = 0;// = player 1 character value
        int column = 0; // player 2 character value
        recordWin(2, row, column, view);
    }

    public void recordWin(int Winner, int row, int column, View view) {
        String cellRecord = "0/0";
        //if row/column cell is not empty{
        //  cellRecord = cell.toString()
        //}

        String[] splitRecord = cellRecord.split("/");

        if(Winner == 1){
            splitRecord[0] = Integer.toString(Integer.parseInt(splitRecord[0])+1);
        }
        if (Winner == 2){
            splitRecord[1] = Integer.toString(Integer.parseInt(splitRecord[1])+1);

        }

        String retCellRecord = splitRecord[0] + "/" + splitRecord[1];

        //Update the spreadsheet with the new value

        //when a winner button is clicked:
        Snackbar snackbar = Snackbar.make(view, "Spreadsheet updated", Snackbar.LENGTH_LONG);
        snackbar.show();
    }


}
