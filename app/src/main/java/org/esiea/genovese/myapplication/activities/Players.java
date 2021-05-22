package org.esiea.genovese.myapplication.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.esiea.genovese.myapplication.R;
import org.esiea.genovese.myapplication.adapters.RecyclerViewAdapterPlayers;
import org.esiea.genovese.myapplication.model.PlayersModel;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Players extends AppCompatActivity {

    private final String JSON_URL = "https://raw.githubusercontent.com/melissagenovese/Projet_Android_GENOVESE_API/main/Players.json";
    private JsonArrayRequest request;
    private RequestQueue requestQueue;
    private List<PlayersModel> lstPlayersModel;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_players);

        lstPlayersModel = new ArrayList<>();
        recyclerView = findViewById(R.id.recycleviewid);
        jsonrequest();
    }

    private void jsonrequest() {
        request = new JsonArrayRequest(JSON_URL, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {

                JSONObject jsonObject = null;
                for(int i=0; i<response.length();i++){
                    try{
                        jsonObject = response.getJSONObject(i);
                        PlayersModel playersModel = new PlayersModel();

                        playersModel.setLastName(jsonObject.getString("lastName"));
                        playersModel.setFirstName(jsonObject.getString("firstName"));
                        playersModel.setTeamId(jsonObject.getString("teamId"));
                        playersModel.setImgUrl(jsonObject.getString("img"));

                        lstPlayersModel.add(playersModel);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                setuprecyclerview(lstPlayersModel);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        requestQueue = Volley.newRequestQueue(Players.this);
        requestQueue.add(request);
    }

    private void setuprecyclerview(List<PlayersModel> lstPlayersModel) {

        RecyclerViewAdapterPlayers myadapter = new RecyclerViewAdapterPlayers(this, lstPlayersModel);
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
