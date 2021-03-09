package com.pojntxoog.utilstation.utilstation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import com.pojntxoog.utilstation.utilstation.Util.GetJsonData;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity{

    String jsonUrl ="http://182.92.219.12:8090/MvList/GetMvListHawMany?howMany=10";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GetJsonMethod();//获取Json数据

    }

    //获取Json数据(带有数据解析代码)
    private void GetJsonMethod() {
        Button GET_Json=(Button)findViewById(R.id.GET_Json);
        GET_Json.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //获取方法
                GetJsonData.getJson(jsonUrl, new GetJsonData.GetJsonListener() {
                    //获取失败
                    @Override
                    public void onFail(String message) {
                        Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
                    }

                    //获取成功
                    @Override
                    public void onSuccess(String jsonResult) {

                        Toast.makeText(MainActivity.this, jsonResult, Toast.LENGTH_SHORT).show();

                        // TODO: 2021/3/9 获取成功：在这里做数据解析工作

                        //解析方法
                        String result = "{\"AbosUser\":"+jsonResult+"}";
                        try {
                            JSONObject result_json=new JSONObject(result);
                            JSONArray indexMapList=result_json.getJSONArray("AbosUser");
                            for (int i = 1; i < 2; i++) {
                                JSONObject indexMapObject = indexMapList.getJSONObject(i);
                                /*nhmmMvListEntity nml =new nhmmMvListEntity();
                                nml.setUser(indexMapObject2.getString("user"));
                                nml.setListName(indexMapObject2.getString("listName"));
                                nml.setIntroduce(indexMapObject2.getString("introduce"));
                                nml.setPicture(indexMapObject2.getString("picture"));
                                nml.setMoney(indexMapObject2.getInt("money"));
                                nml.setTag(indexMapObject2.getString("tag"));
                                nml.setTime(indexMapObject2.getString("time"));
                                mvList.add(nml);*/
                            }
                        } catch (JSONException e) {
                            //文件解析错误
                        }

                    }
                });


            }
        });
    }


}
