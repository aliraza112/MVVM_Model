package com.ambitsolutions.mvvm.home;

import java.util.List;

public class AdViewModel {
    int totalpages;
    private List<brajanwar> brajanwar;

    public AdViewModel(int totalpages, List<com.ambitsolutions.mvvm.home.brajanwar> brajanwar) {
        this.totalpages = totalpages;
        this.brajanwar = brajanwar;
    }

    public int getTotalpages() {
        return totalpages;
    }

    public void setTotalpages(int totalpages) {
        this.totalpages = totalpages;
    }

    public List<com.ambitsolutions.mvvm.home.brajanwar> getBrajanwar() {
        return brajanwar;
    }

    public void setBrajanwar(List<brajanwar> brajanwar) {
        this.brajanwar = brajanwar;
    }
}
