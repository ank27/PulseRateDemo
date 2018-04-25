package ankurkhandelwal.example.com.pchambinodemo.dialog;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.view.View;

import ankurkhandelwal.example.com.pchambinodemo.MainActivity;
import ankurkhandelwal.example.com.pchambinodemo.R;
import ankurkhandelwal.example.com.pchambinodemo.view.BpmView;

public class BpmDialog extends DialogFragment {

    private BpmView bpmView;
    private double bpm;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle(R.string.average_bpm);
        builder.setNeutralButton(android.R.string.ok, null);

        View dialogView = getActivity().getLayoutInflater().inflate(R.layout.bpm, null);
        builder.setView(dialogView);

        bpmView = ((BpmView)dialogView.findViewById(R.id.bpm));
        bpmView.setBpm(bpm);

        return builder.create();
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        MainActivity app = (MainActivity) activity;
        bpm = app.getRecordedBpmAverage();
    }

}
