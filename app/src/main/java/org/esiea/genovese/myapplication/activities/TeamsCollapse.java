package org.esiea.genovese.myapplication.activities;

import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import org.esiea.genovese.myapplication.R;

public class TeamsCollapse extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teams_collapse);
        Toast.makeText(TeamsCollapse.this,R.string.message_swipe,Toast.LENGTH_LONG).show();

        //hide default actions
        getSupportActionBar().hide();

        //Receive data
        String name = getIntent().getExtras().getString("team_name");
        String abbreviation = getIntent().getExtras().getString("team_abbreviation");
        String location = getIntent().getExtras().getString("team_location");
        String arena = getIntent().getExtras().getString("team_arena");
        String logo = getIntent().getExtras().getString("team_logo");
        String description = getIntent().getExtras().getString("team_description");

        //Init views
        CollapsingToolbarLayout collapsingToolbarLayout = findViewById(R.id.collapsingtoolbar_id);
        collapsingToolbarLayout.setTitleEnabled(true);

        TextView tv_name = findViewById(R.id.tc_teams_name);
        TextView tv_abbreviation = findViewById(R.id.tc_teams_abbreviation);
        TextView tv_arena = findViewById(R.id.tc_teams_arena);
        TextView tv_location = findViewById(R.id.tc_teams_location);
        TextView tv_description = findViewById(R.id.tc_description);
        ImageView iv_logo = findViewById(R.id.tc_logo);

        //setting values to each view

        tv_name.setText(name);
        tv_abbreviation.setText(abbreviation);
        tv_arena.setText(arena);
        tv_location.setText(location);
        tv_description.setText(description);

        collapsingToolbarLayout.setTitle(name);

        RequestOptions requestOptions = new RequestOptions().centerCrop().placeholder(R.drawable.loading_shape).error(R.drawable.loading_shape);

        //setting image using Glide

        Glide.with(this).load(logo).apply(requestOptions).into(iv_logo);
    }

}
