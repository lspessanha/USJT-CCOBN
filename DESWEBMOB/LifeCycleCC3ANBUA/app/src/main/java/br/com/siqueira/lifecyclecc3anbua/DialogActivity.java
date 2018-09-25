package br.com.siqueira.lifecyclecc3anbua;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

/**
 * @author Leonardo Siqueira Pessanha
 * @R.A. 816123578
 * @turma CCP3AN-BUA
 */

public class DialogActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_dialog);
    }

    /**
     * Callback method defined by the View
     * @param v
     */
    public void finishDialog(View v) {
        DialogActivity.this.finish();
    }
}
