package platform.client.wind.adapter;

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

import platform.client.wind.R;

public class CarAdapter extends RecyclerView.Adapter<CarAdapter.InnerViewHolder> {
    private List<String> dataList;
    private Context context;

    public CarAdapter(Context context, List data) {
        dataList = data;
        this.context = context;
    }

    @Override
    public InnerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.adapter_car_card, parent, false);
        return new InnerViewHolder(v);
    }

    @Override
    public void onBindViewHolder(InnerViewHolder holder, int position) {
        String[] positions = new String[]{
                "江汉大学", "经开万达", "中百仓储", "沌阳大道", "观湖路"
        };
        holder.text.setText((new Random().nextInt(9) + 1) + "号车辆");
        holder.position.setText((new Random().nextInt(3) + 1) + "分钟后到达" + positions[new Random().nextInt(5)]);
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    class InnerViewHolder extends RecyclerView.ViewHolder {

        TextView text;
        TextView position;
        ImageView image;


        public InnerViewHolder(View view) {
            super(view);
            text = view.findViewById(R.id.text);
            position = view.findViewById(R.id.position);
            image = view.findViewById(R.id.image);
        }
    }
}