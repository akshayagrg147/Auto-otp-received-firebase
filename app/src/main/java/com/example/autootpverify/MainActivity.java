package com.example.autootpverify;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity {
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {

                    // Construct data
                    String apiKey = "apikey=" + "MdA0OWl1taw-tLvZY0ve44T0bNuy7uizkTs1daFFu5";
                    String message = "&message=" + "this is mess";
                    String sender = "&sender=" + "jfjfj";
                    String number = "&numbers" + "007973434833";
                    // Send data
                    HttpURLConnection conn = (HttpURLConnection) new URL("https://api.textlocal.in/get_scheduled/?").openConnection();
                    String data = apiKey + message + sender + number;
                    conn.setDoOutput(true);
                    conn.setRequestMethod("POST");
                    conn.setRequestProperty("Content-Length", Integer.toString(data.length()));
                    Toast.makeText(MainActivity.this, "send", Toast.LENGTH_SHORT).show();

                    conn.getOutputStream().write(data.getBytes("UTF-8"));
                    final BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                    final StringBuffer stringBuffer = new StringBuffer();
                    String line;
                    while ((line = rd.readLine()) != null) {
                        stringBuffer.append(line);
                    }
                    rd.close();


                } catch (Exception e) {
                    System.out.println("Error SMS " + e);

                }
            }
        });
    }
}
