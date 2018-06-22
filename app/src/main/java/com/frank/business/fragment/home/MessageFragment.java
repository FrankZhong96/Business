package com.frank.business.fragment.home;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.frank.business.R;
import com.frank.business.fragment.BaseFragment;

/**
 * Created by Frank on 2018/6/20.
 */

public class MessageFragment extends BaseFragment {

    private View mContentView;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mContext = getActivity();
        mContentView = inflater.inflate(R.layout.fragment_message_layout, container, false);
        return mContentView;
    }
}
