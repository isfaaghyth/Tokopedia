package app.daeng.tokped.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import app.daeng.tokped.R;

/**
 * Created by isfaaghyth on 15/12/16.
 */

public class FourthFragment extends Fragment {
    public FourthFragment() {}

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.fragment_fourth, null);
        return view;
    }
}
