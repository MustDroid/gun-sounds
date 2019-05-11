package com.emokehajdu.gunsounds;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class GunsAdapter extends RecyclerView.Adapter<GunsAdapter.GunHolder> {
    private List<Gun> guns = GunsDatabase.getInstance().getGuns();
    private Context context;

    public GunsAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public GunHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_gun, parent, false);

        return new GunHolder(itemView);
    }

    //@RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onBindViewHolder(@NonNull final GunHolder holder, final int position) {
        final Gun gun = guns.get(position);
        if(gun != null) {
            holder.txtName.setText(gun.getName());
            holder.imageViewGun.setImageResource(gun.getImageResourceID());
            holder.btnPlay.setImageResource(gun.isPlaying() ? R.drawable.stopbutton : R.drawable.playbuttonnew);
            holder.btnPlay.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    gun.clicked(context);
                    notifyDataSetChanged();
                }
            });
        }
        else {
            holder.txtName.setVisibility(View.INVISIBLE);
            holder.cardViewGun.setVisibility(View.INVISIBLE);
            holder.imageViewGun.setVisibility(View.INVISIBLE);
            holder.btnPlay.setVisibility(View.INVISIBLE);
        }
    }

    @Override
    public int getItemCount() {
        return guns.size();
    }

    public class GunHolder extends RecyclerView.ViewHolder {
        public TextView txtName;
        public CardView cardViewGun;
        public ImageView imageViewGun;
        public ImageButton btnPlay;

        public GunHolder(View view) {
            super(view);
            txtName = view.findViewById(R.id.txtName);
            cardViewGun = view.findViewById(R.id.cardViewGun);
            imageViewGun = cardViewGun.findViewById(R.id.imageViewGun);
            btnPlay = view.findViewById(R.id.btnPlay);
        }
    }
}
