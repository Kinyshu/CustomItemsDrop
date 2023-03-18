package com.kinyshu.customitemsdrop.info;

public class BlockInfo {
    public String name;
    public Drops drops;

    public BlockInfo(String name, Drops drops) {
        this.name = name;
        this.drops = drops;
    }

    public static class Drops {
        public Drops(int id, double percent, int count) {
            this.id = id;
            this.percent = percent;
            this.count = count;
        }

        public int id;
        public double percent;
        public int count;
    }
}
