package com.bawei.wangyifei.frag;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.bawei.wangyifei.R;
import com.bawei.wangyifei.activity.AssActivity;
import com.bawei.wangyifei.activity.CustonView;
import com.bawei.wangyifei.activity.DetailsActivity;
import com.bawei.wangyifei.adapter.MyAdapter;
import com.bawei.wangyifei.adapter.MyFirstAdapter;
import com.bawei.wangyifei.adapter.MySecondAdapter;
import com.bawei.wangyifei.adapter.MyShowAdapter;
import com.bawei.wangyifei.adapter.MyShowAdapter2;
import com.bawei.wangyifei.adapter.MyShowAdapter3;
import com.bawei.wangyifei.base.BaseFragment;
import com.bawei.wangyifei.bean.First;
import com.bawei.wangyifei.bean.ResultBean;
import com.bawei.wangyifei.bean.ResultBean1;
import com.bawei.wangyifei.bean.Second;
import com.bawei.wangyifei.bean.ShowBean;
import com.bawei.wangyifei.bean.ShowResult;
import com.bawei.wangyifei.presenter.FirstPresenter;
import com.bawei.wangyifei.presenter.HomePresenter;
import com.bawei.wangyifei.presenter.PicPresenter;
import com.bawei.wangyifei.presenter.SecondPresenter;
import com.bawei.wangyifei.presenter.ShowPresenter;
import com.bawei.wangyifei.view.FirstView;
import com.bawei.wangyifei.view.PicView;
import com.bawei.wangyifei.view.SearchView;
import com.bawei.wangyifei.view.SecondView;
import com.bawei.wangyifei.view.ShowView;
import com.bumptech.glide.Glide;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.view.SimpleDraweeView;
import com.stx.xhb.xbanner.XBanner;

import java.util.List;

/**
 * @author 王艺霏
 * @fileName HomeFragment
 * @package com.bawei.wangyifei.frag
 **/
public class HomeFragment extends BaseFragment<HomePresenter> implements SearchView ,PicView,ShowView,FirstView,SecondView {

    private CustonView cust;
    private XBanner xbanner;
    private RecyclerView recy;
    private SimpleDraweeView simp;
    private PicPresenter picPresenter;

    private RecyclerView show1;
    private RecyclerView show2;
    private RecyclerView show3;

    private TextView title2;
    private TextView title3;
    private TextView title1;
    private FirstPresenter firstPresenter;
    private SecondPresenter secondPresenter;
    private RecyclerView puprecy2;


    //搜索
    @Override
    protected HomePresenter getPresenter() {
        presenter = new HomePresenter(this);

        return presenter;
    }

    @Override
    protected int layoutResID() {
        return R.layout.homefragment;
    }

    @Override
    protected void initView(View view) {
        //找控件
        cust = view.findViewById(R.id.cust);
        xbanner = view.findViewById(R.id.xbanner);
        recy = view.findViewById(R.id.recy);
        simp = view.findViewById(R.id.simp);

        show1 = view.findViewById(R.id.show1);
        show2 = view.findViewById(R.id.show2);
        show3 = view.findViewById(R.id.show3);

        title1 = view.findViewById(R.id.title1);
        title2 = view.findViewById(R.id.title2);
        title3 = view.findViewById(R.id.title3);

        //首页布局管理器
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false);
        show1.setLayoutManager(linearLayoutManager);

        LinearLayoutManager linearLayoutManager1 = new LinearLayoutManager(getContext());
        show2.setLayoutManager(linearLayoutManager1);

