package booksmore.varun.com.booksmore.fragment;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import booksmore.varun.com.booksmore.R;
import booksmore.varun.com.booksmore.fragment.NewsMagFragment.OnListFragmentInteractionListener;
import booksmore.varun.com.booksmore.fragment.dummy.Data;

import java.util.Collections;
import java.util.List;


public class MyNewsMagRecyclerViewAdapter extends RecyclerView.Adapter<MyNewsMagRecyclerViewAdapter.ViewHolder> {

    //private final List<DummyItem> mValues;

    //private final List<Data> mValues;
    List<Data> list = Collections.emptyList();
    private final OnListFragmentInteractionListener mListener;

    public MyNewsMagRecyclerViewAdapter(List<Data> items, OnListFragmentInteractionListener listener) {
        list = items;
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_newsmag, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        //holder.mItem = list.get(position);
        holder.mIdView.setText(list.get(position).id);
        holder.mImageView.setImageResource(list.get(position).imageId);
        holder.mContentView.setText(list.get(position).description);

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
                    mListener.onListFragmentInteraction(holder.mItem);
                }
            }
        });
    }


    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final ImageView mImageView;
        public final TextView mIdView;
        public final TextView mContentView;
        public Data mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mIdView = (TextView) view.findViewById(R.id.id);
            mContentView = (TextView) view.findViewById(R.id.content);
            mImageView = (ImageView)view.findViewById(R.id.image);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mContentView.getText() + "'";
        }
    }
}
