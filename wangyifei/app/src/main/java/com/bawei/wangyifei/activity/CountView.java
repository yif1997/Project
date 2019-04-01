package com.bawei.wangyifei.activity;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bawei.wangyifei.R;
import com.bawei.wangyifei.adapter.MyShopAdapter;
import com.bawei.wangyifei.bean.Shop;

import java.util.List;

/**
 * @author 王艺霏
 * @fileName CountView
 * @package com.bawei.wangyifei.activity
 **/
public class CountView extends LinearLayout implements View.OnClickListener {
    private MyShopAdapter myShopAdapter;
    private List<Shop> result;
    private int number = 1;
    private int i;
    private Button reduce;
    private TextView num;
    private Button plus;

    public CountView(Context context) {
        super(context);
    }

    public CountView(Context context,  AttributeSet attrs) {
        super(context, attrs);
        initData(context);
    }

    private void initData(Context context) {
        View view = LayoutInflater.from(context).inflate(R.layout.count,null,false);
        addView(view);
        reduce = view.findViewById(R.id.reduce);
        num = view.findViewById(R.id.num);
        plus = view.findViewById(R.id.plus);

        num.setText(number+"");

        //设置点击事件监听
        reduce.setOnClickListener(this);
        plus.setOnClickListener(this);


    }

    public CountView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    //点击
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            //减
            case R.id.reduce:
                if (number>1){
                    number--;
                }
                else {
                    Toast.makeText(getContext(), "不能再减了", Toast.LENGTH_SHORT).show();
                }
                num.setText(number+"");
                result.get(i).setCount(number);
                onNumChangeListener.changNum();
                myShopAdapter.notifyItemChanged(i);
                break;
                //加
            case R.id.plus:
                number++;
                num.setText(number+"");
                result.get(i).setCount(number);
                onNumChangeListener.changNum();
                myShopAdapter.notifyItemChanged(i);
                break;
        }
    }


    public void setData(MyShopAdapter myShopAdapter, List<Shop> result, int i){
        this.myShopAdapter = myShopAdapter;
        this.result = result;
        this.number = number;
        number = result.get(i).getCount();
        num.setText(this.number+"");
    }

    public interface OnNumChangeListener{
        void changNum();
    }
    public OnNumChangeListener onNumChangeListener;
    public void setOnNumChangeListener(OnNumChangeListener onNumChangeListener){
        this.onNumChangeListener=onNumChangeListener;
    }
}
