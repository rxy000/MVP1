package com.bw.com.presenter;



import android.util.Log;
import com.bw.com.bean.MyBean;
import com.bw.com.model.MyModel;
import com.bw.com.util.GsonObjectCallback;
import com.bw.com.view.MyView;
import java.io.IOException;
import java.lang.ref.WeakReference;
import okhttp3.Call;

/**
 * Created by ruixuyao on 2018/03/28.
 */

public class Mypresenter {
    private WeakReference<MyView> reference;
    private MyModel model;

    public Mypresenter(){
        model = new MyModel();
    }

    public void attachView(MyView view) {
        reference = new WeakReference<MyView>(view);
    }

    public void detachView(MyView view) {
        if (reference != null) {
            reference.clear();
            reference = null;
        }
    }
    public void getGoodsList(){

        model.getRightData("http://gank.io/api/data/%E7%A6%8F%E5%88%A9/10/1", new GsonObjectCallback<MyBean>() {
            @Override
            public void onUi(MyBean goodsBean) {
                Log.i("+++",goodsBean.toString());
                if (goodsBean != null && goodsBean.getResults() != null) {
                    reference.get().showGoodsData(goodsBean.getResults());
                }
            }

            @Override
            public void onFailed(Call call, IOException e) {

            }
        });
    }
}
