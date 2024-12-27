package com.github.mmo.common;

public record Tuple<A extends Comparable<A>, B extends Comparable<B>, C extends Comparable<C>>(A a, B b, C c) implements Comparable<Tuple<A, B, C>> {

    public static <A extends Comparable<A>, B extends Comparable<B>, C extends Comparable<C>> Tuple<A, B, C> of(A a, B b, C c) {
        return new Tuple<>(a, b, c);
    }

    @Override
    public int compareTo(Tuple<A, B, C> o) {
        int result = this.a.compareTo(o.a);
        if (result == 0) {
            result = this.b.compareTo(o.b);
        }
        if (result == 0) {
            result = this.c.compareTo(o.c);
        }
        return result;
    }
}
