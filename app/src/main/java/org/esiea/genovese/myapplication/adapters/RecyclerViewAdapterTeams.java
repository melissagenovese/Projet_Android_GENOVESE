package org.esiea.genovese.myapplication.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.ImageView;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.Glide;
import org.esiea.genovese.myapplication.R;

import org.esiea.genovese.myapplication.activities.TeamsCollapse;

import java.util.List;
import org.esiea.genovese.myapplication.model.TeamsModel;

public class RecyclerViewAdapterTeams extends RecyclerView.Adapter<RecyclerViewAdapterTeams.MyViewHolder>{

    private Context mContext;
    private List<TeamsModel> mData;
    RequestOptions option;

    public RecyclerViewAdapterTeams(Context mContext, List<TeamsModel> mData) {
        this.mContext = mContext;
        this.mData = mData;

        //Request option for Glide
        option = new RequestOptions().centerCrop().placeholder(R.drawable.loading_shape).error(R.drawable.loading_shape);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        LayoutInflater inflater = LayoutInflater.from(mContext);
        view = inflater.inflate(R.layout.teams_row_item,parent,false);

        final MyViewHolder viewHolder = new MyViewHolder(view);
        viewHolder.view_container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(mContext, TeamsCollapse.class);
                i.putExtra("team_name",mData.get(viewHolder.getAdapterPosition()).getTeamName());
                i.putExtra("team_abbreviation",mData.get(viewHolder.getAdapterPosition()).getAbbreviation());
                i.putExtra("team_location",mData.get(viewHolder.getAdapterPosition()).getLocation());
                i.putExtra("team_arena",mData.get(viewHolder.getAdapterPosition()).getArena());
                i.putExtra("team_logo",mData.get(viewHolder.getAdapterPosition()).getLogoUrl());
                i.putExtra("team_description",mData.get(viewHolder.getAdapterPosition()).getDescription());

                mContext.startActivity(i);
            }
        });

        //click listener here
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        holder.tv_teamname.setText(mData.get(position).getTeamName());
        holder.tv_abbreviation.setText(mData.get(position).getAbbreviation());
        holder.tv_location.setText(mData.get(position).getLocation());
        holder.tv_arena.setText(mData.get(position).getArena());

        //Load images from INTERNET and set it into ImageView using Glide
        Glide.with(mContext).load(mData.get(position).getLogoUrl()).apply(option).into(holder.teamlogo);
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView tv_teamname;
        TextView tv_abbreviation;
        TextView tv_location;
        TextView tv_arena;
        ImageView teamlogo;
        LinearLayout view_container;

        public MyViewHolder(View itemView){
            super(itemView);
            tv_teamname = itemView.findViewById(R.id.teams_name);
            tv_abbreviation = itemView.findViewById(R.id.teams_abbreviation);
            tv_location = itemView.findViewById(R.id.teams_location);
            tv_arena = itemView.findViewById(R.id.teams_arena);
            teamlogo = itemView.findViewById(R.id.logo);
            view_container = itemView.findViewById(R.id.container);

        }
    }

}
