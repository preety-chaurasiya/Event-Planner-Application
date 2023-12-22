package com.example.myeventmanagement;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class EventAdapter extends RecyclerView.Adapter<EventAdapter.ViewHolder> {
    ArrayList<UploadEvent> list;
    Context context;

    public EventAdapter(ArrayList<UploadEvent> list, Context context) {
        this.list = list;
        this.context = context;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.completeevent, parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        UploadEvent model = list.get(position);
        Picasso.get().load(model.getUploadImage()).placeholder(R.drawable.birthday).into(holder.eventImg);
        holder.eventTypeC.setText(model.getEventType());
        holder.eventVenue.setText(model.getEventVenue());
        holder.priceEvent.setText(model.getBudget());
        holder.designEvent.setText(model.getDesign());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,SingleEvent.class);
                intent.putExtra("singleImg",model.getUploadImage());
                intent.putExtra("singleTitle",model.getEventType());
                intent.putExtra("singleVenue",model.getEventVenue());
                intent.putExtra("singleBudget",model.getBudget());
                intent.putExtra("singleDesign",model.getDesign());
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);

            }
        });

    }

    @Override
    public int getItemCount() {

        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView eventTypeC, eventVenue, priceEvent, designEvent;
        ImageView eventImg;


         public ViewHolder(@NonNull View itemView) {
             super(itemView);
             eventTypeC = itemView.findViewById(R.id.eventTypeC);
             designEvent = itemView.findViewById(R.id.designEvent);
             priceEvent = itemView.findViewById(R.id.priceEvent);
             eventVenue = itemView.findViewById(R.id.venueEventU);

             eventImg= itemView.findViewById(R.id.eventImg);
         }
     }
}
