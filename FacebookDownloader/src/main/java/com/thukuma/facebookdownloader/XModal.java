package com.thukuma.facebookdownloader;

public class XModal {
    private String sdlink,hdlink,title,desc,thumb;

    public XModal(String sdlink, String hdlink, String title, String desc, String thumb) {
        this.sdlink = sdlink;
        this.hdlink = hdlink;
        this.title = title;
        this.desc = desc;
        this.thumb = thumb;
    }

    public String getSdlink() {
        return sdlink;
    }

    public String getHdlink() {
        return hdlink;
    }

    public String getTitle() {
        return title;
    }

    public String getDesc() {
        return desc;
    }

    public String getThumb() {
        return thumb;
    }
}
