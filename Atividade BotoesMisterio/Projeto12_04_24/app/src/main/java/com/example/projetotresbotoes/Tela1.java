package com.example.projetotresbotoes;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Tela1 extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_tela1);

        voltaTela vt = new voltaTela();
        vt.setSaida(this);

        Button bt2;

        bt2 = (Button)findViewById(R.id.botao2);


        bt2.setOnClickListener(vt);
    }
}

class voltaTela implements View.OnClickListener {

    private Tela1 saida;

    @Override
    public void onClick(View v) {
        Intent i = new Intent(saida, Principal.class);
        saida.startActivity(i);
    }

    public void setSaida(Tela1 t1) {
        saida = t1;
    }
}

