package pen.entity;

import pen.entity.strategy.GellBallPenWritingStrategy;
import pen.entity.strategy.WritingStrategy;

public class GelPen extends Pen {
    Ink ink;
    Nib nib;

    public void changeRefill(Refill refill) {
        this.ink = refill.ink;
        this.nib = refill.nib;
    }

    public void write() {
        WritingStrategy writingStrategy = new GellBallPenWritingStrategy();
        writingStrategy.write();
    }
}
