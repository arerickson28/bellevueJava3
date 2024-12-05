// enum class to specify the two test cases
package com.example.ericksonmodfour;

public enum Size {
    FIFTY_THOUSAND(50000),
    FIVE_HUNDRED_THOUSAND(500000);

    public final int value;

    Size(int value) {
        this.value = value;
    }
}
