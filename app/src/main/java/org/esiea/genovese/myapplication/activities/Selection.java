package org.esiea.genovese.myapplication.activities;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import org.esiea.genovese.myapplication.R;

import java.util.List;


public class Selection extends AppCompatActivity implements View.OnClickListener {

    private CardView eastern_card, western_card;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selection);
        Toast.makeText(Selection.this, R.string.message_selection, Toast.LENGTH_LONG).show();

        //Defining cards
        eastern_card = (CardView) findViewById(R.id.easternconference);
        western_card = (CardView) findViewById(R.id.westernconference);

        //Add click listener to cards
        eastern_card.setOnClickListener(this);
        western_card.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent i;

        switch (v.getId()) {
            case R.id.easternconference:
                Uri webpage = Uri.parse("https://www.lequipe.fr/Basket/BasketClassementNBA2021_E.html");
                Intent webIntent = new Intent(Intent.ACTION_VIEW, webpage);

                PackageManager packageManager = getPackageManager();
                List<ResolveInfo> activities = packageManager.
                        queryIntentActivities(webIntent, 0);
                boolean isIntentSafe = activities.size() > 0;

                if (isIntentSafe) {
                    startActivity(webIntent);
                }
                break;

            case R.id.westernconference:
                Uri webpage2 = Uri.parse("https://www.lequipe.fr/Basket/BasketClassementNBA2021_W.html");
                Intent webIntent2 = new Intent(Intent.ACTION_VIEW, webpage2);

                PackageManager packageManager2 = getPackageManager();
                List<ResolveInfo> activities2 = packageManager2.
                        queryIntentActivities(webIntent2, 0);
                boolean isIntentSafe2 = activities2.size() > 0;

                if (isIntentSafe2) {
                    startActivity(webIntent2);
                }
                break;

                default:
                break;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_other,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        if (id == R.id.home) {
            Intent intent = new Intent(this,MainActivity.class);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

