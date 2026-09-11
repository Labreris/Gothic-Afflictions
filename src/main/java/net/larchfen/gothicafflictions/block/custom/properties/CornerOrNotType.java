package net.larchfen.gothicafflictions.block.custom.properties;

import net.minecraft.util.StringRepresentable;

public enum CornerOrNotType implements StringRepresentable {

    CORNER("corner"),
    SIDE("side"),
    NONE("none");

    private final String name;

    private CornerOrNotType(String type) {
        this.name = type;
    }

    public String toString() {
        return this.name;
    }

    public String getSerializedName() {
        return this.name;
    }
}