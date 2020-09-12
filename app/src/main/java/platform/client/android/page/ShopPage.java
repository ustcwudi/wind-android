package platform.client.android.page;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import platform.client.android.R;
import platform.client.android.adapter.ShopAdapter;

public class ShopPage extends Fragment {
    private RecyclerView recyclerView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.pager_shop, container, false);
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
        recyclerView = getActivity().findViewById(R.id.shop_recycler);
        GridLayoutManager manager = new GridLayoutManager(getContext(), 2);
        recyclerView.setLayoutManager(manager);
        ShopAdapter adapter = new ShopAdapter(getContext(), dataList);
        recyclerView.setAdapter(adapter);
    }
}
