package com.bupereira.prokb;

import java.net.URL;

/**
 * Created by Bupereira on 09/08/2015.
 */
public class KBEntry {
    public String mID = new String();
    public String mTitle = new String();
    public String mData = new String();
    public String mContent = new String();
    public String mURL = new String();

    KBEntry(String id, String title, String data, String content, String url) {
        mID = id;
        mTitle = title;
        mData = data;
        mContent = content;
        mURL = url;
    }


    public String getmID() {
        return mID;
    }

    public void setmID(String mID) {
        this.mID = mID;
    }

    public String getmTitle() {
        return mTitle;
    }

    public void setmTitle(String mID) {
        this.mID = mTitle;
    }
    public String getmData() {
        return mData;
    }

    public void setmData(String mData) {
        this.mData = mData;
    }

    public String getmContent() {
        return mContent;
    }

    public void setmContent(String mContent) {
        this.mContent = mContent;
    }

    public String getmURL() {
        return mURL;
    }

    public void setmURL(String mURL) {
        this.mURL = mURL;
    }
}
