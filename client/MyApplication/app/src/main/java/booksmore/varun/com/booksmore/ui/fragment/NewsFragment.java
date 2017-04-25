package booksmore.varun.com.booksmore.ui.fragment;


import android.os.Bundle;
import android.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import booksmore.varun.com.booksmore.R;
import booksmore.varun.com.booksmore.ui.fragment.adapter.NewspaperAdapter;
import booksmore.varun.com.booksmore.model.Newspaper;

/**
 * A simple {@link Fragment} subclass.
 */
public class NewsFragment extends Fragment {

    private List<Newspaper> items = new ArrayList<>();
    private RecyclerView recyclerView;


    public NewsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_news, container, false);
        init(v);
        return v;
    }

    private void init(View v) {
        recyclerView = (RecyclerView)v.findViewById(R.id.news_recycler_view);
        

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(v.getContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        //recyclerView.setAdapter(mAdapter);

        recyclerView.setAdapter(new NewspaperAdapter(items, new NewspaperAdapter.OnItemClickListener() {
            @Override public void onItemClick(Newspaper item) {
                Toast.makeText(getActivity(), item.getTitle(), Toast.LENGTH_LONG).show();
            }
        }));


        prepareNewsData();
    }

    private void prepareNewsData() {

        items.add(new Newspaper("Hindustan Times","Rs 10",R.drawable.ht));
        items.add(new Newspaper("Economic Times","Rs 8",R.drawable.et));
        items.add(new Newspaper("Dainik Jagran","Rs 10",R.drawable.dainikjagran));
        items.add(new Newspaper("Dainik Bhaskar","Rs 8",R.drawable.db));
        items.add(new Newspaper("Indian Express","Rs 10",R.drawable.indianexpress));
        items.add(new Newspaper("Hindustan Hinid","Rs 8",R.drawable.hindustan_hindi));
        items.add(new Newspaper("Navbharat Times","Rs 10",R.drawable.nbt));
        items.add(new Newspaper("Punjab Kesari","Rs 8",R.drawable.pk));
        items.add(new Newspaper("Telegraph","Rs 8",R.drawable.telegraph));
        items.add(new Newspaper("The States Man","Rs 10",R.drawable.thestatesman));
        items.add(new Newspaper("Times of India","Rs 8",R.drawable.toi));
        items.add(new Newspaper("Tribune","Rs 10",R.drawable.tribune));
        items.add(new Newspaper("Midday","Rs 8",R.drawable.midday));
        recyclerView.getAdapter().notifyDataSetChanged();

    }

}
