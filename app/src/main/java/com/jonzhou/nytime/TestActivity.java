package com.jonzhou.nytime;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.stx.xhb.xbanner.XBanner;

import java.util.ArrayList;
import java.util.List;

public class TestActivity extends AppCompatActivity {

    private ImageView ivImg;
    private XBanner mBannerNet;
    private ArrayList<String> imgesUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        ivImg = (ImageView) findViewById(R.id.iv_img);
        mBannerNet = (XBanner) findViewById(R.id.xbanner);
    }

    @Override
    protected void onStart() {
        super.onStart();
        String imgUrl = "http://107.173.10.164:8080/VideoServer/img/fd1.jpg";
        Glide.with(this).load(imgUrl).into(ivImg);


        imgesUrl = new ArrayList<>();
        imgesUrl.add("http://img3.fengniao.com/forum/attachpics/913/114/36502745.jpg");
        imgesUrl.add("http://imageprocess.yitos.net/images/public/20160910/99381473502384338.jpg");
        imgesUrl.add("http://imageprocess.yitos.net/images/public/20160910/77991473496077677.jpg");
        imgesUrl.add("http://imageprocess.yitos.net/images/public/20160906/1291473163104906.jpg");
        //添加广告数据
        mBannerNet.setData(imgesUrl, null);//第二个参数为提示文字资源集合

        mBannerNet.setmAdapter(new XBanner.XBannerAdapter() {
            @Override
            public void loadBanner(XBanner banner, Object model, View view, int position) {
                Glide.with(TestActivity.this).load(imgesUrl.get(position)).into((ImageView) view);
            }
        });

    }

}
