package org.ipass.com.ipass;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Abishek on 12-Apr-18.
 */

public class PublicChannelFragment extends Fragment {

    public EditText api;
    Button bview;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_public_channel,null);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Toast.makeText(getContext(), "Enter the API Key", Toast.LENGTH_SHORT).show();
        api = (EditText) view.findViewById(R.id.idApi);
        bview = (Button) view.findViewById(R.id.idView);

        bview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Api = api.getText().toString();
                Toast.makeText(getContext(),Api, Toast.LENGTH_SHORT).show();
            }
        });

    }
}
