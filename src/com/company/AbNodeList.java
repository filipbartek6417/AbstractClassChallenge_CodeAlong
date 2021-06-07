package com.company;

public interface AbNodeList {
    AbListItem getRoot();
    boolean addItem(AbListItem abListItem);
    boolean removeItem(AbListItem abListItem);
    void traverse(AbListItem root);
}
