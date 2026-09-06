package net.larchfen.gothicafflictions.block.custom.properties;

import net.minecraft.util.StringRepresentable;

public enum LargeDiscType implements StringRepresentable {
    TOP("top"),
    MIDDLE("middle"),
    BOTTOM("bottom"),

    NW_CORNER("nw_corner"),
    NORTH_SIDE("north_side"),
    NE_CORNER("ne_corner"),
    EAST_SIDE("east_side"),
    SE_CORNER("se_corner"),
    SOUTH_SIDE("south_side"),
    SW_CORNER("sw_corner"),
    WEST_SIDE("west_side"),
    NONE("none");

    private final String name;

    private LargeDiscType(String type) {
        this.name = type;
    }

    public String toString() {
        return this.name;
    }

    public String getSerializedName() {
        return this.name;
    }
}