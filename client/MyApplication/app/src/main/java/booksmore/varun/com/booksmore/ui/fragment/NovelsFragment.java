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
import booksmore.varun.com.booksmore.ui.fragment.adapter.NovelsAdapter;
import booksmore.varun.com.booksmore.model.Novels;

/**
 * A simple {@link Fragment} subclass.
 */
public class NovelsFragment extends Fragment {

    private List<Novels> magsList = new ArrayList<>();
    private RecyclerView recyclerView;


    public NovelsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_novels, container, false);
        init(v);
        return v;
    }

    private void init(View v) {
        recyclerView = (RecyclerView)v.findViewById(R.id.novels_recycler_view);


        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(v.getContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(new NovelsAdapter(magsList, new NovelsAdapter.OnItemClickListener() {
            @Override public void onItemClick(Novels item) {
                Toast.makeText(getActivity(), item.getTitle(), Toast.LENGTH_LONG).show();
            }
        }));


        prepareMagsData();
    }

    private void prepareMagsData() {

        magsList.add(new Novels("Breaking Dawn","Rs 50",R.drawable.breakingdawn));
        magsList.add(new Novels("Deathly Hallows","Rs 60",R.drawable.dh));
        magsList.add(new Novels("Eclipse","Rs 50",R.drawable.eclipse));
        magsList.add(new Novels("Fantastic Beasts","Rs 60",R.drawable.fb));
        magsList.add(new Novels("Half Blood Prince","Rs 50",R.drawable.hbp));
        magsList.add(new Novels("Cursed Child","Rs 60",R.drawable.hp));
        magsList.add(new Novels("Philosophers Stone","Rs 50",R.drawable.ps));
        magsList.add(new Novels("Twilight","Rs 60",R.drawable.twilight));

        recyclerView.getAdapter().notifyDataSetChanged();
    }

}
