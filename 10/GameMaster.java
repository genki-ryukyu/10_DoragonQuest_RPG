import java.util.ArrayList;

public class GameMaster {
   ArrayList<Character> order = new ArrayList<>();

   GameMaster() {

       var denchu = new Player("デンチウ", 100,20,20);
       denchu.addAction(new Attack());
       //インスタンスのパラメータを変えることで攻撃魔法のバリエーションを作る
       denchu.addAction(new AttackMagic("ジューデン", 30, 10));
       denchu.addAction(new AttackMagic("ベジュデマ", 60, 20));
       denchu.addAction(new HeelingMagic("ケアルガ", 20, 20));


       var dan = new Enemy("ダンさん", 40,10,10);
       dan.addAction(new Attack());

       //アクションの順序を決める
       order.add(denchu);
       order.add(dan);

       //GameMasterクラスのコンストラクタに以下を挿入
       var konbo = new Equipment("こんぼう", 15);
       denchu.equipWeapon(konbo);
       denchu.addBaggage(konbo);  //所持する(荷物に追加する）

       var denchi = new HealingGoods("かんでんち", 30);
       denchu.addBaggage(denchi);

       var ball = new AttackGoods("鉄球", 20);
       denchu.addBaggage(ball);

       var ken = new Equipment("ソード", 20);
       denchu.addBaggage(ken);

       var potion = new Equipment("回復薬", 20);
       denchu.addBaggage(potion);


   }

   void showStatus() { //全キャラクタのステータスを表示（テスト用）
       for(var ch : order) {
           ch.showStatus();
       }
   }

   void battle() { //１ターン実行する
       for(var ch : order) {
           ch.act(order);
       }
   }

   


   public static void main(String[] args) {
    var master = new GameMaster();
  
       for(var i=0; i<3; i++) {
            master.showStatus();
            master.battle();
        }

}


}
