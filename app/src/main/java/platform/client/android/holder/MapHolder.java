package platform.client.android.holder;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.ogaclejapan.smarttablayout.SmartTabLayout;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItemAdapter;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems;

import platform.client.android.R;
import platform.client.android.page.CarPage;

public class MapHolder extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        return inflater.inflate(R.layout.holder_car, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        FragmentPagerItemAdapter adapter = new FragmentPagerItemAdapter(
                getActivity().getSupportFragmentManager(), FragmentPagerItems.with(getActivity())
                .add("物流", CarPage.class)
                .create());

        ViewPager viewPager = getActivity().findViewById(R.id.car_pager);
        viewPager.setAdapter(adapter);

        SmartTabLayout viewPagerTab = getActivity().findViewById(R.id.tab_car);
        viewPagerTab.setViewPager(viewPager);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
    }
}
