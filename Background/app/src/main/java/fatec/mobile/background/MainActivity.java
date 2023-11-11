package fatec.mobile.background;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Button buttonRed;
    private Button buttonGreen;
    private Button buttonBlue;
    private Button buttonRandom;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        buttonRed = findViewById(R.id.redButton);
        buttonGreen = findViewById(R.id.greenButton);
        buttonBlue = findViewById(R.id.blueButton);
        buttonRandom = findViewById(R.id.randomButton);

        buttonRed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int color = Color.rgb(245, 66, 84);
                changeBackgroundColor(color);
                saveColorToPreferences(color);

            }
        });

        buttonGreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int color = Color.rgb(66, 245, 129);
                changeBackgroundColor(color);
                saveColorToPreferences(color);
            }
        });

        buttonBlue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int color = Color.rgb(66, 233, 245);
                changeBackgroundColor(color);
                saveColorToPreferences(color);
            }
        });

        buttonRandom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random random = new Random();
                int color = Color.rgb(random.nextInt(256), random.nextInt(256), random.nextInt(256));
                changeBackgroundColor(color);
                saveColorToPreferences(color);
            }
        });

        Button btnSeguinte = findViewById(R.id.buttonSeguinte1);
        btnSeguinte.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(MainActivity.this, Page2.class);


                startActivity(intent);

            }
        });

        Button btnAntes = findViewById(R.id.buttonBack);
        btnAntes.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(MainActivity.this, MainActivity.class);


                startActivity(intent);

            }
        });













    }

    private void saveColorToPreferences(int cor){
        SharedPreferences preferences = getSharedPreferences("CorPreferences", MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putInt("Cor_Atual", cor);
        editor.apply();
    }

    @Override
    protected void onResume(){
        super.onResume();
        int saveColor = getColorFromPreferences();
        changeBackgroundColor(saveColor);
    }

    public int getColorFromPreferences(){
        SharedPreferences preferences = getSharedPreferences("CorPreferences", MODE_PRIVATE);
        return preferences.getInt("Cor_Atual", Color.WHITE);
    }
    private void changeBackgroundColor(int color){
        getWindow().getDecorView().setBackgroundColor(color);
    }



}