package com.cz1.rebase_android.ui.base;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.animation.DecelerateInterpolator;

import com.cz1.rebase_android.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by cz1 on 2017/2/7.
 */

public abstract class ToolbarActivity extends BaseActivity {

    @BindView(R.id.toolbar)
    Toolbar mToolbar;

    @BindView(R.id.appbar)
    AppBarLayout mAppBarLayout;

    protected abstract int layoutResId();

    protected boolean isHidden = false;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layoutResId());
        ButterKnife.bind(this);

        if (mAppBarLayout == null || mToolbar == null) {
            throw new IllegalStateException(
                    "The subclass of ToolbarActivity must contain a toolbar"
            );
        }
        mToolbar.setOnClickListener(v -> onBackPressed());
        setSupportActionBar(mToolbar);

        if (canBack()) {
            ActionBar actionBar = getSupportActionBar();
            if (actionBar != null) {
                // 显示返回按钮
                actionBar.setDisplayHomeAsUpEnabled(true);
            }
        }

        if (Build.VERSION.SDK_INT >= 21) {
            // 设置阴影
            mAppBarLayout.setElevation(10.6f);
        }
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }
    }

    /**
     * 是否允许返回(默认不允许)
     *
     * @return
     */
    public boolean canBack() {
        return false;
    }

    /**
     * 设置toolbar icon
     *
     * @param icon
     */
    protected void setNavIcon(int icon) {
        mToolbar.setNavigationContentDescription(icon);
    }

    /**
     * 设置toolbar 透明度
     *
     * @param alpha
     */
    protected void setAlpha(float alpha) {
        mToolbar.setAlpha(alpha);
    }

    /**
     * 显示隐藏toolbar
     */
    protected void hideShowToolbar() {
        mAppBarLayout.animate()
                .translationY(isHidden ? 0 : -mAppBarLayout.getHeight())
                .setInterpolator(new DecelerateInterpolator())
                .start();
    }
}
