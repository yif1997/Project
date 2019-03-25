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
import com.bawei.wangyifei.bean.Classity;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * @author 王艺霏
 * @fileName MyClassityAdapter
 * @package com.bawei.wangyifei.adapter
 **/
public class MyClassityAdapter extends RecyclerView.Adapter<MyClassityAdapter.MyClassityViewHolder> {
    Context context;
    List<Classity> result;

    public MyClassityAdapter(Context context, List<Classity> result) {
        this.context = context;
        this.result = result;
    }

    @NonNull
    @Override
    public MyClassityViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.classity,null,false);
        MyClassityViewHolder myClassityViewHolder = new MyClassityViewHolder(view);
        return myClassityViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyClassityViewHolder myClassityViewHolder, int i) {
        Classity classity = result.get(i);
        String commodityName = classity.getCommodityName();
        String price = classity.getPrice();
        String masterPic = classity.getMasterPic();
        final String commodityId = classity.getCommodityId();
        myClassityViewHolder.tv2.setText(commodityName);
        myClassityViewHolder.tv3.setText(price);
        myClassityViewHolder.sdv.setImageURI(Uri.parse(masterPic));
        myClassityViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
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

    public class MyClassityViewHolder extends RecyclerView.ViewHolder{

        private final SimpleDraweeView sdv;
        private final TextView tv2;
        private final TextView tv3;

        public MyClassityViewHolder(@NonNull View itemView) {
            super(itemView);
            sdv = itemView.findViewById(R.id.sdv);
            tv2 = itemView.findViewById(R.id.tv2);
            tv3 = itemView.findViewById(R.id.tv3);
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
