package app.daeng.tokped.Adapters;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import app.daeng.tokped.Listeners.OnItemClickedListener;
import app.daeng.tokped.R;
import app.daeng.tokped.Utils.ItemObjects;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by isfaaghyth on 14/12/16.
 */

public class MainMenuAdapter extends RecyclerView.Adapter<MainMenuAdapter.MainMenuHolder> {

    List<ItemObjects> items;
    Context context;
    OnItemClickedListener itemClickedListener;

    public MainMenuAdapter(OnItemClickedListener itemClickedListener, Context context, List<ItemObjects> items) {
        this.itemClickedListener = itemClickedListener;
        this.context = context;
        this.items = items;
    }

    @Override
    public MainMenuHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MainMenuHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_item, null));
    }

    @Override
    public void onBindViewHolder(MainMenuHolder holder, final int position) {
        holder.imgProduct.setImageResource(items.get(position).getImg());
        holder.txtTitle.setText(items.get(position).getTitle());
        holder.cardItemMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                itemClickedListener.onClick(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    class MainMenuHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.card_item_menu)
        CardView cardItemMenu;

        @BindView(R.id.img_product)
        ImageView imgProduct;

        @BindView(R.id.txt_title)
        TextView txtTitle;

        public MainMenuHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
