package com.example.mysuggestfood;

import android.database.Cursor;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;


public class MainActivity extends AppCompatActivity {

    database database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        BottomNavigationView navBottom = (BottomNavigationView) findViewById(R.id.bottom_nav_bar);
        navBottom.setOnNavigationItemSelectedListener(navListener);
        getSupportFragmentManager().beginTransaction().replace(R.id.layout_all_fragment,new fragment_home()).commit();

    }

    //Database Action
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.activity_main);

        //Create Database List Food
        database = new database(this, "listFood.sqlite", null, 1);

        //Create table Foods
        database.queryDB("CREATE TABLE IF NOT EXISTS listfood(id INTEGER PRIMARY KEY AUTOINCREAMENT, name_food VARCHAR(200), nutritional_values INTEGER, resources VARCHAR(), kind_food VARCHAR(), tutorials VARCHAR(), time_spend INTEGER, price INTEGER");

        //insert data

        database.queryDB("INSERT INTO listfood VALUES(null, 'ca kho to', '500kcal', 'ca , gia vi', 'mon kho', 'dat noi len bep','50','35000')");

        Cursor  dataListFood = database.getData("SELECT * FROM listfood");      //data se tra trong bien con tro dataListFood.
        while(dataListFood.moveToNext()) {          //selest nhung element ke ben, neu true thi la con du lieu.
            String nameFood = dataListFood.getString(1);
            Toast.makeText(this, nameFood, Toast.LENGTH_SHORT).show();
        }

    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment selectedFragment = null;

            switch(item.getItemId()) {
                case R.id.nav_home:
                    selectedFragment = new fragment_home();
                    break;
                case R.id.nav_suggest:
                    selectedFragment = new fragment_suggest();
                    break;
                case R.id.nav_like:
                    selectedFragment = new fragment_love();
                    break;
                case R.id.nav_me:
                    selectedFragment = new fragment_me();
                    break;
            }
            getSupportFragmentManager().beginTransaction().replace(R.id.layout_all_fragment,selectedFragment).commit();
            return true;
        }
    };
}
