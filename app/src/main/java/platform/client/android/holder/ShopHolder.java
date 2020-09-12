package platform.client.android.holder;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ogaclejapan.smarttablayout.SmartTabLayout;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItemAdapter;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems;

import platform.client.android.R;
import platform.client.android.page.ShopPage;

public class ShopHolder extends Fragment  {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        return inflater.inflate(R.layout.holder_shop, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        FragmentPagerItemAdapter adapter = new FragmentPagerItemAdapter(
                getActivity().getSupportFragmentManager(), FragmentPagerItems.with(getActivity())
                .add(R.string.shop, ShopPage.class)
                .add("服装", MineHolder.class)
                .add("饮品", MineHolder.class)
                .add("零食", MineHolder.class)
                .add("电器", MineHolder.class)
                .add("数码", MineHolder.class)
                .add("书籍", MineHolder.class)
                .add("运动", MineHolder.class)
                .add("娱乐", MineHolder.class)
                .create());

        ViewPager viewPager = getActivity().findViewById(R.id.shop_pager);
        viewPager.setAdapter(adapter);

        SmartTabLayout viewPagerTab = getActivity().findViewById(R.id.tab_shop);
        viewPagerTab.setViewPager(viewPager);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
    }
}
