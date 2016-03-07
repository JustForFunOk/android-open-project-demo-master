package xushuai.viewpager_indicator_demo;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import com.viewpagerindicator.CirclePageIndicator;
import com.viewpagerindicator.LinePageIndicator;

public class SampleLinesDefault extends BaseSampleActivity {
    private static final int[] mDrawableResIds = {R.drawable.a,R.drawable.b,R.drawable.c,R.drawable.d};
    private CircleAdapter mAdapter;
    private ViewPager mPager;
    private LinePageIndicator mIndicator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.simple_lines);

        mAdapter = new CircleAdapter(getSupportFragmentManager());

        mPager = (ViewPager)findViewById(R.id.pager);
        mPager.setAdapter(mAdapter);

        mIndicator = (LinePageIndicator)findViewById(R.id.indicator);
        mIndicator.setViewPager(mPager);
    }

    class CircleAdapter extends FragmentPagerAdapter {
        public CircleAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return CircleFragment.newInstance(mDrawableResIds[position]);
        }

        @Override
        public int getCount() {
            return mDrawableResIds.length;
        }
    }
}