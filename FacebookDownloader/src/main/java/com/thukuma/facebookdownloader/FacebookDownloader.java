package com.thukuma.facebookdownloader;

import android.content.Context;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.util.HashMap;
import java.util.Map;

public class FacebookDownloader {
    private String url;
    private Context context;
    private onComplete complete;
    private  onError onError;
    private RequestQueue mRequestQueue;
    private StringRequest mStringRequest;
    private String sdlink,hdlink;

    public FacebookDownloader(String url, Context context, onComplete complete, FacebookDownloader.onError onError) {
        this.url = url;
        this.context = context;
        this.complete = complete;
        this.onError = onError;
        FaceBookDownloder(url,complete,onError);
    }

    public  void FaceBookDownloder(String url,onComplete onComplete,onError onError){
        mRequestQueue = Volley.newRequestQueue(context);
        mStringRequest = new StringRequest(Request.Method.POST, "https://fdown.net/download.php", new com.android.volley.Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                if (!response.isEmpty()) {

                    Document doc = Jsoup.parse(response);
                    sdlink = doc.select("a[id=sdlink]").attr("href");
                    hdlink = doc.select("a[id=hdlink]").attr("href");
                    String title = doc.select("div.lib-header").text();
                    String desc = doc.select("div.lib-desc").text();
                    String img = doc.select("img.lib-img-show").attr("src");

                    if (!sdlink.isEmpty()) {
                        XModal modal = new XModal(
                                sdlink,hdlink,title,desc,img
                        );
                        onComplete.onComplete(modal);
                    }
                }

            }
        }, new com.android.volley.Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                String secondUrl = url.replace("www.","www.m.");
                FaceBookDownloderSecondError(secondUrl, onComplete,onError);

            }
        }){
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String>  params = new HashMap<String, String>();
                params.put("URLz",url);
                return params;
            }
        };


        mRequestQueue.add(mStringRequest);
    }
    public  void FaceBookDownloderSecondError(String url,onComplete onComplete,onError onError){
        mRequestQueue = Volley.newRequestQueue(context);
        mStringRequest = new StringRequest(Request.Method.POST, "https://fdown.net/download.php", new com.android.volley.Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                if (!response.isEmpty()){

                    Document doc = Jsoup.parse(response);
                    sdlink = doc.select("a[id=sdlink]").attr("href");
                    hdlink = doc.select("a[id=hdlink]").attr("href");
                    String title = doc.select("div.lib-header").text();
                    String desc = doc.select("div.lib-desc").text();
                    String img = doc.select("img.lib-img-show").attr("src");

                    if (!sdlink.isEmpty()){

                        XModal modal = new XModal(
                                sdlink,hdlink,title,desc,img
                        );
                        onComplete.onComplete(modal);

                    }else {

                    }


                }else {

                    Toast.makeText(context, "Server Error", Toast.LENGTH_SHORT).show();
                }

            }
        }, new com.android.volley.Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                onError.onError(error);
//                Intent i = new Intent(getContext(),Web_View.class);
//                i.putExtra("url",url);
//                startActivity(i);

            }
        }){
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String>  params = new HashMap<String, String>();
                params.put("URLz",url);
                return params;
            }
        };


        mRequestQueue.add(mStringRequest);
    }

    public interface onComplete{
        void onComplete(XModal xModal);
    }
    public interface onError{
        void onError(Exception error);
    }
}
