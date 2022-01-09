package com.aor.refactoring.example4;

import java.util.Objects;

public class Client extends Person {

    public Client(String name, String phone) {
        super(name, phone);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !(o instanceof Worker)) return false;
        if (!(o instanceof Client)) return false;
        Client worker = (Client) o;
        return Objects.equals(getName(), worker.getName()) &&
                Objects.equals(getPhone(), worker.getPhone());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getPhone());
    }
}
