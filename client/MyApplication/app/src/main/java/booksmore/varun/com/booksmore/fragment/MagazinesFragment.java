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
import booksmore.varun.com.booksmore.fragment.adapter.MagsAdapter;
import booksmore.varun.com.booksmore.fragment.adapter.NewspaperAdapter;
import booksmore.varun.com.booksmore.model.Magazines;

/**
 * A simple {@link Fragment} subclass.
 */
public class MagazinesFragment extends Fragment {

    private List<Magazines> magsList = new ArrayList<>();
    private RecyclerView mrecyclerView;
    private MagsAdapter mAdapter;


    public MagazinesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_magazines, container, false);
        init(v);
        return v;
    }

    private void init(View v) {
        mrecyclerView = (RecyclerView)v.findViewById(R.id.magazines_recycler_view);

        mAdapter = new MagsAdapter(magsList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(v.getContext());
        mrecyclerView.setLayoutManager(mLayoutManager);
        mrecyclerView.setItemAnimator(new DefaultItemAnimator());
        mrecyclerView.setAdapter(mAdapter);


        prepareMagsData();

    }

    private void prepareMagsData() {

        magsList.add(new Magazines("Business Today","Rs 50",R.drawable.businesstoday));
        magsList.add(new Magazines("Femina","Rs 60",R.drawable.femina));
        magsList.add(new Magazines("GQ","Rs 50",R.drawable.gq));
        magsList.add(new Magazines("India Today","Rs 60",R.drawable.indiatoday));
        magsList.add(new Magazines("Outlook","Rs 50",R.drawable.outlook));
        magsList.add(new Magazines("Vogue","Rs 60",R.drawable.vogue));
        magsList.add(new Magazines("Jeevan Utsah","Rs 50",R.drawable.jeevanutsah));
        magsList.add(new Magazines("Kadambini","Rs 60",R.drawable.kadambini));
        magsList.add(new Magazines("Sahitya Amrit","Rs 50",R.drawable.sahityaamrit));
        magsList.add(new Magazines("Sarita","Rs 60",R.drawable.sarita));

        mAdapter.notifyDataSetChanged();

    }

}
