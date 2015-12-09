package com.example.dillonconnolly.admobpractice;

import android.content.Context;
import android.widget.Toast;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;

/**
 * Created by Dillon Connolly on 12/9/2015.
 */
public class ToastAdListener extends AdListener {
    private Context mContext;
    private String mErrorReason;

    @Override
    public void onAdFailedToLoad(int errorCode) {
        super.onAdFailedToLoad(errorCode);
        switch(errorCode){
            case AdRequest.ERROR_CODE_INTERNAL_ERROR:
                mErrorReason = "Woops! something went wrong internally!";
                break;
            case AdRequest.ERROR_CODE_INVALID_REQUEST:
                mErrorReason = "Your request is not valid here.";
                break;
            case AdRequest.ERROR_CODE_NETWORK_ERROR:
                mErrorReason = "Network error. Try enabling wifi or data.";
                break;
            case AdRequest.ERROR_CODE_NO_FILL:
                mErrorReason = "No fill?";
                break;
            default:
                break;
        }
        sendToastMessage(mContext,mErrorReason);
    }

    public ToastAdListener(Context context) {
        super();
        this.mContext = context;
    }

    @Override
    public void onAdOpened() {
        super.onAdOpened();
        sendToastMessage(mContext,"onAdOpened()");
    }

    @Override
    public void onAdLeftApplication() {
        super.onAdLeftApplication();
        sendToastMessage(mContext,"onAdLeftApplication()");
    }

    @Override
    public void onAdLoaded() {
        super.onAdLoaded();
        sendToastMessage(mContext, "onAdLoaded()");
    }

    @Override
    public void onAdClosed() {
        super.onAdClosed();
        sendToastMessage(mContext,"onAdClosed()");
    }

    public void sendToastMessage(Context context,String message){
        Toast.makeText(context,message,Toast.LENGTH_SHORT).show();
    }

    public String getErrorReason() {
        return mErrorReason == null ? "" : mErrorReason;
    }
}
