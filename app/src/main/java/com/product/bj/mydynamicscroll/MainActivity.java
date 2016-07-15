package com.product.bj.mydynamicscroll;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends FragmentActivity
{
    ViewPager viewPager = null;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //初始化viewPager
        viewPager = (ViewPager)findViewById(R.id.pager);

        FragmentManager fragmentManager = getSupportFragmentManager();
        viewPager.setAdapter(new MyAdapter(fragmentManager));
    }
}

class MyAdapter extends FragmentPagerAdapter
{
    boolean toAdd = false;

    int maxCount = 10;   //為3的話，就是0,1,2

    public MyAdapter(FragmentManager fm)
    {
        super(fm);
    }

    @Override
    public Fragment getItem(int position)
    {
        Fragment fooFragment = new CustomFragment(position);

        Log.d("MainLog","Create Fragment"+Integer.toString(position));

        if (position>=(maxCount-2))
        {
            toAdd = true;
        }

        return fooFragment;
    }

    @Override
    public int getCount()
    {
        if (toAdd==true)
        {
            maxCount++;
            toAdd = false;
            notifyDataSetChanged();
        }

        Log.d("MainLog","The MaxCount Now is : "+Integer.toString(maxCount));

        return maxCount;
    }
}