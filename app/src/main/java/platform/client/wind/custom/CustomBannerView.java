package platform.client.wind.custom;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.ms.banner.holder.BannerViewHolder;

import platform.client.wind.R;

public class CustomBannerView implements BannerViewHolder<String> {

    private CardView cardView;
    private TextView textView;

    @Override
    public View createView(Context context) {
        View view = LayoutInflater.from(context).inflate(R.layout.adapter_home_banner, null);
        cardView = view.findViewById(R.id.card);
        textView = view.findViewById(R.id.text);
        return view;
    }

    @Override
    public void onBind(Context context, int position, String data) {
        cardView.setCardBackgroundColor(Color.parseColor(data));
        textView.setText(position + "");
    }
}
