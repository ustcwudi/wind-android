package platform.client.wind.activity;

import android.os.Bundle;

import androidx.annotation.NonNull;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.fragment.app.FragmentTransaction;
import androidx.appcompat.app.AppCompatActivity;

import android.view.MenuItem;

import platform.client.wind.R;
import platform.client.wind.fragment.HomeFragment;
import platform.client.wind.fragment.MapFragment;
import platform.client.wind.fragment.MineFragment;
import platform.client.wind.fragment.ShopFragment;

public class MainActivity extends AppCompatActivity {

    private HomeFragment homeFragment;
    private ShopFragment shopFragment;
    private MineFragment mineFragment;
    private MapFragment mapFragment;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.hide(homeFragment);
            transaction.hide(shopFragment);
            transaction.hide(mapFragment);
            transaction.hide(mineFragment);
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    transaction.show(homeFragment);
                    break;
                case R.id.navigation_item:
                    transaction.show(shopFragment);
                    break;
                case R.id.navigation_find:
                    transaction.show(mapFragment);
                    break;
                case R.id.navigation_mine:
                    transaction.show(mineFragment);
                    break;
            }
            transaction.commit();
            return true;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        homeFragment = new HomeFragment();
        shopFragment = new ShopFragment();
        mineFragment = new MineFragment();
        mapFragment = new MapFragment();
        transaction.add(R.id.main_container, homeFragment);
        transaction.add(R.id.main_container, shopFragment);
        transaction.add(R.id.main_container, mapFragment);
        transaction.add(R.id.main_container, mineFragment);
        transaction.hide(shopFragment);
        transaction.hide(mapFragment);
        transaction.hide(mineFragment);
        transaction.commit();

        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }
}
