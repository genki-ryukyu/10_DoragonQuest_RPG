class HeelingMagic implements Action {
    //魔法は個別の名前を持つ
    String name;
    private int healing;
    int consumption; //消費MP
 
    HeelingMagic(String name, int healing, int consumption) {
        this.name = name;
        this.healing = healing;
        this.consumption = consumption;
    }
 
    @Override
    public String name() {
        return name;
    }
 
    @Override
    public void execute(Character executer, Character target) {
        target.damaged(executer.getAttack());
        System.out.println(executer.getName() + "は" + name + "をとなえた!!");
        target.heal(healing);
        executer.consume(consumption);
        System.out.println(target.getName()+"を"+consumption*2+"ポイント回復させた!!");
    }
 }