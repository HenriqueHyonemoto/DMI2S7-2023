package com.example.h_atv19do04;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class Adiciona extends Activity {

    private EditText edtNome;
    private EditText edtDia;
    private Disciplina disciplina;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adiciona);

        edtNome = (EditText)findViewById(R.id.campoNome);
        edtDia = (EditText)findViewById(R.id.campoDia);

        Intent intent = getIntent();
        disciplina = (Disciplina) intent.getSerializableExtra("disciplina");

        if (disciplina != null) {
                edtNome.setText(disciplina.nome);
            edtDia.setText(disciplina.dia);
        }

        Button btnSalvar = findViewById(R.id.botao);
        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                salvar();
            }
        });
    }

    public void salvar() {
        BancoDados bd = new BancoDados(this);
        bd.abrir();

        String nome = edtNome.getText().toString();
        String dia = edtDia.getText().toString();

        if (disciplina != null) {
            bd.atualizaEvento(disciplina.id,
                    edtNome.getText().toString(),
                    edtDia.getText().toString());
        } else {
            bd.insereEvento(nome, dia);
        }

        bd.fechar();
        setResult(RESULT_OK);
        finish();
    }
}
