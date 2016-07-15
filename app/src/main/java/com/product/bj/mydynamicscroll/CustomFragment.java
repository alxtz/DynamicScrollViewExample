package com.product.bj.mydynamicscroll;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class CustomFragment extends Fragment
{
    int myPosition;

    public CustomFragment(int inputPosition)
    {
        myPosition = inputPosition;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View returnView = inflater.inflate(R.layout.custom_fragment , container , false);

        changeText(returnView);

        return returnView;
    }

    public void changeText(View view)
    {
        TextView mainTextView = (TextView)view.findViewById(R.id.MainTextView);
        mainTextView.setText(Integer.toString(myPosition));
    }
}
