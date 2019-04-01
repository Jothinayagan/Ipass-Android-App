package org.ipass.com.ipass;

import android.app.ProgressDialog;
import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import static com.android.volley.VolleyLog.TAG;

/**
 * Created by Abishek on 13-Apr-18.
 */

public class VolleyPostData {
    public String postTO(String s1){
        return "Success!!!";
    }
    public String result;
    public String  makeJsonObjectRequest(String url, final HashMap<String, String > params){

        Log.d("Volley","Inside volley post data");
        StringRequest strRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>()
                {
                    @Override
                    public void onResponse(String response)
                    {
                       result = response;
                    }
                },
                new Response.ErrorListener()
                {
                    @Override
                    public void onErrorResponse(VolleyError error)
                    {
                        result = error.toString();
                    }
                })
        {
            @Override
            protected Map<String, String> getParams()
            {
                return params;
            }
        };

        return result;
    }

}