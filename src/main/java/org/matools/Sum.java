package org.matools;

@FunctionalInterface
public interface Sum {
    int sum(int a, int b);

    private void helper() {
        System.out.println("Common logic");
    }
}
