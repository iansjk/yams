import com.google.common.collect.Lists;
import kim.ian.yams.cardtypes.Card;
import kim.ian.yams.sets.m15.colorless.BronzeSable;
import kim.ian.yams.sets.m15.lands.*;

import java.util.List;

public class Player {
    private static int startingLife = 20;
    private int life = startingLife;
    private List<Card> library = Lists.newArrayList();
    private List<Card> hand = Lists.newArrayList();

    public boolean isDead() {
        return life <= 0;
    }

    public void loadDeck(String deckfile) {
        // TODO actually loading a deck; this is just a sample
        // 25 basic lands (5 of each), plus 35 Bronze Sables so there's something to cast
        for (int i = 0; i < 5; i++) {
            library.add(new Plains());
            library.add(new Island());
            library.add(new Swamp());
            library.add(new Mountain());
            library.add(new Forest());
        }

        for (int i = 0; i < 35; i++) {
            library.add(new BronzeSable());
        }

        assert library.size() == 60;
    }

    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        this.life = life;
    }
}
