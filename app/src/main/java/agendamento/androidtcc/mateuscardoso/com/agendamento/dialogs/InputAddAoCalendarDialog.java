package agendamento.androidtcc.mateuscardoso.com.agendamento.dialogs;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

import agendamento.androidtcc.mateuscardoso.com.agendamento.R;

/**
 * Created by mateus polonini cardoso on 20/03/2017.
 **/

public class InputAddAoCalendarDialog extends Dialog {

    // region FIELDS

    private InputAddFriendClickListener mListener;

    private Button mAddSchedulingButton;

    // endregion

    // region INTERFACES

    public interface InputAddFriendClickListener {

        // region METHODS

        void onClick();

        // endregion
    }

    // endregion

    // region CONSTRUCTORS

    public InputAddAoCalendarDialog(final Context context) {

        super(context);
    }

    // endregion

    // region PUBLIC METHODS

    public void setListener(InputAddFriendClickListener listener) {

        mListener = listener;
    }

    // endregion

    // region OVERRIDED METHODS

    @Override
    public void onCreate(Bundle savedInstanceState) {

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.dialogo_add_agendamento);

        mAddSchedulingButton = (Button) findViewById(R.id.add_friend_button);

        mAddSchedulingButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                mListener.onClick();

                dismiss();
            }
        });
    }

    // endregion
}
