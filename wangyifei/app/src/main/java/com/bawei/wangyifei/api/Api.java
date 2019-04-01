package com.bawei.wangyifei.api;

/**
 * @author 王艺霏
 * @fileName Api
 * @package com.bawei.wangyifei.api
 **/
public class Api {
    //http://172.17.8.100/small/commodity/v1/findCommodityByKeyword?=keyword"+goods+"&page=1&count=10
    public static final String searchUrl = "http://172.17.8.100/small/commodity/v1/";

    //http://172.17.8.100/small/commodity/v1/bannerShow
    public static final String picUrl = "http://172.17.8.100/small/commodity/v1/";


    //http://172.17.8.100/small/commodity/v1/commodityList商品展示
    public static final String showUrl = "http://172.17.8.100/small/commodity/v1/";


    //http://172.17.8.100/small/commodity/v1/findCommodityDetailsById?=commodityId"+commodityId+"详情
    public static final String detailsUrl = "http://172.17.8.100/small/commodity/v1/";


    //http://172.17.8.100/small/user/v1/login登录
    public static final String loginUrl = "http://172.17.8.100/small/user/v1/";

    //http://172.17.8.100/small/user/v1/register注册
    public static final String registUrl = "http://172.17.8.100/small/user/v1/";


    //http://172.17.8.100/small/commodity/v1/findFirstCategory一级
    public static final String firstUrl = "http://172.17.8.100/small/commodity/v1/";



    //http://172.17.8.100/small/commodity/v1/findSecondCategory?=firstCategoryId"+id+"  二级
    public static final String secondUrl = "http://172.17.8.100/small/commodity/v1/";

    //http://172.17.8.100/small/commodity/v1/findCommodityByCategory?=categoryId"+id+"&page=1&count=10
    public static final String classUrl = "http://172.17.8.100/small/commodity/v1/";

    //http://172.17.8.100/small/order/verify/v1/findShoppingCart查询购物称
    public static final String shopUrl = "http://172.17.8.100/small/order/verify/v1/";


    //http://172.17.8.100/small/order/verify/v1/syncShoppingCart同步购物车
    public static final String addShopUrl = "http://172.17.8.100/small/order/verify/v1/";


    //http://172.17.8.100/small/user/verify/v1/addReceiveAddress
    public static final String addressUrl = "http://172.17.8.100/small/user/verify/v1/";


    //http://172.17.8.100/small/user/verify/v1/receiveAddressList
    public static final String myaddressUrl = "http://172.17.8.100/small/user/verify/v1/";


    //http://172.17.8.100/small/user/verify/v1/setDefaultReceiveAddress默认地址
    public static final String defaultUrl = "http://172.17.8.100/small/user/verify/v1/";
}
