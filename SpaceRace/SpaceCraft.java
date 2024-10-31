//Alexander Kindall SpaceRace
public class SpaceCraft {
    int position;

    public SpaceCraft(int p) {
        position = p;
    }
    public int EagPosChange() {
        int EagRand = (int) (Math.random() * 10) + 1;
        if (EagRand >= 1 && EagRand <= 5) {
            System.out.println("LightSpeed!");
            position = position + 1;
        } else if (EagRand >= 6 && EagRand <= 7) {
            System.out.println("Ludicrous Drive!");
            position = position - 3;
        } else if (EagRand >= 8 && EagRand <= 10) {
            System.out.println("Plaid Drive!");
            position = position + 5;

        }
        return position;
    }
    public int EntPosChange() {
        int USSRand = (int) (Math.random() * 10) + 1;
        if (USSRand == 1) {
            System.out.println("Docked!");
        } else if (USSRand >= 2 && USSRand <= 4) {
            System.out.println("Warp7!");
            position = position + 7;
        } else if (USSRand >= 5 && USSRand <= 8) {
            System.out.println("Impulse!");
            position = position - 4;

        } else if (USSRand >= 9 && USSRand <= 10) {
            System.out.println("Warp1!");
            position = position + 1;

        }
        return position;
    }
}