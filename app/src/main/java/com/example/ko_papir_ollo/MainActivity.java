package com.example.ko_papir_ollo;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private TextView eredmeny;
    private ImageView sajatvalasztas, gepvalasztas;
    private Button ko, papir, ollo;
    private AlertDialog.Builder builder;


    private int ertek;
    private String gepvalertek;
    private int jatekosnyer, gepnyer;
    private String sajatvalaszertek;


    private void init()
    {
        eredmeny = findViewById(R.id.eredmenyId);
        sajatvalasztas = findViewById(R.id.sajatvalasztasId);
        gepvalasztas = findViewById(R.id.gepvalasztasId);
        ko = findViewById(R.id.buttonKo);
        papir = findViewById(R.id.buttonPapir);
        ollo = findViewById(R.id.buttonOllo);
        ertek = 0;
        gepvalertek = "Kő";
        jatekosnyer = 0;
        gepnyer = 0;
        sajatvalaszertek = "Kő";
        builder = new AlertDialog.Builder(MainActivity.this);
        builder.setCancelable(false).setMessage("Szeretnél új játékot kezdeni?").setPositiveButton("Igen", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Ujjatek();
            }
        }).setNegativeButton("Nem", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Kilepes();
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        JatekosKival();

    }

    private void JatekosKival()
    {
        ko.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                sajatvalasztas.setBackgroundResource(R.drawable.rock);
                sajatvalaszertek = "Kő";
                GepKivalasztas();
                Feltetel();
                Eredmeny();
            }
        });

        papir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                sajatvalasztas.setBackgroundResource(R.drawable.paper);
                sajatvalaszertek = "Papír";
                GepKivalasztas();
                Feltetel();
                Eredmeny();
            }
        });
        ollo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                sajatvalasztas.setBackgroundResource(R.drawable.scissors);
                sajatvalaszertek = "Olló";
                GepKivalasztas();
                Feltetel();
                Eredmeny();
            }
        });
    }

    private void GepKivalasztas()
    {
        ertek = (int)Math.random() * 3;
        String[] tomb = {"Kő", "Papír", "Olló"};
        gepvalertek = tomb[ertek];

        if (tomb[ertek] == "Kő")
        {
            gepvalasztas.setBackgroundResource(R.drawable.rock);
        }
        if (tomb[ertek] == "Papír")
        {
            gepvalasztas.setBackgroundResource(R.drawable.paper);
        }
        if (tomb[ertek] == "Olló")
        {
            gepvalasztas.setBackgroundResource(R.drawable.scissors);
        }


    }

    private void Eredmeny()
    {
        eredmeny.setText("Gép: " + gepnyer + " - Játékos: " + jatekosnyer );
    }

    private void Feltetel()
    {
        if (sajatvalaszertek == "Kő" && gepvalertek == "Papír"  )
        {
            Toast.makeText(MainActivity.this, "A gép nyert!", Toast.LENGTH_SHORT).show();
            gepnyer++;
        }
        if (sajatvalaszertek == "Kő" && gepvalertek == "Olló"  )
        {
            Toast.makeText(MainActivity.this, "Te nyertél!", Toast.LENGTH_SHORT).show();
            jatekosnyer++;
        }
        if (sajatvalaszertek == "Papír" && gepvalertek == "Kő"  )
        {
            Toast.makeText(MainActivity.this, "Te nyertél!", Toast.LENGTH_SHORT).show();
            jatekosnyer++;
        }
        if (sajatvalaszertek == "Olló" && gepvalertek == "Kő"  )
        {
            Toast.makeText(MainActivity.this, "A gép nyert!", Toast.LENGTH_SHORT).show();
            gepnyer++;
        }
        if (sajatvalaszertek == "Olló" && gepvalertek == "Papír"  )
        {
            Toast.makeText(MainActivity.this, "Te nyertél!", Toast.LENGTH_SHORT).show();
            jatekosnyer++;
        }
        if (sajatvalaszertek == "Papír" && gepvalertek == "Olló"  )
        {
            Toast.makeText(MainActivity.this, "A gép nyert!", Toast.LENGTH_SHORT).show();
            gepnyer++;
        }

        Eredmeny();

    }

    private void Jatekvege()
    {
        if (gepnyer == 3)
        {
           builder.setTitle("Sajnálom, a gép nyert").create().show();
        }
        if (jatekosnyer == 3)
        {
            builder.setTitle("Gratulálok, te nyertél!").create().show();
        }
    }

    private void Ujjatek()
    {
        ertek = 0;
        jatekosnyer = 0;
        gepnyer = 0;
        sajatvalasztas.setBackgroundResource(R.drawable.rock);
        gepvalasztas.setBackgroundResource(R.drawable.rock);

    }

    private void Kilepes()
    {
        System.exit(0);
    }


}