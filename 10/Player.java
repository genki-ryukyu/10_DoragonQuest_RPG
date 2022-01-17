import java.util.ArrayList;

public class Player extends Character {

    private Equipment weapon; //
    private ArrayList<Baggage> baggages = new ArrayList<>(); //所持品リスト


    @Override
    public int getAttack() {
       //Optionalが使えるならその方がスマートかも
       if( weapon == null) { //武器を持っていなければ影響なし
           return super.getAttack();
       }else {
           return super.getAttack()+weapon.getAttack();
       }
    }


    public void equipWeapon(Equipment weapon) {
        this.weapon = weapon;
    }
    
    @Override
    public ArrayList<Action> getAction() {
       //本来のアクションリストのコピーを生成する
       var integrated_actions = new ArrayList<Action>(super.getAction());

       //全持ち物を調べる
       for(var b : baggages) {
           //この持ち物は道具か? actionを継承するインスタンスを取り出す．
           if(b instanceof Action) { //instanceofはインスタンスのクラスを調べる
               Action goods = (Action)b;//bはActionのインスタンスであることが
                                       //わかっているので安全にダウンキャストできる
               integrated_actions.add(goods);
           }
       }
       //統合した一時的なアクションリストを返す
       return integrated_actions;
   }

   //所持品を追加する
   public void addBaggage(Baggage baggage) {
       baggages.add(baggage);
   }


   //武器を装備する
  



    Player(String name, int hp, int mp, int attack) {
        super(name, hp, mp, attack);
    }
 


    @Override
    void act(ArrayList<Character> targets) {
        var command_selector = new CommandSelector();
        


       //アクションを選択
        for(var action: getAction()) {
            command_selector.addCommand(action.name());
        }
        var command_number = command_selector.waitForUsersCommand("コマンド？");



       //ターゲットを選択
        command_selector.clearCommands();
        for(var target: targets) {
            command_selector.addCommand(target.getName());
        }
        var target_number = command_selector.waitForUsersCommand("ターゲット？");

        getAction().get(command_number).execute(this, targets.get(target_number));
        //           ^ユーザが選択したアクション番号                 ^選択したターゲット番号
}

 }
 