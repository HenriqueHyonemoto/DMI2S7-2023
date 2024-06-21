package com.example.projetotresbotoes;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.widget.Button;
import android.view.View;



public class Principal extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_principal);

        TelaGato1 t1 = new TelaGato1();
        t1.setSaida(this);

        Button bt1;

        bt1 = (Button)findViewById(R.id.botao1);

        bt1.setOnClickListener(t1);
    }
}

class TelaGato1 implements View.OnClickListener {

    private Principal saida;

    @Override
    public void onClick(View v) {
        Intent i = new Intent(saida, Tela1.class);
        saida.startActivity(i);
    }

    public void setSaida(Principal p) {
        saida = p;
    }
}
