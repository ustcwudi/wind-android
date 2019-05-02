package platform.client.wind.fragment;

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
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;

import com.mancj.materialsearchbar.MaterialSearchBar;

import java.util.ArrayList;
import java.util.List;

import platform.client.wind.R;
import platform.client.wind.adapter.HomeAdapter;
import platform.client.wind.custom.CustomScrollListener;

public class HomeFragment extends Fragment {
    private RecyclerView recyclerView;
    private MaterialSearchBar searchBar;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        searchBar = getActivity().findViewById(R.id.search_bar);
        searchBar.setAlpha(0.8f);
        initRecyclerView();
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.main_menu, menu);
        super.onCreateOptionsMenu(menu, inflater);
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
                searchBar.animate().alpha(0.0f).setInterpolator(new AccelerateInterpolator(2));
            }

            @Override
            public void onShow() {
                searchBar.animate().alpha(0.8f).setInterpolator(new DecelerateInterpolator(2));
            }
        });

    }
}
