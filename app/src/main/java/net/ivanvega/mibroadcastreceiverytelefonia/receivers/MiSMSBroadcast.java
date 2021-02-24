package net.ivanvega.mibroadcastreceiverytelefonia.receivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.SmsManager;
import android.telephony.TelephonyManager;
import android.widget.Toast;

public class MiSMSBroadcast extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if(action.equals(TelephonyManager.ACTION_PHONE_STATE_CHANGED)){
            String savedNumber = intent.getExtras().getString(Intent.EXTRA_PHONE_NUMBER);
            String incomingNumber = intent.getStringExtra(TelephonyManager.EXTRA_INCOMING_NUMBER);
            if(incomingNumber.equals(intent.getStringExtra("num"))){
                String strPhone = intent.getStringExtra("num");
                String strMessage = intent.getStringExtra("men");

                SmsManager sms = SmsManager.getDefault();
                sms.sendTextMessage(strPhone, null, strMessage, null, null);
                Toast.makeText(context, "Sent.", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
