package com.alipay.workspace.di.pojo;

import com.alipay.workspace.di.marker;

@marker
public class vip extends Person{
    String vipInfo;

    public void setVipInfo(String vipInfo) {
        this.vipInfo = vipInfo;
    }

    public String getVipInfo() {
        return vipInfo;
    }
}
