class AttackGoods extends Goods {
    private int value;
 
 
    AttackGoods(String name, int value) {
        //スーパークラスのコンストラクタが引数を要求するので，渡す
        super(name);
        this.value = value;
    }
 
    //道具の効果（ふるまい）を記述する
    @Override
    protected void executeImpl(Character executer, Character target) {
        target.damaged(executer.getAttack());
        System.out.println(executer.getName() + "は" + name() + "をつかった！");
        System.out.println(target.getName() + "は" + value + "ダメージを与えた！");
    }
 }
 