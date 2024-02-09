package pen.entity;

import pen.entity.strategy.GellBallPenWritingStrategy;
import pen.entity.strategy.WritingStrategy;

public class FountainPen extends Pen{
    Ink ink;
    Nib nib;

    public void write(){
        WritingStrategy writingStrategy = new GellBallPenWritingStrategy();
        writingStrategy.write();
    }
}
