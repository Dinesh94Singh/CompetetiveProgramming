package com.company.codingscales.templates;

public class Pair<U, V> {
    public U u;
    public V v;

    public Pair(final U u, final V v) {
        this.u = u;
        this.v = v;
    }

    public U getFirst() {
        return this.u;
    }

    public V getSecond() {
        return this.v;
    }

    @Override
    public int hashCode() {
        int prime = 31;
        int result = 1;

        result = prime * result + ((u == null) ? 0 : u.hashCode());
        result = prime * result + ((v == null) ? 0 : v.hashCode());

        return result;
    }

    @Override
    public boolean equals(final Object obj) {
        final Pair other =  (Pair<U, V>) obj;
        return this.u == other.u && this.v == other.v;
    }
}
