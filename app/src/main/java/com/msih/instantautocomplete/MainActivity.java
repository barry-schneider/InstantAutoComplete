package com.msih.instantautocomplete;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    mTextMessage.setText(R.string.title_home);
                    return true;
                case R.id.navigation_dashboard:
                    mTextMessage.setText(R.string.title_dashboard);
                    return true;
                case R.id.navigation_notifications:
                    mTextMessage.setText(R.string.title_notifications);
                    return true;
            }
            return false;
        }
    };

    private static final String[] COUNTRIES = new String[] {
            "Sydney, CA", "Sydney, AU", "France", "Italy", "Germany", "Spain"
    };

    private static ArrayAdapter mCityAdapter;
    private static InstantAutoComplete mAutoCompleteLocation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        // Setup autocomplete
        mAutoCompleteLocation = (InstantAutoComplete) findViewById(R.id.autoCompleteTextView);

        mCityAdapter = new ArrayAdapter(
                getBaseContext(),
                android.R.layout.simple_dropdown_item_1line,
                COUNTRIES
        );
        mAutoCompleteLocation.setAdapter(mCityAdapter);
        mAutoCompleteLocation.setShowAlways(true);

//        // Clear autocomplete
//        mAutoCompleteLocation.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                mAutoCompleteLocation.setText("");
//            }
//        });
    }

}
