package com.felix.learn.jcip.composingobjects;


import com.felix.learn.jcip.annotations.GuardedBy;
import com.felix.learn.jcip.annotations.ThreadSafe;

/**
 * SafePoint
 *
 * @author Brian Goetz and Tim Peierls
 */
@ThreadSafe
public class SafePoint {
    @GuardedBy("this")
    private int x, y;

    private SafePoint(int[] a) {
        this(a[0], a[1]);
    }

    public SafePoint(SafePoint p) {
        this(p.get());
    }

    public SafePoint(int x, int y) {
        this.set(x, y);
    }

    public synchronized int[] get() {
        return new int[]{x, y};
    }

    public synchronized void set(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
