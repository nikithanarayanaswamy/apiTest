package pojoobjects;

import java.util.Date;

public class User {

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public Ad getAd() {
        return ad;
    }

    public void setAd(Ad ad) {
        this.ad = ad;
    }

    private Data data;
    private Ad ad;

}
