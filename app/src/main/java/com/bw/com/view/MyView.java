package com.bw.com.view;

import com.bw.com.bean.MyBean;
import java.util.List;

/**
 * Created by ruixuyao on 2018/03/28.
 */

public interface MyView {
    ////绑定布局的方法
    int bindLayout();

    //设置监听的方法
    void bindEvent();

    //展示数据
    void showGoodsData(List<MyBean.ResultsBean> data);
    //报错信息的展示
    void showError(String error);
}
