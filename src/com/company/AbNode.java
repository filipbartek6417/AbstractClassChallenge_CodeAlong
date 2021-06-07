package com.company;

public class AbNode extends AbListItem {
    public AbNode(Object value) {
        super(value);
    }

    @Override
    AbListItem next() {
        return this.rightLink;
    }

    @Override
    AbListItem setNext(AbListItem abListItem) {
        this.rightLink = abListItem;
        return abListItem;
    }

    @Override
    AbListItem previous() {
        return this.leftLink;
    }

    @Override
    AbListItem setPrevious(AbListItem abListItem) {
        this.leftLink = abListItem;
        return abListItem;
    }

    @Override
    int compareTo(AbListItem abListItem) {
        if (abListItem != null){
            return ((String) abListItem.getValue()).compareTo((String) super.getValue());
        }
        return -1;
    }
}
