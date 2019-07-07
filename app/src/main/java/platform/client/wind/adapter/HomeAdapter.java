package platform.client.wind.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.ms.banner.Banner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import platform.client.wind.R;
import platform.client.wind.custom.CustomBannerView;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.InnerViewHolder> {
    private String[] titleArray = new String[]{"日历", "新闻", "消息", "旗帜", "钱包", "目标", "发现", "设置"};
    private int[] idArray = new int[]{R.drawable.ic_date, R.drawable.ic_news, R.drawable.ic_message, R.drawable.ic_flag, R.drawable.ic_wallet, R.drawable.ic_target, R.drawable.ic_lamp, R.drawable.ic_config};

    private List<String> dataList;
    private Context context;

    private int ITEM_TYPE_NORMAL = 0;
    private int ITEM_TYPE_HEADER = 1;
    private int ITEM_TYPE_FOOTER = 2;

    public HomeAdapter(Context context, List data) {
        dataList = data;
        this.context = context;
    }

    @Override
    public InnerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == ITEM_TYPE_HEADER) {
            return new InnerViewHolder(initHeader(parent));
        } else if (viewType == ITEM_TYPE_FOOTER) {
            return new InnerViewHolder(LayoutInflater.from(context).inflate(R.layout.adapter_bottom, parent, false));
        } else {
            View v = LayoutInflater.from(context).inflate(R.layout.adapter_home_card, parent, false);
            return new InnerViewHolder(v);
        }
    }

    @Override
    public void onBindViewHolder(InnerViewHolder holder, int position) {
        int type = getItemViewType(position);
        if (type == ITEM_TYPE_HEADER || type == ITEM_TYPE_FOOTER) {
            return;
        }
        holder.tv.setText(dataList.get(position - 1));
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return ITEM_TYPE_HEADER;
        }
        if (position == getItemCount() - 1) {
            return ITEM_TYPE_FOOTER;
        }
        return ITEM_TYPE_NORMAL;
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    private View initHeader(ViewGroup parent) {
        View header = LayoutInflater.from(context).inflate(R.layout.adapter_home_header, parent, false);

        GridView gridView = header.findViewById(R.id.home_grid);
        ArrayList<HashMap<String, Object>> arrayList = new ArrayList<>();

        for (int i = 0; i < 8; i++) {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put("image", idArray[i]);
            hashMap.put("text", titleArray[i]);
            arrayList.add(hashMap);
        }

        SimpleAdapter simpleAdapter = new SimpleAdapter(context, arrayList, R.layout.adapter_home_grid,
                new String[]{"image", "text"}, new int[]{R.id.image, R.id.text});
        gridView.setAdapter(simpleAdapter);

        List<String> dataList = new ArrayList<>();
        dataList.add("http://ces.whu.edu.cn/images/18/10/17/20w83ot61d/three.jpg");
        dataList.add("http://ces.whu.edu.cn/images/18/10/17/20w83ot61d/two.jpg");
        dataList.add("http://ces.whu.edu.cn/images/18/10/17/20w83ot61d/one.jpg");
        Banner banner = header.findViewById(R.id.banner);
        banner.setPages(dataList, new CustomBannerView()).setAutoPlay(true).setDelayTime(3000)
                .start();
        return header;
    }

    class InnerViewHolder extends RecyclerView.ViewHolder {

        TextView tv;

        public InnerViewHolder(View view) {
            super(view);
            tv = view.findViewById(R.id.text);
        }
    }
}