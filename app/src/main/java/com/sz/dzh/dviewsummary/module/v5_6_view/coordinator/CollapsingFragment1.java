package com.sz.dzh.dviewsummary.module.v5_6_view.coordinator;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.sz.dzh.dviewsummary.R;
import com.sz.dzh.dviewsummary.base.BaseFragment;
import com.sz.dzh.dviewsummary.fragment.SimpleFragment;

/**
 * Created by dengzh on 2020/5/3 0003.
 */
public class CollapsingFragment1 extends BaseFragment {

    public static CollapsingFragment1 newInstance() {
        return new CollapsingFragment1();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fr_collapsing1, container, false);
    }
}
