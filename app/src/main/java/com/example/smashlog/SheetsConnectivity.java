package com.example.smashlog;

import android.content.res.AssetManager;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp;
import com.google.api.client.extensions.jetty.auth.oauth2.LocalServerReceiver;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.util.store.FileDataStoreFactory;
import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.SheetsScopes;
import com.google.api.services.sheets.v4.model.ValueRange;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.List;
import android.content.Context;

import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

/*
public class SheetsConnectivity extends AsyncTask<String, Void, RSSFeed> {
    private static final String APPLICATION_NAME = "Smash Log";
    private static final JsonFactory JSON_FACTORY = JacksonFactory.getDefaultInstance();
    private static final String TOKENS_DIRECTORY_PATH = "tokens";


    private static final List<String> SCOPES = Collections.singletonList(SheetsScopes.SPREADSHEETS_READONLY);
    private static final String CREDENTIALS_FILE_PATH = "src/main/resources/credentials.json";

    private static Credential getCredentials(final NetHttpTransport HTTP_TRANSPORT, AssetManager am, Context context) throws IOException {
        // Load client secrets
        //InputStream in = SheetsConnectivity.class.getResourceAsStream(path + "/" + CREDENTIALS_FILE_PATH);
        InputStream in = am.open("credentials.json");


        if (in == null) {
            throw new FileNotFoundException("Resource not found: " + CREDENTIALS_FILE_PATH);
        }
        GoogleClientSecrets clientSecrets = GoogleClientSecrets.load(JSON_FACTORY, new InputStreamReader(in));

        // Build flow and trigger user authorization request.
        GoogleAuthorizationCodeFlow flow = new GoogleAuthorizationCodeFlow.Builder(
                HTTP_TRANSPORT, JSON_FACTORY, clientSecrets, SCOPES)
                .setDataStoreFactory(new FileDataStoreFactory(new File(context.getFilesDir(), TOKENS_DIRECTORY_PATH)))
                .setAccessType("offline")
                .build();
        LocalServerReceiver receiver = new LocalServerReceiver.Builder().setPort(8888).build();
        return new AuthorizationCodeInstalledApp(flow, receiver).authorize("user");
    }


    public static void printSheet(AssetManager am, Context context) throws IOException, GeneralSecurityException {
        // Build a new authorized API client service.
        //final NetHttpTransport HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
        final NetHttpTransport HTTP_TRANSPORT = new com.google.api.client.http.javanet.NetHttpTransport();
        //final String spreadsheetId = "1BxiMVs0XRA5nFMdKvBdBZjgmUUqptlbs74OgvE2upms";
        final String spreadsheetId = "13LGU9LY1_GLkCfRtw1p7XSeQFwpk_BUI-jvhxGwUpMU";
        final String range = "Class Data!A2:E";
        System.out.println("GETTING CREDENTIALS");
        Sheets service = new Sheets.Builder(HTTP_TRANSPORT, JSON_FACTORY, getCredentials(HTTP_TRANSPORT, am, context))
                .setApplicationName(APPLICATION_NAME)
                .build();
        System.out.println("GOT CREDENTIALS");
        ValueRange response = service.spreadsheets().values()
                .get(spreadsheetId, range)
                .execute();
        System.out.println("GOT VALUES");
        List<List<Object>> values = response.getValues();
        if (values == null || values.isEmpty()) {
            System.out.println("No data found.");
        } else {
            System.out.println("Name, Major");
            for (List row : values) {
                // Print columns A and E, which correspond to indices 0 and 4.
                System.out.printf("%s, %s\n", row.get(0), row.get(4));
            }
        }
    }


    private Exception exception;

    protected RSSFeed doInBackground(String... urls) {
        try {
            URL url = new URL(urls[0]);
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser();
            XMLReader xmlreader = parser.getXMLReader();
            RssHandler theRSSHandler = new RssHandler();
            xmlreader.setContentHandler(theRSSHandler);
            InputSource is = new InputSource(url.openStream());
            xmlreader.parse(is);

            return theRSSHandler.getFeed();
        } catch (Exception e) {
            this.exception = e;

            return null;
        } finally {
            is.close();
        }
    }

    protected void onPostExecute(RSSFeed feed) {
        // TODO: check this.exception
        // TODO: do something with the feed
    }
}

 */