package com.bawei.wangyifei.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bawei.wangyifei.R;
import com.bawei.wangyifei.bean.First;

import java.util.List;

/**
 * @author 王艺霏
 * @fileName MyFirstAdapter
 * @package com.bawei.wangyifei.adapter
 **/
public class MyFirstAdapter extends RecyclerView.Adapter<MyFirstAdapter.MyFirstViewHolder> {
    Context context;
    List<First> result;

    public MyFirstAdapter(Context context, List<First> result) {
        this.context = context;
        this.result = result;
    }

    @NonNull
    @Override
    public MyFirstViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.first,null,false);
        MyFirstViewHolder myFirstViewHolder = new MyFirstViewHolder(view);
        return myFirstViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyFirstViewHolder myFirstViewHolder, int i) {
        First first = result.get(i);
        String name = first.getName();
        final String id = first.getId();
        myFirstViewHolder.tv.setText(name);
        myFirstViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onFirstListener.onFirst(id);
            }
        });
    }

    @Override
    public int getItemCount() {
        return result.size();
    }

    public class MyFirstViewHolder extends RecyclerView.ViewHolder{


        private final TextView tv;

        public MyFirstViewHolder(@NonNull View itemView) {
            super(itemView);
            tv = itemView.findViewById(R.id.tv);
        }
    }


    public interface OnFirstListener{
        void onFirst(String id);
    }
    public OnFirstListener onFirstListener;
    public void setOnFirstListener(OnFirstListener onFirstListener){
        this.onFirstListener=onFirstListener;
    }
}
