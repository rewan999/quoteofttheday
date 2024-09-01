package com.example.quote_of_the_day_encriptix;

import static android.content.Intent.ACTION_SEND;
import static androidx.core.content.res.TypedArrayUtils.getText;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Adaptry extends RecyclerView.Adapter<Adaptry.MyViewHolder> {

    private final Context context;
    private int checkposition=0;
    private ArrayList<QModel> qModelList;
    private OnItemClickListner listner;
    private Random random=new Random();



    public interface OnItemClickListner {
        void onitemclick(QModel model);
    }


    public void itemselection(int position){
        QModel model=qModelList.get(position);
        model.setSelected(!model.isselected());
        notifyItemChanged(position);
    }


    public Adaptry(Context context, ArrayList<QModel> qModelList) {
        this.context = context;
        this.qModelList = qModelList;
        shaffleData();
    }

    public void shaffleData(){
        Collections.shuffle(qModelList,random);
    }
    public void setitems(ArrayList<QModel> qModelList) {
        this.qModelList = new ArrayList<>();
        this.qModelList = qModelList;
        notifyDataSetChanged();
    }





    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context)
                .inflate(R.layout.item_view, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        QModel model = qModelList.get(position);
        holder.text.setText(model.getText());
        holder.author.setText(model.getAuthor());


    }
    @Override
    public int getItemCount() {
        return qModelList.size();
    }
    class MyViewHolder extends RecyclerView.ViewHolder{
        private TextView text;
        private TextView author;
        private FloatingActionButton soicial;
        private Button fav;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            text =itemView.findViewById(R.id.queto);
            author=itemView.findViewById(R.id.author);
            soicial=itemView.findViewById(R.id.sharesocial);
            fav=itemView.findViewById(R.id.clickfav);
            soicial.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    sharedqueto();
                }
            });

        }
    }


    public void sharedqueto() {
        QModel qModel=new QModel();

        Intent intent = new Intent(ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT, qModel.getText() + "\n" +
                qModel.getAuthor());

        intent.putExtra(Intent.EXTRA_SUBJECT, "Quote of the Day");
        intent.putExtra(Intent.EXTRA_TEXT, qModel.getText() + " - " + qModel.getAuthor()
                + " (via Quote of the Day App)");
    }



}
