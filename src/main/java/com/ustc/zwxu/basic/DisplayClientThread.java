package com.ustc.zwxu.basic;
import com.ustc.zwxu.basic.activeobject.ActiveObject;
import com.ustc.zwxu.basic.activeobject.Result;

public class DisplayClientThread extends Thread {
    private final ActiveObject activeObject;
    public DisplayClientThread(String name, ActiveObject activeObject) {
        super(name);
        this.activeObject = activeObject;
    }
    public void run() {
        try {
            for (int i = 0; true; i++) {
                // û�д���ֵ�ĺ���
                String string = Thread.currentThread().getName() + " " + i;
                activeObject.displayString(string);
                Thread.sleep(200);
            }
        } catch (InterruptedException e) {
        }
    }
}
