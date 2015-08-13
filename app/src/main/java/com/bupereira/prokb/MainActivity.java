package com.bupereira.prokb;

import android.os.StrictMode;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.apache.http.HttpResponse;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.DefaultHttpClientConnection;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class MainActivity extends ActionBarActivity {

    ListView mListView;
    EditText vETSearchEditText;
    KBAdapter mKBAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // TODO - Test code - REMOVE
        KBEntry mTest = new KBEntry("1", "My Title", "Article", "This is the content for the proKB blah blah blah", "http://www.bupereira.com");


        KBAdapter mKBAdapter = new KBAdapter(getApplicationContext());
        mListView = (ListView) findViewById(R.id.listView);
        mListView.setAdapter(mKBAdapter);

        // TODO - Test Code - REMOVE
        mKBAdapter.add(mTest);


        vETSearchEditText = (EditText) findViewById(R.id.searchText);

        vETSearchEditText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                    performSearch();
                    return true;
                }
                return false;
            }
        });

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

    public void performSearch() {
        // Look at http://stackoverflow.com/questions/18960306/android-httpget-incomplete-response-bufferedreader , look for " size limit of java string". Workaround
        // is split the string into an array.
        String page = "";
        // Just in case this reference is empty
        if (vETSearchEditText == null) {
            vETSearchEditText = (EditText) findViewById(R.id.searchText);
        }

        DefaultHttpClient httpClient = new DefaultHttpClient();
        HttpGet httpGet = new HttpGet("http://knowledgebase.progress.com/pkb_Home?q=" + vETSearchEditText.getText() + "&l=en_US");
        ResponseHandler<String> resHandler = new BasicResponseHandler();

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        try {
            page = httpClient.execute(httpGet, resHandler);

        } catch(Exception e) {
            if (e instanceof IOException) {
                Toast.makeText(this, "Error sending request, check your network connection.", Toast.LENGTH_SHORT).show();
            }

            else {
                Log.e("ERROR:", e.getMessage());
            }
        } finally {

        }

        Toast.makeText(this, page, Toast.LENGTH_SHORT).show();
        Log.i("MuriloDEBUG", "http://knowledgebase.progress.com/pkb_Home?q=" + vETSearchEditText.getText() + "&l=en_US");
        Log.i("HTTP", page);


    }
}
