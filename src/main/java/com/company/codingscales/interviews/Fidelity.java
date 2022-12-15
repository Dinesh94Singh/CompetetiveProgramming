package com.company.codingscales.interviews;

public class Fidelity {
    public String foo(String s) {
        try {
            return "try";
        } finally {
            if (true)
                System.out.println("Inside finally");
        }
    }

    public void moo() {
        System.out.println(foo("hello, world"));
    }

    public void moo2() {
        try {
            foo("hello, world");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public String foo2(String s) throws Exception {
        try {
            throw new Exception("try");
        } finally {
            System.out.println("Reached finally");
            if (true)
                throw new Exception("finally");
        }
    }

    public static void main(String[] args) {
        new Fidelity().moo();

        new Fidelity().moo2();
    }
}