        GridLayoutManager gridLayoutManager1 = new GridLayoutManager(getContext(), 2);
        show3.setLayoutManager(gridLayoutManager1);


        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 2);
        recy.setLayoutManager(gridLayoutManager);


        //轮播图
        picPresenter = new PicPresenter(this);
        picPresenter.sendPic();

        //一级
        firstPresenter = new FirstPresenter(this);
        //二级
        secondPresenter = new SecondPresenter(this);
        //展示
        ShowPresenter showPresenter = new ShowPresenter(this);
        showPresenter.sendShow();
    }

    @Override
    protected void initData() {
        //点击搜索
        cust.setOnSearchListener(new CustonView.OnSearchListener() {
            @Override
            public void onSearch(String goods) {
                presenter.sendParameter(goods);
                xbanner.setVisibility(View.GONE);
                recy.setVisibility(View.VISIBLE);
            }

        });


        //分类
        cust.setOnMenuListener(new CustonView.OnMenuListener() {
            @Override
            public void onMenu() {
                firstPresenter.sendFirst();
            }
        });

    }

    ///搜索
    @Override
    public void onSearch(List<ResultBean> result) {

        if (result.size()==0){
            simp.setVisibility(View.VISIBLE);
        }
        else {
            simp.setVisibility(View.GONE);
        }
        MyAdapter myAdapter = new MyAdapter(getContext(), result);
        recy.setAdapter(myAdapter);
        myAdapter.setOnClickItemListener(new MyShowAdapter.OnClickItemListener() {
            @Override
            public void onClickItem(String commodityId) {
                Intent intent = new Intent(getActivity(), DetailsActivity.class);
                intent.putExtra("id",commodityId);
                startActivityForResult(intent,1);
            }
        });
    }


    //轮播
    @Override
    public void onPic(final List<ResultBean1> result) {

        xbanner.setData(result,null);
        xbanner.loadImage(new XBanner.XBannerAdapter() {
            @Override
            public void loadBanner(XBanner banner, Object model, View view, int position) {
                Glide.with(getActivity()).load(result.get(position).getImageUrl()).into((ImageView) view);
                banner.setPageChangeDuration(2000);
            }
        });
    }


    //展示
    @Override
    public void onShow(ShowResult result) {

        String name = result.getRxxp().getName();
        String name1 = result.getMlss().getName();
        String name2 = result.getPzsh().getName();
        title1.setText(name);
        title2.setText(name1);
        title3.setText(name2);

        MyShowAdapter myShowAdapter = new MyShowAdapter(getContext(), result);
        show1.setAdapter(myShowAdapter);
        myShowAdapter.setOnClickItemListener(new MyShowAdapter.OnClickItemListener() {
            @Override
            public void onClickItem(String commodityId) {
                Intent intent = new Intent(getActivity(), DetailsActivity.class);
                intent.putExtra("id",commodityId);
                startActivityForResult(intent,1);
            }
        });

        MyShowAdapter2 myShowAdapter2 = new MyShowAdapter2(getContext(), result);
        show2.setAdapter(myShowAdapter2);
        myShowAdapter2.setOnClickItemListener(new MyShowAdapter.OnClickItemListener() {
            @Override
            public void onClickItem(String commodityId) {
                Intent intent = new Intent(getActivity(), DetailsActivity.class);
                intent.putExtra("id",commodityId);
                startActivityForResult(intent,1);
            }
        });

        MyShowAdapter3 myShowAdapter3 = new MyShowAdapter3(getContext(), result);
        show3.setAdapter(myShowAdapter3);
        myShowAdapter3.setOnClickItemListener(new MyShowAdapter.OnClickItemListener() {
            @Override
            public void onClickItem(String commodityId) {
                Intent intent = new Intent(getActivity(), DetailsActivity.class);
                intent.putExtra("id",commodityId);
                startActivityForResult(intent,1);
            }
        });
    }

    @Override
    public void onFirst(List<First> result) {
        //找到pup的布局
        View view = View.inflate(getContext(),R.layout.pupwindows,null);
        RecyclerView puprecy = view.findViewById(R.id.puprecy);
        puprecy2 = view.findViewById(R.id.puprecy2);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        puprecy.setLayoutManager(linearLayoutManager);
        LinearLayoutManager linearLayoutManager1 = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        puprecy2.setLayoutManager(linearLayoutManager1);
        MyFirstAdapter myFirstAdapter = new MyFirstAdapter(getContext(), result);
        puprecy.setAdapter(myFirstAdapter);

        PopupWindow popupWindow = new PopupWindow(view, LinearLayout.LayoutParams.MATCH_PARENT, 150);
        //点击pop外部可消失
        popupWindow.setOutsideTouchable(true);



        //pop设置颜色
        popupWindow.setBackgroundDrawable(new ColorDrawable(Color.RED));

        //pop里面的控件点不了 因为没有焦点
        //给pop设置焦点
        popupWindow.setFocusable(true);

        ImageView tu = cust.findViewById(R.id.menu);
        popupWindow.showAsDropDown(tu);

        myFirstAdapter.setOnFirstListener(new MyFirstAdapter.OnFirstListener() {
            @Override
            public void onFirst(String id) {
                secondPresenter.sendSecond(id);
            }
        });


    }

    @Override
    public void onSecond(List<Second> result) {
        MySecondAdapter mySecondAdapter = new MySecondAdapter(getContext(), result);
        puprecy2.setAdapter(mySecondAdapter);
        mySecondAdapter.setOnSecondListener(new MySecondAdapter.OnSecondListener() {
            @Override
            public void onSecond(String id) {

                Intent intent = new Intent(getContext(), AssActivity.class);
                intent.putExtra("categoryId",id);
                Log.i("pppp",id);
                startActivity(intent);

            }
        });
    }
}
