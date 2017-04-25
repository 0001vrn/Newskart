package booksmore.varun.com.booksmore.ui.fragment;


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.app.Fragment;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;


import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.squareup.picasso.Picasso;

import booksmore.varun.com.booksmore.Constants;
import booksmore.varun.com.booksmore.R;
import booksmore.varun.com.booksmore.ui.activity.LoginActivity;
import booksmore.varun.com.booksmore.common.CircleTransform;


/**
 * A simple {@link Fragment} subclass.
 */
public class ProfileFragment extends Fragment implements View.OnClickListener {

    private ImageButton user_pic;
    private TextView user_email;
    private TextView user_name;
    private SharedPreferences pref;
    private Button mLogout;
    private GoogleApiClient mGoogleApiClient;
    public ProfileFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_profile, container, false);
        initFrags(v);
        return v;
    }

    private void initFrags(View v) {
        user_email = (TextView)v.findViewById(R.id.user_email);
        user_name = (TextView)v.findViewById(R.id.user_name);
        user_pic = (ImageButton) v.findViewById(R.id.user_pic);
        mLogout = (Button)v.findViewById(R.id.bt_logout);
        pref = getActivity().getSharedPreferences("LoginActivity",0);

        mLogout.setOnClickListener(this);
        setProfile();
    }

    private void setProfile() {

        user_email.setText(pref.getString(Constants.EMAIL,""));
        user_name.setText(pref.getString(Constants.NAME,""));
        Picasso.with(getActivity())
                .load(pref.getString(Constants.IMAGE_URL,""))
                .fit()
                .centerCrop()
                .transform(new CircleTransform()).into(user_pic);

        //Glide.with(this).load(pref.getString(Constants.IMAGE_URL,"")).into(user_pic);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt_logout:
                Auth.GoogleSignInApi.signOut(mGoogleApiClient).setResultCallback(new ResultCallback<Status>() {
                    @Override
                    public void onResult(@NonNull Status status) {

                    }
                });
                logout();
                goToLogin();
                break;
        }
    }

    @Override
    public void onStart() {
        super.onStart();

        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();
        mGoogleApiClient = new GoogleApiClient.Builder(getActivity())
                .addApi(Auth.GOOGLE_SIGN_IN_API, gso)
                .build();
        mGoogleApiClient.connect();
    }

    private void goToLogin() {
        getActivity().finish();
        startActivity(new Intent(getActivity(), LoginActivity.class));
    }

    private void logout() {
        SharedPreferences.Editor editor = pref.edit();
        editor.putBoolean(Constants.IS_LOGGED_IN,false);
        editor.putString(Constants.EMAIL,"");
        editor.putString(Constants.NAME,"");
        editor.apply();
    }


}
