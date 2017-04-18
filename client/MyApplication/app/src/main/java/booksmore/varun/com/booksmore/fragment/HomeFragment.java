package booksmore.varun.com.booksmore.fragment;


import android.app.FragmentTransaction;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import booksmore.varun.com.booksmore.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment implements View.OnClickListener {

    Button news;
    Button magazines;
    Button ncert;
    Button competitve;
    Button novels;



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
        news = (Button) v.findViewById(R.id.news_button);
        magazines = (Button) v.findViewById(R.id.mag_button);
        novels = (Button) v.findViewById(R.id.novels_button);

        news.setOnClickListener(this);
        magazines.setOnClickListener(this);
        novels.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.news_button:
                goToNews();
                break;
            case R.id.mag_button:
                goToMagazines();
                break;
            case R.id.novels_button:
                goToNovels();
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
