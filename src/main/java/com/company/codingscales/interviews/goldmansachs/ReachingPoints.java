package com.company.codingscales.interviews.goldmansachs;

public class ReachingPoints {
    public boolean reachingPointsBT(int sx, int sy, int tx, int ty) {
        if (sx > tx || sy > ty) return false;
        if (sx == tx && sy == ty) return true;
        return reachingPointsBT(sx+sy, sy, tx, ty) || reachingPointsBT(sx, sx+sy, tx, ty);
    }

    public boolean reachingPointsDP(int sx, int sy, int tx, int ty) {
        // you can remember the outcome if you already covered a branch = use memo of (tx, ty)
        return false;
    }

    // from x, y => we will go to (x + y, y) or (x, y + x)
    // going backwards, so => (x - y, y) or (x, y - x)
    public boolean reachingPointsBackwards(int sx, int sy, int tx, int ty) {
        while (tx >= sx && ty >= sy) {
            if (sx == tx && sy == ty)
                return true;
            if (tx > ty)
                tx -= ty;
            else
                ty -= tx;
        }

        return false;
    }

    // O(LogN)
    //  We know that the next parent operations will be to subtract ty from tx, until such time that tx = tx % ty; similarly ty = ty % tx;
    public boolean reachingPointsWithModulo(int sx, int sy, int tx, int ty) {
        while (tx >= sx && ty >= sy) {
            if (tx == ty)
                break;

            if (tx > ty) { // either decrease tx by (tx - ty) until tx % ty; // instead of linear, we hop multiple steps
                if (ty > sy) { // we can only hop when ty > sy. If tx > ty && ty == sy ==> we only need to check one branch where tx = tx % ty;
                    tx = tx % ty;
                } else {
                    return (tx - sx) % ty == 0;
                }
            } else { // similarly for ty as well.
                if (tx > sx) {
                    ty = ty % tx;
                } else {
                    return (ty - sy) % tx == 0;
                }
            }
        }

        return tx == sx && ty == sy;
    }

    public boolean reachingPointsSimpler(int sx, int sy, int tx, int ty) {
        while (sx < tx && sy < ty) {
            if (tx < ty) ty %= tx;
            else tx %= ty;
        }
        return sx == tx && sy <= ty && (ty - sy) % sx == 0 ||
                sy == ty && sx <= tx && (tx - sx) % sy == 0;
    }
}
