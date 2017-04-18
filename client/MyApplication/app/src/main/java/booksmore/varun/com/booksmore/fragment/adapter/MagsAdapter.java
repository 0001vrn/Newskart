package booksmore.varun.com.booksmore.fragment.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import booksmore.varun.com.booksmore.R;
import booksmore.varun.com.booksmore.model.Magazines;

/**
 * Created by Varun on 4/18/2017.
 */
public class MagsAdapter extends RecyclerView.Adapter<MagsAdapter.MyViewHolder> {

    private List<Magazines> list;
    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title, price;
        public ImageView imageView;

        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.title);
            price = (TextView) view.findViewById(R.id.price);
            imageView = (ImageView) view.findViewById(R.id.list_image);
        }
    }


    public MagsAdapter(List<Magazines> newspaperList) {
        list = newspaperList;
    }

    @Override
    public MagsAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.mags_list_row, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MagsAdapter.MyViewHolder holder, int position) {
        Magazines newspaper = list.get(position);
        holder.title.setText(newspaper.getTitle());
        holder.price.setText(newspaper.getPrice());
        holder.imageView.setImageResource(newspaper.getImageID());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
