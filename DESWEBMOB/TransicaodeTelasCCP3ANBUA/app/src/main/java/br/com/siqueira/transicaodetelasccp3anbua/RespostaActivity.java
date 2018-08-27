package br.com.siqueira.transicaodetelasccp3anbua;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

/**
 * @author Leonardo Siqueira Pessanha
 * @R.A. 816123578
 */

public class RespostaActivity extends AppCompatActivity {

    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resposta);

        textView = (TextView)findViewById(R.id.resposta);
        textView.setText(getIntent().getStringExtra("resposta"));
    }
}
