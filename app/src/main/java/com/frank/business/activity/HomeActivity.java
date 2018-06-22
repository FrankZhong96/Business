package com.frank.business.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.frank.business.R;
import com.frank.business.activity.base.BaseActivity;
import com.frank.business.fragment.home.HomeFragment;
import com.frank.business.fragment.home.MessageFragment;
import com.frank.business.fragment.home.MineFragment;

public class HomeActivity extends BaseActivity implements View.OnClickListener {

    private TextView mHomeView, mMessageView, mMineView, mPondView;
    private RelativeLayout mHomeLayout, mMessageLayout, mMineLayout, mPondLayout;
    private HomeFragment mHomeFragment;
    private Fragment mCommonFragmentOne;
    private MessageFragment mMessageFragment;
    private MineFragment mMineFragment;
    private FragmentManager mFragmentManager;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_layout);
        initView();

        //添加默认显示的Fragment
        mHomeFragment = new HomeFragment();
        mFragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.content_layout, mHomeFragment);
        fragmentTransaction.commit();
        mHomeView.setBackgroundResource(R.drawable.comui_tab_home_selected);

    }

    private void initView() {

        mHomeLayout = findViewById(R.id.home_layout_view);
        mMessageLayout = findViewById(R.id.message_layout_view);
        mMineLayout = findViewById(R.id.mine_layout_view);
        mPondLayout = findViewById(R.id.pond_layout_view);
        mHomeLayout.setOnClickListener(this);
        mMessageLayout.setOnClickListener(this);
        mMineLayout.setOnClickListener(this);
        mPondLayout.setOnClickListener(this);

        mHomeView = findViewById(R.id.home_image_view);
        mMessageView = findViewById(R.id.message_image_view);
        mMineView = findViewById(R.id.mine_image_view);
        mPondView = findViewById(R.id.fish_image_view);
    }

    /**
     * 隐藏fragment
     *
     * @param fragment
     * @param ft
     */
    private void hideFragment(Fragment fragment, FragmentTransaction ft) {
        if (fragment != null) {
            ft.hide(fragment);
        }
    }

    @Override
    public void onClick(View v) {
        FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();
        switch (v.getId()) {
            case R.id.home_layout_view:
                Log.e(TAG, "首页");
                mHomeView.setBackgroundResource(R.drawable.comui_tab_home_selected);
                mMessageView.setBackgroundResource(R.drawable.comui_tab_message);
                mPondView.setBackgroundResource(R.drawable.comui_tab_pond);
                mMineView.setBackgroundResource(R.drawable.comui_tab_person);
                //隐藏其他fragment
                hideFragment(mMessageFragment, fragmentTransaction);
                hideFragment(mMineFragment, fragmentTransaction);
                if (mHomeFragment == null) {
                    mHomeFragment = new HomeFragment();
                    fragmentTransaction.add(R.id.content_layout, mHomeFragment);
                } else {
                    //显示fragment
                    fragmentTransaction.show(mHomeFragment);
                }
                break;
            case R.id.message_layout_view:
                Log.e(TAG, "消息");
                mHomeView.setBackgroundResource(R.drawable.comui_tab_home);
                mMessageView.setBackgroundResource(R.drawable.comui_tab_message_selected);
                mPondView.setBackgroundResource(R.drawable.comui_tab_pond);
                mMineView.setBackgroundResource(R.drawable.comui_tab_person);
                //隐藏其他fragment
                hideFragment(mHomeFragment, fragmentTransaction);
                hideFragment(mMineFragment, fragmentTransaction);
                if (mMessageFragment == null) {
                    mMessageFragment = new MessageFragment();
                    fragmentTransaction.add(R.id.content_layout, mMessageFragment);
                } else {
                    //显示fragment
                    fragmentTransaction.show(mMessageFragment);
                }
                break;
            case R.id.mine_layout_view:
                Log.e(TAG, "我的");
                mHomeView.setBackgroundResource(R.drawable.comui_tab_home);
                mMessageView.setBackgroundResource(R.drawable.comui_tab_message);
                mPondView.setBackgroundResource(R.drawable.comui_tab_pond);
                mMineView.setBackgroundResource(R.drawable.comui_tab_person_selected);
                //隐藏其他fragment
                hideFragment(mHomeFragment, fragmentTransaction);
                hideFragment(mMessageFragment, fragmentTransaction);
                if (mMineFragment == null) {
                    mMineFragment = new MineFragment();
                    fragmentTransaction.add(R.id.content_layout, mMineFragment);
                } else {
                    //显示fragment
                    fragmentTransaction.show(mMineFragment);
                }
                break;
        }
        //提交事务
        fragmentTransaction.commit();
    }
}
