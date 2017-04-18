package booksmore.varun.com.booksmore.fragment;


import android.os.Bundle;
import android.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import booksmore.varun.com.booksmore.R;
import booksmore.varun.com.booksmore.fragment.adapter.NewspaperAdapter;
import booksmore.varun.com.booksmore.model.Newspaper;

/**
 * A simple {@link Fragment} subclass.
 */
public class NewsFragment extends Fragment {

    private List<Newspaper> newsList = new ArrayList<>();
    private RecyclerView recyclerView;
    private NewspaperAdapter mAdapter;

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
        
        mAdapter = new NewspaperAdapter(newsList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(v.getContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);


        prepareNewsData();
    }

    private void prepareNewsData() {

        newsList.add(new Newspaper("Hindustan Times","Rs 10",R.drawable.ht));
        newsList.add(new Newspaper("Economic Times","Rs 8",R.drawable.et));
        newsList.add(new Newspaper("Dainik Jagran","Rs 10",R.drawable.dainikjagran));
        newsList.add(new Newspaper("Dainik Bhaskar","Rs 8",R.drawable.db));
        newsList.add(new Newspaper("Indian Express","Rs 10",R.drawable.indianexpress));
        newsList.add(new Newspaper("Hindustan Hinid","Rs 8",R.drawable.hindustan_hindi));
        newsList.add(new Newspaper("Navbharat Times","Rs 10",R.drawable.nbt));
        newsList.add(new Newspaper("Punjab Kesari","Rs 8",R.drawable.pk));
        newsList.add(new Newspaper("Telegraph","Rs 8",R.drawable.telegraph));
        newsList.add(new Newspaper("The States Man","Rs 10",R.drawable.thestatesman));
        newsList.add(new Newspaper("Times of India","Rs 8",R.drawable.toi));
        newsList.add(new Newspaper("Tribune","Rs 10",R.drawable.tribune));
        newsList.add(new Newspaper("Midday","Rs 8",R.drawable.midday));
        mAdapter.notifyDataSetChanged();

    }

}
