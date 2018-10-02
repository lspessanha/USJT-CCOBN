package br.com.siqueira.weatherforecastbycityccp3anbua;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Weather> weatherList = new ArrayList<>();
    private WeatherArrayAdapter weatherArrayAdapter;
    private ListView weatherListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        weatherListView = (ListView) findViewById(R.id.weatherListView);
        weatherArrayAdapter = new WeatherArrayAdapter(this, weatherList);
        weatherListView.setAdapter(weatherArrayAdapter);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            EditText locationEditText =
                    (EditText) findViewById(R.id.locationEditText);

            @Override
            public void onClick(View view) {
                new Thread(new Runnable(){
                    @Override
                    public void run() {
                        try{
                            String cidade = locationEditText.getEditableText().toString();
                            URL url = createURL(cidade);
                            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                            InputStream stream = connection.getInputStream();
                            BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
                            String linha = null;
                            StringBuilder stringBuilder = new StringBuilder("");
                            while ((linha = reader.readLine()) != null){
                                stringBuilder.append(linha);
                            }
                            String json = stringBuilder.toString();
                            Toast.makeText(MainActivity.this, json, Toast.LENGTH_SHORT).show();
                        } catch(Exception e){
                            e.printStackTrace();
                        }
                    }
                }).start();
            }
        });
    }

    private void dismissKeyboard (View view){
        InputMethodManager imm = (InputMethodManager)
                getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(view.getWindowToken(),0);
    }

    private URL createURL (String city){
        String apiKey = getString (R.string.api_key);
        String baseUrl = getString(R.string.web_service_url);
        try{
            String urlString = baseUrl + URLEncoder.encode (city, "UTF-8") + "&units=metric&APPID=" + apiKey;
            return new URL(urlString);
        }
        catch( Exception e){
            e.printStackTrace();
        }
        return null;
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
}
