package com.company.codingscales.java.concepts.service.Gson;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.time.Instant;

public class MyObject {
    private Instant date;
    public Instant getDate() {
        return date;
    }

    public void setDate(Instant date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        MyObject myObject = (MyObject) o;

        return new EqualsBuilder().append(date, myObject.date).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37).append(date).toHashCode();
    }

    @Override
    public String toString() {
        return "MyObject{" +
                "date=" + date +
                '}';
    }
}
