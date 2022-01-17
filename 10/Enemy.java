import java.util.ArrayList;

public class Enemy extends Character {
    Enemy(String name, int hp, int mp, int attack) {
        super(name, hp, mp, attack);
    }
 
    @Override
    void act(ArrayList<Character> targets) {
        //テスト用コード
        //actions.get(0)はたたあうのはず．．．
        //targets.get(0)はデンチウのはず．．．
        getAction().get(0).execute(this, targets.get(0));
    }
 }
 
 