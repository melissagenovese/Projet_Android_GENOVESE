package org.esiea.genovese.myapplication.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.esiea.genovese.myapplication.R;
import org.esiea.genovese.myapplication.adapters.RecyclerViewAdapterTeams;
import org.esiea.genovese.myapplication.model.TeamsModel;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Teams extends AppCompatActivity {

    private final String JSON_URL = "https://raw.githubusercontent.com/melissagenovese/Projet_Android_GENOVESE_API/main/Teams.json";
    private JsonArrayRequest request;
    private RequestQueue requestQueue;
    private List<TeamsModel> lstTeamsModel;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teams);

        lstTeamsModel = new ArrayList<>();
        recyclerView = findViewById(R.id.recycleviewid);
        jsonrequest();
        Toast.makeText(Teams.this,R.string.message_teams,Toast.LENGTH_LONG).show();
    }

    private void jsonrequest() {
        request = new JsonArrayRequest(JSON_URL, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {

                JSONObject jsonObject = null;
                for(int i=0; i<response.length();i++){
                    try{
                        jsonObject = response.getJSONObject(i);
                        TeamsModel teamsModel = new TeamsModel();

                        teamsModel.setTeamName(jsonObject.getString("teamName"));
                        teamsModel.setAbbreviation(jsonObject.getString("abbreviation"));
                        teamsModel.setLocation(jsonObject.getString("location"));
                        teamsModel.setArena(jsonObject.getString("arena"));
                        teamsModel.setLogoUrl(jsonObject.getString("logo"));
                        teamsModel.setDescription(jsonObject.getString("description"));

                        lstTeamsModel.add(teamsModel);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                setuprecyclerview(lstTeamsModel);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        requestQueue = Volley.newRequestQueue(Teams.this);
        requestQueue.add(request);
    }

    private void setuprecyclerview(List<TeamsModel> lstTeamsModel) {

        RecyclerViewAdapterTeams myadapter = new RecyclerViewAdapterTeams(this, lstTeamsModel);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(myadapter);
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
