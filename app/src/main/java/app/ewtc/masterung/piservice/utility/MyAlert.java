package app.ewtc.masterung.piservice.utility;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;

import app.ewtc.masterung.piservice.R;

/**
 * Created by masterung on 2/11/2017 AD.
 */

public class MyAlert {

    //    Explicit
    private Context context;

    public MyAlert(Context context) {
        this.context = context;
    }

    public void myDialog(String strTitle, String strMessage) {

//        You Inherited Object From Class
//        สร้าง ออฟเจ็ค ที่สามารถสร้างป้อปอัพ
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(strTitle);
        builder.setCancelable(false);
        builder.setIcon(R.drawable.ic_action_alert);
        builder.setMessage(strMessage);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.show();

    }

}   // Main Class
