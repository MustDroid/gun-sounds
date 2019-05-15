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

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import java.util.List;

public class GunsAdapter extends RecyclerView.Adapter<GunsAdapter.GunHolderBase> {
    private final int GUN_TYPE = 0;
    private final int AD_TYPE = 1;

    private List<Gun> guns = GunsDatabase.getInstance().getGuns();
    private Context context;

    public GunsAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public GunHolderBase onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if(viewType == GUN_TYPE) {
            View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_gun, parent, false);
            return new GunHolder(itemView);
        }

        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_ad, parent, false);
        return new AdHolder(itemView);
    }

    //@RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onBindViewHolder(@NonNull final GunHolderBase holderBase, final int position) {
        final Gun gun = guns.get(position);
        int type = getItemViewType(position);
        if(type == GUN_TYPE) {
            GunHolder holder = (GunHolder)holderBase;
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
            AdHolder holder = (AdHolder)holderBase;
        }
    }

    @Override
    public int getItemViewType(int position) {
        return guns.get(position) != null ? GUN_TYPE : AD_TYPE;
    }

    @Override
    public int getItemCount() {
        return guns.size();
    }

    public class GunHolderBase extends RecyclerView.ViewHolder {
        public GunHolderBase(View itemView) {
            super(itemView);
        }
    }

    public class GunHolder extends GunHolderBase {
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

    public class AdHolder extends GunHolderBase {

        public AdView adView;

        public AdHolder(View itemView) {
            super(itemView);

            adView = itemView.findViewById(R.id.adView);
            AdRequest adRequest = new AdRequest.Builder().addTestDevice("0F16E7C6A3B2A844025E3E39695F70BE").build();
            adView.loadAd(adRequest);
        }
    }
}
