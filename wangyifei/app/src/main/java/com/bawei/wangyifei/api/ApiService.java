package com.bawei.wangyifei.api;

import com.bawei.wangyifei.bean.AddAddressBean;
import com.bawei.wangyifei.bean.AddShopBean;
import com.bawei.wangyifei.bean.ClassityBean;
import com.bawei.wangyifei.bean.DefaultBean;
import com.bawei.wangyifei.bean.DetailsBean;
import com.bawei.wangyifei.bean.FirstBean;
import com.bawei.wangyifei.bean.JsonBean;
import com.bawei.wangyifei.bean.LoginBean;
import com.bawei.wangyifei.bean.MyAddressBean;
import com.bawei.wangyifei.bean.PicBean;
import com.bawei.wangyifei.bean.RegistBean;
import com.bawei.wangyifei.bean.ResultBean;
import com.bawei.wangyifei.bean.SecondBean;
import com.bawei.wangyifei.bean.ShopBean;
import com.bawei.wangyifei.bean.ShowBean;

import java.util.Map;

import io.reactivex.Flowable;
import okhttp3.RequestBody;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.HeaderMap;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Part;
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
    Flowable<ClassityBean> getClassity( @Query("categoryId") String id, @Query("page") int page, @Query("count") int count);


    //http://172.17.8.100/small/order/verify/v1/findShoppingCart查询购物称
    @GET("findShoppingCart")
    Flowable<ShopBean> getShop(@Header("userId") String userId,@Header("sessionId") String sessionId);

    //http://172.17.8.100/small/order/verify/v1/syncShoppingCart同步购物车
    @Multipart
    @PUT("syncShoppingCart")
    Flowable<AddShopBean> getaddShop(@Part("data")RequestBody jsonObject, @Header("userId")String userId, @Header("sessionId")String sessionId);



    //http://172.17.8.100/small/user/verify/v1/addReceiveAddress新增收货地址
    @POST("addReceiveAddress")
    Flowable<AddAddressBean> getAddress(@Header("userId")String userId, @Header("sessionId")String sessionId,@Query("realName")String user1,@Query("phone")String phone1,@Query("address")String s,@Query("zipCode")String mail1);



    //http://172.17.8.100/small/user/verify/v1/receiveAddressList展示收货地址
    @GET("receiveAddressList")
    Flowable<MyAddressBean> getMyAddress(@Header("userId")String userId, @Header("sessionId")String sessionID);


    //http://172.17.8.100/small/user/verify/v1/setDefaultReceiveAddress默认地址
    @POST("setDefaultReceiveAddress")
    Flowable<DefaultBean> getDefault(@Header("userId")String userId, @Header("sessionId")String sessionId,@Query("id")String id);
}
