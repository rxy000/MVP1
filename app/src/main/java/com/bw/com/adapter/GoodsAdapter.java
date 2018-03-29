package com.bw.com.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.bw.com.bean.MyBean;
import com.bw.com.mvp.R;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by tangxueqin on 2018/3/9.
 */
public class GoodsAdapter extends RecyclerView.Adapter<GoodsAdapter.GoodsViewHoder> {
    private Context context;
    private List<MyBean.ResultsBean> list=new ArrayList<>();

    public GoodsAdapter(Context context, List<MyBean.ResultsBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public GoodsViewHoder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item, parent,false);

        return new GoodsViewHoder(view);
    }

    @Override
    public void onBindViewHolder(GoodsViewHoder holder,final int position) {

        holder.titiel.setText(list.get(position).getWho());
        Glide.with(context).load(list.get(position).getUrl()).into(holder.img);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class GoodsViewHoder extends RecyclerView.ViewHolder{
        ImageView img;
        TextView titiel;
        public GoodsViewHoder(View itemView) {
            super(itemView);
            img =(ImageView) itemView.findViewById(R.id.img);
            titiel = (TextView)itemView.findViewById(R.id.text_titiel);
        }
    }
}
