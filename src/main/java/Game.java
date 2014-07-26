import com.google.common.collect.Lists;

import java.util.List;

public class Game {
    private List<Player> players = Lists.newArrayList(new Player(), new Player());
    private Player activePlayer = players.get(0);
    private Player nonactivePlayer = players.get(1);

    private void passTurn() {
        Player temp = activePlayer;
        activePlayer = nonactivePlayer;
        nonactivePlayer = temp;
    }

    private boolean isOver() {
        return activePlayer.isDead() || nonactivePlayer.isDead();
    }
}
