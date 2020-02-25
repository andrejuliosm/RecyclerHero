package com.example.heroapps;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class HeroesAdapter extends RecyclerView.Adapter<HeroesAdapter.ViewHolder> {

    private Context context;
    private ArrayList<Heroes> listHero = new ArrayList<>();

    public HeroesAdapter(Context context, ArrayList<Heroes> listHero) {
        this.context = context;
        this.listHero = listHero;
    }

    public ArrayList<Heroes> getListHero() {
        return listHero;
    }

    @NonNull
    @Override
    public HeroesAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.item_hero,parent,false
        );
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HeroesAdapter.ViewHolder holder, final int position) {
        holder.tvHeroName.setText(getListHero().get(position).getHeroName());
        holder.tvHeroDetail.setText(getListHero().get(position).getHeroDetail());

        Glide.with(context).load(getListHero().get(position).getHeroImage()).into(holder.ivHero);

        holder.cvHero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context,"Hero Name : " + getListHero().get(position).getHeroName(),
                        Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return listHero.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView ivHero;
        TextView tvHeroName,tvHeroDetail;
        CardView cvHero;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            ivHero = itemView.findViewById(R.id.itemhero_iv);
            tvHeroDetail = itemView.findViewById(R.id.itemhero_tv_herodetail);
            tvHeroName = itemView.findViewById(R.id.itemhero_tv_heroname);

            cvHero = itemView.findViewById(R.id.itemhero_cv);
        }
    }
}
