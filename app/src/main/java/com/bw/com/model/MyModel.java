package com.bw.com.model;

import android.os.Handler;

import com.bw.com.bean.MyBean;
import com.bw.com.util.GsonObjectCallback;
import com.bw.com.util.OkhttpUtil;

/**
 * Created by ruixuyao on 2018/03/28.
 */

public class MyModel {
    public void getRightData(String url, GsonObjectCallback<MyBean> callback) {
        OkhttpUtil.getInstance().doGet(url,callback);
    }
}
