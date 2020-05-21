package com.example.termin18_d;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;

public class NasDijalog extends AlertDialog.Builder {
    public NasDijalog(Context context) {
        super(context);
        setTitle("Termin 18_d");
        setMessage("Sve poruke mozete proslediti na mejl restorana");
        setPositiveButton("U Redu", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        setNegativeButton("Odustani", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
    }

    public AlertDialog prepareDialog(){
        AlertDialog dialog = create();
        dialog.setCanceledOnTouchOutside(false);
        return dialog;
    }
}
