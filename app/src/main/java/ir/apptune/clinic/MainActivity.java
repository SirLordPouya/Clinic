package ir.apptune.clinic;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.ShareActionProvider;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.google.gson.Gson;

import ir.apptune.clinic.Adapters.ScienceMagazineAdapter;
import ir.apptune.clinic.DataModels.ScienceMagazineDataModel;

public class MainActivity extends AppCompatActivity {
    public ProgressDialog pbMain;
    Button btnRetry;
    WebService webService;
    String result;
    Gson gson;
    ScienceMagazineAdapter adapter;
    ScienceMagazineDataModel model;
    ListView scienceMagazineListview;
    ShareActionProvider shareActionProvider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        webService = new WebService();
        gson = new Gson();
        pbMain = new ProgressDialog(this);
        scienceMagazineListview = (ListView) findViewById(R.id.science_magazine_listview);
        Log.d("LOG", "WE ARE before threadMaker ");
        threadMaker();


    }

    private void setShareIntent() {
        if (shareActionProvider != null) {

            Intent myShareIntent = new Intent(Intent.ACTION_SEND);
            myShareIntent.setType("text/plain");

            myShareIntent.putExtra(Intent.EXTRA_TEXT, "");

            shareActionProvider.setShareIntent(myShareIntent);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        MenuItem item = menu.findItem(R.id.share_btn);
        shareActionProvider = (ShareActionProvider) MenuItemCompat.getActionProvider(item);
        setShareIntent();
        return true;
    }


    private void onRetry() {
        setContentView(R.layout.network_failur_layout);
        btnRetry = (Button) findViewById(R.id.btn_retry);
        btnRetry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setContentView(R.layout.activity_main);
                threadMaker();
            }
        });
    }

    private String resultChecker(String result) {
        if (result == null) {
            onRetry();
        }else {
         model = gson.fromJson(result,ScienceMagazineDataModel.class);
            adapter = new ScienceMagazineAdapter(MainActivity.this,model.getList());
            scienceMagazineListview.setAdapter(adapter);

        }
        return result;
    }

    private void threadMaker() {

        new AsyncTask<Void, Void, String>() {
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                pbMain.setMessage("در حال دریافت اطلاعات...");
                pbMain.show();
            }

            @Override
            protected String doInBackground(Void... voids) {
                result = webService.getUrl("http://drapplication.artiwhite.ir/api/SelectSienceMagzine.aspx", MainActivity.this);
                return result;
            }

            @Override
            protected void onPostExecute(String response) {
                super.onPostExecute(response);
                resultChecker(response);
                pbMain.dismiss();
            }
        }.execute();

    }
}
