package com.bawei.wangyifei.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bawei.wangyifei.R;
import com.bawei.wangyifei.bean.Second;

import java.util.List;

/**
 * @author 王艺霏
 * @fileName MySecondAdapter
 * @package com.bawei.wangyifei.adapter
 **/
public class MySecondAdapter extends RecyclerView.Adapter<MySecondAdapter.MySecondViewHolder> {
    Context context;
    List<Second> result;

    public MySecondAdapter(Context context, List<Second> result) {
        this.context = context;
        this.result = result;
    }

    @NonNull
    @Override
    public MySecondViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.second,null,false);
        MySecondViewHolder mySecondViewHolder = new MySecondViewHolder(view);
        return mySecondViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MySecondViewHolder mySecondViewHolder, int i) {
        Second second = result.get(i);
        final String id = second.getId();
        String name = second.getName();
        mySecondViewHolder.tv1.setText(name);
        mySecondViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onSecondListener.onSecond(id);
            }
        });
    }

    @Override
    public int getItemCount() {
        return result.size();
    }

    public class MySecondViewHolder extends RecyclerView.ViewHolder{

        private final TextView tv1;

        public MySecondViewHolder(@NonNull View itemView) {
            super(itemView);
            tv1 = itemView.findViewById(R.id.tv1);
        }
    }


    public interface OnSecondListener{
        void onSecond(String id);
    }
    public OnSecondListener onSecondListener;

    public void setOnSecondListener(OnSecondListener onSecondListener){
        this.onSecondListener=onSecondListener;
    }
}
