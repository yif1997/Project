package com.bawei.wangyifei.api;

import com.bawei.wangyifei.bean.ClassityBean;
import com.bawei.wangyifei.bean.DetailsBean;
import com.bawei.wangyifei.bean.FirstBean;
import com.bawei.wangyifei.bean.JsonBean;
import com.bawei.wangyifei.bean.LoginBean;
import com.bawei.wangyifei.bean.PicBean;
import com.bawei.wangyifei.bean.RegistBean;
import com.bawei.wangyifei.bean.ResultBean;
import com.bawei.wangyifei.bean.SecondBean;
import com.bawei.wangyifei.bean.ShowBean;

import java.util.Map;

import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

/**
 * @author 王艺霏
 * @fileName ApiService
 * @package com.bawei.wangyifei.api
 **/
public interface ApiService {
    @GET("findCommodityByKeyword")
    Flowable<JsonBean> getSearch(@Query("keyword") String keyword, @Query("page") int page, @Query("count") int count);

    @GET("bannerShow")
    Flowable<PicBean> getPic();

    //首页展示
    @GET("commodityList")
    Flowable<ShowBean> getShow();

    //详情
    @GET("findCommodityDetailsById")
   Flowable<DetailsBean> getDetails(@Query("commodityId") String commodityId);


    //登录
    //http://172.17.8.100/small/user/v1/login登录
    @POST("login")
    Flowable<LoginBean> getLogin(@QueryMap Map<String,String> login );



    //http://172.17.8.100/small/user/v1/register注册
    @POST("register")
    Flowable<RegistBean> getRegist(@Query("phone") String phone,@Query("pwd") String pwd);


    //http://172.17.8.100/small/commodity/v1/findFirstCategory一级
    @GET("findFirstCategory")
    Flowable<FirstBean> getFirst();


    //http://172.17.8.100/small/commodity/v1/findSecondCategory?=firstCategoryId"+id+"  二级
    @GET("findSecondCategory")
    Flowable<SecondBean> getSecond(@Query("firstCategoryId") String id);


    //http://172.17.8.100/small/commodity/v1/findCommodityByCategory?=categoryId"+id+"&page=1&count=10
    @GET("findCommodityByCategory")
    Flowable<ClassityBean> getClassity(@Query("categoryId") String id, @Query("page") int page, @Query("count") int count);

}
