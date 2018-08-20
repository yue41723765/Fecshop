package com.gtjh.user.model;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Handler;

/**
 * Created by android on 2018/7/5.
 */

public interface IUserModel {
    void  login(HashMap<String,Object> param, int tag);
    void  register(HashMap<String,Object> param,int tag);
    void  updatePwd(HashMap<String,Object> param,int tag);
    //编辑用户信息
    void editAccountInfo(int tag);
    //用户信息提交
    void submitAccountInfo(HashMap<String,Object> param,int tag);
    //货运地址-列表
    void addressList(int tag);
    //货运地址-初始化
    void addressInitialize(HashMap<String,Object> param,int tag);
    //货运地址-保存
    void addressSubmit(HashMap<String,Object> param,int tag);
    //货运地址-切换国家
    void addressCounty(HashMap<String,Object> param,int tag);
    //货运地址-删除地址
    void deleteAddress(HashMap<String,Object> param,int tag);
    //我的订单 -列表
    void orderList(HashMap<String,Object> param,int tag);
    //我的订单 -详情
    void orderDetails(HashMap<String,Object> param,int tag);
    //我的订单-重新下单
    void orderAgain(HashMap<String,Object> param,int tag);
    //评价 -初始化
    void evaluationInitialize(HashMap<String,Object> param,int tag);
    //评价 -提交
    void evaluationSubmit(HashMap<String ,Object> param,int tag);
    //收藏商品 -列表
    void collectList(HashMap<String,Object> param,int tag);
    //收藏商品 -刪除
    void deleteCollect(HashMap<String,Object> param,int tag);
    //忘记密码 -初始化
    void forgetInit(int tag);
    //忘记密码 -发送验证码
    void forgetSendCode(HashMap<String,Object> param,int tag);
    //忘记密码 -提交 -初始化 token验证
    void forgetTokenInit(HashMap<String,Object> param,int tag);
    //忘记密码 -提交
    void forgetPw(HashMap<String,Object> param,int tag);
    //首页 -获取语言
    void languageM(int tag);
}
