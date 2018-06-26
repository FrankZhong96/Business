package com.frank.mybase.net;

import java.util.WeakHashMap;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Part;
import retrofit2.http.QueryMap;
import retrofit2.http.Streaming;
import retrofit2.http.Url;

/**
 * Created by 傅令杰 on 2017/4/2
 */
public interface RestService {

    /**
     * GET请求
     * @param url 请求的地址
     * @param params 请求的参数
     * @return 返回String类型的结果
     */
    @GET
    Call<String> get(@Url String url, @QueryMap WeakHashMap<String, Object> params);

    /**
     * POST请求
     * @param url 请求的地址
     * @param params 请求的参数
     * @return 返回String类型的结果
     */
    @FormUrlEncoded
    @POST
    Call<String> post(@Url String url, @FieldMap WeakHashMap<String, Object> params);

    @POST
    Call<String> postRaw(@Url String url, @Body RequestBody body);

    @FormUrlEncoded
    @PUT
    Call<String> put(@Url String url, @FieldMap WeakHashMap<String, Object> params);

    @PUT
    Call<String> putRaw(@Url String url, @Body RequestBody body);

    @DELETE
    Call<String> delete(@Url String url, @QueryMap WeakHashMap<String, Object> params);

    /**
     * 下载
     * @param url 请求的地址
     * @param params 请求的参数
     * @return 返回ResponseBody(请求体)
     */
    @Streaming//retrofit的下载是先把文件下载到内存，然后写入文件里
    @GET //避免一次性将所有的文件下载下来，导致内存的溢出；但是在写的时候，仍然需要将文件放在单独的线程，否则在主线程操作任然会报错。
    Call<ResponseBody> download(@Url String url, @QueryMap WeakHashMap<String, Object> params);

    /**
     * 上传
     * @param url 请求的地址
     * @param file 上传的文件
     * @return 返回String类型的结果
     */
    @Multipart
    @POST
    Call<String> upload(@Url String url, @Part MultipartBody.Part file);
}
