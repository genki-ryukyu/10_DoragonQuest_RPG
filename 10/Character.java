import java.util.ArrayList;


public abstract class Character {
    private String name;
    private int hp;
    private int mp;
    private int attack;
 
    private static ArrayList<Action> actions = new ArrayList<>();
 
    public Character(String name, int hp, int mp, int attack) {
        this.name = name;
        this.hp = hp;
        this.mp = mp;
        this.attack = attack;
    }

    String getName(){
        return name;
    }

    int getHp(){
        return hp;
    }

    int getMp(){
        return mp;
    }

    int getAttack(){
        return attack;
    }

    ArrayList<Action> getAction(){
        return actions;
    }
 
 
    public void addAction(Action action) {
        getAction().add(action);
    }


    public void showStatus() {
        System.out.printf("%s:HP %d  MP %d\n", name, hp, mp);
    }

    //Characterクラスに追加するメソッド
    public void damaged(int value) {
        hp -= value;
    }

    public void heal(int value){
        hp += value;
    }

    public void consume(int value){
    }
 
 
 
    //影響を与える可能性のあるオブジェクトの参照を引数として受け取る
    abstract void act(ArrayList<Character> targets); //サブクラスで定義する

 }
 