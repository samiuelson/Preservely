package me.urbanowicz.samuel.preservely.sample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import me.urbanowicz.samuel.preservely.PreservedInstanceFactory;
import me.urbanowicz.samuel.preservely.Preserver;

public class MainActivity extends AppCompatActivity implements Contract.View{

    private static final String TAG = MainActivity.class.getSimpleName();
    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.textView = (TextView) findViewById(R.id.text);

        Preserver.init(
                this,
                23,
                new PreservedInstanceFactory<Presenter>() {
                    @Override
                    public Presenter create() {
                        return new Presenter();
                    }
                },
                new Preserver.OnInstanceReloadedAction<Presenter>() {
                    @Override
                    public void performAction(Presenter presenter) {
                        presenter.onViewAttached(MainActivity.this);
                    }
                },
                new Preserver.OnInstanceDestroyedAction() {
                    @Override
                    public void performAction() {

                    }
                }
        );

    }

    @Override
    public void displayMessage(String msg) {
        this.textView.setText(msg);
        Log.d(TAG, msg);
    }
}
