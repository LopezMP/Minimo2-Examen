package edu.upc.dsa.minimo2examen;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import edu.upc.dsa.minimo2examen.models.Element;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {


    private Context context;
    private List<Element> elementsList;

    public MyAdapter(Context context, List<Element> elementsList) {
        this.context = context;
        this.elementsList = elementsList;
    }

    public void setUserList(List<Element> elementsList) {
        this.elementsList = elementsList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MyAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.row_layout, viewGroup, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter.MyViewHolder myViewHolder, final int i) {

            Picasso.with(context).load(elementsList.get(i).getImatge().get(1)).into(myViewHolder.imageView2);

            myViewHolder.txtname.setText(elementsList.get(i).getAdrecaNom());
            myViewHolder.txtDescription.setText(elementsList.get(i).getDescripcio());
    }

    @Override
    public int getItemCount() {
        if (elementsList != null)
            return elementsList.size();
        else
            return 0;
    }

    static class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView txtname;
        private TextView txtDescription;
        private ImageView imageView2;

        public MyViewHolder(View itemView) {
            super(itemView);
            txtname= itemView.findViewById(R.id.txtname);
            txtDescription= itemView.findViewById(R.id.txtDescription);
            imageView2=itemView.findViewById(R.id.imageView2);
        }
    }
}