package com.example.h_atv19do04;


import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {

    private BancoDados bd;
    private List<Disciplina> disciplinas = new ArrayList<Disciplina>();
    private DisciplinaAdapter adaptadorDisciplina;
    public static final int REQUEST_EDICAO = 0;
    public static final int REQUEST_SALVOU = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bd = new BancoDados(this);
        lerDados();
    }

    public void lerDados() {

        bd.abrir();
        disciplinas.clear();

        Cursor cursor = bd.retornaTodosEventos();
        if (cursor.moveToFirst()) {
            do {
                Disciplina d = new Disciplina();

                d.id = cursor.getInt(cursor.getColumnIndex(BancoDados.KEY_ID));
                d.nome = cursor.getString(cursor.getColumnIndex(BancoDados.KEY_NOME));
                d.dia = cursor.getString(cursor.getColumnIndex(BancoDados.KEY_DIA));

                disciplinas.add(d);
            } while(cursor.moveToNext());
        }

        if (disciplinas.size() > 0) {

            if (adaptadorDisciplina == null) {

                adaptadorDisciplina = new DisciplinaAdapter(this, disciplinas) {
                    @Override
                    public void edita(Disciplina disciplina) {
                        Intent intent = new Intent(getApplicationContext(), Adiciona.class);
                        intent.putExtra("disciplina", disciplina);
                        startActivityForResult(intent, REQUEST_EDICAO);
                    }

                    @Override
                    public void deleta(Disciplina disciplina) {
                        bd.abrir();
                        bd.apagaEvento(disciplina.id);
                        bd.fechar();
                        lerDados();
                    }
                };

                ListView Lista = (ListView)findViewById(R.id.listaDisciplinas);
                Lista.setAdapter(adaptadorDisciplina);
                Log.i("teste", "teste");
            } else {
                adaptadorDisciplina.novosDados(disciplinas);
            }
        }

        bd.fechar();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.item_disciplina, menu);
        return true;
    }

    @Override
    public boolean onMenuItemSelected(int featureId, MenuItem item) {

        if (item.getItemId() == R.id.menu_add) {
            //Toast.makeText(this, "teste", Toast.LENGTH_LONG).show();
            Intent intent = new Intent (this, Adiciona.class);
            startActivityForResult(intent, REQUEST_EDICAO);
            return true;
        } else {
            return super.onMenuItemSelected(featureId, item);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_EDICAO) {
            if (resultCode == REQUEST_SALVOU) {
                lerDados();
            }
        }
    }
}
