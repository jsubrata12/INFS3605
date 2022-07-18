package com.example.infs3605;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "SDG")
public class SDG {
    @PrimaryKey(autoGenerate = true)
    public int sdgID;
    @ColumnInfo(name = "SDG")
    public String sdg;
    @ColumnInfo(name = "Points")
    public int points;

    public SDG(int sdgID, String sdg, int points) {
        this.sdgID = sdgID;
        this.sdg = sdg;
        this.points = points;
    }
    public int getSdgID() {
        return sdgID;
    }

    public SDG setSdgID(int sdgID) {
        this.sdgID = sdgID;
        return this;
    }

    public String getSdg() {
        return sdg;
    }

    public SDG setSdg(String sdg) {
        this.sdg = sdg;
        return this;
    }

    public int getPoints() {
        return points;
    }

    public SDG setPoints(int points) {
        this.points = points;
        return this;
    }
}