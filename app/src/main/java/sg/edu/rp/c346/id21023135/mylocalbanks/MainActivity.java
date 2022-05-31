package sg.edu.rp.c346.id21023135.mylocalbanks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView tvdbs;
    TextView tvocbc;
    TextView tvuob;
    String wordClicked = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvdbs = findViewById(R.id.textViewDBS);
        tvocbc = findViewById(R.id.textViewOCBC);
        tvuob = findViewById(R.id.textViewUOB);
        registerForContextMenu(tvdbs);
        registerForContextMenu(tvocbc);
        registerForContextMenu(tvuob);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    @Override
    public void onCreateContextMenu (ContextMenu menu, View v,
                                     ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        if (v == tvdbs) {
            wordClicked = "dbs";
        } else if (v == tvocbc) {
            wordClicked = "ocbc";
        } else if (v == tvuob) {
            wordClicked = "uob";
        }
        menu.add(0, 0, 0, "Website");
        menu.add(0, 1, 1, "Contact the bank");
    }
    @Override
    public boolean onContextItemSelected(MenuItem item) {
        if (wordClicked.equalsIgnoreCase("dbs")) {
            if (item.getItemId() == 0) {
                Intent intentWeb = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.dbs.com.sg/index/default.page"));
                startActivity(intentWeb);
                return true;
            } else if (item.getItemId() == 1) {
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + 1800 + 1111111));
                startActivity(intentCall);
                return true;
            }
        } else if (wordClicked.equalsIgnoreCase("ocbc")) {
            if (item.getItemId() == 0) {
                Intent intentWeb2 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.ocbc.com/group/gateway.page"));
                startActivity(intentWeb2);
                return true;
            } else if (item.getItemId() == 1) {
                Intent intentCall2 = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + 1800 + 3633333));
                startActivity(intentCall2);
                return true;
            }
        } else if (wordClicked.equalsIgnoreCase("uob")) {
            if (item.getItemId() == 0) {
                Intent intentWeb3 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.uobgroup.com/uobgroup/default.page"));
                startActivity(intentWeb3);
                return true;
            } else if (item.getItemId() == 1) {
                Intent intentCall3 = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + 1800 + 2222121));
                startActivity(intentCall3);
                return true;
            }
        }
        return super.onContextItemSelected(item);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.EnglishSelection) {
            tvdbs.setText("DBS");
            tvocbc.setText("OCBC");
            tvuob.setText("UOB");
            return true;
        } else if (id == R.id.ChineseSelection) {
            tvdbs.setText("星展银行");
            tvocbc.setText("华侨银行");
            tvuob.setText(" 大华银行");
            return true;
        } else {
            tvdbs.setText("Error translation");
            tvocbc.setText("Error translation");
            tvuob.setText("Error translation");
        }

        return super.onOptionsItemSelected(item);
    }
}