package com.bawei.wangyifei.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bawei.wangyifei.R;
import com.bawei.wangyifei.bean.ResultBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * @author 王艺霏
 * @fileName MyAdapter
 * @package com.bawei.wangyifei.adapter
 **/
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    Context context;
    List<ResultBean> result;

    public MyAdapter(Context context, List<ResultBean> result) {
        this.context = context;
        this.result = result;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.search,null,false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        ResultBean resultBean = result.get(i);
        String commodityName = resultBean.getCommodityName();
        String masterPic = resultBean.getMasterPic();
        String price = resultBean.getPrice();
        final String commodityId = resultBean.getCommodityId();
        myViewHolder.name.setText(commodityName);
        myViewHolder.price.setText(price);
        myViewHolder.simp.setImageURI(Uri.parse(masterPic));
        myViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickItemListener.onClickItem(commodityId);
            }
        });
    }

    @Override
    public int getItemCount() {
        return result.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        private final SimpleDraweeView simp;
        private final TextView name;
        private final TextView price;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            simp = itemView.findViewById(R.id.simp);
            name = itemView.findViewById(R.id.name);
            price = itemView.findViewById(R.id.price);
        }
    }
    public interface OnClickItemListener{
        void onClickItem(String commodityId);
    }
    public MyShowAdapter.OnClickItemListener onClickItemListener;
    public void setOnClickItemListener(MyShowAdapter.OnClickItemListener onClickItemListener){
        this.onClickItemListener=onClickItemListener;
    }

}
