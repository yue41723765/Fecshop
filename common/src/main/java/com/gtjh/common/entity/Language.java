package com.gtjh.common.entity;

import com.google.gson.annotations.SerializedName;

import java.util.HashMap;
import java.util.List;

/**
 * Created by android on 2018/7/3.
 */

public class Language {
    private List<LanguageClassfly> langList;
    private HashMap<String,languageInfo> langListAll;
    private String currentLang;
    public List<LanguageClassfly>  getLangList() {
        return langList;
    }

    public HashMap<String,languageInfo> getLangListAll() {
        return langListAll;
    }

    class LanguageClassfly {
        public String code;
        public String language;
        public String languageName;
    }

    public class languageInfo {
        @SerializedName("Enter your email adress")
        public String emailAddress;  //输入您的邮箱
        @SerializedName("Home")
        public String home;  //首页
        @SerializedName("Shopping Cart")
        public String shopCar;        //购物车
        @SerializedName("Contact Us")
        public String contactUs;   //联系我们
        @SerializedName("Return Policy")
        public String returnPolicy;     //退款条约
        @SerializedName("Privacy Policy")
        public String privacyPolicy;  //隐私条约
        @SerializedName("About Us")
        public String aboutUs;  //关于我们
        @SerializedName("My Favorite")
        public String myFavorite;  //我的收藏
        @SerializedName("My Reviews")
        public String myReviews;  //我的评论
        @SerializedName("My Order")
        public String myOrder;  //我的订单
        @SerializedName("My Account")
        public String myAccount;  //我的账户
        @SerializedName("Site Map")
        public String siteMap;  //网站地图
        @SerializedName("Captcha can not empty")
        public String captchaCanNotEmpty;  //验证码不能为空
        @SerializedName("Language")
        public String Language;  //语言
        @SerializedName("Currency")
        public String currency;  //货币
        @SerializedName("Welcome!")
        public String welcome;  //欢迎您！
        @SerializedName("Logout")
        public String logout;  //退出
        @SerializedName("Sign In / Join Free")
        public String loginJoin;  //登录账户
        @SerializedName("My Orders")
        public String myOrders;  //我的订单
        @SerializedName("My Favorites")
        public String myFavorites;  //我的收藏
        @SerializedName("My Review")
        public String myReview;  //我的评论
        @SerializedName("Products keyword")
        public String productsKeyword;  //搜索产品
        @SerializedName("custom menu")
        public String customMenu;  //自定义菜单
        @SerializedName("my custom menu 2")
        public String myCustomMenu2;  //自定义菜单2
        @SerializedName("my custom menu 3")
        public String myCustomMenu3;  //自定义菜单3
        @SerializedName("best seller")
        public String bestSeller;  //热销产品
        @SerializedName("featured products")
        public String featuredProducts;  //特色产品
        @SerializedName("more")
        public String more;  //更多
        @SerializedName("Sort By")
        public String sortBy;  //排序
        @SerializedName("Sort")
        public String sort;  //排序
        @SerializedName("Filter")
        public String filter;  //过滤
        @SerializedName("Hot")
        public String hot;  //销量
        @SerializedName("Review")
        public String review;  //评论
        @SerializedName("Favorite")
        public String favorite;  //收藏
        @SerializedName("New")
        public String New;  //上架时间
        @SerializedName("$ Low to High")
        public String LowToHigh;  //￥ 价格由低到高
        @SerializedName("$ High to Low")
        public String HighToLow;  //￥  价格由高到低
        @SerializedName("Refine By")
        public String refineBy;  //过滤选项
        @SerializedName("clear all")
        public String clearAll;  //清空所有过滤
        @SerializedName("style")
        public String style;  //风格
        @SerializedName("dresses-length")
        public String dresses_length;  //裙长
        @SerializedName("Sexy & Club")
        public String SexyAndClub;  //性感＆俱乐部
        @SerializedName("Login or Create an Account")
        public String LoginOrCreateAnAccount;  //登录 创建用户
        @SerializedName("New Customers")
        public String newUser;  //新用户
        @SerializedName("By creating an account with our store, you will be able to move through the checkout process faster, store multiple shipping addresses, view and track your orders in your account and more.")
        public String  hiht;  //在我们的店铺里面注册账户，您可以快速的下单，保存您的货运地址，查看或追踪您的订单信息，等等
        @SerializedName("Register")
        public String register;  //注册
        @SerializedName("Login")
        public String login;  //登录
        @SerializedName("E-mail")
        public String Email;  //邮箱地址
        @SerializedName("Registered Customers")
        public String registeredCustomers;  //已注册用户
        @SerializedName("If you have an account with us, please log in.")
        public String isYouLogin;  //如果您已经注册了一个用户，请直接登录
        @SerializedName("Email Address")
        public String EmailAddress;  //邮箱地址
        @SerializedName("Password")
        public String password;  //密码
        @SerializedName("Captcha")
        public String captcha;  //验证码
        @SerializedName("click refresh")
        public String clickRefresh;  //点击刷新
        @SerializedName("Sign In")
        public String signIn;  //登录
        @SerializedName("Forgot Your Password?")
        public String forgotPassword;  //忘记密码？

        @SerializedName("user password is not correct")
        public String userPasswordIsNotCorrect;  //用户的账号密码不正确
        @SerializedName("ERROR,Your email address has subscribe , Please do not repeat the subscription")
        public String subscription;  //您的电子邮件地址已订阅，请不要重复订阅
        @SerializedName("newsletter email address is empty")
        public String emailAddressIsEmpty;  //邮件订阅邮箱地址为空
        @SerializedName("The email address format is incorrect!")
        public String incorrect;  //电子邮件地址格式不正确！
         @SerializedName("Your subscribed email was successful, You can {urlB} click Here to Home Page {urlE}, Thank You.")
        public String successful;  //您的订阅电子邮件已成功，您可以{urlB}点击此处访问主页{urlE}，谢谢。

        @SerializedName("Create an Account")
        public String reateAccount;  //创建新账户
        @SerializedName("Personal Information")
        public String personal;  //个人账户信息

        @SerializedName("First Name")
        public String FirstName;  //名
        @SerializedName("Last Name")
        public String lastName;  //姓

        @SerializedName("Sign Up for Newsletter")
        public String Newsletter;  //订阅邮件

        @SerializedName("Login Information")
        public String Information;  //登录信息

        @SerializedName("Confirm Password")
        public String Password;  //确认密码

        @SerializedName("Submit")
        public String submit;  //提交


        @SerializedName("Back")
        public String back;  //返回

        @SerializedName("This is a required field.")
        public String field;  //这是一个必填选项

        @SerializedName("Please enter a valid email address. For example johndoe@domain.com.")
        public String  validEmailAddress;  //请填写一个正确的邮箱，譬如：johndoe@domain.com。


        @SerializedName("first name length must between")
        public String first_name_length_must_between;  //名字的长度范围：
        @SerializedName("last name length must between")
        public String last_name_length_must_between;  //姓的长度范围：

        @SerializedName("Please enter 6 or more characters. Leading or trailing spaces will be ignored.")
        public String Please;  //请输入6个或更多字符。 前导或尾随空格将被忽略。

        @SerializedName("Please make sure your passwords match.")
        public String match;  //请确保您的密码和确认密码一致。

        @SerializedName("Captcha is not right.")
        public String Captcha;  //验证码不正确

        @SerializedName("Email is not a valid email address.")
        public String  not_alid_email_address;  //您输入的邮箱格式格式不正确

        @SerializedName("My Dashboard")
        public String MyDashboard;  //我的信息中心

        public String commodityCategories; //商品类别
        public String my; //我的
    }
}
