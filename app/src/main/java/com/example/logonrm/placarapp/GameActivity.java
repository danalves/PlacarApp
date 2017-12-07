package com.example.logonrm.placarapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.logonrm.placarapp.R.id.etTimeCasa;

public class GameActivity extends AppCompatActivity {

    private String timeCasa;
    private String timeVisitante;

    private TextView tvTimeCasa;
    private TextView tvTimeVisitante;

    private TextView tvPlacarTC;
    private TextView tvPlacarTV;

    private int placarTC;
    private int placarTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        tvTimeCasa = (TextView) findViewById(R.id.tvTimeCasa);
        tvTimeVisitante = (TextView) findViewById(R.id.tvTimeVisitante);
        tvPlacarTC = (TextView) findViewById(R.id.tvPlacarTC);
        tvPlacarTV = (TextView) findViewById(R.id.tvPlacarTV);

        if(getIntent() != null){
            timeCasa = getIntent().getStringExtra("TIMECASA");
            timeVisitante = getIntent().getStringExtra("TIMEVISITANTE");

            tvTimeCasa.setText(timeCasa);
            tvTimeVisitante.setText(timeVisitante);
        }

        if(savedInstanceState != null){
            placarTC = savedInstanceState.getInt("PLACARCASA");
            placarTV = savedInstanceState.getInt("PLACARVISITANTE");
        }

        tvPlacarTC.setText(String.valueOf(placarTC));
        tvPlacarTV.setText(String.valueOf(placarTV));
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("PLACARCASA", placarTC);
        outState.putInt("PLACARVISITANTE", placarTV);
    }

    public void pontuarTC(View v){

        placarTC = Integer.parseInt(tvPlacarTC.getText().toString());
        placarTC += 1;
        tvPlacarTC.setText(String.valueOf(placarTC));

    }

    public void pontuarTV(View v){

        placarTV = Integer.parseInt(tvPlacarTV.getText().toString());
        placarTV += 1;
        tvPlacarTV.setText(String.valueOf(placarTV));

    }

    public void limpar(View v){

        placarTC = 0;
        placarTV = 0;
        tvPlacarTC.setText(String.valueOf(placarTC));
        tvPlacarTV.setText(String.valueOf(placarTV));

    }

}
