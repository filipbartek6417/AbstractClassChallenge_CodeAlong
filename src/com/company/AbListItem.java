package com.company;

public abstract class AbListItem {
    protected AbListItem leftLink = null;
    protected AbListItem rightLink = null;
    protected Object value;

    public AbListItem(Object value) {
        this.value = value;
    }

    abstract AbListItem next();
    abstract AbListItem setNext(AbListItem abListItem);
    abstract AbListItem previous();
    abstract AbListItem setPrevious(AbListItem abListItem);

    abstract int compareTo(AbListItem abListItem);

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }
}
