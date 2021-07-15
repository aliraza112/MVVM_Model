package com.ambitsolutions.mvvm.retrofit;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public interface WebApi {
    //https://pakpoultryhub.com/adminlte/restapi/Dboyorders/GetOrders
    String BASE_URL = "https://pakpoultryhub.com/DMS/restapi/"; // Base url part,
    // Base Url + Relative Url make complete api to get data
    String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ0aW1lU3RhbXAiOiIyMDIxLTAzLTE2IDA3OjIzOjA0In0.bFL-GrJD-u_Y5qv3GuRKCE8nwxj-m1m47Ga98pPfVBM";
    String login = "JwtToken/LoginToken/JwtToken.php";
    String get_products = "Product/GetProductData/";
    String get_categories = "Category/GetCategoryData";
    String get_brands = "Brand/GetBrandData";
    String place_order = "Order/PlaceOrder";
    String update_user = "Profile/UpdateProfile";
    String insert_shop = "Shop/InsertShop";
    String account_details = "Accounts/GetAccounts";
    String account_transaction = "Accounts/GetTransections";
    String get_shop = "Shop/GetShopData/";
    String receive_order = "Order/UpdateStatus";
    //    SELECT MAX(prodid) As id
    //  FROM synccounter
    String get_order_report = "Ordersreport/Getreports";
    String get_user_orders = "Order/GetOrders";
    String get_salesman_orders = "Order/GetSalemanOrders";

    //    String get_shops = "/Shop/GetShopData"; for shopkeeper by uid

    String get_shops = "Shop/FetchAllShopData";
    String get_all_users = "Users/GetAllUsers";
    String update_order = "Order/editOrder";
    String delete_product = "Order/deleteOrderProduct";

    //deliveryman apis
    String get_order = "Dboyorders/GetOrders";
    String get_order_details = "Dboyorders/GetOrderData";
    String deliver_order = "Dboyorders/UpdateStatus";

    String receive_cash = "Dboyorders/cashrecived";
    String sync_delivered_orders = "Dboyorders/syncorders";
    String getGet_shops = "Dboyorders/GetAllShops/";
    String getGet_shopkeeper = "Dboyorders/GetAllUsers/";
    String get_paymentmethod = "Paymentmethod/Getmethods";
    String get_outstanding = "Dboyorders/getOutstanding/";
    String search_outstanding = "Dboyorders/SearchOutstanding";
    String update_outstanding = "Dboyorders/OutstandingPayment/";

    // Sync counter
    String sync_counter = "Synccounter/GetsyncData";
    String delete_order = "Order/deleteOrder";



    //to get specific data from json
//    @GET(USER_LOGIN)
//    Call<user_login> userLogin(@QueryMap HashMap<String, String> user);

//    @FormUrlEncoded
//    @POST(login)
//    Call<user> userlogin(@FieldMap Map<String, String> fields);
//
//    @FormUrlEncoded
//    @POST(get_products)
//    Call<List<products>> get_products(@Field("pageno") int pageno);
//
//    @FormUrlEncoded
//    @POST(get_categories)
//    Call<List<categories>> get_categories(@Field("date") String date);
//
//    @FormUrlEncoded
//    @POST(get_brands)
//    Call<List<brand>> get_brands(@Field("date") String date);
//
//    @FormUrlEncoded
//    @POST(get_shops)
//    Call<List<shopdetails>> get_shops(@Field("date") String date);
//
//    @GET(getGet_shops)
//    Call<List<shopdetails>> dboy_get_shops();
//
//    @GET(get_all_users)
//    Call<List<user>> get_shopkeeper();
//
//    @FormUrlEncoded
//    @POST(getGet_shopkeeper)
//    Call<List<user>> dboy_get_shopkeeper(@Field("date") String date);
//
//    @FormUrlEncoded
//    @POST(get_outstanding)
//    Call<List<dboy_orders>> get_outstanding(@Field("pageno") Integer pageno);
//
//    @FormUrlEncoded
//    @POST(search_outstanding)
//    Call<List<dboy_orders>> search_outstanding(@Field("name") String name);
//
//    @Multipart
//    @POST(update_outstanding)
//    Call<deliver_order> update_outstanding(@Part("recievedby") RequestBody recievedby,
//                                           @Part("userid") RequestBody userid,
//                                           @Part("paidbill") RequestBody paidbill,
//                                           @Part("paymentid") RequestBody paymentid,
//                                           @Part("referenceno") RequestBody referenceno,
//                                           @Part("paymentnote") RequestBody paymentnote,
//                                           @Part MultipartBody.Part signature);
//
//    @FormUrlEncoded
//    @POST(sync_counter)
//    Call<synccounter> get_sync_count(@Field("userid") Integer userid);
//
//    @FormUrlEncoded
//    @POST(get_order)
//    Call<List<dboy_orders>> get_orders(@Field("deliveredby") String userid);
//
//    @FormUrlEncoded
//    @POST(get_order_details)
//    Call<List<dboy_orderdetails>> get_orders_details(@Field("orderid[]") List<Integer> orderid);
//
//    @FormUrlEncoded
//    @POST(get_order_details)
//    Call<List<dboy_orderdetails>> get_dboy_orders_details(@Field("orderid[]") List<Integer> orderid
//            , @Field("userid") int userid);
//
//    @FormUrlEncoded
//    @POST(get_order_details)
//    Call<List<ordersdetails>> get_edit_order(@Field("orderid[]") List<Integer> orderid);
//
//    @FormUrlEncoded
//    @POST(account_details)
//    Call<List<account>> get_account_details(@Field("userid") int userid,
//                                            @Field("startdate") String startdate,
//                                            @Field("enddate") String enddate
//    );
//
//
//    @FormUrlEncoded
//    @POST(account_transaction)
//    Call<List<account>> get_account_transaction(@Field("orderid") int userid
//    );
//
//    @Multipart
//    @POST(update_user)
//    Call<user> update_user(@Part("userid") RequestBody userid, @Part("username") RequestBody username,
//                           @Part("useraddress") RequestBody useraddress,
//                           @Part MultipartBody.Part image);
//
//    @Multipart
//    @POST(receive_cash)
//    Call<deliver_order> recive_cash(@Part("orderid") RequestBody orderid,
//                                    @Part("deliveredby") RequestBody deliveredby,
//                                    @Part("paidbill") RequestBody paidbill,
//                                    @Part("paymentid") RequestBody paymentid,
//                                    @Part("referenceno") RequestBody referenceno,
//                                    @Part("paymentnote") RequestBody paymentnote,
//                                    @Part MultipartBody.Part signature);
//
//    @Multipart
//    @POST(sync_delivered_orders)
//    Call<deliver_order> sync_delivered_orders(@Part("orderid") RequestBody orderid,
//                                              @Part("userid") RequestBody userid,
//                                              @Part("deliveredby") RequestBody deliveredby,
//                                              @Part("statusid") RequestBody statusid,
//                                              @Part("paidbill") RequestBody paidbill,
//                                              @Part("paymentid") RequestBody paymentid,
//                                              @Part("referenceno") RequestBody referenceno,
//                                              @Part("paymentnote") RequestBody paymentnote,
//                                              @Part MultipartBody.Part signature);
//
//    @Multipart
//    @POST(insert_shop)
//    Call<user_shopdetails> insert_shop(@Part("username") RequestBody uname,
//                                       @Part("userphone") RequestBody uphone,
//                                       @Part("useraddress") RequestBody useraddress,
//                                       @Part("shopname") RequestBody ushopname,
//                                       @Part("shopphone") RequestBody shopphone,
//                                       @Part("userpassword") RequestBody userpassword,
//                                       @Part("lat") RequestBody lat,
//                                       @Part("lng") RequestBody lng,
//                                       @Part MultipartBody.Part image);
//
//    @FormUrlEncoded
//    @POST(place_order)
//    Call<order_orderdetails_model> place_order(@Field("userid") int userid,
//                                               @Field("salesmanid") int salesmanid,
//                                               @Field("subtotal") String totalbill,
//                                               @Field("prodid[]") ArrayList<Integer> prodid,
//                                               @Field("prodqty[]") ArrayList<Integer> prodqty,
//                                               @Field("prodprice[]") ArrayList<Integer> prodprice
//    );//totlbitt -> subtotal
//
//    @FormUrlEncoded
//    @POST(update_order)
//    Call<order_orderdetails_model> update_order(@Field("userid") int userid,
//                                                @Field("orderid") int orderid,
////                                                @Field("salesmanid") int salesmanid,
//                                                @Field("totalbill") String totalbill,
//                                                @Field("prodid[]") ArrayList<Integer> prodid,
//                                                @Field("prodqty[]") ArrayList<Integer> prodqty,
//                                                @Field("prodprice[]") ArrayList<Integer> prodprice
//    );
//
//    @FormUrlEncoded
//    @POST(delete_product)
//    Call<order_orderdetails_model> delete_order_product(
//            @Field("orderid") Integer orderid,
//            @Field("prodid") Integer prodid
//    );
//
//    @FormUrlEncoded
//    @POST(deliver_order)
//    Call<deliver_order> deliver_order(@Field("orderid") int orderid,
//                                      @Field("statusid") int statusid,
//                                      @Field("deliveredby") int deliveredby,
//                                      @Field("userid") int userid);
//
//    @FormUrlEncoded
//    @POST(receive_order)
//    Call<deliver_order> receive_order(@Field("orderid") int orderid,
//                                      @Field("statusid") int statusid,
//                                      @Field("userid") int userid);
//
//    @FormUrlEncoded
//    @POST(delete_order)
//    Call<orders> delete_order(@Field("orderid") int orderid,
//                              @Field("userid") int userid
//    );
//
//    @FormUrlEncoded
//    @POST(get_shop)
//    Call<shopdetails> get_shop(@Field("userid") int userid);
//
//    @FormUrlEncoded
//    @POST(get_order_report)
//    Call<List<prod_reports>> get_prod_reports(@Field("userid") int userid,
//                                              @Field("startdate") String startdate,
//                                              @Field("enddate") String enddate);
//
//    @FormUrlEncoded
//    @POST(get_user_orders)
//    Call<List<orders>> user_orders(@FieldMap Map<String, Integer> fields);
//
//    @FormUrlEncoded
//    @POST(get_salesman_orders)
//    Call<List<orders>> salesman_orders(@FieldMap Map<String, Integer> fields);
//
//    @GET(get_paymentmethod)
//    Call<List<paymentmethod>> get_methods();

}


