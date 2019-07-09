package platform.client.wind.pager;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ogaclejapan.smarttablayout.SmartTabLayout;

import java.util.ArrayList;
import java.util.List;

import platform.client.wind.R;
import platform.client.wind.adapter.HomeAdapter;
import platform.client.wind.custom.CustomScrollListener;

public class HomePager extends Fragment {
    private RecyclerView recyclerView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        return inflater.inflate(R.layout.pager_home, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initRecyclerView();
    }

    private void initRecyclerView() {
        List<String> dataList = new ArrayList<>();
        for (int i = 'A'; i < 'Z'; i++) {
            dataList.add("" + (char) i);
        }
        recyclerView = getActivity().findViewById(R.id.main_recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        HomeAdapter adapter = new HomeAdapter(getContext(), dataList);
        recyclerView.setAdapter(adapter);
        recyclerView.addOnScrollListener(new CustomScrollListener() {
            @Override
            public void onHide() {
                SmartTabLayout viewPagerTab = getActivity().findViewById(R.id.tab_layout);
                viewPagerTab.animate().alpha(0);
            }

            @Override
            public void onShow() {
                SmartTabLayout viewPagerTab = getActivity().findViewById(R.id.tab_layout);
                viewPagerTab.animate().alpha(1);
            }
        });

    }
}
