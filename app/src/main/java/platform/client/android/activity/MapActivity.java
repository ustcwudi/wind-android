package platform.client.android.activity;

import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.amap.api.maps2d.CameraUpdateFactory;
import com.amap.api.maps2d.MapView;
import com.amap.api.maps2d.model.MyLocationStyle;

import platform.client.android.R;

public class MapActivity extends AppCompatActivity {
    MapView mapView = null;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
        mapView = findViewById(R.id.map);
        mapView.onCreate(savedInstanceState);
        MyLocationStyle locationStyle = new MyLocationStyle();
        locationStyle.interval(10000);
        locationStyle.radiusFillColor(Color.argb(10, 0, 0, 180));
        locationStyle.myLocationType(MyLocationStyle.LOCATION_TYPE_FOLLOW_NO_CENTER);
        mapView.getMap().moveCamera(CameraUpdateFactory.zoomTo(17));
        mapView.getMap().getUiSettings().setMyLocationButtonEnabled(true);
        mapView.getMap().setMyLocationEnabled(true);
        mapView.getMap().setMyLocationStyle(locationStyle);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mapView.onDestroy();
    }

    @Override
    public void onResume() {
        super.onResume();
        mapView.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        mapView.onPause();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        mapView.onSaveInstanceState(outState);
    }
}
