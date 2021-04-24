

package org.thoughtcrime.securesms.conversationlist.model;

import androidx.appcompat.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.view.View;


public class RateUs extends View {
    String packageName = "org.thoughtcrime.securesms";

    public RateUs(Context context){
        super(context);
    }

    public AlertDialog.Builder buildRemoteTranslateConfirmationDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());

        builder.setTitle("Rate Us");
        builder.setMessage("If you enjoy using Signal, please rate us !")
                .setCancelable(true)
                .setPositiveButton("Rate Now", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        try {
                            getContext().startActivity(new Intent(Intent.ACTION_VIEW,
                                    Uri.parse("market://details?id=" + packageName)));
                        } catch (android.content.ActivityNotFoundException e) {
                            getContext().startActivity(new Intent(Intent.ACTION_VIEW,
                                    Uri.parse("http://play.google.com/store/apps/details?id=" + packageName)));
                        }
                    }
                })
                .setNegativeButton("Later", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
        return builder;
    }
}