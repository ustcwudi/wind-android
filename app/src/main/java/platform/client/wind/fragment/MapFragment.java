package platform.client.wind.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;
import com.amap.api.maps2d.CameraUpdateFactory;
import com.amap.api.maps2d.LocationSource;
import com.amap.api.maps2d.MapView;
import com.amap.api.maps2d.model.LatLng;
import com.amap.api.maps2d.model.MyLocationStyle;

import java.text.SimpleDateFormat;
import java.util.Date;

import platform.client.wind.R;

public class MapFragment extends Fragment implements LocationSource, AMapLocationListener {
    MapView mapView = null;
    AMapLocationClient locationClient = null;
    AMapLocationClientOption locationClientOption = null;//定位参数
    OnLocationChangedListener listener = null;//定位监听器
    boolean isFirstLocation = true;

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
        MyLocationStyle locationStyle;
        locationStyle = new MyLocationStyle();
        locationStyle.interval(2000);
        mapView.getMap().setMyLocationStyle(locationStyle);
        mapView.getMap().getUiSettings().setMyLocationButtonEnabled(true);
        mapView.getMap().setMyLocationEnabled(true);
        initLoc();
    }

    //定位
    private void initLoc() {
        locationClient = new AMapLocationClient(getActivity().getApplicationContext());
        locationClient.setLocationListener(this);
        locationClientOption = new AMapLocationClientOption();
        locationClientOption.setLocationMode(AMapLocationClientOption.AMapLocationMode.Hight_Accuracy);
        locationClientOption.setNeedAddress(true);
        locationClientOption.setOnceLocation(false);
        locationClientOption.setMockEnable(false);
        locationClientOption.setInterval(10000);
        locationClient.setLocationOption(locationClientOption);
        locationClient.startLocation();
    }

    @Override
    public void onLocationChanged(AMapLocation mapLocation) {
        if (mapLocation != null) {
            if (mapLocation.getErrorCode() == 0) {
                mapLocation.getLocationType();
                mapLocation.getLatitude();
                mapLocation.getLongitude();
                mapLocation.getAccuracy();
                mapLocation.getAddress();
                mapLocation.getCountry();
                mapLocation.getProvince();
                mapLocation.getCity();
                mapLocation.getDistrict();
                mapLocation.getStreet();
                mapLocation.getStreetNum();
                mapLocation.getCityCode();
                mapLocation.getAdCode();

                // 如果不设置标志位，此时再拖动地图时，它会不断将地图移动到当前的位置
                if (isFirstLocation) {
                    mapView.getMap().moveCamera(CameraUpdateFactory.zoomTo(17));
                    mapView.getMap().moveCamera(CameraUpdateFactory.changeLatLng(new LatLng(mapLocation.getLatitude(), mapLocation.getLongitude())));
                    listener.onLocationChanged(mapLocation);
                    isFirstLocation = false;
                }
            } else {
                System.out.println("location error " + mapLocation.getErrorCode());
            }
        }
    }

    @Override
    public void activate(OnLocationChangedListener listener) {
        this.listener = listener;
    }

    @Override
    public void deactivate() {
        listener = null;
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
