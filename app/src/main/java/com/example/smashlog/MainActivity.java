package com.example.smashlog;

import android.accounts.Account;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

//import com.google.android.gms.auth.api.signin.GoogleSignIn;
//import com.google.android.gms.auth.api.signin.GoogleSignInClient;
//import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
//import com.google.android.gms.auth.api.signin.GoogleSignInStatusCodes;
//import com.google.android.gms.common.api.ApiException;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

//import com.google.android.gms.*;
//import com.google.android.gms.common.api.Scope;
//import com.google.api.client.extensions.android.http.AndroidHttp;
//import com.google.api.client.googleapis.extensions.android.gms.auth.GoogleAccountCredential;
//import com.google.api.client.googleapis.extensions.android.gms.auth.UserRecoverableAuthIOException;
//import com.google.api.client.json.jackson2.JacksonFactory;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;


public class MainActivity extends AppCompatActivity {
    private static final int RC_SIGN_IN = 007;
    private Account account;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onResume(){
        super.onResume();
        //thread.resume()
    }
    /*
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == RC_SIGN_IN) {
            try {
                account = GoogleSignIn.getSignedInAccountFromIntent(data).getResult(ApiException.class).getAccount();

            } catch (ApiException e) {
                Log.w("MyActivity", "signInResult: failed code=" + e.getStatusCode() + ", reason: " + GoogleSignInStatusCodes.getStatusCodeString(e.getStatusCode()), e);
            }
        }
    }

    public void signIn(){
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestScopes(new Scope("https://www.googleapis.com/auth/spreadsheets"))
                .requestEmail()
                .build();
        GoogleSignInClient googleSignInClient = GoogleSignIn.getClient(this, gso);

        if (GoogleSignIn.getLastSignedInAccount(this) == null) {
            startActivityForResult(googleSignInClient.getSignInIntent(), RC_SIGN_IN);
        } else {
            // use the already signed in account
            Account account = GoogleSignIn.getLastSignedInAccount(this).getAccount();
        }
    }*/

    public void getSheet(){
        /*
        Context context = View.getContext();

        GoogleAccountCredential credential = GoogleAccountCredential.usingOAuth2(context, Collections.singleton("https://www.googleapis.com/auth/spreadsheets"));
        credential.setSelectedAccount(account);
        Sheets sheetsService = new Sheets.Builder(AndroidHttp.newCompatibleTransport(), JacksonFactory.getDefaultInstance(), credential).build();
        Spreadsheet response = null;
        try {
            response = sheetsService.spreadsheets().get("insert spreadsheet ID here").setRanges(Arrays.asList("'sheet name here'!A2:G30"))
                    .setFields("sheets.data.rowData.values.effectiveValue").execute();
        } catch (UserRecoverableAuthIOException ex) {
            context.startActivity(ex.getIntent());
        } catch (IOException e) {
            Log.e(CLASS_NAME, "failure to get spreadsheet: " + e.getMessage(), e);
        }
         */
    }

    //Called when the button is clicked, called in the xml
    public void loadSheet(View view){

        //connect to google?
        //Send info to other activity
        Intent actionActivity = new Intent(this, ActionActivity.class);
        startActivity(actionActivity);

    }
}
