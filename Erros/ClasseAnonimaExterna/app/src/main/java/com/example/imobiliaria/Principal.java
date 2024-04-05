package com.example.imobiliaria;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class Principal extends Activity {

    @Override
    public void onCreate (Bundle estado) {
        super.onCreate(estado);
        setContentView(R.layout.layout_principal);

        ImageButton btn = (ImageButton)findViewById(R.id.imagemBotao);
        Externa ext = new Externa();
        ext.saida = this;

        btn.setOnClickListener(ext);

        //Modificar essa classe
       /* btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mostraMensagem();
            }
        });
*/
        EditText et = (EditText)findViewById(R.id.campoRegiao);

        et.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                notificacao("Clique curto");
            }
        });

        et.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                notificacao("Clique longo");
                return false;
            }
        });
    }

    class Externa implements View.OnClickListener{
        private Principal saida;

        @Override
        public void onClick(View v) {
            mostraMensagem();
        }

        public void setSaida (Principal p) {
            saida = p;
        }
    }

    public void mostraMensagem() {
        Intent i = new Intent(this, Mensagem.class);
        startActivity(i);
    }

    public void notificacao (String texto) {
        Toast.makeText(this, texto, Toast.LENGTH_LONG).show();
    }
}









/*Implementacao alternativa*/
/*class LeitorBotao implements View.OnClickListener {
    private Principal objetoPrincipal;

    @Override
    public void onClick(View v) {
        Intent i = new Intent(objetoPrincipal, Mensagem.class);
        objetoPrincipal.startActivity(i);
    }

    public void recebePrincipal (Principal p) {
        objetoPrincipal = p;
    }
}

public class Principal extends Activity {
    @Override
    public void onCreate (Bundle estadoSalvo) {
        super.onCreate(estadoSalvo);
        setContentView(R.layout.layout_principal);

        ImageButton btn = (ImageButton)findViewById(R.id.imagemBotao);
        LeitorBotao l = new LeitorBotao();
        l.recebePrincipal(this);
        btn.setOnClickListener(l);
    }
}*/