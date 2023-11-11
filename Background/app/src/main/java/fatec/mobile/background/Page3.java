package fatec.mobile.background;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class Page3 extends AppCompatActivity {

    private Button buttonRed;
    private Button buttonGreen;
    private Button buttonBlue;
    private Button buttonRandom;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page3);




        buttonRed = findViewById(R.id.redButton);
        buttonGreen = findViewById(R.id.greenButton);
        buttonBlue = findViewById(R.id.blueButton);
        buttonRandom = findViewById(R.id.randomButton);

        buttonRed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int color = Color.rgb(200, 109, 242);
                changeBackgroundColor(color);
                saveColorToPreferences(color);

            }
        });

        buttonGreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int color = Color.rgb(179, 30, 55);
                changeBackgroundColor(color);
                saveColorToPreferences(color);
            }
        });

        buttonBlue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int color = Color.rgb(230, 118, 39);
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
                Intent intent = new Intent(Page3.this, Page4.class);


                startActivity(intent);

            }
        });

        Button btnAntes = findViewById(R.id.buttonBack);
        btnAntes.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(Page3.this, Page2.class);


                startActivity(intent);

            }
        });













    }

    private void saveColorToPreferences(int cor){
        SharedPreferences preferences = getSharedPreferences("CorPreferences", MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putInt("Cor_Atual3", cor);
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
        return preferences.getInt("Cor_Atual3", Color.WHITE);
    }
    private void changeBackgroundColor(int color){
        getWindow().getDecorView().setBackgroundColor(color);
    }



}