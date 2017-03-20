package agendamento.androidtcc.mateuscardoso.com.agendamento.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import agendamento.androidtcc.mateuscardoso.com.agendamento.model.Professor;
import agendamento.androidtcc.mateuscardoso.com.agendamento.R;
import java.util.List;

/**
 * Created by mateus polonini cardoso on 20/03/2017.
 */

public class ProfessorAdapter extends RecyclerView.Adapter<ProfessorAdapter.ItemViewHolder> {

    // region FIELDS

    private List<Professor> mProfessors;

    // endregion

    // region CONSTRUCTORS

    public ProfessorAdapter(List<Professor> professors) {

        mProfessors = professors;
    }

    // endregion

    // region OVERRIDED METHODS

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.itemview_list_agendamento, parent, false);

        ItemViewHolder vh = new ItemViewHolder(v);

        return vh;
    }

    @Override
    public void onBindViewHolder(ItemViewHolder holder, int position) {

        holder.nameTextView.setText(mProfessors.get(position).getName());

        double debt = mProfessors.get(position).getDebt();

        if (debt == 0) {
            holder.debtTextView.setText("-");
        } else {
            holder.debtTextView.setText(String.valueOf(debt));
        }
    }

    @Override
    public int getItemCount() {

        return mProfessors.size();
    }

    // endregion

    // region UTILITY CLASSES

    class ItemViewHolder extends RecyclerView.ViewHolder {

        // region FIELDS

        public TextView nameTextView;
        public TextView debtTextView;

        // endregion

        // region CONSTRUCTORS

        public ItemViewHolder(View itemView) {

            super(itemView);

            nameTextView = (TextView) itemView.findViewById(R.id.nameTextView);
            debtTextView = (TextView) itemView.findViewById(R.id.debtTextView);
        }

        // endregion
    }

    // endregion
}
