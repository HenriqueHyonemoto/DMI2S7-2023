package com.example.projetotresbotoes;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;

public class Principal extends Activity{
//essa tela foi modificada
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_principal);

        TelaGato1 t1 = new TelaGato1();
        t1.setSaida(this);

        Button bt1;
        bt1 = (Button)findViewById(R.id.botao1);
        bt1.setOnClickListener(t1);

        //

        voltaPrincipal t2 = new voltaPrincipal();
        t2.setSaida(this);

        Button bt2;
        bt2 = (Button)findViewById(R.id.botao2);
        bt2.setOnClickListener(t2);

    }
}

class TelaGato1 implements View.OnClickListener {

    private Principal saida;

    @Override
    public void onClick(View v) {
        Intent i = new Intent(saida, Tela1.class);
        saida.startActivity(i);
    }

    public void setSaida (Principal p) {
        saida = p;
    }
}

class voltaPrincipal implements View.OnClickListener {

    private TelaGato1 saida;

    @Override
    public void onClick(View v) {
        Intent i = new Intent(saida, Principal.class);
        saida.startActivity(i);
    }

    public void setSaida (Principal p) {
        saida = p;
    }
}




