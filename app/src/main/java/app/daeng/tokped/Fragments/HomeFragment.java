package app.daeng.tokped.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import app.daeng.tokped.Adapters.MainMenuAdapter;
import app.daeng.tokped.Listeners.OnItemClickedListener;
import app.daeng.tokped.R;
import app.daeng.tokped.Utils.ItemObjects;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by isfaaghyth on 14/12/16.
 */

public class HomeFragment extends Fragment implements OnItemClickedListener {

    public HomeFragment() {}

    @BindView(R.id.lst_main_menu)
    RecyclerView lstMainMenu;

    List<ItemObjects> items;
    MainMenuAdapter adapter;
    GridLayoutManager layoutManager;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.fragment_main, null);
        ButterKnife.bind(this, view);

        inisializeData();
        return view;
    }

    private void inisializeData() {
        layoutManager = new GridLayoutManager(getActivity(), 3);

        items = new ArrayList<>();
        items.add(new ItemObjects(R.mipmap.ic_clock, "Clock", "Jam Tangan"));
        items.add(new ItemObjects(R.mipmap.ic_earphone, "Earphone", "Pendengar Musik"));
        items.add(new ItemObjects(R.mipmap.ic_fashion, "Fashion", "Gaya Terkini"));
        items.add(new ItemObjects(R.mipmap.ic_phone, "Smartphone", "Telepon Genggam Pintar"));
        items.add(new ItemObjects(R.mipmap.ic_tv, "Smart TV", "Televisi Masa Kini"));

        adapter = new MainMenuAdapter(this, getActivity(), items);

        lstMainMenu.setLayoutManager(layoutManager);
        lstMainMenu.setAdapter(adapter);
    }

    @Override
    public void onClick(int position) {
        Toast.makeText(getActivity(), items.get(position).getDesc(), Toast.LENGTH_SHORT).show();
    }
}
