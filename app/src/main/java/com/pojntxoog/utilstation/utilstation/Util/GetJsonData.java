package com.pojntxoog.utilstation.utilstation.Util;

import android.os.AsyncTask;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by PojNtxoog007 on 2020-08-19.
 * 获取Json数据的工具
 * 功能：传入Json数据接口地址，返回String类型的Json格式数据。
 */
public class GetJsonData {

    /**
     * 获取数据
     * @param jsonUrl Json数据接口地址
     * @param listenner 接口回调参数
     */
    public static void getJson(String jsonUrl,GetJsonListener listenner){
        GetJsonAsynctask asynctask =new GetJsonAsynctask(jsonUrl,listenner);
        asynctask.execute();
    }

    public static class GetJsonAsynctask extends AsyncTask<String,Integer,Boolean> {

        String jsonUrl;
        GetJsonListener mListenner;
        String result;

        public GetJsonAsynctask(String jsonUrl,GetJsonListener listenner) {
            this.mListenner=listenner;
            this.jsonUrl=jsonUrl;
        }

        //异步任务的主体方法
        @Override
        protected Boolean doInBackground(String... strings) {

            try {
                URL url=new URL(jsonUrl);
                HttpURLConnection connect=(HttpURLConnection)url.openConnection();
                connect.setDoInput(true);
                connect.setDoOutput(true);
                connect.setRequestMethod("POST");
                connect.setUseCaches(false);
                connect.setRequestProperty("Content-Type", "application/json;charset=UTF-8");
                int response = connect.getResponseCode();
                if (response== HttpURLConnection.HTTP_OK){
                    InputStream input=connect.getInputStream();
                    BufferedReader in = new BufferedReader(new InputStreamReader(input));
                    String line = null;
                    StringBuffer sb = new StringBuffer();
                    while ((line = in.readLine()) != null) {
                        sb.append(line);
                    }
                    result=sb.toString();
                    return  true;
                }else {
                    System.out.println(response);
                    return false;
                }
            } catch (Exception e) {
                return false;
            }

        }

        //后的UI操作
        @Override
        protected void onPostExecute(Boolean aBoolean) {
            super.onPostExecute(aBoolean);
            if(aBoolean==true){
                mListenner.onSuccess(result);//获取成功，则返回结果
            }else {
                mListenner.onFail("获取失败");//获取失败
            }
        }

    }

    public interface GetJsonListener{

        void onFail(String message);

        void onSuccess(String jsonResult);

    }

}
