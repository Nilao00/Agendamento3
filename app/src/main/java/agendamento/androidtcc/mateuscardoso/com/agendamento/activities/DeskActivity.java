package agendamento.androidtcc.mateuscardoso.com.agendamento.activities;

import agendamento.androidtcc.mateuscardoso.com.agendamento.R;
import agendamento.androidtcc.mateuscardoso.com.agendamento.dialogs.InputAddAoCalendarDialog;
import agendamento.androidtcc.mateuscardoso.com.agendamento.adapters.ProfessorAdapter;
import agendamento.androidtcc.mateuscardoso.com.agendamento.model.Professor;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

public class DeskActivity extends AppCompatActivity {

    // region FIELDS
    private RecyclerView mFriendsRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    private ProfessorAdapter mFriendsAdapter;
    private TextView mWarningTextView;
    private List<Professor> mProfessors = new ArrayList<>();
    private FloatingActionButton mAddFriendFloatingActionButton;
    // endregion

    // region ACTIVITY LIFECYCLE METHODS

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_desk);

        mFriendsRecyclerView = (RecyclerView) findViewById(R.id.agendamentoRecyclerView);
        mWarningTextView = (TextView) findViewById(R.id.mensagemTextView);

        mFriendsAdapter = new ProfessorAdapter(mProfessors);
        mLayoutManager = new LinearLayoutManager(this);

        mFriendsRecyclerView.setLayoutManager(mLayoutManager);
        mFriendsRecyclerView.setAdapter(mFriendsAdapter);

        mAddFriendFloatingActionButton = (FloatingActionButton) findViewById(R.id.deskfloatingactionbutton);

        mAddFriendFloatingActionButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                final InputAddAoCalendarDialog inputAddFriendDialog = new InputAddAoCalendarDialog(DeskActivity.this);

                InputAddAoCalendarDialog.InputAddFriendClickListener listener  = new InputAddAoCalendarDialog.InputAddFriendClickListener() {

                    @Override
                    public void onClick() {

                        final EditText nameEditText = (EditText) inputAddFriendDialog.findViewById(R.id.friend_name_edittext);

                        final String FRIEND_NAME = nameEditText.getText().toString();

                        Professor professor = new Professor(FRIEND_NAME, 0);

                        mProfessors.add(professor);

                        if (mProfessors.size() > 0) {
                            mWarningTextView.setVisibility(View.GONE);
                            mFriendsRecyclerView.setVisibility(View.VISIBLE);
                        }

                        mFriendsAdapter.notifyDataSetChanged();
                    }
                };

                inputAddFriendDialog.setListener(listener);
                inputAddFriendDialog.show();
            }
        });
    }

    // endregion
}
