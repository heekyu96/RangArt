package imtt96.com.rangart;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by imtt9 on 2017-02-05.
 */

public class ShowOwnPiece extends Fragment {
    private RecyclerView recyclerView;
    private RecyclerViewAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.show_piece_recyclerview, container, false);

        recyclerView = (RecyclerView) rootView.findViewById(R.id.show_recycler_recyclerview);

        List<ShowOwnPieceData> items = new ArrayList<>();

        items.add(new ShowOwnPieceData("Test", "Test화면입니다"));
        items.add(new ShowOwnPieceData("Test", "Test화면입니다"));

        adapter = new RecyclerViewAdapter(items);
        recyclerView.setAdapter(adapter);

        LinearLayoutManager manager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, true);
        recyclerView.setLayoutManager(manager);

        return rootView;
    }

    private class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewHolder> {
        private List<ShowOwnPieceData> items;

        public RecyclerViewAdapter(List<ShowOwnPieceData> items) {
            this.items = items;
        }

        @Override
        public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.show_piece_card, parent, false);
            return new RecyclerViewHolder(view);
        }

        @Override
        public void onBindViewHolder(RecyclerViewHolder holder, int position) {
            ShowOwnPieceData cardData = items.get(position);

            holder.name.setText(cardData.getName());
            holder.comment.setText(cardData.getComment());
        }

        @Override
        public int getItemCount() {
            return items.size();
        }

        public void setItems(List<ShowOwnPieceData> items) {
            this.items = items;
        }

        public List<ShowOwnPieceData> getItems() {
            return items;
        }
    }

    private class RecyclerViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageView;
        private TextView name;
        private TextView comment;

        public RecyclerViewHolder(View itemView) {
            super(itemView);

            name = (TextView) itemView.findViewById(R.id.show_card_name);
            comment = (TextView) itemView.findViewById(R.id.show_card_comment);
        }
    }
}
