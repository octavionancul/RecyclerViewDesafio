package cl.octavionancul.recyclerviewdesafio.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import cl.octavionancul.recyclerviewdesafio.R;
import cl.octavionancul.recyclerviewdesafio.models.Wine;

public class WinesAdapter extends RecyclerView.Adapter<WinesAdapter.ViewHolder>{

    private List<Wine> wines;
    public WinesAdapter(List<Wine> wines) {
        this.wines = wines;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_wine,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Wine wine = wines.get(position);
        holder.brandTv.setText(wine.getBrand());
        holder.typeTv.setText(wine.getType());
        holder.yearsTv.setText(Integer.toString(wine.getYears()));
    }

    @Override
    public int getItemCount() {
        return wines.size();
    }

    public void update(Wine wine){
        wines.add(wine);
        notifyDataSetChanged();
      // Log.d("adapter",wine.getBrand());
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

    private TextView brandTv,typeTv,yearsTv;

    public ViewHolder(View itemView) {
        super(itemView);
        brandTv = itemView.findViewById(R.id.brandTv);
        typeTv= itemView.findViewById(R.id.typeTv);
        yearsTv= itemView.findViewById(R.id.yearsTv);

    }
}
}
