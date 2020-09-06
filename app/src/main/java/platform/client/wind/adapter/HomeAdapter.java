package platform.client.wind.adapter;

import android.content.Context;

import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.ms.banner.Banner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import platform.client.wind.R;
import platform.client.wind.custom.CustomBannerView;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.InnerViewHolder> {
    private String[] titleArray = new String[]{"服装", "饮品", "零食", "电器", "数码", "书籍", "运动", "娱乐"};
    private int[] idArray = new int[]{R.drawable.ic_girl, R.drawable.ic_drink, R.drawable.ic_cookie, R.drawable.ic_equipment, R.drawable.ic_digit, R.drawable.ic_book, R.drawable.ic_sport, R.drawable.ic_game};

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
        } else {
            View v = LayoutInflater.from(context).inflate(R.layout.adapter_home_card, parent, false);
            return new InnerViewHolder(v);
        }
    }

    @Override
    public void onBindViewHolder(InnerViewHolder holder, int position) {
        String[] images = new String[]{
                "https://y.zdmimg.com/202009/05/5f2781e9496e2542.png_d200.jpg",
                "https://qny.smzdm.com/202009/06/5f54394840be41595.jpg_d250.jpg",
                "https://qny.smzdm.com/202009/06/5f545185cfca12280.jpg_d200.jpg",
                "https://qny.smzdm.com/202009/06/5f53cdb177e9f8603.jpg_d200.jpg",
                "https://qny.smzdm.com/202009/06/5cce4ef527a116405.jpg_d200.jpg",
                "https://qny.smzdm.com/202009/04/5f51f2dbb108d135.jpg_d200.jpg",
                "https://qny.smzdm.com/202009/05/5c890016382993033.jpg_d200.jpg",
                "https://qny.smzdm.com/202009/05/5f536e363827d5157.jpg_d200.jpg",
                "https://qny.smzdm.com/202009/05/5f538c4f2f6144805.jpg_d200.jpg",
                "https://y.zdmimg.com/202009/03/5f50449d17ec17766.jpg_d200.jpg"};
        String[] titles = new String[]{
                "天堂伞 时尚商务三折伞 多款可选",
                "三只松鼠 爆款零食大礼包 *3件",
                "UNIQLO 优衣库 女士羊毛混纺喇叭裙",
                "AMOI 夏新 F9 5.0无线蓝牙耳机",
                "Sofy 苏菲 卫生巾套装",
                "Nike 耐克 BRASILIA CU1033 训练行李包",
                "Tingyi 康师傅 妙芙蛋糕 奶油口味 9枚 432g *5件",
                "蒙牛 暖.酸奶 阿胶红枣枸杞红糖",
                "哈尔斯 304不锈钢保温杯 450ml",
                "CAFINE 刻凡 匠心制饼 中秋月饼礼盒 720g"};
        int type = getItemViewType(position);
        if (type == ITEM_TYPE_HEADER || type == ITEM_TYPE_FOOTER) {
            return;
        }
        holder.text.setText(titles[new Random().nextInt(10)]);
        Glide.with(holder.image).load(images[new Random().nextInt(10)]).into(holder.image);
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
        dataList.add("https://eimg.smzdm.com/202009/04/5f519e4b7fa9b5824.png");
        dataList.add("https://eimg.smzdm.com/202009/04/5f520a13abac25992.png");
        dataList.add("https://eimg.smzdm.com/202009/04/5f52152b4ee948800.png");
        Banner banner = header.findViewById(R.id.banner);
        banner.setPages(dataList, new CustomBannerView()).setAutoPlay(true).setDelayTime(3000)
                .start();
        return header;
    }

    class InnerViewHolder extends RecyclerView.ViewHolder {

        TextView text;
        ImageView image;


        public InnerViewHolder(View view) {
            super(view);
            text = view.findViewById(R.id.text);
            image = view.findViewById(R.id.image);
        }
    }
}