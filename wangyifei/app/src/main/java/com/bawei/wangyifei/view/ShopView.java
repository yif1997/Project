package com.bawei.wangyifei.view;

import com.bawei.wangyifei.bean.Shop;

import java.util.List;

/**
 * @author 王艺霏
 * @fileName ShopView
 * @package com.bawei.wangyifei.view
 **/
public interface ShopView {
    void onShop(List<Shop> result,String status);
}
