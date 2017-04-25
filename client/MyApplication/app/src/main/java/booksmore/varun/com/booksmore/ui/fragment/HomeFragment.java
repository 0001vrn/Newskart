package booksmore.varun.com.booksmore.ui.fragment;


import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.Toast;

import booksmore.varun.com.booksmore.R;
import booksmore.varun.com.booksmore.common.CustomGrid;
import booksmore.varun.com.booksmore.ui.activity.LocationActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment implements View.OnClickListener {

    GridView grid;
    String[] web = {
            "Newspaper",
            "Novels",
            "Magazines",
            "NCERT",
            "Competitive"

    } ;
    int[] imageId = {
            R.drawable.news_f,
            R.drawable.f_novels,
            R.drawable.magazine_f,
            R.drawable.books_f,
            R.drawable.entrance

    };

    private Button mLocation;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_home, container, false);
        init(v);
        return v;
    }

    private void init(View v) {
        mLocation = (Button) v.findViewById(R.id.location_button);
        mLocation.setOnClickListener(this);

        CustomGrid adapter = new CustomGrid(getActivity(), web, imageId);
        grid=(GridView)v.findViewById(R.id.grid);
        grid.setAdapter(adapter);
        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                //Toast.makeText(getActivity(), "You Clicked at " +web[+ position], Toast.LENGTH_SHORT).show();
                switch (web[position]){
                    case "Newspaper":
                        goToNews();
                        break;
                    case "Magazines":
                        goToMagazines();
                        break;
                    case "Novels":
                        goToNovels();
                        break;
                    default:
                        Toast.makeText(getActivity(), "You Clicked at " +web[+ position], Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.location_button:
                startActivity(new Intent(getActivity(), LocationActivity.class));
                break;
        }
    }

    private void goToMagazines() {
        Fragment frag = new MagazinesFragment();
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.replace(R.id.content,frag);
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        ft.commit();

    }
    private void goToNovels() {
        Fragment frag = new NovelsFragment();
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.replace(R.id.content,frag);
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        ft.commit();
    }

    private void goToNews() {
        Fragment frag = new NewsFragment();
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.replace(R.id.content,frag);
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        ft.commit();
    }
}
