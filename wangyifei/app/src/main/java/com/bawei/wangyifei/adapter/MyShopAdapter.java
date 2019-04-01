package com.bawei.wangyifei.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.bawei.wangyifei.R;
import com.bawei.wangyifei.activity.CountView;
import com.bawei.wangyifei.bean.Shop;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * @author 王艺霏
 * @fileName MyShopAdapter
 * @package com.bawei.wangyifei.adapter
 **/
public class MyShopAdapter extends RecyclerView.Adapter<MyShopAdapter.MyShopViewHolder> {
    Context context;
    List<Shop> result;
    private int i = 1;

    public MyShopAdapter(Context context, List<Shop> result) {
        this.context = context;
        this.result = result;
    }

    @NonNull
    @Override
    public MyShopViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.shop_item,null,false);
        MyShopViewHolder myShopViewHolder = new MyShopViewHolder(view);
        return myShopViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyShopViewHolder myShopViewHolder, final int i) {
        Shop shop = result.get(i);
        final String commodityId = shop.getCommodityId();
        String commodityName = shop.getCommodityName();
        int count = shop.getCount();
        String pic = shop.getPic();
        final int price = shop.getPrice();
        myShopViewHolder.shop_name.setText(commodityName);
        myShopViewHolder.shop_price.setText("$"+price);
        myShopViewHolder.shop_simp.setImageURI(Uri.parse(pic));

        //根据我记录的状态，改变勾选
        myShopViewHolder.check_odd.setChecked(result.get(i).isItem_check());

        //商品复选框点击
        myShopViewHolder.check_odd.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                result.get(i).setItem_check(isChecked);
                if (onCallBackListener!=null){
                    onCallBackListener.callBack(result);
                }
            }
        });


        //加减器
        myShopViewHolder.shop_count.setData(this,result,i);
        //商品数量改变
        myShopViewHolder.shop_count.setOnNumChangeListener(new CountView.OnNumChangeListener() {
            @Override
            public void changNum() {
                if (onCallBackListener!=null){
                    onCallBackListener.callBack(result);
                }
            }
        });




    }

    @Override
    public int getItemCount() {
        return result.size();

    }

    public class MyShopViewHolder extends RecyclerView.ViewHolder{

        private final CountView shop_count;
        private final TextView shop_name;
        private final TextView shop_price;
        private final SimpleDraweeView shop_simp;
        private final CheckBox check_odd;


        public MyShopViewHolder(@NonNull View itemView) {
            super(itemView);
            shop_count = itemView.findViewById(R.id.shop_count);
            shop_name = itemView.findViewById(R.id.shop_name);
            shop_price = itemView.findViewById(R.id.shop_price);
            shop_simp = itemView.findViewById(R.id.shop_simp);
            check_odd = itemView.findViewById(R.id.check_odd);
        }
    }

//计算总价接口回调
    public interface OnCallBackListener{
        void callBack(List<Shop> result);
}
public OnCallBackListener onCallBackListener;
    public void setOnCallBackListener(OnCallBackListener onCallBackListener){
        this.onCallBackListener=onCallBackListener;
    }





}
