package com.mummyding.app.leisure.ui.news;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.mummyding.app.leisure.api.NewsApi;
import com.mummyding.app.leisure.support.Utils;
import com.mummyding.app.leisure.support.adapter.PagerAdapter;
import com.mummyding.app.leisure.ui.AbsTopNavigationFragment;

/**
 * Created by mummyding on 15-11-13.
 */
public class BaseNewsFragment extends AbsTopNavigationFragment {
    private PagerAdapter pagerAdapter;
    private String [] name ;
    private String [] url ;
    @Override
    protected PagerAdapter initPagerAdapter() {
        name = NewsApi.getNewsTitle();
        url = NewsApi.getNewsUrl();
        pagerAdapter = new PagerAdapter(getFragmentManager(),name) {
            @Override
            public Fragment getItem(int position) {
                Utils.DLog(name.length+" "+url.length);
                NewsFragment fragment = new NewsFragment();
                Bundle bundle = new Bundle();
                bundle.putString("url",url[position]);
                fragment.setArguments(bundle);
                return fragment;
            }
        };
        return pagerAdapter;
    }
}