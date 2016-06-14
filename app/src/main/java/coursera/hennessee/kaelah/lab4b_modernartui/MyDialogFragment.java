package coursera.hennessee.kaelah.lab4b_modernartui;

/**
 * Created by Kaelah Hennessee in 2015.
 */

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

public class MyDialogFragment extends DialogFragment {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        DialogInterface.OnClickListener positiveClick = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                //Website if they click Visit MOMA
                Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.moma.org"));
                getActivity().startActivity(intent);
            }
        };

        DialogInterface.OnClickListener negativeClick = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                //If they click Not Now
                dismiss();
            }
        };

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        builder.setNegativeButton("Not Now", negativeClick);
        builder.setPositiveButton("Visit MOMA", positiveClick);
        builder.setTitle("Visit to learn more");
        Dialog dialog = builder.create();
        return dialog;
    }
}
