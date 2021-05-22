package org.esiea.genovese.myapplication.activities;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import org.esiea.genovese.myapplication.R;

import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    final Context context = this;
    private CardView players_card, teams_card, standings_card, web_card;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Defining cards
        players_card = (CardView) findViewById(R.id.card1);
        teams_card = (CardView) findViewById(R.id.card2);
        standings_card = (CardView) findViewById(R.id.card4);
        web_card = (CardView) findViewById(R.id.card5);

        //Add click listener to cards
        players_card.setOnClickListener(this);
        teams_card.setOnClickListener(this);
        standings_card.setOnClickListener(this);
        web_card.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Intent i;

        switch (v.getId()){
            case R.id.card1: i = new Intent(this,Players.class);
                startActivity(i);
                break;

            case R.id.card2: i = new Intent(this,Teams.class);
                startActivity(i);
                break;

            case R.id.card4: i = new Intent(this,Selection.class);
                startActivity(i);
                break;

            case R.id.card5:
                Uri webpage = Uri.parse("https://www.basketball-reference.com/");
                Intent webIntent = new Intent(Intent.ACTION_VIEW, webpage);

                PackageManager packageManager = getPackageManager();
                List<ResolveInfo> activities = packageManager.
                        queryIntentActivities(webIntent, 0);
                boolean isIntentSafe = activities.size() > 0;

                if (isIntentSafe) {
                    startActivity(webIntent);
                }
                break;
            default:
                break;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return true;
    }

    //Fonction qui génère une boite de dialogue si l'on veut quitter l'application
    private void exit(){
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setMessage(R.string.message_exit);
        alertDialogBuilder.setNegativeButton(R.string.negative, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        alertDialogBuilder.setPositiveButton(R.string.positive, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this,R.string.message_close,Toast.LENGTH_LONG).show();
                finish();
            }
        });

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        if (id == R.id.exit) {
            exit();
            //System.exit(0);
            return true;
        }

        if(id == R.id.github){
            //On lance le navigateur a l'appui sur le bouton dans le menu
            //On forme un objet URI à partir d'une chaine de caractère définissant une adresse web
            Uri webpage = Uri.parse("https://github.com/melissagenovese");
            Intent webIntent = new Intent(Intent.ACTION_VIEW, webpage);

            PackageManager packageManager = getPackageManager();
            List<ResolveInfo> activities = packageManager.
                    queryIntentActivities(webIntent, 0);
            boolean isIntentSafe = activities.size() > 0;

            if (isIntentSafe) {
                startActivity(webIntent);
            }
            return true;
        }

        if(id == R.id.notif){
            NotificationManager manager = (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
            NotificationCompat.Builder builder = new NotificationCompat.Builder(MainActivity.this);
            Notification notification = builder.setSmallIcon(android.R.drawable.btn_dialog)
                    .setContentTitle("Welcome to NBA Reference")
                    .setContentText("Check NBA stats and informations")
                    .setSmallIcon(R.mipmap.ic_launcher_nbareference)
                    .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                    .build();
            manager.notify(0,notification);
        }

        if(id == R.id.info){
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
            alertDialogBuilder.setMessage(R.string.message_info);
            AlertDialog alertDialog = alertDialogBuilder.create();
            alertDialog.show();
        }

        if(id == R.id.home){
            Intent intent = new Intent(this,MainActivity.class);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }
    /*
    //Methode qui permet d'éviter le crash lors du landscape
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        System.gc();
        super.onConfigurationChanged(newConfig);
        setContentView(R.layout.activity_main);
    }
    */

}
