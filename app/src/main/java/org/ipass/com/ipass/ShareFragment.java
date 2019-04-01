package org.ipass.com.ipass;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

/**
 * Created by Abishek on 12-Apr-18.
 */

public class ShareFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.under_construction,null);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Toast.makeText(view.getContext(), "Menu -> Share", Toast.LENGTH_SHORT).show();
        Toast.makeText(view.getContext(), "Come back after some time!!!", Toast.LENGTH_SHORT).show();
    }
}
