package platform.client.wind.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

import platform.client.wind.R;

public class HomeFragment extends Fragment {

    private GridView gridView;
    ArrayList<HashMap<String, Object>> arrayList;
    private String[] titleArray = new String[]{"日历", "新闻", "消息", "旗帜", "钱包", "目标", "发现", "设置"};
    private int[] idArray = new int[]{R.drawable.ic_date, R.drawable.ic_news, R.drawable.ic_message, R.drawable.ic_flag, R.drawable.ic_wallet, R.drawable.ic_target, R.drawable.ic_lamp, R.drawable.ic_config};

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        gridView = getActivity().findViewById(R.id.main_grid);
        arrayList = new ArrayList<>();

        for (int i = 0; i < 8; i++) {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put("image", idArray[i]);
            hashMap.put("text", titleArray[i]);
            arrayList.add(hashMap);
        }

        SimpleAdapter simpleAdapter = new SimpleAdapter(getContext(), arrayList, R.layout.fragment_item,
                new String[] { "image", "text" }, new int[] { R.id.image, R.id.text });
        gridView.setAdapter(simpleAdapter);
    }
}
