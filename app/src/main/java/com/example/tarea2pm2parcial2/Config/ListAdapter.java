package com.example.tarea2pm2parcial2.Config;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;
import com.example.tarea2pm2parcial2.R;
import java.util.List;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> {
    private List<Datos> datos;
    private LayoutInflater inflater;
    private Context context;

    public ListAdapter(List<Datos> datos, Context context) {
        this.inflater=LayoutInflater.from(context);
        this.datos = datos;
        this.context = context;
    }

    @Override
    public int getItemCount(){return datos.size();}

    @Override
    public ListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewtype){
        View view=inflater.inflate(R.layout.disenio,null);
        return new ListAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ListAdapter.ViewHolder holder, final int position){
        holder.bindData(datos.get(position));
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView id, subId;

        ViewHolder(View itemView){
            super(itemView);
            id=(TextView) itemView.findViewById(R.id.texViewItem);
            subId=(TextView) itemView.findViewById(R.id.textViewSubItem);
        }
        void bindData(final Datos datos){
            id.setText("Item: "+datos.getId());
            subId.setText("Sub-item: "+datos.getSubId());
        }
    }
}
