package br.com.siqueira.lifecyclecc3anbua;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import br.com.siqueira.lifecyclecc3anbua.util.StatusTracker;
import br.com.siqueira.lifecyclecc3anbua.util.Utils;

/**
 * @author Leonardo Siqueira Pessanha
 * @R.A. 816123578
 * @turma CCP3AN-BUA
 */

public class ActivityC extends AppCompatActivity {

    private String mActivityName;
    private TextView mStatusView;
    private TextView mStatusAllView;
    private StatusTracker mStatusTracker = StatusTracker.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c);
        mActivityName = "Atividade C";
        mStatusView = (TextView)findViewById(R.id.status_view_c);
        mStatusAllView = (TextView)findViewById(R.id.status_view_all_c);
        mStatusTracker.setStatus(mActivityName, getString(R.string.on_create));
        Utils.printStatus(mStatusView, mStatusAllView);
    }

    @Override
    protected void onStart() {
        super.onStart();
        mStatusTracker.setStatus(mActivityName, "onStart");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        mStatusTracker.setStatus(mActivityName, getString(R.string.on_restart));
        Utils.printStatus(mStatusView, mStatusAllView);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mStatusTracker.setStatus(mActivityName, getString(R.string.on_resume));
        Utils.printStatus(mStatusView, mStatusAllView);
    }

    @Override
    protected void onPause() {
        super.onPause();
        mStatusTracker.setStatus(mActivityName, getString(R.string.on_pause));
        Utils.printStatus(mStatusView, mStatusAllView);
    }

    @Override
    protected void onStop() {
        super.onStop();
        mStatusTracker.setStatus(mActivityName, getString(R.string.on_stop));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mStatusTracker.setStatus(mActivityName, getString(R.string.on_destroy));
        mStatusTracker.clear();
    }

    public void startDialog(View v){
        Intent intent = new Intent(ActivityC.this, DialogActivity.class);
        startActivity(intent);
    }

    public void startActivityA(View v){
        Intent intent = new Intent(ActivityC.this, ActivityA.class);
        startActivity(intent);
    }

    public void startActivityB(View v) {
        Intent intent = new Intent(ActivityC.this, ActivityB.class);
        startActivity(intent);
    }

    public void finishActivityC(View v){
        ActivityC.this.finish();
    }
}
