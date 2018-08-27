package br.com.siqueira.transicaodetelasccp3anbua;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

/**
 * @author Leonardo Siqueira Pessanha
 * @R.A. 816123578
 */

public class MainActivity extends AppCompatActivity {

    private EditText mensagemEditText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mensagemEditText = findViewById(R.id.mensagemEditText);
    }

    public void enviarMensagem (View view){
        String mensagem = mensagemEditText.getEditableText().toString();
        //Toast.makeText(this, mensagem, Toast.LENGTH_LONG).show();
        Intent conteudo = new Intent(view.getContext(), RespostaActivity.class);
        conteudo.putExtra("resposta",mensagem);
        startActivity(conteudo);
    }
}
