package ir.apptune.clinic;

import android.content.Context;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.SyncHttpClient;

import org.json.JSONObject;

import java.io.UnsupportedEncodingException;

import cz.msebera.android.httpclient.Header;

/**
 * Created by Pouya on 10/11/2016.
 * Gets an URL as an argument and connects to the webservice and when its ready onSuccess runs
 * This service uses Android Asynchronous Http Client library
 */

class WebService {
    private String result = null;

    String getUrl(String url, final Context mContext) {
        SyncHttpClient client = new SyncHttpClient();
        client.setConnectTimeout(5000);
        client.setTimeout(5000);

        client.get(url, new AsyncHttpResponseHandler() {

            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                String response = null;
                try {
                    response = new String(responseBody,"UTF-8");
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                result = response;

            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {

            }

        });

        return result;
    }

}
