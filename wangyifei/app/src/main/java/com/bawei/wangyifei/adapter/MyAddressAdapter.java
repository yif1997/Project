package com.bawei.wangyifei.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import com.bawei.wangyifei.R;
import com.bawei.wangyifei.bean.MyAddress;

import java.util.List;

/**
 * @author 王艺霏
 * @fileName MyAddressAdapter
 * @package com.bawei.wangyifei.adapter
 **/
public class MyAddressAdapter extends RecyclerView.Adapter<MyAddressAdapter.MyAddressViewHolder> {
    Context context;
    List<MyAddress> result;

    public MyAddressAdapter(Context context, List<MyAddress> result) {
        this.context = context;
        this.result = result;
    }

    @NonNull
    @Override
    public MyAddressViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.lay,viewGroup,false);
        MyAddressViewHolder myAddressViewHolder = new MyAddressViewHolder(view);
        return myAddressViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyAddressViewHolder myAddressViewHolder, int i) {
        MyAddress myAddress = result.get(i);
        String address = myAddress.getAddress();
        String createTime = myAddress.getCreateTime();
        final String id = myAddress.getId();
        String phone = myAddress.getPhone();
        String realName = myAddress.getRealName();
        String userId = myAddress.getUserId();
        String whetherDefault = myAddress.getWhetherDefault();
        String zipCode = myAddress.getZipCode();
        myAddressViewHolder.name2.setText(realName);
        myAddressViewHolder.phone2.setText(phone);
        myAddressViewHolder.address2.setText(address);
        myAddressViewHolder.my_check.setText(id);

        //
        if (whetherDefault.equals("1")){
            myAddressViewHolder.my_check.setChecked(true);
        }

        myAddressViewHolder.my_check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onDefaultListener.onDedault(id);
            }
        });
    }

    @Override
    public int getItemCount() {
        return result.size();
    }


    public class MyAddressViewHolder extends RecyclerView.ViewHolder{

        private final TextView name2;
        private final TextView phone2;
        private final TextView address2;
        private final CheckBox my_check;

        public MyAddressViewHolder(@NonNull View itemView) {
            super(itemView);
            name2 = itemView.findViewById(R.id.user2);
            phone2 = itemView.findViewById(R.id.phone2);
            address2 = itemView.findViewById(R.id.address2);
            my_check = itemView.findViewById(R.id.my_check);
        }
    }

    public interface OnDefaultListener{
        void onDedault(String id);
    }
    public OnDefaultListener onDefaultListener;

    public void setOnDefaultListener(OnDefaultListener onDefaultListener){
        this.onDefaultListener=onDefaultListener;
    }
}
