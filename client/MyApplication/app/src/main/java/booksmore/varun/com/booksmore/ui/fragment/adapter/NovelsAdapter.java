package booksmore.varun.com.booksmore.ui.fragment.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import booksmore.varun.com.booksmore.R;
import booksmore.varun.com.booksmore.model.Novels;

public class NovelsAdapter extends RecyclerView.Adapter<NovelsAdapter.ViewHolder> {

    public interface OnItemClickListener {
        void onItemClick(Novels item);
    }

    private final List<Novels> items;
    private final OnItemClickListener listener;

    public NovelsAdapter(List<Novels> items, OnItemClickListener listener) {
        this.items = items;
        this.listener = listener;
    }

    @Override public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.mags_list_row, parent, false);
        return new ViewHolder(v);
    }

    @Override public void onBindViewHolder(ViewHolder holder, int position) {
        holder.bind(items.get(position), listener);
    }

    @Override public int getItemCount() {
        return items.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        private TextView title,price;
        private ImageView image;

        public ViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.title);
            price = (TextView) itemView.findViewById(R.id.price);
            image = (ImageView) itemView.findViewById(R.id.list_image);
        }

        public void bind(final Novels item, final OnItemClickListener listener) {
            title.setText(item.getTitle());
            price.setText(item.getPrice());
            image.setImageResource(item.getImageID());

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override public void onClick(View v) {
                    listener.onItemClick(item);
                }
            });
        }
    }
}