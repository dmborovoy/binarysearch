package org.cardpay.search;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
class DataHolder {

    private int[] arr;
    private int val;
    private int expectedIdx;

}
