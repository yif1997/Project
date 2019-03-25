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
import com.bawei.wangyifei.bean.Show1;
import com.bawei.wangyifei.bean.ShowBean;
import com.bawei.wangyifei.bean.ShowResult;
import com.bawei.wangyifei.bean.Zhan;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * @author 王艺霏
 * @fileName MyShowAdapter
 * @package com.bawei.wangyifei.adapter
 **/
public class MyShowAdapter extends RecyclerView.Adapter<MyShowAdapter.MyShowViewHolder> {
    Context context;
    ShowResult result;

    public MyShowAdapter(Context context, ShowResult result) {
        this.context = context;
        this.result = result;
    }

    @NonNull
    @Override
    public MyShowViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.show1,viewGroup,false);
        MyShowViewHolder myShowViewHolder = new MyShowViewHolder(view);
        return myShowViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyShowViewHolder myShowViewHolder, int i) {
        Show1 rxxp = result.getRxxp();
        List<Zhan> commodityList = rxxp.getCommodityList();
        Zhan zhan = commodityList.get(i);
        String commodityName = zhan.getCommodityName();
        String masterPic = zhan.getMasterPic();
        final String commodityId = zhan.getCommodityId();

        String price = zhan.getPrice();
        myShowViewHolder.name1.setText(commodityName);
        myShowViewHolder.pic1.setImageURI(Uri.parse(masterPic));
        myShowViewHolder.price1.setText(price);
        //点击详情
        myShowViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickItemListener.onClickItem(commodityId);
            }
        });
    }

    @Override
    public int getItemCount() {
        return result.getRxxp().getCommodityList().size();
    }


    public class MyShowViewHolder extends RecyclerView.ViewHolder{

        private final SimpleDraweeView pic1;
        private final TextView name1;
        private final TextView price1;

        public MyShowViewHolder(@NonNull View itemView) {
            super(itemView);
            pic1 = itemView.findViewById(R.id.pic1);
            name1 = itemView.findViewById(R.id.name1);
            price1 = itemView.findViewById(R.id.price1);
        }
    }



    public interface OnClickItemListener{
        void onClickItem(String commodityId);
    }
    public OnClickItemListener onClickItemListener;
    public void setOnClickItemListener(OnClickItemListener onClickItemListener){
        this.onClickItemListener=onClickItemListener;
    }
}
