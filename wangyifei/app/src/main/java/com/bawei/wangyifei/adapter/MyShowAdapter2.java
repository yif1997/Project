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
import com.bawei.wangyifei.bean.ShowResult;
import com.bawei.wangyifei.bean.Zhan;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * @author 王艺霏
 * @fileName MyShowAdapter2
 * @package com.bawei.wangyifei.adapter
 **/
public class MyShowAdapter2 extends RecyclerView.Adapter<MyShowAdapter2.MyShowViewHolder2> {
    Context context;
    ShowResult result;

    public MyShowAdapter2(Context context, ShowResult result) {
        this.context = context;
        this.result = result;
    }

    @NonNull
    @Override
    public MyShowViewHolder2 onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.show2,null,false);
        MyShowViewHolder2 myShowViewHolder2 = new MyShowViewHolder2(view);
        return myShowViewHolder2;
    }

    @Override
    public void onBindViewHolder(@NonNull MyShowViewHolder2 myShowViewHolder2, int i) {
        Show1 mlss = result.getMlss();
        List<Zhan> commodityList = mlss.getCommodityList();
        Zhan zhan = commodityList.get(i);
        String commodityName = zhan.getCommodityName();
        String masterPic = zhan.getMasterPic();
        String price = zhan.getPrice();
        final String commodityId = zhan.getCommodityId();
        myShowViewHolder2.name2.setText(commodityName);
        myShowViewHolder2.price2.setText(price);
        myShowViewHolder2.pic2.setImageURI(Uri.parse(masterPic));
        myShowViewHolder2.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickItemListener.onClickItem(commodityId);
            }
        });
    }

    @Override
    public int getItemCount() {
        return result.getMlss().getCommodityList().size();
    }


    public class MyShowViewHolder2 extends RecyclerView.ViewHolder{

        private final SimpleDraweeView pic2;
        private final TextView name2;
        private final TextView price2;

        public MyShowViewHolder2(@NonNull View itemView) {
            super(itemView);
            pic2 = itemView.findViewById(R.id.pic2);
            name2 = itemView.findViewById(R.id.name2);
            price2 = itemView.findViewById(R.id.price2);
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
