package com.example.chart.services;

import com.example.chart.entities.VegOrder;

import java.util.Comparator;

public class SortCompare implements Comparator<VegOrder> {
    @Override
    public int compare(VegOrder o1, VegOrder o2) {
        return o2.getDate().compareTo(o1.getDate());
    }
}
