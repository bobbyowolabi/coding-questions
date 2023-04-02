package com.owodigi.binary.search;

public class VersionControl {
    private int firstBadVersion = -1;

    public boolean isBadVersion(final int version) {
        return version >= firstBadVersion;
    }

    protected void setFirstBadVersion(final int version) {
        this.firstBadVersion = version;
    }
}
