package platform.client.android.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;
import java.util.Random;

import platform.client.android.R;

public class ShopAdapter extends RecyclerView.Adapter<ShopAdapter.InnerViewHolder> {
    private List<String> dataList;
    private Context context;

    public ShopAdapter(Context context, List data) {
        dataList = data;
        this.context = context;
    }

    @Override
    public InnerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.card_product, parent, false);
        return new InnerViewHolder(v);
    }

    @Override
    public void onBindViewHolder(InnerViewHolder holder, int position) {
        String[] images = new String[]{
                "https://qny.smzdm.com/202007/29/5f211719bda35270.jpg_d200.jpg",
                "https://y.zdmimg.com/201909/29/5d9079af158d79113.jpg_d200.jpg",
                "https://qny.smzdm.com/202009/08/5f56dc6d679977057.jpg_d200.jpg",
                "https://y.zdmimg.com/202009/05/5f52ff36b82ca5542.jpg_d200.jpg",
                "https://qny.smzdm.com/202009/07/5f563e3b2edb08667.png_d200.jpg",
                "https://qny.smzdm.com/202009/08/5f56e0eb660058055.jpg_d200.jpg",
                "https://y.zdmimg.com/201712/21/5a3b52be136bc4976.jpg_d200.jpg",
                "https://y.zdmimg.com/202009/07/5f49f9bcd8b3c3143.jpg_d200.jpg",
                "https://qny.smzdm.com/202009/08/5f56e6aa32d842641.jpg_d200.jpg",
                "https://qny.smzdm.com/202005/13/5ebb5809b18b86977.jpg_d200.jpg",
                "https://y.zdmimg.com/201909/29/5d9049e4e82c68845.jpg_d200.jpg",
                "https://qny.smzdm.com/202009/04/5ce35fbbd416e4920.jpg_d200.jpg",
                "https://qny.smzdm.com/202009/07/5f563bdf83eaf4043.jpg_d200.jpg",
                "https://y.zdmimg.com/202009/07/5f55f1459698a6770.png_d200.jpg",
                "https://qny.smzdm.com/202009/07/5f55be880d7052781.jpg_d200.jpg",
                "https://qny.smzdm.com/202003/24/5e79be0a6f73f9647.jpg_d200.jpg",
                "https://qny.smzdm.com/202009/08/5f56eaeb79e882837.jpg_d200.jpg"};
        String[] titles = new String[]{
                "海氏海诺 一次性医用外科口罩 50只装",
                "Tide 汰渍 护色防串色洗衣凝珠 19颗 *2件",
                "白雪 T15 直液式走珠中性笔 0.5mm 10支",
                "柚柏 iPhone11 磨砂全包手机壳",
                "Colgate 高露洁 超洁纤柔牙刷 10支",
                "UNIQLO 优衣库 422230 女款羊毛混纺迷你裙",
                "Panasonic 松下 EH-WNE5D 电吹风机",
                "ARIEL 碧浪 清爽防异味长效抑菌珠 140g",
                "JOY 超浓缩除菌洗洁精 170ml*3瓶",
                "KINGSHORE 金号 纯棉毛巾 75g/条 4条",
                "M&G 晨光 ADM95297 黑色四层桌面带锁文件柜",
                "ZMI 紫米 彩虹碱性电池 5号12粒 + 7号12粒",
                "邻里赞 会理突尼斯软籽石榴 净重5斤中果",
                "华味亨 焦糖味瓜子 500g/袋",
                "伊利 金典 低脂纯牛奶 250ml*12盒/箱",
                "怡宝 饮用纯净水 4.5l*4支/箱 * 2箱",
                "BeLLE 百丽 U7D1DDD9 女士马丁靴"};
        int random = new Random().nextInt(17);
        holder.text.setText(titles[random]);
        holder.price.setText("￥" + new Random().nextInt(100));
        holder.count.setText(new Random().nextInt(500) + "人付款");
        Glide.with(holder.image).load(images[random]).into(holder.image);
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    class InnerViewHolder extends RecyclerView.ViewHolder {

        TextView text;
        TextView price;
        TextView count;
        ImageView image;


        public InnerViewHolder(View view) {
            super(view);
            text = view.findViewById(R.id.text);
            price = view.findViewById(R.id.price);
            count = view.findViewById(R.id.count);
            image = view.findViewById(R.id.image);
        }
    }
}