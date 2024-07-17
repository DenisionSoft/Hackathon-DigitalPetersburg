package spb.hack.lifeindex.util;

import java.io.Serializable;

public class Pair<A,B> implements Serializable {
    public final A a;
    public final B b;

    public Pair(A a, B b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public String toString() {
        return String.format("(%s, %s)", a, b);
    }
}