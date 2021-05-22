package org.esiea.genovese.myapplication.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import org.esiea.genovese.myapplication.R;
import org.esiea.genovese.myapplication.model.PlayersModel;

import java.util.List;

public class RecyclerViewAdapterPlayers extends RecyclerView.Adapter<RecyclerViewAdapterPlayers.MyViewHolder>{

    private Context mContext;
    private List<PlayersModel> mData;
    RequestOptions option;

    public RecyclerViewAdapterPlayers(Context mContext, List<PlayersModel> mData) {
        this.mContext = mContext;
        this.mData = mData;

        //Request option for Glide
        option = new RequestOptions().centerCrop().placeholder(R.drawable.loading_shape).error(R.drawable.loading_shape);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        LayoutInflater inflater = LayoutInflater.from(mContext);
        view = inflater.inflate(R.layout.players_row_item,parent,false);

        //click listener here
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        holder.tv_firstname.setText(mData.get(position).getFirstName());
        holder.tv_lastname.setText(mData.get(position).getLastName());
        holder.tv_teamId.setText(mData.get(position).getTeamId());

        //Load images from INTERNET and set it into ImageView using Glide
        Glide.with(mContext).load(mData.get(position).getImgUrl()).apply(option).into(holder.playersThumbnail);
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView tv_lastname;
        TextView tv_firstname;
        TextView tv_teamId;
        ImageView playersThumbnail;

        public MyViewHolder(View itemView){
            super(itemView);
            tv_lastname = itemView.findViewById(R.id.players_lastname);
            tv_firstname = itemView.findViewById(R.id.players_firstname);
            tv_teamId = itemView.findViewById(R.id.players_teamId);
            playersThumbnail = itemView.findViewById(R.id.thumbnail);

        }
    }

}
