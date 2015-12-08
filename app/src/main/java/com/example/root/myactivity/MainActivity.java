package com.example.root.myactivity;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.root.myactivity.R;

public class MainActivity extends Activity implements
        OverviewFragment.OverviewFragmentActivityListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // ta metoda pochodzi z OverviewFragmentActivityListener
    @Override
    public void onItemSelected(String msg) {
//        DetailFragment fragment = (DetailFragment) getFragmentManager()
//                .findFragmentById(R.id.detailFragment);
//
//        // sprawdzamy czy fragment istnieje w tej aktywności
//        if (fragment != null && fragment.isInLayout()) {
//            // ustawiamy teskt we fragmencie
//            fragment.setText(msg);
//        }


        DetailFragment fragment = (DetailFragment) getFragmentManager()
                .findFragmentById(R.id.detailFragment);
        // jeżeli fragment istnieje w tej aktywności,
        // znaczy, że jesteśmy w trybie landscape
        if (fragment != null && fragment.isInLayout()) {
            fragment.setText(msg);
        } else {
            // w trybie portrait wywołujemy drugą aktywność
            Intent intent = new Intent(getApplicationContext(),
                    DetailActivity.class);
            intent.putExtra("msg", msg);
            startActivity(intent);
        }
    }
}