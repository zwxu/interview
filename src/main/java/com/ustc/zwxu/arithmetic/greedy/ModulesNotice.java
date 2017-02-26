package com.ustc.zwxu.arithmetic.greedy;

import java.util.List;



public class ModulesNotice {

    /** 通知id，关联到多个模块，客户端统一处理 */
    private String nid;

    /** 关联到的模块数量 */
    private int mcount;

    

    /** 更新Key的集合 */
    private List<String> keys;

    public int getMcount() {
        return mcount;
    }

    public void setMcount(int mcount) {
        this.mcount = mcount;
    }

   

    public String getNid() {
        return nid;
    }

    public void setNid(String nid) {
        this.nid = nid;
    }

    public List<String> getKeys() {
        return keys;
    }

    public void setKeys(List<String> keys) {
        this.keys = keys;
    }
}

