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
 * @fileName MyShowAdapter3
 * @package com.bawei.wangyifei.adapter
 **/
public class MyShowAdapter3 extends RecyclerView.Adapter<MyShowAdapter3.MyShowViewHolder3> {
    Context context;
    ShowResult result;

    public MyShowAdapter3(Context context, ShowResult result) {
        this.context = context;
        this.result = result;
    }

    @NonNull
    @Override
    public MyShowViewHolder3 onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.show3,null,false);
        MyShowViewHolder3 myShowViewHolder3 = new MyShowViewHolder3(view);
        return myShowViewHolder3;
    }

    @Override
    public void onBindViewHolder(@NonNull MyShowViewHolder3 myShowViewHolder3, int i) {
        Show1 pzsh = result.getPzsh();
        List<Zhan> commodityList = pzsh.getCommodityList();
        Zhan zhan = commodityList.get(i);
        String commodityName = zhan.getCommodityName();
        String masterPic = zhan.getMasterPic();
        String price = zhan.getPrice();
        final String commodityId = zhan.getCommodityId();
        myShowViewHolder3.name3.setText(commodityName);
        myShowViewHolder3.price3.setText(price);
        myShowViewHolder3.pic3.setImageURI(Uri.parse(masterPic));
        myShowViewHolder3.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickItemListener.onClickItem(commodityId);
            }
        });
    }

    @Override
    public int getItemCount() {
        return result.getPzsh().getCommodityList().size();
    }

    public class MyShowViewHolder3 extends RecyclerView.ViewHolder{

        private final SimpleDraweeView pic3;
        private final TextView name3;
        private final TextView price3;
        private final TextView title1;

        public MyShowViewHolder3(@NonNull View itemView) {
            super(itemView);
            pic3 = itemView.findViewById(R.id.pic3);
            name3 = itemView.findViewById(R.id.name3);
            price3 = itemView.findViewById(R.id.price3);
            title1 = itemView.findViewById(R.id.title1);
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
