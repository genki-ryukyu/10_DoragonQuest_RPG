class AttackMagic implements Action {
    //魔法は個別の名前を持つ
    String name;
    int attack; //攻撃力
    int consumption; //消費MP
 
    AttackMagic(String name, int attack, int consumption) {
        this.name = name;
        this.attack = attack;
        this.consumption = consumption;
    }

    
 
    @Override
    public String name() {
        return name;
    }
 
    @Override
    public void execute(Character executer, Character target) {
        target.damaged(executer.getAttack());
        System.out.println(executer.getName() + "の魔法!!");
        System.out.println(executer.getName() + "は" + target.getName() + 
                    "に" + executer.getAttack() + "ポイントのダメージを与えた!");
    }
 }
 
 
 
 