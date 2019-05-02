package platform.client.wind.custom;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.ms.banner.holder.BannerViewHolder;
import com.nostra13.universalimageloader.core.ImageLoader;

import platform.client.wind.R;

public class CustomBannerView implements BannerViewHolder<String> {

    private ImageView imageView;
    private TextView textView;

    @Override
    public View createView(Context context) {
        View view = LayoutInflater.from(context).inflate(R.layout.adapter_home_banner, null);
        imageView = view.findViewById(R.id.image);
        textView = view.findViewById(R.id.text);
        return view;
    }

    @Override
    public void onBind(Context context, int position, String data) {
        ImageLoader.getInstance().displayImage(data, imageView);
        textView.setText(position + "");
    }
}
