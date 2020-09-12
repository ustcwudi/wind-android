package platform.client.wind.activity;

import android.os.Bundle;

import androidx.annotation.NonNull;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.fragment.app.FragmentTransaction;
import androidx.appcompat.app.AppCompatActivity;

import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import platform.client.wind.R;
import platform.client.wind.holder.HomeHolder;
import platform.client.wind.holder.MapHolder;
import platform.client.wind.holder.MineHolder;
import platform.client.wind.holder.ShopHolder;

public class MainActivity extends AppCompatActivity {

    private HomeHolder homeHolder;
    private ShopHolder shopHolder;
    private MineHolder mineHolder;
    private MapHolder mapHolder;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.hide(homeHolder);
            transaction.hide(shopHolder);
            transaction.hide(mapHolder);
            transaction.hide(mineHolder);
            TextView title = findViewById(R.id.title);
            ImageView operation = findViewById(R.id.operation);
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    transaction.show(homeHolder);
                    title.setText(R.string.app_name);
                    operation.setImageResource(R.drawable.ic_scan);
                    break;
                case R.id.navigation_item:
                    title.setText(R.string.shop);
                    operation.setImageResource(R.drawable.ic_search);
                    transaction.show(shopHolder);
                    break;
                case R.id.navigation_find:
                    title.setText(R.string.trans);
                    operation.setImageResource(R.drawable.ic_map);
                    transaction.show(mapHolder);
                    break;
                case R.id.navigation_mine:
                    title.setText(R.string.mine);
                    operation.setImageResource(R.drawable.ic_set);
                    transaction.show(mineHolder);
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
        homeHolder = new HomeHolder();
        shopHolder = new ShopHolder();
        mineHolder = new MineHolder();
        mapHolder = new MapHolder();
        transaction.add(R.id.main_container, homeHolder);
        transaction.add(R.id.main_container, shopHolder);
        transaction.add(R.id.main_container, mapHolder);
        transaction.add(R.id.main_container, mineHolder);
        transaction.hide(shopHolder);
        transaction.hide(mapHolder);
        transaction.hide(mineHolder);
        transaction.commit();

        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }
}
