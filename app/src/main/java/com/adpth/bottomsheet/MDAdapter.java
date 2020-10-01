package com.adpth.bottomsheet;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.List;

public class MDAdapter extends RecyclerView.Adapter<MDAdapter.MyViewHolder> {

    private Context context;
    private List<Modal> list;

    public MDAdapter(Context context, List<Modal> list)
    {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        LayoutInflater inflater = LayoutInflater.from(context);
        view = inflater.inflate(R.layout.layout_design,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, int position) {
        holder.img.setImageResource(list.get(position).getImage());
        holder.siz.setText(list.get(position).getSize());
        holder.tit.setText(list.get(position).getTitle());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

     public static class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView img;
        TextView tit,siz;
        ConstraintLayout constraintLayout;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            img = itemView.findViewById(R.id.image);
            tit = itemView.findViewById(R.id.title);
            siz = itemView.findViewById(R.id.size);
            itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    openBottomSheet(v);
                    return false;
                }
            });
        }

         private void openBottomSheet(View v) {

             View view = ((FragmentActivity)v.getContext()).getLayoutInflater().inflate(R.layout.bottom_sheet, null);
             BottomSheetDialog dialog = new BottomSheetDialog(v.getContext());
             dialog.setContentView(view);
             dialog.show();

             LinearLayout share,link,edit,delete;

             share=view.findViewById(R.id.share);
             share.setOnClickListener(new View.OnClickListener() {
                 @Override
                 public void onClick(View v) {
                     Toast.makeText(v.getContext(), "Share "+getAdapterPosition(), Toast.LENGTH_SHORT).show();
                 }
             });
             link=view.findViewById(R.id.link);
             link.setOnClickListener(new View.OnClickListener() {
                 @Override
                 public void onClick(View v) {
                     Toast.makeText(v.getContext(), "Get Link "+getAdapterPosition(), Toast.LENGTH_SHORT).show();
                 }
             });
             edit=view.findViewById(R.id.edit);
             edit.setOnClickListener(new View.OnClickListener() {
                 @Override
                 public void onClick(View v) {
                     Toast.makeText(v.getContext(), "Edit "+getAdapterPosition(), Toast.LENGTH_SHORT).show();
                 }
             });
             delete=view.findViewById(R.id.delete);
             delete.setOnClickListener(new View.OnClickListener() {
                 @Override
                 public void onClick(View v) {
                     Toast.makeText(v.getContext(), "Delete "+getAdapterPosition(), Toast.LENGTH_SHORT).show();
                 }
             });

         }
     }
}
