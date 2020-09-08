package platform.client.wind.pager;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.amap.api.maps2d.CameraUpdateFactory;
import com.amap.api.maps2d.MapView;
import com.amap.api.maps2d.model.MyLocationStyle;

import platform.client.wind.R;

public class MapPager extends Fragment {
    MapView mapView = null;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        return inflater.inflate(R.layout.fragment_map, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mapView = getActivity().findViewById(R.id.map);
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
