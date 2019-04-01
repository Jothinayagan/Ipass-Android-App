package org.ipass.com.ipass;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.kosalgeek.asynctask.PostResponseAsyncTask;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Gowtham on 11-Apr-18.
 */

public class LoginFragment extends Fragment{

    public EditText email;
    public EditText password;
    Button blogin;

    private String url = AppConfig.urlLogin;
    private String jsonResponse;
    private RequestQueue requestQueue;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_login,null);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        requestQueue = Volley.newRequestQueue(getActivity());
        Toast.makeText(getContext(), "Enter your login credentials", Toast.LENGTH_SHORT).show();
        email = (EditText) view.findViewById(R.id.idEmail);
        password = (EditText) view.findViewById(R.id.idPassword);
        blogin = (Button) view.findViewById(R.id.idLogin);




        blogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final ProgressDialog loading = ProgressDialog.show(getActivity(), "Authenticating user", "Please wait...", false, false);
                final String mail = email.getText().toString();
                final String pass = password.getText().toString();
                Toast.makeText(getContext(),mail, Toast.LENGTH_SHORT).show();
                Toast.makeText(getContext(),pass, Toast.LENGTH_SHORT).show();
                //
                StringRequest stringRequest = new StringRequest(Request.Method.POST, AppConfig.urlLogin,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                //if the server response is success
                                    //dismissing the progressbar
                                    loading.dismiss();
                                if (response != null)
                                {
                                    try {
                                        JSONObject jsonObject = new JSONObject(response);
                                        //Toast.makeText(getContext(),jsonObject.getString("status"), Toast.LENGTH_SHORT).show();
                                        Intent intent =new Intent(getActivity(),DashboardPrivate.class);
                                        intent.putExtra("token",jsonObject.getString("token"));
                                        intent.putExtra("api",jsonObject.getString("apiKey"));
                                        intent.putExtra("name",jsonObject.getString("name"));
                                        startActivity(intent);
                                    } catch (JSONException e) {
                                        e.printStackTrace();
                                    }
                                }

                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                loading.dismiss();
                                Toast.makeText(getContext(), "Invalid Email/ Password", Toast.LENGTH_LONG).show();
                            }
                        }){
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {
                        Map<String,String> params = new HashMap<String, String>();
                        //Adding the parameters
                        params.put("email", mail);
                        params.put("password", pass);
                        return params;
                    }
                };
                //Adding the request to the queue
                requestQueue.add(stringRequest);
            }
        });

    }
}
